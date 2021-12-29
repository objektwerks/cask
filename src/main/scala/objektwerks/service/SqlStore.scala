package objektwerks.service

import com.typesafe.config.Config

import objektwerks.datetime.DateTime
import objektwerks.entity.*

import scalikejdbc._

class SqlStore(conf: Config) extends Store:
  val driver = conf.getString("db.driver")
  val url = conf.getString("db.url")
  val user = conf.getString("db.user")
  val password = conf.getString("db.password")

  Class.forName(driver)
  ConnectionPool.singleton(url, user, password)

  def register(email: String): Option[Account] =
    val account = Account(email = email)
    val message = Email(id = "1", license = account.license, address = email, message = "message")
    if Emailer.send(message) then
      DB localTx { implicit session =>
        sql"insert into account(license, email, pin, activated, deactivated) values(${account.license}, ${account.email}, ${account.pin}, ${account.activated}, ${account.deactivated})"
        .update()
      }
      Some(account)
    else None

  def login(email: String, pin: String): Option[Account] =
    DB readOnly { implicit session =>
      sql"select * from account where email = $email and pin = $pin"
        .map(rs => Account(rs.string("license"), rs.string("email"), rs.string("pin"), rs.int("activated"), rs.int("deactivated")))
        .single()
    }

  def isAuthorized(license: String): Boolean =
    val count = DB readOnly { implicit session =>
      sql"select count(*) from account where license = $license and deactivated = 0 and activated > 0"
        .update()
    }
    if count > 0 then true else false

  def deactivate(license: String): Option[Account] =
    DB localTx { implicit session =>
      val deactivated = sql"update account set deactivated = ${DateTime.currentDate}, activated = 0 where license = $license"
      .update()
      if deactivated > 0 then
        sql"select * from account where license = $license"
          .map(rs => Account(rs.string("license"), rs.string("email"), rs.string("pin"), rs.int("activated"), rs.int("deactivated")))
          .single()
      else None
    }

  def reactivate(license: String): Option[Account] =
    DB localTx { implicit session =>
      val activated = sql"update account set activated = ${DateTime.currentDate}, deactivated = 0 where license = $license"
      .update()
      if activated > 0 then
        sql"select * from account where license = $license"
          .map(rs => Account(rs.string("license"), rs.string("email"), rs.string("pin"), rs.int("activated"), rs.int("deactivated")))
          .single()
      else None
    }

  def listPools(): Seq[Pool] =
    DB readOnly { implicit session =>
      sql"select * from pool order by built"
        .map(rs => Pool(rs.int("id"), rs.string("license"), rs.string("name"), rs.int("built"), rs.int("volume")))
        .list()
    }

  def addPool(pool: Pool): Pool =
    val id = DB localTx { implicit session =>
      sql"insert into pool(license, name, built, volume) values(${pool.license}, ${pool.name}, ${pool.built}, ${pool.volume})"
      .updateAndReturnGeneratedKey().toInt
    }
    pool.copy(id = id)
    
  def updatePool(pool: Pool): Unit =
    DB localTx { implicit session =>
      sql"update pool set name = ${pool.name}, built = ${pool.built}, volume = ${pool.volume} where id = ${pool.id}"
      .update()
    }
    ()

  def listSurfaces(): Seq[Surface] =
    DB readOnly { implicit session =>
      sql"select * from surface order by installed"
        .map(rs => Surface(rs.int("id"), rs.int("pool_id"), rs.int("installed"), rs.string("kind")))
        .list()
    }

  def addSurface(surface: Surface): Surface =
    val id = DB localTx { implicit session =>
      sql"insert into surface(pool_id, installed, kind) values(${surface.poolId}, ${surface.installed}, ${surface.kind})"
      .updateAndReturnGeneratedKey().toInt
    }
    surface.copy(id = id)

  def updateSurface(surface: Surface): Unit =
    DB localTx { implicit session =>
      sql"update surface set installed = ${surface.installed}, kind = ${surface.kind} where id = ${surface.id}"
      .update()
    }
    ()

  def listPumps(): Seq[Pump] =
    DB readOnly { implicit session =>
      sql"select * from pump order by installed"
        .map(rs => Pump(rs.int("id"), rs.int("pool_id"), rs.int("installed"), rs.string("model")))
        .list()
    }

  def addPump(pump: Pump): Pump =
    val id = DB localTx { implicit session =>
      sql"insert into pump(pool_id, installed, kind) values(${pump.poolId}, ${pump.installed}, ${pump.model})"
      .updateAndReturnGeneratedKey().toInt
    }
    pump.copy(id = id)  
  
  def updatePump(pump: Pump): Unit =
    DB localTx { implicit session =>
      sql"update pump set installed = ${pump.installed}, kind = ${pump.model} where id = ${pump.id}"
      .update()
    }
    ()

  def listTimers(): Seq[Timer] =
    DB readOnly { implicit session =>
      sql"select * from timer order by installed"
        .map(rs => Timer(rs.int("id"), rs.int("pool_id"), rs.int("installed"), rs.string("model")))
        .list()
    }

  def addTimer(timer: Timer): Timer =
    val id = DB localTx { implicit session =>
      sql"insert into timer(pool_id, installed, kind) values(${timer.poolId}, ${timer.installed}, ${timer.model})"
      .updateAndReturnGeneratedKey().toInt
    }
    timer.copy(id = id)
  
  def updateTimer(timer: Timer): Unit =
    DB localTx { implicit session =>
      sql"update timer set installed = ${timer.installed}, kind = ${timer.model} where id = ${timer.id}"
      .update()
    }
    ()

  def listTiimerSettings(): Seq[TimerSetting] =
    DB readOnly { implicit session =>
      sql"select * from timersetting order by created"
        .map(rs => TimerSetting(rs.int("id"), rs.int("timer_id"), rs.int("created"), rs.int("time_on"), rs.int("time_off")))
        .list()
    }

  def addTimerSetting(timerSetting: TimerSetting): TimerSetting = ???
  def updateTimerSetting(timerSetting: TimerSetting): Unit = ???

  def listHeaters(): Seq[Heater] =
    DB readOnly { implicit session =>
      sql"select * from heater order by installed"
        .map(rs => Heater(rs.int("id"), rs.int("pool_id"), rs.int("installed"), rs.string("model")))
        .list()
    }

  def addHeater(heater: Heater): Heater =
    val id = DB localTx { implicit session =>
      sql"insert into heater(pool_id, installed, kind) values(${heater.poolId}, ${heater.installed}, ${heater.model})"
      .updateAndReturnGeneratedKey().toInt
    }
    heater.copy(id = id)

  def updateHeater(heater: Heater): Unit =
    DB localTx { implicit session =>
      sql"update heater set installed = ${heater.installed}, kind = ${heater.model} where id = ${heater.id}"
      .update()
    }
    ()

  def listHeaterSettings(): Seq[HeaterSetting] = ???
  def addHeaterSetting(heaterSetting: HeaterSetting): HeaterSetting = ???
  def updateHeaterSetting(heaterSetting: HeaterSetting): Unit = ???

  def listMeasurements(): Seq[Measurement] = ???
  def addMeasurement(measurement: Measurement): Measurement = ???
  def updateMeasurement(measurement: Measurement): Unit = ???

  def listCleanings(): Seq[Cleaning] = ???
  def addCleaning(cleaning: Cleaning): Cleaning = ???
  def updateCleaning(cleaning: Cleaning): Unit = ???

  def listChemicals(): Seq[Chemical] = ???
  def addChemical(chemical: Chemical): Chemical = ???
  def updateChemical(chemical: Chemical): Unit = ???

  def listSupplies(): Seq[Supply] = ???
  def addSupply(supply: Supply): Supply = ???
  def updateSupply(supply: Supply): Unit = ???

  def listRepairs(): Seq[Repair] = ???
  def addRepair(repair: Repair): Repair = ???
  def updateRepair(repair: Repair): Unit = ???
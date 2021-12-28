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

  def register(email: String): Option[Account] = ???
  def login(email: String, pin: String): Option[Account] = ???

  def isAuthorized(license: String): Boolean = ???

  def deactivate(license: String): Option[Account] = ???
  def reactivate(license: String): Option[Account] = ???

  def listPools(): Seq[Pool] =
    DB readOnly { implicit session =>
      sql"select * from pool"
        .map( rs => Pool( rs.int("id"), rs.string("license"), rs.string("name"), rs.int("built"), rs.int("volume") ) )
        .list()
    }

  def addPool(pool: Pool): Pool =
    val id = DB localTx { implicit session =>
      sql"insert into pool(license, name, built, volume) values(${pool.license}, ${pool.name}, ${pool.built}, ${pool.volume})"
      .update()
    }
    pool.copy(id = id)
    
  def updatePool(pool: Pool): Unit =
    DB localTx { implicit session =>
      sql"update pool set name = ${pool.name}, built = ${pool.built}, volume = ${pool.volume} where id = ${pool.id}"
      .update()
    }
    ()

  def listSurfaces(): Seq[Surface] = ???
  def addSurface(surface: Surface): Surface = ???
  def updateSurface(surface: Surface): Unit = ???

  def listPumps(): Seq[Pump] = ???
  def addPump(pump: Pump): Pump = ???
  def updatePump(pump: Pump): Unit = ???

  def listTiimers(): Seq[Timer] = ???
  def addTimer(timer: Timer): Timer = ???
  def updateTimer(timer: Timer): Unit = ???

  def listTiimerSettings(): Seq[TimerSetting] = ???
  def addTimerSetting(timerSetting: TimerSetting): TimerSetting = ???
  def updateTimerSetting(timerSetting: TimerSetting): Unit = ???

  def listHeaters(): Seq[Heater] = ???
  def addHeater(heater: Heater): Heater = ???
  def updateHeater(heater: Heater): Unit = ???

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
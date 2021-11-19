package parkinggarage


import cats.data.State

sealed trait GarageAvailability

object GarageAvailability {
  case object Vacancy extends GarageAvailability

  case object NoVacancy extends GarageAvailability
}

case class ParkingGarage(totalCapacity: Int, currentCapacity: Int, garageState: GarageAvailability)

object ParkingGarage {
  def issueTicket: State[ParkingGarage, Unit] = State(pg => {
    if (pg.garageState == GarageAvailability.NoVacancy) throw new RuntimeException("Garage is full")
    else {
      val newCarNumber = pg.currentCapacity + 1
      (pg.copy(currentCapacity = newCarNumber, garageState = calcAvail(pg.totalCapacity, newCarNumber)), ())
    }
  })

  def returnTicket: State[ParkingGarage, Unit] = State(pg => {
    val newCarNumber = pg.currentCapacity - 1
    (pg.copy(currentCapacity = newCarNumber, garageState = calcAvail(pg.totalCapacity, newCarNumber)), ())
  })

  private def calcAvail(t: Int, c: Int): GarageAvailability = if (c == t) GarageAvailability.NoVacancy else GarageAvailability.Vacancy
}
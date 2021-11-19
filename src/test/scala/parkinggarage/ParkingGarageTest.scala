package parkinggarage

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import parkinggarage.GarageAvailability.Vacancy

class ParkingGarageTest extends AnyFlatSpec with Matchers {

  it should "run scenario and output correct state" in {
    import parkinggarage.ParkingGarage._

    val s = for {
      _ <- issueTicket
      _ <- issueTicket
      _ <- issueTicket
      _ <- returnTicket
    } yield ()

    s.run(ParkingGarage(3, 0, Vacancy)).value shouldBe(ParkingGarage(3, 2, Vacancy), ())
  }

}

package basic

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import io.vavr.control.Option

class BasicTestSpec extends AnyFlatSpec with Matchers {

  "The Basic test" should "compute power" in {

    BasicTest.power(0, 0) shouldBe Option.of(1)
    BasicTest.power(1, 0) shouldBe Option.of(1)
    BasicTest.power(5, 0) shouldBe Option.of(1)


    BasicTest.power(5, 1) shouldBe Option.of(5)
    BasicTest.power(0, 1) shouldBe Option.of(0)
    BasicTest.power(1, 1) shouldBe Option.of(1)

    BasicTest.power(5, 2) shouldBe Option.of(25)
    BasicTest.power(0, 2) shouldBe Option.of(0)
    BasicTest.power(1, 2) shouldBe Option.of(1)

    BasicTest.power(5, 3) shouldBe Option.of(25*5)
    BasicTest.power(0, 3) shouldBe Option.of(0)
    BasicTest.power(1, 3) shouldBe Option.of(1)

    BasicTest.power(5, 4) shouldBe Option.of(25*5*5)
    BasicTest.power(5, 5) shouldBe Option.of(25*5*5*5)

    BasicTest.power(1, -1) shouldBe Option.none()
    BasicTest.power(-1, 1) shouldBe Option.none()

    BasicTest.power(2, 9898909) shouldBe Option.none()
    BasicTest.power(100, 20) shouldBe Option.none()
  }
}

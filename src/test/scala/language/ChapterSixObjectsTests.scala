package language

import org.scalatest.FunSuite
import impatient.Conversions.inchesToCentimeters
import impatient.Conversions.gallonsToLiters
import impatient.Conversions.milesToKilometers
import impatient._

class ChapterSixObjectsTests extends FunSuite{

  test("Call methods from Conversion companion object"){
    assert(inchesToCentimeters(20) == 50.8)
    assert(gallonsToLiters(20) == 75.70823568)
    assert(milesToKilometers(20) == 32)
  }

  test("Companion object that extends Super class"){
    assert(InchesToCentimeters.toCentimeters(20) == 50.8)
    assert(GallonsToLiters.toLiters(20) == 75.70823568)
    assert(MilesToKilometers.toKilometers(20) == 32)
  }

  test("Create Account instance without ´new´ operator"){
    val acc = Account2(110)
    assert(acc.balance == 110)
    assert(acc.id == 1)
  }

  test("Enum TraficLightColor has 3 elements with sequential IDs"){
    assert(TrafficLightColor.Red.id === 0)
    assert(TrafficLightColor.Yellow.id === 1)
    assert(TrafficLightColor.Green.id === 2)
  }

  test("Without type alias, enum is of type TrafficLightColor.Value"){
    assert(TrafficLightColor.Red.isInstanceOf[TrafficLightColor.Value] === true)
  }

  test("Create Point instance without ´new´ operator"){
    val acc = Point(3,2)
    assert(acc.coordX == 3)
    assert(acc.coordY == 2)
  }

  test("Check if card is of color RED"){
    assert(ScalaSay.isCardRed(Card.hearts) === true)
    assert(ScalaSay.isCardRed(Card.clubs) === true)
    assert(ScalaSay.isCardRed(Card.diamonds) === false)
    assert(ScalaSay.isCardRed(Card.spades) === false)
  }

  test("Enum RGB has 3 elements with sequential IDs"){
    assert(RGB.Red.id === 0xff0000)
    assert(RGB.Blue.id === 0x0000ff)
    assert(RGB.Green.id === 0x00ff00)
  }

  test("With type alias, enum is of type RGB.RGB"){
    assert(RGB.Red.isInstanceOf[RGB.RGB] === true)
  }


}

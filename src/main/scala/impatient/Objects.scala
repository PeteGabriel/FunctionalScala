package impatient

import impatient.Card.Card

class Objects {

}

object Objects extends App{

    // The Apply method
    /*
    The apply method is called for expressions of the form: Object(arg1, ..., argN)

    Typically, such an apply method returns an object of the companion class.

    For example, the Array object defines apply methods that allow array creation with
    expressions such as
    */
      Array("Mary", "had", "a", "little", "lamb")

    /*
    Why doesn’t one just use a constructor? Not having the new keyword is handy
    for nested expressions, such as
     */
      Array(Array(1, 7), Array(2, 9))



    val acct = Account2(1000.0)


    for (c <- TrafficLightColor.values) println(s"${c.id}: $c")
    /*
    0: Red
    1: Yellow
    2: Green
     */


    println(TrafficLightColor(0)) // Calls Enumeration.apply
    println(TrafficLightColor.withName("Red"))


}



/*
You often have a class with both instance methods and static methods.
In Scala, you can achieve this by having a class and a “companion”
object of the same name.
 */
class Account {
  val id = Account.newUniqueNumber()
  private var balance = 0.0
  def deposit(amount: Double) = balance += amount
}

object Account {
  private var lastNumber = 0
  private def newUniqueNumber(): Int = {
    lastNumber += 1
    lastNumber
  }
}


class Account2 private (val id: Int, initialBalance: Double){
  var balance = initialBalance
}

object Account2 {

  private var lastNumber = 0
  private def newUniqueNumber(): Int = {
    lastNumber += 1
    lastNumber
  }

  def apply(initialBalance: Double): Account2 =
    new Account2(newUniqueNumber(), initialBalance)

}


//Enums
// If not specified, the ID is one more than the previously assigned one, starting
// with zero. The default name is the field name.
// The type of the enumeration is TrafficLightColor.Value and not TrafficLightColor
object TrafficLightColor extends Enumeration {
  val Red, Yellow, Green = Value
}




/*
Whats the difference between 'Array(100)' and 'new Array(100)' ?
 */


/*
Write an object Conversions with methods inchesToCentimeters, gallonsToLiters, and
milesToKilometers.
 */

object Conversions {

  def inchesToCentimeters(inches: Double) = inches * 2.54

  def gallonsToLiters(gallons: Double) = gallons * 3.785411784

  def milesToKilometers(miles: Double) = miles * 1.6
}


/*
The preceding problem wasn’t very object-oriented.
Provide a general superclass UnitConversion
and define objects InchesToCentimeters, GallonsToLiters, and MilesToKilometers
that extend it.
 */
abstract class UnitConversion {
  def toCentimeters(inches: Double)
  def toLiters(gallons: Double)
  def toKilometers(miles: Double)
}

object InchesToCentimeters{
  def toCentimeters(inches: Double) = inches * 2.54
}

object GallonsToLiters{
  def toLiters(gallons: Double) = gallons * 3.785411784
}

object MilesToKilometers{
  def toKilometers(miles: Double) = miles * 1.6
}


/*
  Define an Origin object that extends java.awt.Point.
  Why is this not actually a good idea?
  (Have a close look at the methods of the Point class.)
 */

object Origin extends java.awt.Point{

  // TODO

}


/*
Define a Point class with a companion object so that you can construct Point
instances as Point(3, 4), without using new.
 */
class Point private (val coordX:Double, val coordY: Double) {}

object Point{
  def apply(x: Double, y: Double): Point = new Point(x, y)
}


/*
Write a Scala application, using the App trait, that prints its command-line
arguments in reverse order, separated by spaces. For example, scala Reverse
Hello World should print World Hello.
 */

object ScalaSay extends App{
  for (arg <- args.reverseIterator) println(arg)

  /*
    Implement a function that checks whether a card suit value from the preceding
    exercise is red.
  */
  def isCardRed(card: Card) = card match {
    case x if x == Card.hearts || x == Card.clubs => true
    case _ => false
  }
}

/*
Write an enumeration describing the four playing card suits so that the toString
method returns hearts, clubs, diamonds, and spades.
 */
object Card extends Enumeration {
  type Card = Value
  val hearts, clubs, diamonds, spades = Value
}

object RGB extends Enumeration {
  type RGB = Value
  val Red = Value(0xff0000)
  val Green = Value(0x00ff00)
  val Blue = Value(0x0000ff)
}

















package impatient

import scala.annotation.switch
import scala.beans.BeanProperty

object Classes {

  def main(args: Array[String]): Unit = {
    val myCounter = new Counter();
    myCounter.increment()
    println(myCounter.current)


    val acc = new BankAccount(12.9)
    var balance = acc.balance


  }

}


class Counter {
  private var value = 0
  //good style to use () for a mutator method
  def increment(): Unit = value = if ((value + 1) > Int.MaxValue) 0 else value + 1
  //drop the () for an accessor method
  def current:Int = value
}

/*
Scala generates a class for the JVM with a private age field and getter and setter
methods. These methods are public because we did not declare age as private. (For
a private field, the getter and setter methods are private.)
 */
class Person {
  var age = 0
}

class Message {
  //read-only property
  val timeStamp = java.time.Instant.now
}

//private to the client pov. Mutable from inside.
class Counter2 {
  private var value = 0
  def increment() = value += 1
  def current = value
}

// A class with methods deposit and withdraw, and a read-only property balance.
class BankAccount(private var bal: Double) {

  def balance: Double = bal

  def deposit(amount: Double): Unit = bal += amount

  def withdraw(amount: Double): Double =
    amount match {
      case amount if amount < 0 => throw new Error("Cannot withdraw negative amounts")
      case amount if amount > `bal` => throw new Error("Insufficient funds")
      case _ => bal -= amount; bal
    }



}

/*
  A class with read-only properties hours and minutes and a method
  before(other: Time): Boolean that checks whether this time comes before the
  other. A Time object should be constructed as new Time(hrs, min), where hrs is in
  military time format (between 0 and 23).
*/
class Time (val hours: Int, val mins: Int) {

  if (hours > 23 || hours < 0)
    throw new IllegalArgumentException("Hours should be between [0,23]")
  if (mins > 59 || mins < 0)
    throw new IllegalArgumentException("Minutes should be between [0,59]")

  def before(other: Time): Boolean =  this.hours<=other.hours && this.mins<=other.mins
}

/*
  Reimplement the Time class from the preceding exercise so that the internal
  representation is the number of minutes since midnight (between 0 and 24 ×
  60 – 1). Do not change the public interface. That is, client code should be
  unaffected by your change.
 */
class Time2 (val hours: Int, val mins: Int) {

  if (hours > 23 || hours < 0)
    throw new IllegalArgumentException("Hours should be between [0,23]")
  if (mins > 59 || mins < 0)
    throw new IllegalArgumentException("Minutes should be between [0,59]")

  private val time = (mins*60) + (hours*3600)

  def before(other: Time2): Boolean =  this.time <= other.time
}


/*
Make a class Student with read-write JavaBeans properties name (of type String)
and id (of type Long). What methods are generated? (Use javap to check.) Can
you call the JavaBeans getters and setters in Scala? Should you?
 */
class Student(@BeanProperty val name: String,@BeanProperty var age: Int) {

  /*
  private field, public Scala and JavaBeans getters/setters

  * @BeanProperty var age: Int :

     1. age: Int
     2. age_=(newValue: Int): Unit
     3. getAge(): Int
     4. setAge(newValue: Int): Unit

  * @BeanProperty var age: Int :

     1. age: Int
     3. getAge(): Int

   This property should be used when we expect interoperability with Java.
   Many Java tools rely on this naming convention.

   */
}


/*
  In the Person class, provide a primary constructor that turns negative ages to 0.
 */
class Person2(a: Int) {
  var age = if (a < 0) 0 else a
}


/*
  Write a class Person with a primary constructor that accepts a string containing
  a first name, a space, and a last name, such as new Person("Fred Smith"). Supply
  read-only properties firstName and lastName. Should the primary constructor
  parameter be a var, a val, or a plain parameter? Why?
 */
class Person3(name: String){

  val firstName = name.split(" ")(0)
  val lastName = name.split(" ")(1)

  // Classes should be seen as functions that can receive params.
  // By making the parameter object-private, it will not be a property of the class
  // since its not called in any of its methods. Its useful only to aid in the primary ctor.
}

/*
  Make a class Car with read-only properties for manufacturer, model name,
  and model year, and a read-write property for the license plate. Supply four
  constructors. All require the manufacturer and model name. Optionally,
  model year and license plate can also be specified in the constructor. If not,
  the model year is set to -1 and the license plate to the empty string. Which
  constructor are you choosing as the primary constructor? Why?
 */
class Car (val manufacturer: String,
           val modelName: String,
           val modelYear: Int,
           var licensePlate: String) {

  def this(manufacturer: String, modelName: String){
    this(manufacturer, modelName, -1, "")
  }

  def this(manufacturer: String, modelName: String, modelYear: Int){
    this(manufacturer, modelName, modelYear, "")
  }


  // By setting the primary ctor with all the parameters, we can invoke in every
  // secondary ctor the primary with different params and therefore use provided parameters
  // as class properties.

}






























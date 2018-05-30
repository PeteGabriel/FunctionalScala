package language

import org.scalatest.FunSuite
import impatient._

class ClassesTests extends FunSuite{


  test("Invoking ´new Time(hrs,mins)´ should be valid"){
    val twoOclock = new Time(2,0)
    assert(twoOclock.hours === 2)
    assert(twoOclock.mins === 0)
  }

  test("Assert False if a certain Time instance comes after"){
    val twoOclock = new Time(2,49)
    val anotherClock = new Time(1,49)
    assert(twoOclock.before(anotherClock) === false)
  }

  test("Assert True if a certain Time instance comes before"){
    val twoOclock = new Time(2,49)
    val anotherClock = new Time(1,49)
    assert(anotherClock.before(twoOclock))
  }

  test("Cannot invoke Time class with wrong parameters (Hours)."){
    val thrown = intercept[IllegalArgumentException] {
      val twoOclock = new Time(-2,0)
    }
    assert(thrown.getMessage === "Hours should be between [0,23]")
  }


  test("Cannot invoke Time class with wrong parameters (Minutes)."){
    val thrown = intercept[IllegalArgumentException] {
      val twoOclock = new Time(2,60)
    }
    assert(thrown.getMessage === "Minutes should be between [0,59]")
  }

  test("Invoking ´new Time2(hrs,mins)´ should be valid"){
    val twoOclock = new Time2(2,0)
    assert(twoOclock.hours === 2)
    assert(twoOclock.mins === 0)
  }

  test("Assert False if a certain Time2 instance comes after"){
    val twoOclock = new Time2(2,49)
    val anotherClock = new Time2(1,49)
    assert(twoOclock.before(anotherClock) === false)
  }

  test("Assert True if a certain Time2 instance comes before"){
    val twoOclock = new Time2(2,49)
    val anotherClock = new Time2(1,49)
    assert(anotherClock.before(twoOclock))
  }

  test("Cannot invoke Time2 class with wrong parameters (Hours)."){
    val thrown = intercept[IllegalArgumentException] {
      val twoOclock = new Time2(-2,0)
    }
    assert(thrown.getMessage === "Hours should be between [0,23]")
  }

  test("Cannot invoke Time2 class with wrong parameters (Minutes)."){
    val thrown = intercept[IllegalArgumentException] {
      val twoOclock = new Time2(2,60)
    }
    assert(thrown.getMessage === "Minutes should be between [0,59]")
  }

  test("Person2 instances turn negative age into 0"){
    val person = new Person2(-1)
    assert(person.age === 0)
  }

  test("Person2 instances can keep correct age"){
    val person = new Person2(19)
    assert(person.age === 19)
  }

  test("Person3 instances have two properties read-only."){
    val person = new Person3("Peter Gabriel")
    assert(person.firstName === "Peter")
    assert(person.lastName === "Gabriel")
  }

  test("Car instances can be created by one of three forms."){
    val mazda = new Car("Mazda", "Z1")
    assert(mazda.manufacturer === "Mazda")
    assert(mazda.modelName === "Z1")
    assert(mazda.modelYear === -1)
    assert(mazda.licensePlate === "")

    val wvGolf = new Car("WV", "Golf", 1999)
    assert(wvGolf.manufacturer === "WV")
    assert(wvGolf.modelName === "Golf")
    assert(wvGolf.modelYear === 1999)
    assert(wvGolf.licensePlate === "")

    val wvPolo = new Car("WV", "Polo", 2000, "19-99-OK")
    assert(wvPolo.manufacturer === "WV")
    assert(wvPolo.modelName === "Polo")
    assert(wvPolo.modelYear === 2000)
    assert(wvPolo.licensePlate === "19-99-OK")
  }


}

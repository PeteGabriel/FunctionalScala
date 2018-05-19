package language

import impatient.control_structures_and_functions.ChapterTwo._
import org.scalatest.FunSuite

class ChapterTwoTests extends FunSuite{


  test("The signum of a positive number is 1") {
    assert(signum(23) == 1)
    assert(sigNumPatternMatch(23) == 1)
  }

  test("The signum of zero is 0") {
    assert(signum(0) == 0)
    assert(sigNumPatternMatch(0) == 0)
  }

  test("The signum of a negative number is -1") {
    assert(signum(-23) == -1)
    assert(sigNumPatternMatch(-23) == -1)
  }

  test("Unicode product of string") {
    assert(unicodeProduct("Hello") == 9415087488L)
  }

  test("Unicode product of string - Recursive") {
    assert(unicodeProductRecursive("Hello") == 9415087488L)
  }

}

package language
import impatient.Arrays._
import org.scalatest.FunSuite

import scala.collection.mutable.ArrayBuffer

class ChapterThreeArraysTests extends FunSuite{


  test("An array of size 10 and every element is eql to 1") {
    val ones = getArrayOfOnesWithSize(10)
    assert(ones.length == 10)
    for (member <- ones) assert(member == 1)
  }

  test("An array of size 0 is empty") {
    val ones = getArrayOfOnesWithSize(0)
    assert(ones.length == 0)
  }


  test("Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5)") {
    val initial = Array(1, 2, 3, 4, 5)
    val expected = Array(2, 1, 4, 3, 5)
    val swappedElems = swapAdjacents(initial)
    for (i <- initial.indices){
      assert(swappedElems(i) == expected(i))
    }
  }

  test("swapAdjacent method keeps array when len eql 1") {
    val initial = Array(1)
    val expected = Array(1)
    val swappedElems = swapAdjacents(initial)
    for (i <- initial.indices){
      assert(swappedElems(i) == expected(i))
    }
  }

  test("Average of [] is eql to 0") {
    val initial = Array(0)
    val expected = 0
    assert(avg(initial) == expected)
  }

  test("Average of [1] is eql to 1") {
    val initial = Array(1)
    val expected = 1
    assert(avg(initial) == expected)
  }

  test("Average of [1,2,3,4,5] is eql to 3") {
    val initial = Array(1,2,3,4,5)
    val expected = 3
    assert(avg(initial) == expected)
  }

  test("Reverse elements of Array(1,2,3,4,5) to (5,4,3,2,1)") {
    val initial = reverse(Array(1,2,3,4,5))
    val expected = Array(5,4,3,2,1)
    for (i <- 0.until(initial.length) )
      assert(expected(i) == initial(i))
  }


  test("Remove distinct elements from Array(1,1,2,2,3,3,3,4,5,4)") {
    val initial = remDuplicates(Array(1,1,2,2,3,3,3,4,5,4))
    val expected = Array(1,2,3,4,5)
    for (i <- 0.until(initial.length) )
      assert(expected(i) == initial(i))
  }

  test("Remove negative elements (Inefficient impl)") {
    val initial = ArrayBuffer(-1,-1,2,-2,3,-3,3,-4,5,4, -13)
    remNegativesInPlace_1(initial)
    val expected = Array(-1,2,3,3,5,4)
    for (i <- 0.until(initial.length) )
      assert(expected(i) == initial(i))
  }

  test("Remove negative elements") {
    val initial = ArrayBuffer(-1,-1,2,-2,3,-3,3,-4,5,4, -13)
    remNegatives(initial)
    val expected = Array(-1,2,3,3,5,4)
    for (i <- 0.until(initial.length) )
      assert(expected(i) == initial(i))
  }

}
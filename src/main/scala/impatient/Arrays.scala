package impatient

import scala.collection.immutable
import scala.collection.mutable.ArrayBuffer

object Arrays {

  def main(args: Array[String]): Unit = {

    //some examples of dealing with arrays in scala
    //by default, all values are zero
    val nums = new Array[Int](10)
    //by default, all values are null
    val a = new Array[String](10)
    //Type inferred
    val s = Array("Hello", "World")
    val hello = s(0)


    //ArrayBuffer is for variable len arrays
    val buffer = ArrayBuffer[Int]()
    buffer += 1
    //add elements with ´+=´
    buffer += (1,2,3,4)
    //add any other collection with ´++=´
    buffer ++= Array(7,8,9)

    for(i <- buffer.indices) print(buffer(i) + " ")

    //[2, 4, 8]
    val newBuffer = for (elem <- buffer if elem % 2 == 0) yield elem
    //[2, 4, 8]
    val functionalBuffer = buffer filter { _ % 2 == 0 }  map { _ * 1 }

  }


  // Remove in place the negative elements from a given array.
  def removeNegativeElementsInPlace(src: ArrayBuffer[Int]): Unit = {
    val positionsToRemove = for (i <- src.indices if src(i) < 0) yield i
    //removals at the end are efficient.
    for(i <- positionsToRemove.reverse) src.remove(i)
  }

  // Return a new collection without negative elements.
  def removeNegativeElements(src: ArrayBuffer[Int]): ArrayBuffer[Int] =
    src filter { _ > 0 } map { _ * 1 }

  /**
   * Set an array of n random integers between 0 (inclusive) and n (exclusive).
   */
  def getArrayOfOnesWithSize(size: Int): Array[Int] = new Array[Int](size).map(_ => 1)


  /**
    * Write a loop that swaps adjacent elements of an array of integers. For example,
    * Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5).
    */
  def swapAdjacents(src: Array[Int]): Array[Int] = {
    if (src.length <= 1) return src
    val swapElems = new Array[Int](src.length)
    for(i <- src.indices by 2) {
      if ((i + 1) >= src.length) {
        swapElems(i) = src(i)
        return swapElems
      }
      swapElems(i) = src(i+1)
      swapElems(i + 1) = src(i)
    }
    swapElems
  }

  /**
    * Given an array of integers, produce a new array that contains all positive
    * values of the original array, in their original order, followed by all values that
    * are zero or negative, in their original order
    */
  def reorderArray(src: ArrayBuffer[Int]): ArrayBuffer[Int] =
    ArrayBuffer[Int]()  ++= src filter { _ > 0 } ++= src filter { _ <= 0 }


  /**
    * Compute the average
    */
  def avg(src: Array[Int]): Int = src.sum / src.length

  /**
    * Rearrange the elements of an Array[Int] so that they appear in
    * reverse sorted order
    */
  def reverse(src: Array[Int]): immutable.IndexedSeq[Int] = for (i <- src.indices.reverse) yield src(i)

  /**
    * Rearrange the elements of an ArrayBuffer[Int] so that they appear in
    * reverse sorted order
    */
  def reverse (src: ArrayBuffer[Int]): immutable.IndexedSeq[Int] = for (i <- src.indices.reverse) yield src(i)


  /**
    * Produces all values from an array with duplicates removed.
    */
  def remDuplicates(src: Array[Int]): Array[Int] = src.distinct

  /**
    * Remove all but the first negative number.
    */
  def remNegativesInPlace_1(a: ArrayBuffer[Int]) = {
    var first = true
    var n = a.length
    var i = 0
    while (i < n) {
      if (a(i) >= 0)
        i += 1
      else {
        if (first) {
          first = false
          i += 1
        }
        else {
          a.remove(i)
          n -= 1
        }
      }
    }
  }

  def remNegatives(src: ArrayBuffer[Int])= {
    var negativeIdxs = for (elem <- src.indices if src(elem) < 0) yield elem
    negativeIdxs = negativeIdxs.drop(1)
    for(e <- negativeIdxs.indices.reverse) src.remove(negativeIdxs(e))
  }
}

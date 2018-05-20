package impatient

import scala.collection.immutable.HashMap
import scala.collection.mutable
import scala.io.Source

object MapsTuples {

  /*
  Set up a map of prices for a number of gizmos that you covet.
  Then produce a second map with the same keys and the prices
  at a 10 percent discount.
   */
  val Gizmos = Map("PS4" -> 400, "MacbookPro" -> 1600)
  val DiscountGizmos = for((g,p) <- Gizmos) yield (g, p-(p * 0.1))


  def main(args: Array[String]): Unit = {
    println(DiscountGizmos) // Map(PS4 -> 360.0, MacbookPro -> 1440.0)

    println(WeekDays) // Map(Tuesday -> 3, Monday -> 2, Wednesday -> 4, Thursday -> 5, Friday -> 6)

    //printSystemProperties()

    println("Hello".zip("World")) // => Vector((H,W), (e,o), (l,r), (l,l), (o,d))
  }

  /*
  Write a function that reads words from a file.
  Use a mutable map to count how often each word appears.
   */
  def countWords(filePath: String): mutable.HashMap[String, Int] = {
    val words = mutable.HashMap[String, Int]()
    for(line <- Source.fromFile(filePath).getLines()){
      for(word <- line.split(" "))
        if (words.contains(word))
          words.update(word, words(word) + 1)
        else words(word) = 1
    }
    words
  }

  //Same as before bu returning an immutable structure
  def countWordsImmutable(filePath: String): Map[String, Int] = {
    val words = mutable.HashMap[String, Int]()
    for(line <- Source.fromFile(filePath).getLines()){
      for(word <- line.split(" "))
        if (words.contains(word))
          words.update(word, words(word) + 1)
        else words(word) = 1
    }
    return HashMap() ++ words
  }

  def countWordsSorted(filePath: String): mutable.SortedMap[String, Int] = {
    val words = mutable.SortedMap[String, Int]()
    for(line <- Source.fromFile(filePath).getLines()){
      for(word <- line.split(" "))
        if (words.contains(word))
          words.update(word, words(word) + 1)
        else words(word) = 1
    }
    words
  }

  def countWordsWithTree(filePath: String): mutable.TreeMap[String, Int] = {
    val words = mutable.TreeMap[String, Int]()
    for(line <- Source.fromFile(filePath).getLines()){
      for(word <- line.split(" "))
        if (words.contains(word))
          words.update(word, words(word) + 1)
        else words(word) = 1
    }
    words
  }


  /*
  Define a linked hash map that maps "Monday" to java.util.Calendar.MONDAY,
  and similarly for the other weekdays.
  Demonstrate that the elements are visited in insertion order.
   */
  val WeekDays = mutable.LinkedHashMap(
    "Tuesday" -> java.util.Calendar.TUESDAY,
    "Monday" -> java.util.Calendar.MONDAY,
    "Wednesday" -> java.util.Calendar.WEDNESDAY,
    "Thursday" -> java.util.Calendar.THURSDAY,
    "Friday" -> java.util.Calendar.FRIDAY)


  def printSystemProperties():Unit = {
    val props = System.getProperties

    val keys = props.keySet().toArray()
    val values = props.values().toArray()

    val biggestLenKey = keys.map(_.toString.length).max
    val keyRep = biggestLenKey - keys(0).toString.length


    for ((k,v) <- keys.zip(values)){
      val keyRep = biggestLenKey - k.toString.length
      val rep = k.toString + ("\t" * Math.ceil(keyRep / 4).toInt) + " | " + v

      println(rep)
    }
  }

  /**
    * Write a function that returns a pair containing the
    * smallest and the largest values in the array.
    */
  def minAndMax(values: Array[Int]): (Int, Int) = {
    var min = Int.MaxValue
    var max = Int.MinValue

    for(elem <- values) {
      if (elem > max) max = elem
      if (elem < min) min = elem
    }

    (min, max)
  }

  def minAndMax_2(values: Array[Int]) = (values.min, values.max)

  /**
    * Write a function that returns a triple containing
    * the counts of values less than v, equal to v, and greater than v.
    */
  def lteqgt(values: Array[Int], v: Int): (Int, Int, Int) =
    (values.count(_ < v), values.count(_ == v), values.count(_ > v) )

}

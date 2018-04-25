package impatient.control_structures_and_functions

import java.time.LocalDate

import scala.annotation.tailrec

object ChapterTwo {

  def main(args: Array[String]): Unit = {

    /*
    Write a Scala equivalent for the Java loop
      for (int i = 10; i >= 0; i--) System.out.println(i);

    for (i <- 10 to 1 by -1){
      print(f"$i ") //10 9 8 7 6 5 4 3 2 1 0
    }

    countdown(10) //10 9 8 7 6 5 4 3 2 1 0
    */

    print( StringContext("$year-$month-$day") date("3000","3","2") )
  }


  /*
  The signum of a number is
     1 if the number is positive,
    –1 if it is negative,
     0 if it is zero.
  Write a function that computes this value.
   */
  def signum(num: Int):Int = {
    if (num > 0) 1
    else if (num == 0) 0
    else -1
  }

  def sigNumPatternMatch(num: Int): Int = num match {
    case num if num > 0 => 1
    case 0 => 0
    case _ => -1
  }


  /*
  What is the value of an empty block expression {}?
  What is its type?
   */
  def emptyBlock(): Unit = {
    println({}.getClass().getCanonicalName()) //void since its calling java methods
    return {} // Unit
  }

  /*
    Write a procedure countdown(n: Int) that prints the numbers from n to 0.
   */
  def countdown(n: Int): Unit = for (i <- n to 0 by -1) print(f"$i ")

  /*
    Write a for loop for computing the product of the Unicode codes
    of all letters in a string.
    For example, the product of the characters in "Hello" is 9415087488L.
   */
  def unicodeProduct(str: String): Long = {
    var prod: Long = 1
    for (ch <- str) prod *= ch.toInt
    prod
  }

  //The preceding exercise without writing a loop
  def unicodeProductRecursive(str: String): Long = {
    @tailrec
    def loop(iteration: Int, acc: Long): Long =
      if (iteration < 0) acc else loop(iteration-1, acc * str(iteration).toInt)

    loop(str.length-1, 1L)
  }


  /**
    * Define a string interpolator date so that you can define a java.time.LocalDate as
    * date"$year-$month-$day". You need to define an “implicit” class with a date method.
    *
    * args(i) is the value of the ith expression. Convert each to a string and then to
    * an integer, and pass them to the LocalDate.of method.
    *
    * If you already know
    * some Scala, add error handling. Throw an exception if there aren’t three
    * arguments, or if they aren’t integers, or if they aren’t separated by dashes.
    * (You get the strings in between the expressions as sc.parts.)
    *
    *
    *
    */
  implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
    def date(args: Any*): LocalDate = {
      println(sc.parts(0))
      println(args(0))
      println(args(1))
      println(args(2))
      return LocalDate.now()
    }
  }

}


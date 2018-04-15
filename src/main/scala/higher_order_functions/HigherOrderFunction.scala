package higher_order_functions

import scala.annotation.tailrec


object HigherOrderFunction {

  def factorial(n: Int): Int = {
    @tailrec
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n-1, n*acc)
    go(n, 1)
  }

  /*
    Write a recursive function to get the nth Fibonacci number.
    The first two Fibonacci numbers are 0 and 1.
    The nth number is always the sum of the previous two.
    The sequence begins 0, 1, 1, 2, 3, 5.
    Your definition should use a local tail-recursive function.
  */
  def fib(n: Int): Int = {
    /*
    If all recursive calls made by a function are in tail position, Scala automatically compiles
    the recursion to iterative loops that don’t consume call stack frames for each iteration.
     */
    @tailrec
    def loop(iteration: Int, previous: Int, acc: Int): Int =
      if (iteration == n) acc
      else loop(iteration + 1, acc, acc + previous)

    loop(0, 1, 0)
  }


  def findFirst[A](source: Array[A], key: A): Int = {
    @tailrec
    def loop(iteration: Int): Int ={
      if (iteration >= source.length) -1
      else if (source(iteration) == key) iteration
      else loop(iteration + 1)
    }
    loop(0)
  }

  def isSorted[A](source: Array[A], ordered: (A,A) => Boolean): Boolean = {
    def loop(iteration: Int, acc: Boolean): Boolean = {
      if (iteration >= source.length) acc
      else if (ordered(source(iteration - 1), source(iteration))) loop(iteration + 1, true)
      else false
    }
    loop(1, false)
  }

  def curry[A,B,C](f: (A, B) => C): A => B => C = a => b => f(a,b)

  def uncurry[A,B,C](f: A => B => C): (A, B) => C = (a,b) => f(a)(b)

  def compose[A,B,C](f: B => C, g: A => B): A => C = a => f(g(a))
}

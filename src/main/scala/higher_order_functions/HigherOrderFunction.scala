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
    @tailrec
    def loop(idx: Int, previous: Int, acc: Int): Int =
      if (idx == n) acc
      else loop(idx + 1, acc, acc + previous)

    loop(0, 1, 0)
  }

}

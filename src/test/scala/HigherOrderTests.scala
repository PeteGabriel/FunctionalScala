import org.scalatest.FunSuite
import higher_order_functions.HigherOrderFunction.factorial
import higher_order_functions.HigherOrderFunction.fib

class HigherOrderTests extends FunSuite {

  test("Factorial of 8 should be 40320") {
    assert(factorial(8) == 40320)
  }

  test("Fibonacci for the first 10 numbers") {
    assert(fib(0) == 0)
    assert(fib(1) == 1)
    assert(fib(2) == 1)
    assert(fib(3) == 2)
    assert(fib(4) == 3)
    assert(fib(5) == 5)
    assert(fib(6) == 8)
    assert(fib(7) == 13)
  }

}
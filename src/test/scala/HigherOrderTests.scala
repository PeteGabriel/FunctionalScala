import org.scalatest.FunSuite
import higher_order_functions.HigherOrderFunction.factorial
import higher_order_functions.HigherOrderFunction.fib
import higher_order_functions.HigherOrderFunction.findFirst
import higher_order_functions.HigherOrderFunction.isSorted

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

  test("First first element in array"){
    val source = Array("1","2","3","4","5","6")
    assert(findFirst(source, "4") == 3)
  }

  test("Return -1 if key is not present in array"){
    val source = Array(1,2,3,4,5,6)
    assert(findFirst(source, 14) == -1)
  }

  test("Validate if an array is sorted"){
    var source = Array(1,2,3,4,5,6)
    assert(isSorted(source, (a: Int, b: Int) => a <= b))

    source = Array(1,3,4,2,6)
    assert(!isSorted(source, (a: Int, b: Int) => a <= b))
  }

  test("Validate if an array with equal elements is sorted "){
    val source = Array(1,1,1,1,1,1)
    assert(isSorted(source, (a: Int, b: Int) => a <= b))
  }


}
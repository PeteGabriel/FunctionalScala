package fp

import funcprogramming.tail_recursion.TailRecursion._
import org.scalatest.FunSuite

class TailRecursionTests extends FunSuite{


  test("Test Balance method"){
    assert(balance("(if (zero? x) max (/ 1 x))".toList))
    assert(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
    assert(!balance(":-)".toList))
    assert(!balance("())(".toList))
  }


  test("Test Pascal method"){
    assert(pascal(0,2) === 1)
    assert(pascal(1,2) === 2)
    assert(pascal(1,3) === 3)
  }


  test("Test CountChange method"){
    assert(countChange(4,List(1,2)) === 3)

    assert(countChange(300,List(5,10,20,50,100,200,500)) === 1022)

    assert(countChange(301,List(5,10,20,50,100,200,500)) === 0)

    assert(countChange(300,List(500,5,50,100,20,200,10)) === 1022)
  }
}

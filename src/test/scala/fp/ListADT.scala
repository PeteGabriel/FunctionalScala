package fp

import funcprogramming.functional_data_structures.{Cons, List, Nil}
import org.scalatest.FunSuite

class ListADT extends FunSuite{

  test("Sum of a list"){
    val list = List(1,2,1,2)
    assert(List.sum(list) == 6)
  }

  test("Product of a list"){
    val list = List(1.0,2.0,1.0,2.0)
    assert(List.product(list) == 4)
  }

  test("Sum2 of a list"){
    val list = List(1,2,1,2)
    assert(List.sum2(list) == 6)
  }

  test("Product2 of a list"){
    val list = List(1.0,2.0,1.0,2.0)
    assert(List.product2(list) == 4)
  }

  test("FoldRight of a list using sum"){
    val list = Cons(1,Cons(2,Cons(1, Cons(2, Nil))))
    assert(List.foldRight(list, 0)(_+_) == 6)
  }

  test("Sum3 of a list"){
    val list = List(1,2,1,2)
    assert(List.sum3(list) == 6)
  }

  test("Product3 of a list"){
    val list = List(1.0,2.0,1.0,2.0)
    assert(List.product3(list) == 4)
  }

  test("FoldLeft of a list using sum"){
    val list = Cons(1,Cons(2,Cons(1, Cons(2, Nil))))
    assert(List.foldLeft(list, 0)(_+_) == 6)
  }

  test("Drop while elements match predicate") {
    val list = List(1,2,3,4,5,6,7,8,9,10)
    val expectedList = List.dropWhile(list)(x => x < 7)
    assert(expectedList.toString.equals("Cons(7,Cons(8,Cons(9,Cons(10,Nil))))"))
  }

  test("Drop elements when list is null") {
    val list = Nil
    val expectedList = List.dropWhile(list)(x => x)
    assert(expectedList.toString.equals("Nil"))
  }

  test("Drop elements when none match the predicate") {
    val list = List(7,8,9,10)
    val expectedList = List.dropWhile(list)(x => x < 7)
    assert(expectedList.toString.equals("Cons(7,Cons(8,Cons(9,Cons(10,Nil))))"))
  }


  test("Compute the length of a list") {
    val list = List(1,2,3,4,5,6,7,8,9,10)
    assert(List.length(list) == 10)
  }

  test("Compute the length2 of a list") {
    val list = List(1,2,3,4,5,6,7,8,9,10)
    assert(List.length2(list) == 10)
  }

}

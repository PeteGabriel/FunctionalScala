package funcprogramming.functional_data_structures

import scala.annotation.tailrec


sealed trait List[+A] //Data type parameterized on a type, A.

case object Nil extends List[Nothing] //A List data constructor representing an empty list.

//Representing non-empty lists.
case class Cons[+A](head: A, tail: List[A]) extends List[A]


/**
  * Companion object to contain methods to work with lists.
  */
object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  /*
  Remove the first element of a List in constant time.
   */
  def tail[A](l: List[A]): List[A]  = l match {
    case Nil => throw new IllegalArgumentException
    case Cons(_, t) => t
  }

  /*
  Replace the first element of a List with a different value
   */
  def setHead[A](l: List[A], newHead: A): List[A] = l match {
    case Nil => Nil
    case Cons(_, t) => Cons(newHead, t)
  }

  /*
  Remove the first n elements from a list.
  Takes time proportional to the n elements being removed.
   */
  def drop[A](l: List[A], n: Int): List[A] =
    if (n <= 0) l
    else l match {
      case Nil => Nil
      case Cons(_, t) => drop(t, n-1)
    }

  /*
  Remove elements from the list prefix as long as they match a predicate.
   */
  def dropWhile[A](l: List[A]) (f: A => Boolean): List[A] = l match {
    case Nil => Nil
    case Cons(h, t) if f(h) => dropWhile(t)(f)
    case _ => l
  }

  def foldRight[A,B](l: List[A], z: B)(f: (A,B) => B): B = l match {
    case Nil => z
    case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  }

  def sum2(l: List[Int]) = foldRight(l, 0)((a,b) => a + b)


  /*
  Anonymous functions like '(x,y) => x*y' can be written as '_*_'
  in situations where the types of x and y could be inferred by Scala.
   */
  def product2(l: List[Double]) = foldRight(l, 1.0)(_ * _)


  def length[A](l: List[A]): Int = foldRight(l, 0)((_,acc) => acc+1)

  @tailrec
  def foldLeft[A,B](l: List[A], z: B)(f: (B,A) => B): B = l match {
    case Nil => z
    case Cons(h, t) => foldLeft(t, f(z,h))(f)
  }

  def sum3(l: List[Int]) = foldLeft(l, 0)((a,b) => a + b)


  /*
  Anonymous functions like '(x,y) => x*y' can be written as '_*_'
  in situations where the types of x and y could be inferred by Scala.
  */
  def product3(l: List[Double]) = foldLeft(l, 1.0)(_*_)


  def length2[A](l: List[A]): Int = foldLeft(l, 0)((acc,_) => acc+1)




}

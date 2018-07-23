package funcprogramming.handling_errors_without_exceptions

/**
  * Data type that encodes whatever information we want about failures.
  */

trait Either[+E, +A]
case class Left[+E](value: E) extends Either[E, Nothing]
case class Right[+A](value: A) extends Either[Nothing, A]


object Either {

  def map[B](f: Int => B): Either[String, B] = ???


}
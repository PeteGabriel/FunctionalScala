package funcprogramming.handling_errors_without_exceptions

sealed trait Either[+E, +A] {

  def map[B](f: A => B): Either[E,B] = this match {
    case Left(e) => Left(e)
    case Right(a) => Right(f(a))
  }

  def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B] = this match {
    case Left(e) => Left(e)
    case Right(a) => f(a)
  }

  def orElse[EE >: E, B >: A](b:  => Either[EE, B]): Either[EE, B] = this match {
    case Left(_) => b
    case Right(a) => Right(a)
  }

  def map2[EE >: E, B, C](b:  => Either[EE, B])(f: (A,B) => C) : Either[EE, C] =
    for { a <- this; b1 <- b } yield f(a, b1)
}

case class Left[+E](value: E) extends Either[E,  Nothing]

case class Right[+A](value: A) extends Either[Nothing, A]


object Either{

  def mean(source: IndexedSeq[Double]): Either[String, Double] =
    if (source.isEmpty)
      Left("Mean of empty list !")
    else Right(source.sum / source.length)

  def safeDivision(x: Int, y: Int): Either[Exception, Double] =
    try {
      Right(x/y)
    }
    catch {
      case e: Exception => Left(e)
    }

  def safeDivision2(x: Int, y: Int): Either[Exception, Double] = Try(x/y)

  private def Try[A](a: => A): Either[Exception, A] =
    try {
      Right(a)
    }
    catch {
      case e: Exception => Left(e)
    }








}

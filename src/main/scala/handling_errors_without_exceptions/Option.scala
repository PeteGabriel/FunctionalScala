package handling_errors_without_exceptions

sealed trait Option[+A] {

  /**
    * Apply f if the option is not None
    */
  def map[B](f: A => B): Option[B] = this match {
    case None => None
    case Some(v) => Some(f(v))
  }

  /**
    * Apply f, which may fail, to the Option if not None
    */
  def flatMap[B](f: A => Option[B]): Option[B] = this match {
    case None => None
    case Some(v) => f(v)
  }

  def flatMap_1[B](f: A => Option[B]): Option[B] = map(f).getOrElse(None)

  def getOrElse[B>:A](default: => B): B = this match {
    case None => default
    case Some(_) => _
  }

  def orElse[B>:A](ob: => Option[B]): Option[B] = this match {
    case None => ob
    case _ => this
  }

  /**
    * Convert Some to None if the value dont satisfy f.
    */
  def filter(f: A => Boolean): Option[A] = this match {
    case Some(v) if f(v) => Some(v)
    case _ => None
  }
}
case class Some[+A](get: A) extends Option[A]
case object None extends Option[Nothing]

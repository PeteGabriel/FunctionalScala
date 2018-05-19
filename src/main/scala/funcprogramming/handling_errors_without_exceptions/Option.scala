package funcprogramming.handling_errors_without_exceptions

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
    case Some(v) => v
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


object Option {

  def mean(xs: Seq[Double]): Option[Double] =
    if (xs.isEmpty) None
    else Some(xs.sum / xs.length)

  /*
  If the mean of a sequence is m, the variance is the mean of math.pow(x-m,2) for
  each element x in the sequence.
   */
  def variance(seq: Seq[Double]): Option[Double] =
    mean(seq) flatMap(m => mean(seq.map(elem => math.pow(m - elem, 2))))



  /*
  Combine two option values using a binary function. If either Option value is None,
  then return value is too.
   */
  def map2[A,B,C](a: Option[A], b: Option[B]) (f: (A,B) => C): Option[C] =
    a flatMap(aa => b map(bb => f(aa, bb)))

  def sequence[A](a: List[Option[A]]): Option[List[A]] = ???
}
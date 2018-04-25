package functional_data_structures

sealed trait Tree[+A]
case class Leaf[A](value:A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]



object Tree {


  /**
    * Counts the number of nodes (leaves and branches) in a tree.
    *
    * @param t the Tree
    * @tparam A Generic type
    * @return Size of Tree
    */
  def size[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 1
    case Branch(l,r) => size(l) + size(r) + 1
  }

  /**
    * Return the maximum element in a Tree[Int].
    * @param t The Tree
    * @return The highest element
    */
  def maximum(t: Tree[Int]): Int = t match {
    case Leaf(v) => t.asInstanceOf[Leaf[Int]].value.max(v)
    case Branch(l,r) => maximum(l) max maximum(r)
  }


  /**
    * Returns the maximum path length from the root
    * to any leaf.
    */
  def depth[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 1
    case Branch(l,r) => 1 + depth(l) max depth(r)
  }


  def map[A,B](t: Tree[A])(f: A => B): Tree[B] = t match {
    case Leaf(v) => Leaf(f(v))
    case Branch(l,r) => Branch(map(l)(f), map(r)(f))
  }


}
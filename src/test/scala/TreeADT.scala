import functional_data_structures.{Branch, Leaf, Tree}
import org.scalatest.FunSuite

class TreeADT extends FunSuite {

  test("Example tree has size of 7 (all nodes)") {
    val tree = Branch(Branch(Leaf("a"), Leaf("b")), Branch(Leaf("c"), Leaf("d")))
    assert(Tree.size(tree) == 7)
  }

  test("Example tree has the maximum value of 10"){
    val tree = Branch(Branch(Leaf(1), Leaf(10)), Branch(Leaf(8), Leaf(9)))
    assert(Tree.maximum(tree) == 10)
  }

  test("Example tree has the longest path of 5"){
    val tree = Branch(Branch(Branch(Branch(Leaf("x"), Leaf("y")), Leaf("b")), Leaf("c")), Branch(Leaf("d"), Leaf("e")))
    assert(Tree.depth(tree) == 5)
  }

  test("Double every element of example tree") {
    val tree = Branch(Branch(Leaf(1), Leaf(2)), Branch(Leaf(3), Leaf(4)))

    var treePrint = ""

    val tree2 = Tree.map(tree)(_ * 2)
    assert(treePrint  == "2468")

  }

}

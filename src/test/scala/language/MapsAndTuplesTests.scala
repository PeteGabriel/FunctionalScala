package language

import org.scalatest.FunSuite
import impatient.MapsTuples._

class MapsAndTuplesTests extends FunSuite{

  test("Count Words"){
    val currentPath = new java.io.File(".").getCanonicalPath()
    val wordsMap = countWords(currentPath + "/src/test/scala/resources/words.txt")
    val wordsImmutMap = countWordsImmutable(currentPath + "/src/test/scala/resources/words.txt")
    val sortedWordsMap = countWordsSorted(currentPath + "/src/test/scala/resources/words.txt")
    val treeWordsMap = countWordsWithTree(currentPath + "/src/test/scala/resources/words.txt")
    assert(wordsMap.nonEmpty)
    assert(wordsImmutMap.nonEmpty)
    assert(sortedWordsMap.nonEmpty)
    assert(treeWordsMap.nonEmpty)
  }

  test("Min eql 4 and Max eql 95 for a random sequence"){
    val seq = Array(68,80,7,36,52,28,49,10,20,5,88,95,89,66,4,25,85,58,12)
    val (min, max) = minAndMax(seq)
    assert(min == 4)
    assert(max == 95)
  }

  test("Min eql 1 and Max eql 1"){
    val seq = Array(1,1,1,1,1,1,1,1)
    val (min, max) = minAndMax(seq)
    assert(min == 1)
    assert(max == 1)
  }

  test("Min eql 100 and Max eql 100"){
    val seq = Array(100)
    val (min, max) = minAndMax(seq)
    assert(min == 100)
    assert(max == 100)
  }

  test("Count of values less than, equal to, and greater than 50"){
    val seq = Array(68,80,7,36,52,28,49,10,20,5,88,95,89,66,4,25,85,58,12)
    val (less, eql, greater) = lteqgt(seq, 50)
    assert(less == 10)
    assert(eql == 0)
    assert(greater == 9)
  }


}

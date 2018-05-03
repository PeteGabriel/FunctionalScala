import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import handling_errors_without_exceptions.{None, Option, Some}

import scala.annotation.tailrec

class ChapterFourTests extends FunSuite with BeforeAndAfter {

  var company: Array[Employee] = Array(
    Employee("Peter Gabriel", "A"),
    Employee("Gabriel", "A"),
    Employee("Peter", "B"),
    Employee("Joseph", "B"),
    Employee("Agnis", "C"),
    Employee("Dani Lewis", "D"))


  case class Employee(name: String, department: String)


  def lookupByName(name: String): Option[Employee] = {
    @tailrec
    def loop(index: Int, size: Int): Option[Employee] = {
      if (index < size && company(index).name == name) Some(company(index))
      else if (index >= size) None
      else loop(index + 1, size)
    }
    loop(0, company.length - 1)
  }

  test("Look up employee with name Peter and map to its department") {
    val employeeDepartment: Option[String] = lookupByName("Peter").map(_.department)
    assert(employeeDepartment.asInstanceOf[Some[String]].get == "B")
  }

  test("If employee is not found get default value instead") {
    val employeeDepartment: String = lookupByName("Pietro").map(_.department).getOrElse("None")
    assert(employeeDepartment == "None")
  }

  test("If employee is not found and no default value set, expect None") {
    val employeeDepartment: Option[Employee] = lookupByName("Pietro")
    assert(employeeDepartment == None )
  }

}

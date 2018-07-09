package fp

import funcprogramming.handling_errors_without_exceptions.{None, Option, Some}
import org.scalatest.FunSpec

import scala.annotation.tailrec

class ChapterFourTests extends FunSpec{

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

  def lookupByNameEither(name: String): Either[Exception, Employee] = {
    @tailrec
    def loop(index: Int, size: Int): Either[Exception, Employee] = {
      if (index < size && company(index).name == name)
        Right(company(index))
      else if (index >= size)
        Left(new Exception("No employee found with name " + name))
      else loop(index + 1, size)
    }
    loop(0, company.length - 1)
  }


  describe("Testing Option trait") {

    it("Look up employee with name Peter and map to its department") {
      val employeeDepartment: Option[String] = lookupByName("Peter").map(_.department)
      assert(employeeDepartment.asInstanceOf[Some[String]].get == "B")
    }

    it("If employee is not found get default value instead") {
      val employeeDepartment: String = lookupByName("Pietro").map(_.department).getOrElse("None")
      assert(employeeDepartment == "None")
    }

    it("If employee is not found and no default value set, expect None") {
      val employeeDepartment: Option[Employee] = lookupByName("Pietro")
      assert(employeeDepartment == None)
    }
  }


  describe("Testing the Either trait"){

    it("Look up an existing employee"){
      val dept: Either[Exception, String] = lookupByNameEither("Peter").map(_.department)
      assert(dept.asInstanceOf[Right[Exception, String]].value == "B")
    }

    it("Look up a none existing employee should give error description"){
      val dept: Either[Exception, String] = lookupByNameEither("Lord Peter").map(_.department)

      lookupByNameEither("Pedro").map2()
      assert(dept.asInstanceOf[Left[Exception, String]].value.getClass.getSimpleName == "Exception")
      assert(dept.asInstanceOf[Left[Exception, String]].value.getMessage == "No employee found with name Lord Peter")
    }

  }



}

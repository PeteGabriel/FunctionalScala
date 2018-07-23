package funcprogramming.tail_recursion

object TailRecursion {


  def balance(chars: List[Char]): Boolean = {

    def checkBalance(chars: List[Char], counter: Int): Boolean = {
      if (chars.isEmpty && counter == 0) return true
      if (chars.head == '(') return checkBalance(chars.tail, counter + 1)
      if (chars.head == ')' && counter < 1) return false
      if (chars.head == ')') return checkBalance(chars.tail, counter - 1)

      checkBalance(chars.tail, counter)
    }

    checkBalance(chars, 0)
  }

  def countChange(money: Int, coins: List[Int]): Int =
    if(money == 0) 1
    else if(money > 0 && coins.nonEmpty)
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    else 0

  def pascal(c: Int, r: Int): Int = if (c == 0 || c == r) 1 else pascal(c, r-1) + pascal(c-1, r-1)
}

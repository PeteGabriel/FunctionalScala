

## 1 - Pure functions

A pure functions is a function with _no side effects_ other than compute a result given its inputs.

```scala
def intoString(n: Int): String = "".format(n)
```

## 2 - High-Order functions

Functions that accept other functions as parameters.


```scala
def isSorted[A](source: Array[A], ordered: (A,A) => Boolean): Boolean = {
    def loop(iteration: Int, acc: Boolean): Boolean = {
      if (iteration >= source.length) acc
      else if (ordered(source(iteration - 1), source(iteration))) loop(iteration + 1, true)
      else false
    }
    loop(1, false)
  }
```

## 3 - Tail-call in Scala

A call is said to be in tail if the caller does nothing other than return the value of the recursive
call. In this case, Scala will compile the recursion to iterative loops that don't consume the call
stack.


```scala
def factorial(n: Int): Int = {
    @tailrec
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n-1, n*acc)
    go(n, 1)
  }
```



## 4 - Handling errors without exceptions

The functional solution of returning errors as values is safer and
retains referential transparency, and through the use of higher-order functions, we can
preserve the primary benefit of exceptions - _consolidation of error-handling logic_.

### Option

The solution is to represent explicitly in the return type that a function may not always
have an answer. We can think of this as deferring to the caller for the error-handling strategy.

```scala
sealed trait Option[+A] {

  def map[B](f: A => B): Option[B]
  def getOrElse[B>:A](default: => B): B
  ...
}
```

Usage example:

```scala
lookupByName("Pete").map(_.department).getOrElse("Default Dept")
```



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
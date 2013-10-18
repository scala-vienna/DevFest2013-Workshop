import org.scalatest.FunSuite
import devfest.????
import scala.annotation.tailrec

/**
 * In this part of the workshop we are a going to learn about
 * functions in Scala and their "status" as first-class citizens.
 */
class FunctionsSuite extends FunSuite {

  /**
   * Takeaways from this section:
   *
   *   - What are functions and what differentiates them from methods?
   *   - What are anonymous functions and why are they useful?
   *   - What are higher-order functions and why should I care?
   *
   * Credits
   *
   * The following exercises are based on Chapter 5 of the book
   *
   *   "Scala by Example" by Martin Odersky:
   *    http://www.scala-lang.org/docu/files/ScalaByExample.pdf
   *
   * which in turn is based on material from the book
   *
   *   "Structure and Interpretation of Computer Programs"
   *   by Harold Abelson and Gerald Jay Sussman:
   *   http://mitpress.mit.edu/sicp/full-text/book/book.html
   */

  /**
   * Methods are always part of an object whereas functions have 
   * an existence of their own as values.
   * 
   * Let's create a function that squares a given number.
   *
   * Notes: we do not need to explicitly indicate the return type
   * of the function since, the Scala compiler will take it to be 
   * the type of the last expression in the function body
   */
  def square(n: Int) = n * n

  test("square(n) does what it should") {
    assert(square(2) === 4)
    assert(square(3) === 9)
  }

  /**
   * Exercise 1
   *
   * Now we create a function that returns the given base to
   * the given exponent.
   *
   * Note: in Scala the "&#94;" operator is used for bitwise
   * operations but you can use Math.pow(base, exponent)
   * which returns a double.
   * 
   * You will then need to convert the result to an Int which
   * is usually done with .toInt
   */
  def power(base: Int, exponent: Int): Int = ???

  test("power(base, exponent) does what it should") {
    assert(power(2, 4) === 16)
    assert(power(3, 2) === 9)
  }

  /**
   * Exercise 2
   *
   * Let's create now a function that adds all integers between two
   * given numbers.
   *
   * You can think first about the implementation in an iterative 
   * way with a for loop.
   * 
   *  for (i <- a to b) {
   *    ...
   *  }
   *
   * Note: you can use curly braces when you have more than one
   * expression in the body of a function.
   */
  def sumIntsIter(a: Int, b: Int): Int = {
    var sum = 0
    ???
  }

  test("sumIntsIter(a, b) does what it should") {
    assert(sumIntsIter(1, 3) === 6)
    assert(sumIntsIter(4, 5) === 9)
  }

  /**
   * Exercise 3
   *
   * How would you do the same but in a recursive way?
   *
   * Note: remember you need to consider the base case,
   * i.e. when a > b and then the recursive case.
   *         
   *           2 3 4 5 6 7 8 9 ...
   *        |-|-|-|-|-|-|-|-|-|-|-|
   *           a       b        
   */
  def sumInts(a: Int, b: Int): Int = ???

  test("sumInts(a, b) does what it should") {
    assert(sumInts(1, 3) === 6)
    assert(sumInts(4, 5) === 9)
  }

  /**
   * Bonus
   *
   * As you can see the previous implementation of sumInts() is recursive.
   * When the last expression in the body of a recursive function is the
   * recursive call, then we recursive function can be converted to an
   * iteration-based implementation by the compiler.
   *
   * See: http://en.wikipedia.org/wiki/Tail_call
   *
   * Here we can see that Scala also allows for nesting functions within
   * other functions!
   */
  def sumIntsTailRec(a: Int, b: Int): Int = {
    @tailrec
    def sumIntsTailRecAux(pos: Int, sum: Int): Int = {
      if (pos > b) sum else sumIntsTailRecAux(pos + 1, sum + pos)
    }
    sumIntsTailRecAux(a, 0)
  }

  test("sumIntsTailRec(a, b) does what it should") {
    assert(sumInts(1, 3) === sumIntsTailRec(1, 3))
    assert(sumInts(4, 5) === sumIntsTailRec(4, 5))
  }

  /**
   * Exercise 4
   *
   * Now we are in a good position to create a recursive function
   * that squares all integers between two given numbers!
   *
   * Note: think again about the base case as before!
   */
  def sumSquares(a: Int, b: Int): Int = ???

  test("sumSquares(a, b) does what it should") {
    assert(sumSquares(1, 3) === 14)
    assert(sumSquares(4, 5) === 41)
  }

  /**
   * Exercise 5
   *
   * You have probably have already noticed that there is a
   * pattern in the previous exercises!
   *
   *  - sumRec(a, b): calculates the sum of all integers
   *                  between a and b
   *
   *  - sumSquares(a, b): calculates the sum of the squares
   *                      of all integers between a and b
   *
   * The pattern is that we are calculating the sum of a
   * function applied to all integers between two given
   * numbers!
   *
   *  - sumRec(a, b): the function is the identity function
   *                 f(n) = n
   * 
   *  - sumSquares(a, b): the function is the square function
   *                      f(n) = n * n
   *
   * could we generalize this?
   *
   * Yes! This is where the power of higher-order functions comes in!
   * Let's create a "sum" function that takes another function as an
   * argument and calculates the sum of applying that function to all
   * integers between two given numbers.
   *
   * Note at how the f parameter is defined with the "=>" symbol to
   * indicate the f is a function that takes one Int argument and
   * returns an Int!
   */
  def sum(f: Int => Int, a: Int, b: Int): Int = ???

  /*
   * Since we had not defined yet the identity function, we do
   * it now here to be able to write our tests afterwards
   */
  def identity(n: Int): Int = ???

  /*
   * The square(n) function we had already defined before
   */
  
  // Now you can complete the tests below
  test("sum(f, a, b) does what it should") {
    assert(sum(???, 1, 3) === 6)
    assert(sum(???, 1, 3) === 14)
  }

  /**
   * Exercise 6
   *
   * So far so good! But sometimes we do not want to give a name 
   * to a function and just pass that function around. This is 
   * where anonymous functions or function literals come in very
   * handy.
   * 
   * Let's remember the syntax of a function
   * 
   *  ( arg1: TypeArg1, arg2: TypeArg2, ... ) => TypeOfResult
   * 
   */
  test("anonymous functions") {
    assert(identity(1) === 1)
    /*
     * Uncomment the test below and replace "identity" with an
     * anonymous function that does the same
     */
    //assert(??? === 1)

    assert(square(2) === 4)
    /*
     * Do the same here with "square"
     */
    //assert(??? === 4)
  }

  test("sum(f, a, b) does what it should with anonymous functions") {
    assert(sum(identity, 4, 5) === 9)
    /*
     * Uncomment the test below and replace "identity" with an
     * anonymous function that does the same
     */
    //assert(??? === 9)

    assert(sum(square, 4, 5) === 41)
    /*
     * Do the same here with "square"
     */
    //assert(??? === 41)
  }

  /**
   * Wrapping up
   *
   * All the functions that we have created in the previous exercises
   * were actually methods! We have been cheating a bit because we
   * did not want to bring in too many new things at the same time!
   * They are all methods of the FunctionSuite class. But you have
   * been able to see that even if they are methods, Scala allows
   * you to pass them around as arguments
   *
   * In Scala, functions are first-class citizens, i.e. they are 
   * objects that can be passed around like any other value.
   *
   * We can create a function from a method!
   * For instance, we can create a function that computes the 2 to
   * the power of n.
   */
  val powerOfTwo = (n: Int) => power(2, n)
  val powerOfThree = (n: Int) => power(3, n)

  test("powerOfTwo() function and power() method give the same results") {
    assert(powerOfTwo(4) === power(2, 4))
    assert(powerOfThree(3) === power(3, 3))
  }
}
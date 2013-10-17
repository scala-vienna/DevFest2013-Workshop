import org.scalatest.FunSuite
import devfest.????

/**
 * In this part of the workshop we are a going to learn about
 * functions in Scala and their "status" as first-class citizens.
 */
class FunctionsSuite extends FunSuite {

  /**
   * Takeaways from this sections:
   *
   *   - What are functions and what differentiates them from methods?
   *   - What are anonymous functions and why are they useful?
   *   - What are higher-order functions and why should I care?
   *
   * Credits
   *
   * The following exercises are based on Chapter 5 of the book
   * "Scala by Example" by Martin Odersky: 
   * http://www.scala-lang.org/docu/files/ScalaByExample.pdf
   * which in turn is based on material from the book
   * "Structure and Interpretation of Computer Programs" 
   * by Harold Abelson and Gerald Jay Sussman:
   * http://mitpress.mit.edu/sicp/full-text/book/book.html
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
   * Now we create a function that returns 2 to the given exponent.
   *
   * Notes: in Scala the "&#94;" operator is used for bitwise 
   * operations but you can use the method Math.pow(base, exponent) 
   * which returns a double.
   * 
   * You will then need to convert the result to an Int which is
   * usually done with .toInt
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
   * You can think first about the implementation in an iterative 
   * way with a for loop.
   * 
   *  for (i <- a to b) {
   *    ...
   *  }
   *
   * Notes: you can use curly braces when you have more than one 
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
   * Notes: remember you need to consider the base case, 
   * i.e. when a > b
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
   * Exercise 4
   *
   * Now we are in a good position to create a recursive function
   * that squares all integers between two given numbers!
   *
   * Notes: think again about the base case as before!
   */
  def sumSquares(a: Int, b: Int): Int = ???

  test("sumSquares(a, b) does what it should") {
    assert(sumSquares(1, 3) === 14)
    assert(sumSquares(4, 5) === 41)
  }

  /**
   * Exercise 5
   *
   * You have probably have already noticed that there is a pattern
   * the previous exercises!
   *
   * In sumRec(a, b) we are calculating the sum of all integers 
   * between a and b
   * In sumSquares(a, b) we are calculating the sum of the squares
   * of all integers between a and b
   *
   * We are calculating the sum of a function applied to all integers
   * between two given numbers!
   *
   * in sumInts(a, b) the function is the identity function: 
   *    f(n) = n
   * 
   * in sumSquares(a, b) the function is the square function: 
   *    f(n) = n * n
   *
   * could we generalize this?
   *
   * Yes! This is where the power of higher-order functions comes in!
   * Let's create a sum function that takes another function as an 
   * argument and calculates the sum of applying that function to all
   * integers between two given numbers.
   *
   * Note at how the f parameter is defined with the "=>" symbol to
   * indicate the f is a function that takes one Int argument and
   * returns an Int!
   */
  def sum(f: Int => Int, a: Int, b: Int): Int = ???

  // We first define the identity function
  def identity(n: Int) = ???

  // The square(n) function we had already defined before
  
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
   * where anonymous functions come in handy.
   * 
   * Let's remember the syntax of a function
   * 
   *  ( arg1: TypeArg1, arg2: TypeArg2, ... ) => TypeOfResult
   * 
   */
  test("anonymous functions") {
    assert(identity(1) === 1)
    // Replace "identity" with an anonymous function
    assert(??? === 1)

    assert(square(2) === 4)
    // Do the same here with "square"
    assert(??? === 4)
  }

  test("sum(f, a, b) does what it should with anonymous functions") {
    assert(sum(identity, 4, 5) === 9)
    // Replace "identity" with an anonymous function
    assert(??? === 9)

    assert(sum(square, 4, 5) === 41)
    // Do the same here with "square"
    assert(??? === 41)
  }

  /**
   * Wrapping up
   *
   * All the functions that we have created in the previous exercises
   * were actually methods! We have been cheating a bit!
   * They are all methods of the FunctionSuite class.
   *
   * In Scala, functions are first-class citizens, i.e. they are 
   * objects that can be passed around like any other value.
   */
  object Test {
    def squareMethod(n: Int) = n * n
    val squareFunction1 = (n: Int) => n * n
    val squareFunction2 = squareMethod(_)
    val squareFunction3 = squareMethod(3)
    
  }

  test("square() method and function give same results") {
    assert(Test.squareMethod(3) === Test.squareFunction1(3))
    assert(Test.squareMethod(3) === Test.squareFunction2(3))
    assert(Test.squareFunction3 === 9)
  }
}
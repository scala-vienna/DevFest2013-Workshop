import org.scalatest.FunSuite

class HelloFunSuite extends FunSuite{
  /**
   * This is our first exercise. We will use ScalaTest library
   * for unit testing.
   *
   * This exercise is about null in Scala.
   */

  /**
   * This is just for those who havent' seen Scala yet.
   * We use val for variables.
   * We do not have to specify any type, Scala is clever enough
   * to figure it out.
   * You do not have to use semi-colon either to separate
   * statements.
   */
  test("1 + 1 = 2") {
    val i = 1 + 1
    assert(i == 3)
  }

  /**
   * You do not have to use tricky method names for tests like
   * testThatTwoPlusTwoIsFive
   * Just use any meaningful tests as method parameter.
   *
   * Tip: if you use === operator, you see not only that test failed
   * but also concrete values that were not equal
   */
  test(" 2 + 2 - 1 + 2 - 3 + 4 - 3 sums to 3") {
    val i = 2 + 2 - 1 + 2 - 3 + 4 - 3
    assert(i === 5)
  }

}
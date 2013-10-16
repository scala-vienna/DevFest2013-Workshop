import org.scalatest.FunSuite

class PatMatSuite extends FunSuite {

  /**
   * Exercise 1
   *
   * In the most simple case, Scala's Pattern Matching can be roughly compared to
   * Java's switch-statements. However, we will soon see that Pattern Matching
   * has many additional use cases and is actually much more powerful ;)
   *
   * The following function should return the value of the given Integer 1, 2 or 3
   * as english word. For any other Integer, the method should return 'unknown'
   *
   * Notes:
   * # Since everything in Scala is an expression, you can automatically return
   * the 'result' of a pattern match.
   */
  def matchNumber(num: Int): String = {
    num match {
      case 1 => "one"
      case 2 => "two"
      // TODO insert missing case
      case _ => "unknown"
    }
  }

  test("matchNumber") {
    assert(matchNumber(1).equals("one"))
    assert(matchNumber(2).equals("two"))
    assert(matchNumber(3).equals("three"))
    assert(matchNumber(5).equals("unknown"))
  }

  /**
   * Exercise 2
   *
   * Consider the following task: We want to write a function that returns a
   * specific text depending on the type that has been passed to the function.
   * In some cases the returned text might even refer to a property of the
   * given object.
   *
   * One possible approach would be to use isInstanceOf[Type] and asInstanceOf[A]
   * to detect and cast the object to the given type. However, these two functions
   * are very low-level and can lead to type errors at runtime. For these reasons
   * it's not recommended to use them.
   *
   * Pattern Matching provides a much more elegant (and typesafe) solution for
   * this task: It allows us to match the type of the given object.
   *
   * To see this feature in action, complete the following function to return
   * different texts depending on whether a String, a User or an Address has
   * been passed to the function.
   */
  def matchType(someObject: Any): String = {
    someObject match {
      case s: String => "String '" + s + "'"
      case u: User => "User with name " + u.name
      // TODO insert missing case which should return a String saying 'Address with city ...'
      case _ => "unknown"
    }
  }

  case class User(name: String, email: String, age: Int)
  case class Address(street: String, city: String, country: String)

  test("matchType") {
    assert(matchType("Hello") === "String 'Hello'")
    assert(matchType(User("Joe", "joe@example.org", 35)) === "User with name Joe")
    assert(matchType(Address("Some Street", "Vienna", "Austria")) === "Address with city Vienna")
    assert(matchType(7.5) === "unknown")
  }

  /**
   * Exercise 3
   *
   * Often we want to know
   *   1) which subclass of a common supertype was used
   *   2) and what where the arguments of the constructor
   *
   * For this task we can use constructor matching.
   *
   * Can you add the required case and the respective case class to
   * enable the evaluation of a subtraction?
   */
  trait Expr {
    def eval(): Int = {
      this match {
        case Num(n) => n
        case Add(e1, e2) => e1.eval + e2.eval
      }
    }
  }

  case class Num(num: Int) extends Expr
  case class Add(e1: Expr, e2: Expr) extends Expr

  test("exercise 4") {
    assert(Num(4).eval === 4)
    assert(Add(Num(2), Num(5)).eval === 7)
    //assert(Sub(Num(10), Num(7)).eval == 3)
  }

  /**
   * Exercise 5
   *
   * tbd
   */
  def advancedMatching(user: User): String = {
    user match {
      case User("jim", _, _) => "This is Jim"
      case User(_, _, 28) => "Person of age 28"
    }
  }

  test("exercise 5") {
    assert(advancedMatching(User("jim", "x", 0)) === "This is Jim")
  }

}

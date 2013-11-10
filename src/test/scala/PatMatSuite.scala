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
   * as english word. For any other Integer, the function will throw a MatchError.
   *
   * Notes:
   * # Since everything in Scala is an expression, you can automatically return
   *   the 'result' of a pattern match.
   * # A MatchError indicates that the matcher encountered an object that didn't
   *   match any of the provided cases. This is different to Java, where such
   *   problems often remain undetected, since no error is thrown.
   * # You can specify a 'catch-all' or wildcard pattern, that is similar to
   *   Java's default case. In Scala, such a default case is written as case _ => ...
   */
  def matchNumber(num: Int): String = {
    num match {
      case 1 => "one"
      case 2 => "two"
      case 3 => "three"
    }
  }

  test("exercise 1") {
    assert(matchNumber(1) === "one")
    assert(matchNumber(2) === "two")
    assert(matchNumber(3) === "three")
    intercept[MatchError] {
      assert(matchNumber(5) === "five")
    }
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
   *
   * Notes:
   * # In this example we use the wildcard pattern (mentioned in exercise 1) to
   *   handle all objects that are neither of type String, User or Address.
   */
  def matchType(someObject: Any): String = {
    someObject match {
      case s: String => "String '" + s + "'"
      case u: User => "User with name " + u.name
      case a: Address => s"Address with city ${a.city}" // Scala also provides String interpolation
      case _ => "unknown"
    }
  }

  case class User(name: String, email: String, age: Int)
  case class Address(street: String, city: String, country: String)

  test("exercise 2") {
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
   * Can you add the required case to enable the evaluation of subtractions?
   */
  trait Expr {
    def eval(): Int = {
      this match {
        case Num(n) => n
        case Add(e1, e2) => e1.eval + e2.eval
        case Sub(e1, e2) => e1.eval - e2.eval
      }
    }
  }

  case class Num(num: Int) extends Expr
  case class Add(e1: Expr, e2: Expr) extends Expr
  case class Sub(e1: Expr, e2: Expr) extends Expr

  test("exercise 3") {
    assert(Num(4).eval === 4)
    assert(Add(Num(2), Num(5)).eval === 7)
    assert(Sub(Num(10), Num(7)).eval === 3)
  }

  /**
   * Exercise 4
   *
   * Constructor patterns can also match concrete values of objects.
   * In the following example we specify patterns that match certain
   * books depending on their title, author or number of pages.
   *
   * This example also introduces 'guards' which can be used to
   * specify conditions that must be fulfilled by the matched object.
   * In our example, the second case matches any book with more
   * than 1000 pages.
   *
   * Your task is to add another matcher for a book with the title "1984"
   * by author "George Orwell" and return "Big Brother is Watching You"
   */
  def advancedMatching(book: Book): String = {
    book match {
      case Book("Game of Thrones", _, _) => "Winter is coming"
      case Book(_, _, pages) if pages > 1000 => "This is a really long book!"
      case Book("1984", "George Orwell", _) => "Big Brother is Watching You"
      case _ => "you should read more books"
    }
  }

  case class Book(title: String, author: String, pages: Int)

  test("exercise 4") {
    assert(advancedMatching(Book("Game of Thrones", "George R.R. Martin", 478))
      === "Winter is coming")
    assert(advancedMatching(Book("LOTR 1-3", "J.R.R. Tolkien", 1377))
      === "This is a really long book!")
    assert(advancedMatching(Book("1984", "George Orwell", 342))
      === "Big Brother is Watching You")
    assert(advancedMatching(Book("some book", "some author", 123))
      === "you should read more books")
  }
}
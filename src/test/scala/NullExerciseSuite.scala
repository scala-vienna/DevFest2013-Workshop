import devfest.{***, ???}
import org.scalatest.FunSuite


class NullExerciseSuite extends FunSuite {
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
  test(" 2 + 2 - 1 + 2 - 3 + 4 - 3 sums to 4") {
    val i = 2 + 2 - 1 + 2 - 3 + 4 - 3
    assert(i === 5)
  }

  /**
   * Let's start with something more interesting.
   * Case classes are what is in Java known as
   * data transfer objects.
   * They have equals and toString for you automatically.
   *
   * There is a new keyword for you - Option.
   * It is Scala way to express type with optional values.
   * Option[A] can be instance of Some[A] or None
   */
  case class User(
                   id: Int,
                   name: String,
                   age: Int,
                   gender: Option[String]
                   )

  /**
   * Here is how you use value that is not null.
   * Use "male" value here with Some instance
   * and "null" for squirrel
   */
  test("None is null and != null is Some") {
    val radim: Option[User] = Some(User(1, "Radim", 32, ???))
    assert(radim.get.gender.isDefined)

    val squirrel: Option[User] = Some(User(1, "Ice Age", 100, ???))
    assert(squirrel.isEmpty)
  }


  /**
   * Let's code something more difficult.
   * We have map of users (see how Scala elegant is?)
   * and we have two methods.
   *
   * findById may and may not return values.
   */
  object UserRepository {
    private val users = Map(
      1 -> User(1, "Radim", 32, Some("male")),
      2 -> User(2, "Ice Age Squirrel", 100, None),
      3 -> User(3, "Bill", 55, Some("male")),
      5 -> User(5, "Petra", 25, Some("woman")),
      4 -> User(4, "David", 45, Some("male"))
    )

    def findById(id: Int): Option[User] = users.get(id)

    def findAll = users.values
  }

  /**
   * This is Guava (Google collections) library way how to do
   * it in Java.
   *
   * Here search for method that returns alternative if
   * value is not defined from <code>user2</code2>.
   * Use http://www.scala-lang.org/api/current/index.html#scala.Option
   */
  test("user with id=2 should have undefined gender") {
    val user1 = UserRepository.findById(1)
    if (user1.isDefined) {
      assert("Radim" === user1.get.name)
    }
    val user2 = UserRepository.findById(2)
    assert("Gender not specified" === ???)
  }

  /**
   * Here some examples with filtering.
   */
  test("filtering should return None or Some") {
    assert(??? == UserRepository.findById(1).filter(_.age > 40))
    val filter = UserRepository.findById(2).filter(_.age > 30)
    assert(filter.isInstanceOf[***])
    // there isn't any user with id 100
    assert(??? ==UserRepository.findById(100).filter(_.age > 1))
  }

  /**
   * And final example. Using for comprehensions.
   *
   * Tip: use Console.out.println() and genders.mkString
   */
  test("extract gender types from repository") {
    val genders = for {
      user <- UserRepository.findAll
      gender <- user.gender
    } yield gender


    assert(??? == genders.size)
  }
}
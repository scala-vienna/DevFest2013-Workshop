import org.scalatest.FunSuite

class CollectionsSuite extends FunSuite {

  /**
   * What do you thing an empty list is written?
   */
  test("empty list") {
    val emptyList = List(???)
    assert(emptyList.isEmpty, "List should be empty")
  }

  /**
   * Simple example to show a simple list.
   *
   * Can you correct the list so that it satisfies the conditions?
   */
  test("should contain numbers from 1 to 3") {
    val list = List(0)

    assert(list.size === 3, "List should have 3 elements")
    assert(list.head === 1, "First element should be 1")
    assert(list.tail === List(2, 3), "Elements past first one should be 2,3")
  }

  /**
   * You can access elements in a collection by treating it as a
   * function and passing the index as a parameter. Indexes are 0 based.
   *
   * For example:
   *  val skywalkers = List("Luke", "Leia", "Anakin")
   *  println(skywalkers(1))  // output: "Leia"
   *
   * Can you get the correct flavors?
   * Bonus: access the first element using a special method (see above)
   */
  test("accessing elements") {
    val flavors = List("Banana", "Strawberry", "Chocolate", "Vanilla")

    assert("Chocolate" === ???, "Write an expression to get Chocolate")
    assert("Banana" === ???, "Write an expression to get Banana")
  }

  /**
   * You can add an element in two ways: appending and pre-pending.
   * Appending: List(1,2,3) :+ 4  // output: List(1,2,3,4)
   * Prepending: 4 :: List(1,2,3) // output: List(4,1,2,3)
   *
   * NOTE: the default implementation of List is *immutable*; adding
   * an element will give you a new collection.
   *
   * Complete the love-triangle to add drama to the story.
   */
  test("appending an element") {
    val couple = List("Scott Summers", "Jean Grey")
    val loganLast = couple // append "Logan" to the collection
    val loganFirst = couple // prepend "Logan" to the collection

    assert(loganLast.size === 3, "A love triangle should have 3 persons")
    assert(loganLast(2) === "Logan", "Should end with Logan")

    assert(loganFirst.size === 3, "A love triangle should have 3 persons")
    assert(loganFirst.head === "Logan", "Should start with Logan")
  }

  /**
   * Filtering is done by passing an anonymous function which
   * takes as a parameter an element of the same type as the list.
   *
   * NOTE: the type declaration in the closure is automatically
   * type-inferenced. No need to declare types.
   *
   * Here we filter all even numbers.
   * Can you find the bugs?
   */
  test("filtering even numbers") {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8)
    val evenNrs = numbers.filter(n => n % 3 == 0)

    assert(evenNrs.size === 4, "Should find 4 even numbers")
    assert(evenNrs.contains(1), "Should contain 1")
    assert(!evenNrs.contains(2), "Should not contain 2")
  }

  /**
   * For simple expressions in a closure, you can skip parameter
   * declaration. Instead, you can use the "wildcard-argument".
   *
   * For example:        n => n / 2
   * Can be written as:  _ / 2
   *
   * Here we filter numbers greater than 4.
   * Can you find the bug?
   */
  test("filtering numbers greater than 4") {
    val numbers = List(1, 2, 3, 4, 5, 6, 7)
    val evenNrs = numbers.filter(_ > 44)

    assert(evenNrs.size === 3, "Should find 3 numbers")
    assert(evenNrs.contains(5), "Should contain 5")
    assert(!evenNrs.contains(4), "Should not contain 4")
  }

  /**
   * We want to select all names containing "e" (all cases!)
   *
   * HINT: String has methods "contains" and "toLowerCase"
   *
   * Can you use the wildcard-argument described above to
   * solve this?
   */
  test("filtering names") {
    val names =
      List(
        "Abraham",
        "Matthew",
        "Franz",
        "Roland",
        "Raphael",
        "Ernest")
    val withE = names.filter(???)

    assert(withE.size === 3)
    assert(withE.head === "Matthew", "First name should be Matthew")
    assert(withE.contains("Ernest"), "Should contain Ernest")
    assert(withE.contains("Raphael"), "Should contain Raphael")
  }

  /**
   * With the method "exists" you can see if there
   * is an element that satisfies a condition.
   *
   * With "count" you can count how many satisfy that
   * condition.
   *
   * Help! Is there a doctor in the audience? Find out.
   * Also find out how many developers are in the list.
   *
   */
  test("find a doctor and how many developers") {
    val people = List("Fritz(dev)", "Franz(dev)", "Fred(doc)", "Fran(dev)")
    val isThereADoctor = ??? // use "exists" on the list
    val howManyDevs = ??? // use "count" on the list

    assert(true === isThereADoctor, "There should be doctor")
    assert(3 === howManyDevs, "There should be 3 developers")
  }

  /**
   * Mapping lets you apply, or "map", a function to a
   * collection of values.
   *
   * For example: List(1,2,3,4).map(n => n * 2)
   * Output: List(2,4,6,8)
   *
   * If you need multiple lines, you can use curly brackets
   * instead of normal parenthesis. Like:
   *
   * List(1,2,3,4).map{ n =>
   *   ...
   *   ...
   * }
   *
   * Can you extract the domain names from the e-mail addresses?
   * Can you extract their secret bases from the domains?
   *
   * HINT: String has the method "split", and the method
   * dropRight(n) which you can use to drop the last n elements
   * of a collection (String is a collection)
   *
   */
  test("mapping") {
    val emails =
      List(
        "batman@batcave.com",
        "superman@solitude.com",
        "heman@grayskull.com")
    val domains = emails.map { e =>
      ???
    }
    val bases = domains.map(d => ???)

    assert(List("batcave.com", "solitude.com", "grayscull.com") === domains)
    assert(List("batcave", "solitude", "grayscull") === bases)
  }

  /**
   * Let's revise some programming language history.
   * 
   * Can you sort these according to their year of
   * appearance?
   * 
   * You can use the method "sortBy" on a collection.
   * The parameter for sortBy should be a closure that returns
   * a numerical value. The collection will be sorted ascendingly
   * using that numerical value.
   * 
   * Example:
   *   List("abc","ab","a","abcde","abcd").sortBy(_.length)
   * Output:
   *   List(a, ab, abc, abcd, abcde) 
   * */
  test("sorting programming languages") {
    val langs = List(
      "Scala: 2003",
      "Lisp: 1958",
      "Java: 1995",
      "Haskell: 1990",
      "Smalltalk: 1972 ",
      "Ruby: 1995",
      "Erlang: 1986",
      "C#: 2000")
    val sorted = List(???)
    assert("Lisp: 1958" === sorted.head, "In the beginning, it was Lisp")
    assert("Scala: 2003" === sorted(7), "The youngest language of the lot is Scala")
    
    // Bonus, use "map" to extract the years, and "sorted" on them 
    // val sortedYears = ???
    // assert(List(1958, 1972, 1986, 1990, 1995, 1995, 2000, 2003) === sortedYears)
  }

  test("reducing") { pending }

  test("grouping") { pending }

  test("sliding") { pending }

}
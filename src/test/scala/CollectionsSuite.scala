import org.scalatest.FunSuite

class CollectionsSuite extends FunSuite {

  /**
   * What do you think an empty list is written?
   */
  test("empty list") {
    val emptyList = List(???) // fix this
    assert(emptyList.isEmpty, "List should be empty")
  }

  /**
   * Simple example to show a simple list.
   *
   * Can you correct the list so that it satisfies the conditions?
   */
  test("should contain numbers from 1 to 3") {
    val list = List(0) // fix

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
    val thirdElement = ???
    val firstElement = ??? // bonus: use specific method

    assert("Chocolate" === thirdElement, "Write an expression to get Chocolate")
    assert("Banana" === firstElement, "Write an expression to get Banana")
  }

  /**
   * Immutable List: adding elements.
   *
   * NOTE: the default implementation of List is IMMUTABLE:
   *   adding/removing an element will give you a *new* collection.
   *
   * You can add an element in two ways: appending and pre-pending.
   *
   * Appending: List(1,2,3) :+ 4  // output: List(1,2,3,4)
   * Prepending: 4 :: List(1,2,3) // output: List(4,1,2,3)
   *
   * Alternate way to prepend: 4 +: List(1,2,3)
   *
   * The colon ":" points to the position the new element will
   * be added to the list.
   * 
   * Consider the TDD cycle. We found a developer moving from
   * "test/fail" to "implement/pass". We would like to illustrate
   * what happened before and after that, which is: refactoring!
   * 
   * Create two collections, one with "refactor" at the beginning
   * and the other with "refactor" at the end. 
   */
  test("adding an element to an immutable list") {
    val incompleteTdd = List("test/fail", "implement/pass")
    val refactorLast = "refactor"  // append "refactor" 
    val refactorFirst = "refactor" // prepend "refactor"

    // Note that original "incompleteTdd" collection was not modified!
    assert(incompleteTdd.size === 2, "The original tdd collection should contain 2 elements")

    // Instead, *new* collections were returned
    
    assert(refactorLast.size === 3, "TDD consists of 3 steps")
    assert(refactorLast(2) === "refactor", "Should end with 'refactor'")

    assert(refactorFirst.size === 3, "TDD consists of 3 steps")
    assert(refactorFirst.head === "refactor", "Should start with 'refactor'")
  }

  /**
   * Immutable List: adding two Lists together
   *
   * You can add collections together with "++"
   * Example: List(1,2) ++ List(3,4) // output: List(1,2,3,4)
   *
   * Can you add these collections to form a proper jazz orchestra?
   *
   */
  test("adding two lists") {
    val sax = List("alt sax", "tenor sax", "baritone sax")
    val brass = List("trumpet", "trombone")
    val rhythm = List("piano", "bass", "guitar", "drums")
    val jazzOrchestra = List() // fix this

    // Note that the original collections are not changed
    assert(sax.size === 3, "Should contain 3 sax types (sopran sax is rarely used)")
    assert(brass.size === 2, "Trumpet and trombone")
    assert(rhythm.size === 4, "The rhythm section should contain 4 members")

    // The resulting collection is a new one
    assert(jazzOrchestra.size === 9, "The orchestra should have 9 types of instruments")
  }

  /**
   * Immutable Sets.
   *
   * In contrast to Lists, Sets hold *unique* values.
   *
   * The default implementation of Set is IMMUTABLE.
   *
   * Many of the same operations that you learned for lists also
   * are available to Sets.
   *
   * There is one difference: when adding an element, you use "+"
   * instead of "+:" or ":+". This is because there is no "position
   * to add to" (as we defined above).
   *
   * Can you complete the years to satisfy the conditions?
   *
   * You will be adding one element with "+" and two sets with "++"
   * You can remove one element with "-"
   * You can remove many elements with "--"
   * There is "intersect(otherSet)" to calculate the intersection between
   * two sets.
   *
   */
  test("introduction to sets") {
    val years = Set(2010, 2011, 2010, 2012, 2011, 2013) // ;-)
    val twoYeasInTheFuture = Set(2014) + ??? // fix
    val yearsUpTo2015 = Set(0) // fix
    val without2015 = Set(0) // fix
    val someOddYears = Set(2010, 2012, 2014, 2016, 2018)
    val oddYearsUpTo2015 = Set(0) // "intersect" of "someOddYears" and "yearsUpTo2015"

    // Note that original Sets are immutable (not changed)
    assert(years.size === 4, "Original years should be 4")

    // Assertions on new Sets
    assert(yearsUpTo2015.size === 6)
    assert(yearsUpTo2015.contains(2015), "Should include the year 2015")
    assert(!without2015.contains(2015), "Should NOT include the year 2015")
    assert(oddYearsUpTo2015.size === 3, "Should have 3 elements")
  }

  /**
   * Filtering is done by passing an anonymous function which
   * takes as a parameter an element of the same type as the list.
   *
   * NOTE: the type declaration in the closure is automatically
   * type-inferenced. No need to declare types.
   *
   * We introduce Range(s), just for illustration purposes.
   * Ranges can be instantiated like this:
   *   (1 to 10)     // includes 10
   *   (1 until 10)  // excluding 10
   *
   * Here we filter all EVEN numbers.
   * Can you find the bugs in our filter?
   */
  test("filtering a range for even numbers") {
    val numbers = (1 to 8)
    val evenNrs = numbers.filter(n => n % 3 == 0) // fix

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
    val numbers = (1 until 8)
    val evenNrs = numbers.filter(_ > 44) // fix

    assert(numbers.contains(8) === false, "Should not contain 8 (note the *until*)")

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
    val withE = names.filter(???) // fix

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
      ??? // fix
    }
    val bases = domains.map(d => ???) // fix

    assert(List("batcave.com", "solitude.com", "grayskull.com") === domains)
    assert(List("batcave", "solitude", "grayskull") === bases)
  }

  /**
   * You can sort a collection with the "sorted" method.
   * This works for collections where Scala knows how to sort them.
   * (note that you can not sort Sets)
   */
  test("simple sorting") {
    val numbers = List(5, 2, 7, 1, 3)
    val sortedNumbers = ??? // fix (sort them!)
    val greekLetters = List("gamma", "beta", "omega", "alpha")
    val sortedGreekLetters = greekLetters // sort them!

    assert(List(1, 2, 3, 5, 7) === sortedNumbers, "Numbers should be sorted")
    assert("alpha" === sortedGreekLetters(0), "Alpha should be first")
    assert("omega" === sortedGreekLetters(3), "Omega should be last")
  }

  /**
   * Another way to sort a collection is through the method "sortBy".
   *
   * The parameter for sortBy should be a closure that returns
   * a numerical value. The collection will be sorted ascendingly
   * using that numerical value.
   *
   * Example:
   *   List("abc","ab","a","abcde","abcd").sortBy(_.length)
   * Output:
   *   List(a, ab, abc, abcd, abcde)
   *
   * (Remember that "_" is the "wildcard"-argument)
   *
   * Can you sort these programing languages according to
   * their year of appearance?
   *
   * HINT: use "string".toInt to parse to an Integer;
   * HINT: to get the year, you can split by the space
   *   or use takeRight(n) which will give you the last
   *   "n" elements of a collection (String is a collection) 
   */
  test("sorting programming languages") {
    val langs = List(
      "Scala: 2003",
      "Lisp: 1958",
      "Java: 1995",
      "Haskell: 1990",
      "Smalltalk: 1972",
      "Ruby: 1995",
      "Erlang: 1986",
      "C#: 2000")

    val sorted = List(???) // fix, use sortBy by getting the year
    
    assert("Lisp: 1958" === sorted.head, "In the beginning, it was Lisp")
    assert("Scala: 2003" === sorted(7), "The youngest language of the lot is Scala")

    // Bonus: use "map" to extract the years, and "sorted" to sort them 
    // val sortedYears = ???
    // assert(List(1958, 1972, 1986, 1990, 1995, 1995, 2000, 2003) === sortedYears)
  }

  /**
   * Reducing a collection is to apply one operation to all
   * its members to obtain a final result.
   *
   * A typical example is to sum all numbers.
   *
   * For example:
   *   List(1,2,3,4).reduce( (n1, n2) => n1+n2 )
   * Or using two wildcard-arguments:
   *   List(1,2,3,4).reduce(_+_)
   *
   * Implement your own "strJoin" function using "reduce".
   * It becomes a list of string and a "joiner" string.
   *
   */
  test("reducing") {
    def strJoin(strings: List[String], joiner: String): String = {
      ??? // implement
    }
    
    assert(strJoin(List("rock", "paper", "scissors"), joiner = "/") === "rock/paper/scissors")
    assert(strJoin(List("Hello", "world"), joiner = " ") === "Hello world")
  }

  /**
   * Immutable Maps
   *
   * Maps are collections where one value, the key, maps to another, the value.
   * The types need not be the same.
   *
   * Scala guesses the type of the Map from the elements included.
   *
   * The quickest way to create a Map is like this:
   *  val myMap = Map( key1 -> value1, key2 -> value2, ...)
   *
   * To access an element, you do like this:
   *  myMap(key1)  // output: value1
   *
   * (the best way is with the "get" method shown below, but
   * you can ignore that for now; it returns an Option, which you'll
   * see, or saw, in another tutorial)
   *
   * You can add an element simply with "+".
   * Example:
   *  Map("a" -> 1, "b" -> 2) + ("c" -> 3)
   * Or you can combine two maps like this:
   *  Map("a" -> 1, "b" -> 2) ++ Map("c" -> 3, "d" -> 4)
   *
   * NOTE that you don't modify the existing map, you get a new one.
   *
   * You can ask all the keys of a Map with the "keys" method.
   * Similarly, you can ask the values of a Map with... (that's right)
   *
   * Our friend Fred went for dinner at the pub, and then
   * bought an ice-cream on the street. Change the code to reflect this.
   * We also want to know the name of the items he consumed which have
   * an "e" on it.
   *
   * HINT: filters the keys for the consumed items
   * HINT: you can use the method "sum" to add a list of numbers
   * Bonus: implement your own sum with "reduce"
   *
   */
  test("immutable Maps") {
    val atThePub = Map(
      "pizza" -> 7.50,
      "beer" -> 2.20,
      "cafe" -> 3.40)

    val pubAndStreet = atThePub // add "ice-cream" costing 2.30
    val pubAndStreetCost = -1 // don't add manually!
    val consumedItemsWithE = List() // all things consumed in the pub and the street

    // Adding "ice-cream" did not modify the original map, since it's immutable
    assert(atThePub.get("ice-cream") === None, "Ice-cream was not taken in the pub!")

    assert(pubAndStreet.size === 4, "Consumed items should be 4")
    assert(pubAndStreet("ice-cream") === 2.30, "Ice-Cream should cost 2.30")
    assert(pubAndStreetCost === (2.30 + 3.40 + 2.20 + 7.50), "Total cost is wrong")

    assert(consumedItemsWithE.toSet === Set("beer", "cafe", "ice-cream"))

    // Extra bonus: find the highest price 
    // HINT: use a combination of "reduce" and "if"
    def mostExpensivePrice(items: Map[String, Double]): Double = ???
    //assert(mostExpensivePrice(pubAndStreet) === 7.50)
  }

}
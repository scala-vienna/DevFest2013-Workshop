import org.scalatest.FunSuite
import devfest.????

/**
 * Workshop exercise showing classes and objects
 */
class ClassesAndObjectsSuite extends FunSuite {

  /**
   * This is how you can write a class or object in Scala. It's the simplest form you can use
   */
  class SimplestClass   // classes are blueprints for object instances
  object SimplestObject // objects are directly instances, there's no static keyword in scala, objects are singletons

  /**
   * How do you thing an Object is accessed?
   */
  test("difference between class and object") {
    val classInstance = new SimplestClass
    assert(classInstance != null)

    val objectInstance = ???
    assert(objectInstance != null)
  }

  /**
   * Class can contain various members. They can be variables, values and methods (procedures or functions).
   * Return types are normally inferred by compiler, but it is a good style to used them.
   * Types of the parameters have to be supplied to compiler in method signatures.
   */
  class GeekyCoder {
    var codesIn = "Scala"         // variable 
    val neverGoesBackTo = "Java"  // value

    def dontLikeProcedures() {    // procedure, type is inferred
      println("I hate procedures")
    }

    def dontLikeProceduresEvenWithParams(param: String): Unit = { // procedure, function notation
      println("I hate procedures, even with " + param)
    }

    def preferFunctions = { // finally function, type is inferred, braces not needed
      val isFunctional = if (codesIn == "Scala") // expressions have return type, even the loops
        "Yes of course, it's Scala"
      else if (codesIn == "Java") {
        "Nope, oldie Java"
      }
      else "I'm not sure"

      isFunctional // no return is needed, last expression is always return value
    }
    
    // function with just single expression
    // because statements are expressions, its return value can be directly used as return value of the function
    def preferFunctionsAndExpressionsIn(lang: String) = if (lang == codesIn)
      "single expressions, without braces and returns" 
    else 
      "don't care"
  }

  /**
   * Can you learn our coder Ruby?
   * Write the line, which does that.
   */
  test("re-assignment to var") {
    val coder = new GeekyCoder

    ???
    assert(coder.codesIn === "Ruby")
  }

  /**
   * Does the procedure have an return type, if yes what type is it?
   * Fill the missing type (hint look at next procedure)
   */
  test("return type of procedure") {
    val coder = new GeekyCoder

    assert(coder.dontLikeProcedures() === ???)
  }

  /**
   * Can you say what the function returns?
   * And what is the return type?
   */
  test("return type of function") {
    val coder = new GeekyCoder

    val result = coder.preferFunctions
    assert(result === ???)
    assert(result.getClass === classOf[????])
  }

  /**
   * Can you correct the following facts about functions and expressions?
   */
  test("truth about functions and expressions") {
    val coder = new GeekyCoder
    
    assert(coder.preferFunctionsAndExpressionsIn(???) === "don't care")
    assert(coder.preferFunctionsAndExpressionsIn("Scala") === coder.preferFunctionsAndExpressionsIn("Java"))
  }

  /**
   * Classes can form hierarchies via inheritance like in Java, but...
   */
  class FunctionalGeekyCoder extends GeekyCoder {
    override val preferFunctions = "Always" // methods can be overridden to values
  }

  /**
   * Objects can extend classes, but not another objects.
   * They are directly instances thus can only inherit from 'blueprints' for instances.
   */
  object YouAfterWorkshop extends GeekyCoder {
    override val preferFunctions = "Yes I do" // methods in objects can be overridden to values too

    def skillsLearned() = {
      for (i <- 1 to 100) yield { // example of for loop, it's expression
        codesIn * i
      }
    }.toList
  }

  /**
   * Does the functional geeky coder prefer functions?
   */
  test("calling overridden method on class") {
    val coder = new FunctionalGeekyCoder

    assert(coder.preferFunctions === ???)
  }

  /**
   * How many times do you learn scala at this workshop?
   */
  test("calling method on object") {
    val result: List[String] = ???

    assert(result.size === ???)
  }

  /**
   * Class default constructor is in the the class signature and body
   * Parameters of the default constructor can have various visibilities. In our example:
   *  - firstName is private value
   *  - lastName is public value
   *  - age is public variable
   * For some of them compiler generates accessors/muttarors, but these does not follow Java rules.
   * They are named by fields without get/set prefixes. Using @BeanProperty annotation you can say
   * the compiler to generate also the getter/setter pair of the methods. In case of values only
   * accessor is generated.
   */
  class FamousGeekyCoder(firstName: String, val lastName: String, var age: Int) extends GeekyCoder {
    val fullName = if (firstName == lastName) firstName else firstName + lastName // expression, part of default constructor
    println("And " + fullName + " geeky coder was born...")                       // part of default constructor, too
    
    var nickname: String = _  // initialization of variables and values is mandatory, _ means default value, in this case null
    
    def this(nickname: String, age: Int) = { // auxiliary constructor
      this(nickname, nickname, age) // it has to call the default one as a 1st statement
      this.nickname = nickname
    }
    
    def this(nickname: String) = { // another auxiliary constructor
      this(nickname, -1) // it is allowed to call another auxiliary constructor as a 1st statement
    }
  }

  /**
   * Can you change the above mentioned class and fill the ??? in asserts to make test pass?
   */
  test("using default constructor and accessors/muttators") {
    val linus = new FamousGeekyCoder("Linus", "Torvalds", 42)
    linus.age += 1

    assert(linus.fullName === "" + ??? + linus.lastName)
    assert(linus.age === ???)
  }

  /**
   * Can you correct the test bellow?
   * It's not correct while auxiliary constructor is used.
   */
  test("using auxiliary constructors") {
    val bob = new FamousGeekyCoder("Uncle Bob")

    assert(bob.nickname != bob.fullName)
  }

  /**
   * Case classes are classes with generated methods from compiler and companion objects.
   * By prepending the keyword case to class, the compiler will generate following:
   *  - equals method
   *  - hashCode method
   *  - prettier toString
   *  - serialization implementation
   *  - support for pattern matching via companion object
   * Methods equals, hashCode and toString are based on all the field of default constructor.
   * Case classes are ready-made value objects or DTOs if you want from the compiler.
   */
  case class ScalaGeekyCoder(firstName: String, lastName: String) extends GeekyCoder // they can extends from classes

  /**
   * What is the result of equality test of the following two instances?
   * Does the using the 'new' keyword, play any role?
   */
  test("case classes") {
    val coder1 = ScalaGeekyCoder("John", "Doe")
    val coder2 = new ScalaGeekyCoder("John", "Doe") // Try to remove the new keyword

    ??? // Write equality test here, please
  }

}

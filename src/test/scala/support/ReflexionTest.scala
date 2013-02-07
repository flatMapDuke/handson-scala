package support


import language.experimental.macros
import org.scalatest.exceptions.TestFailedException
import org.scalatest.FunSuite
import reflect.api.JavaUniverse
import scala.reflect.runtime.{universe=>ru}
import scala.reflect.runtime.universe._
import scala.tools.reflect.ToolBox




class ReflexionTest {

  lazy val toolbox:ToolBox[_] = ru.runtimeMirror(this.getClass().getClassLoader).mkToolBox()
  import toolbox._

  def assertCompile(code:String):Unit = {

    val parseRes = parse(code)
    compile(parseRes)
  }

  def assertEval(code:String, clue:Any):Any =  {
    try {
     eval(parse(code))

    } catch {
      case e:Exception => throw new TestFailedException(Option(clue.toString),Option(e), 3)
    }
  }

  def testscope = {

    val a = 1

    eval(parse("a + 1"))

  }


}

/**
 * Testing the test tool !
 */
class ReflexionTestTest extends ReflexionTest with FunSuite {
  test("basic runtime test") {
    assert(assertEval("1+2","basic test") == 3)
  }

  test("basic failure test") {
    intercept[Exception] {
      assertCompile("Personne(1,2)")
    }
  }

  test("localscope") {
    testscope
  }
}
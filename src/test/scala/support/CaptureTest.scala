package support

import org.scalatest.FunSuite


class CaptureBlockTest extends ReflexionTest with FunSuite {


  test("basic capture") {

   val (astring, ares)= CaptureBlock.capture {
      val a = 1
      a + 1
    }

    println(astring)
    assert(ares == 2)
  }

  test("capture + eval") {
    val (block,_ ) = CaptureBlock.capture {

      val a = 1
      assert(a == 1)

    }

    println(block)
     assertCompile(block)

  }

  test("Drop Block") {
  }
}

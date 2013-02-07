package support

import scala.reflect.macros.Context
import language.experimental.macros
import language.implicitConversions

object CaptureBlock {
  def desugar(a: Any): String = macro desugarImpl

  def desugarImpl(c: Context)(a: c.Expr[Any]) = {
    import c.universe._

    c.Expr(Literal(Constant(show(a.tree))))
  }

  def capture[A](a: A): (String, A) = macro captureImpl[A]

  def captureImpl[A: c.WeakTypeTag](c: Context)(a: c.Expr[A]): c.Expr[(String, A)] = {
    import c.universe._
    val aCode = c.Expr(Literal(Constant(show(a.tree))))
    val aRaw = c.Expr(Literal(Constant(showRaw(a.tree))))

    c.universe.reify {
      (aCode.splice.toString, a.splice)
    }
  }


}

object DropBlock {
  /*def shouldCompile (a:String) : String = macro shouldCompileImpl

  def shouldCompileImpl(c:Context)(a: c.Expr[String]) = {
    import c.universe._
    c.universe



  } */


  def drop(a: Any):String = macro dropImpl

  def dropImpl(c:Context)(a: c.Expr[Any]) = {

    import c.universe._

    reify("done")
  }

}


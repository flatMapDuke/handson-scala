import org.scalatest.Tag
import support.HandsOnSuite


/**
 * ceci est un p1_1_premiers_pas object, c'est un truc cool ce Scala qui permet d'avoir des fonctions utilitaires ou autres
 */
package object p1_1_premiers_pas {

  trait HandsOnSuiteP1 extends support.HandsOnSuite {
    override protected def test(testName: String, testTags: Tag*)(testFun: => Unit) {
      super.test(testName, (testTags :+ (HandsOnSuite.partie1)):_*)(testFun)
    }
  }

}

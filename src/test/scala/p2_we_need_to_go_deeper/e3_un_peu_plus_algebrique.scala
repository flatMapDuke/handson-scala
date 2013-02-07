package p2_we_need_to_go_deeper

import support.HandsOnSuite


class e3_un_peu_plus_algebrique extends HandsOnSuite {


  /**
   * Un type algébrique (ici Sac) est un type composé ici par l'union disjointe de SacVide et SacPlein.
   * Cela veut dire que Sac est forcement un SacVide ou un SacPlein.
   */

  sealed trait Sac {

    def tagDeSac:Set[String]

    def map(fonction:Int => Int):Sac

    def flatMap(fonction:Int => Sac):Sac

    def filter(fonction:Int => Boolean):Sac

    def contenuOuSinon(replacement:Int):Int

    def addTags(tag:Set[String]):Sac

  }

  object Sac {
    def apply(contenu:Int, tagDeSac:Set[String] = Set.empty):Sac = SacPlein(contenu, tagDeSac)
  }

  case class SacVide(tagDeSac:Set[String] = Set.empty) extends Sac {

    override def map(fonction:Int => Int):Sac = ???

    override def flatMap(fonction:Int => Sac):Sac = ???

    override def filter(fonction:Int => Boolean):Sac = ???

    override def contenuOuSinon(replacement:Int):Int = replacement

    def addTags(tag: Set[String]): Sac = ???
  }

  case class SacPlein(contenu:Int , tagDeSac:Set[String] = Set.empty) extends Sac {

    override def map(fonction:Int => Int):Sac = ???

    override def flatMap(fonction:Int => Sac):Sac = ???

    override def filter(fonction:Int => Boolean):Sac = ???

    override def contenuOuSinon(replacement:Int):Int = contenu

    def addTags(tag: Set[String]): Sac = ???
  }


  test("toujours comme avant, je peux construire mon Sac")  {

    val s0 = Sac(0, Set("petit sac"))    // appel de la fonction apply dans l'objet companion de Sac
                                         // un peu comme List(1,2,3)

  }

  test("on peut ajouter des tags au sac") {

    val s0 = Sac(0)

    s0.addTags(Set("petit sac")).tagDeSac should be(Set("petit sac"))

    val v0 = SacVide()

    v0.addTags(Set("petit sac")).tagDeSac should be(Set("petit sac"))

  }


  test("toujours comme avant, je peux appliquer une fonction à l'intétieur") {

    val sacDeZero = Sac(0, Set("petit sac"))


    //Le sealed sur le trait Sac rend ce pattern matching exhaustif
    sacDeZero.map(x => x +1) match {
      case SacPlein(contenu, _) => contenu should be(1)

      case SacVide(_) => fail("Cela ne devrait pas être un Sac Vide")
    }

  }

  test("toujours comme avant, je peux combiner mes sac") {
    val sacDeDeux = Sac(2, Set("petit sac"))

    val sacDeCent  = Sac(100, Set("grand sac"))

    val combinaison = for (deux <- sacDeDeux; cent <- sacDeCent) yield( deux * cent )

    combinaison match {
      case SacPlein(contenu, tags) => {
        contenu should be (200)
        tags should be(Set("petit sac", "grand sac"))
      }

      case _ => fail("ne doit pas être vide")
    }
  }

  test("on peut filter le contenu d'un sac") {

    val sacDeDeux = Sac(2, Set("petit sac"))

    val sac = sacDeDeux.filter(x => x > 10)

    sac match {
      case SacPlein(_,_) => fail("Cela devrait être une sac vide")
      case _  => {}
    }

    sacDeDeux.filter(x => x > 1) match {
      case SacVide(_) => fail("Cela doit être un sac plein")
      case _ => {}
    }

  }

}

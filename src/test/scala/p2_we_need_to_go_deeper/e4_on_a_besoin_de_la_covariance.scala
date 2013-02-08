package p2_we_need_to_go_deeper

import support.HandsOnSuite

class e4_on_a_besoin_de_la_covariance extends HandsOnSuite {

  /**
   *
   * La covariance est un mécanisme pour dire qu'un type paramêtrée varie de la même façon que son paramêtre.
   *
   * Si A <: B  (cela veut dire que A est une sous classe de B)
   * Et que Sac[A] est covariance sur A (Sac[+A])
   * Alors Sac[A] <: Sac[B]
   *
   * Ce mécanisme est nécessaire ici pour définir le Sac Vide.
   *
   * Quelque soit A dans les types, Nothing <: A
   * SacVide <: Sac[Nothing]
   * alors SacVide <: Sac[A]
   *
   *
   * @tparam A
   */
  sealed trait Sac[+A] {

    def tagDeSac:Set[String]

    def map[B](fonction:A => B):Sac[B]

    def flatMap[B](fonction:A => Sac[B]):Sac[B]

    def filter(fonction:A => Boolean):Sac[A]

    def contenuOuSinon[B >: A](replacement:B):B

    def isEmpty:Boolean

    def addTags(tag:Set[String]):Sac[A]

  }

  object Sac {
    def apply[A](contenu:A, tagDeSac:Set[String] = Set.empty):Sac[A] = SacPlein(contenu, tagDeSac)
  }

  case class SacVide(tagDeSac:Set[String] = Set.empty) extends Sac[Nothing] {

    type A = Nothing

    override def map[B](fonction:A => B):Sac[B]  = ???

    override def flatMap[B](fonction:A => Sac[B]):Sac[B]  = ???

    override def filter(fonction:A => Boolean):Sac[A]  = ???

    override def contenuOuSinon[B >: A](replacement:B):B = replacement

    override val isEmpty: Boolean = true

    def addTags(tag:Set[String]):Sac[A] = ???

  }

  case class SacPlein[A](contenu:A , tagDeSac:Set[String] = Set.empty) extends Sac[A] {

    override def map[B](fonction:A => B):Sac[B]  = ???

    override def flatMap[B](fonction:A => Sac[B]):Sac[B]  = ???

    override def filter(fonction:A => Boolean):Sac[A]  = ???

    override def contenuOuSinon[B >: A](replacement:B):B = contenu

    override val isEmpty: Boolean = false

    def addTags(tag:Set[String]):Sac[A] = ???

  }


  test("on peut ajouter des tags au sac") {

    val s0 = Sac(0)

    s0.addTags(Set("petit sac")).tagDeSac should be(Set("petit sac"))

    val v0 = SacVide()

    v0.addTags(Set("petit sac")).tagDeSac should be(Set("petit sac"))

  }


  test("Un peu comme avant, l'application de fonction dans le conteneur") {
    val petitSacDeZero = Sac(0,Set("petit sac"))

    petitSacDeZero.map(x => x + 1) match {
      case SacPlein(contenu, _ )  =>  contenu should be(1)

      case _ => fail("cela ne doit pas être un sac vide")
    }

  }




  test("La combinaison de Sac") {

    val petitSacDeZero = Sac(0,Set("petit sac"))

    val grandSacDeA = Sac("A", Set("grand sac"))

    val combinaison = for (p <- petitSacDeZero; g <- grandSacDeA) yield { p.toString + g}

    combinaison match {
      case SacPlein(contenu, tagDeSac) => {
        contenu should be("0A")
        combinaison.tagDeSac should be(Set("petit sac", "grand sac"))
      }
      case _ => fail("cela ne doit pas être un sac vide")
    }
  }

  test("Le filtrage") {
    val petitSacDeZero = Sac(0,Set("petit sac"))

    assert(petitSacDeZero.filter(x => x > 1).isEmpty)
  }



}

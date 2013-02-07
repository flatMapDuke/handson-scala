package p2_we_need_to_go_deeper

import support.HandsOnSuite

class e1_un_peu_plus_generique  extends  HandsOnSuite {

  case class Sac[A](contenu:A, tagDeSac:Set[String]) {

    def map[B](fonction: A => B):Sac[B] = ???

    def flatMap[B](fonction: A => Sac[B]):Sac[B] = ???

  }


  test("Un peu comme avant, l'application de fonction dans le conteneur") {
    val petitSacDeZero = Sac(0,Set("petit sac"))

    petitSacDeZero.map(x => x + 1).contenu should be(1)

  }

  test("La combinaison de Sac") {

    val petitSacDeZero = Sac(0,Set("petit sac"))

    val grandSacDeA = Sac("A", Set("grand sac"))

    val combinaison = for (p <- petitSacDeZero; g <- grandSacDeA) yield { p.toString + g}


    combinaison.contenu should be("0A")
    combinaison.tagDeSac should be(Set("petit sac", "grand sac"))
  }

}

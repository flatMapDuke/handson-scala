package p1_2_pas_suivant

import p1_1_premiers_pas.HandsOnSuiteP1

/**
* les fonctions de plus haut niveau
*/
class e8_fonctions_de_plus_haut_niveau extends HandsOnSuiteP1 {

  /**
  * variable faisant référence à une fonction anonyme
  *
  * remarque : on peut aussi écrire la fonction lambda de cette façon avec les accolade:
  *
  * val lambda = {
  *   x: Int => x + 1
  * }
  */
  test("Une fonction anonyme comme variable") {
    val lambda = (x: Int) => x + 1
    def result = List(1, 2, 3) map lambda
    result should be(__)
  }

  /**
  * ça marche encore avec une 'vraie' fonction comme variable, c'est justement une des particularité des fonctions de plus haut niveau
  */
  test("Variable qui fait référence à une fonction") {
    val lambda = new Function1[Int, Int] {
      def apply(v1: Int) = v1 + 1
    }
    def result = List(1, 2, 3) map lambda
    result should be(__)
  }

  /**
  * Avec une autre façon de définir la fonction lambda, passée en paramètre de map
  */
  test("Encore une autre façon") {
    val lambda = new (Int => Int) {
      def apply(v1: Int) = v1 + 1
    }

    def result = List(1, 2, 3) map lambda
    result should be(__)
  }



  /**
  *  Les fonctions de plus haut niveau peuvent retourner des fonctions
  */
  test("Fonction retournant une autre fonction") {
    def addWithoutSyntaxSugar(x: Int) = {
      new Function1[Int, Int]() {
        def apply(y: Int): Int = x + y
      }
    }

    addWithoutSyntaxSugar(1)(2) should be(__)

    def add(x: Int) = (y: Int) => x + y
    add(2)(3) should be(__)

    def fiveAdder = add(5)
    fiveAdder(5) should be(__)
  }

  /**
  * Les fonctions de plus haut niveau peuvent prendre une fonction en paramètre
  */
  test("Fonction prenant en paramètre une autre fonction. ça aide dans la composition de fonctions") {
    def makeUpper(xs: List[String]) = xs map {
      _.toUpperCase
    }
    def makeWhatEverYouLike(xs: List[String], sideEffect: String => String) = {
      xs map sideEffect
    }
    makeUpper(List("abc", "xyz", "123")) should be(List("ABC", "XYZ", "123"))

    makeWhatEverYouLike(List("ABC", "XYZ", "123"), {
      x => x.toLowerCase
    }) should be(__)
    //using it inline
    List("Scala", "Erlang", "Clojure") map {
      _.length
    } should be(__)
  }

  /**
  * La currification
  */
  test("La currification est une technique qui permet de transformer une fonction avec des paramètres multiples en une fonction à un seul paramètre") {
    def multiply(x: Int, y: Int) = x * y
    val multiplyCurried = (multiply _).curried
    multiply(4, 5) should be(__)
    multiplyCurried(3)(2) should be(__)
  }


  test("La currification permet de créer des fonctions spécialisées") {
    def customFilter(f: Int => Boolean)(xs: List[Int]) = {
      xs filter f
    }
    def onlyEven(x: Int) = x % 2 == 0
    val xs = List(12, 11, 5, 20, 3, 13, 2)
    customFilter(onlyEven)(xs) should be(List(12, 20, 2))

    val onlyEvenFilter = customFilter(onlyEven) _
    onlyEvenFilter(xs) should be(List(12, 20, 2))
  }
}

package p1_1_premiers_pas

import support.HandsOnSuite

/**
*  Les for
*/

class e3_boucle_for extends HandsOnSuiteP1 {


  test("les for c'est assez simple") {
    //0, 1, 2, 3, 4, 5, 6, 7, 8, 9
    val quelqueNombres = Range(0, 10)
    var somme = 0
    for (i <- quelqueNombres) {
      somme += i
    }

    somme should equal(__)
  }

  /**
  * on peut rajouter des conditions à l'intérieur des boucles
  */
  test("les boucles for peuvent contenir de la logique") {
    val quelqueNombres = Range(0, 10)
    var somme = 0
    // somme des nombres entiers, seulement !
    for (i <- quelqueNombres) {
      if (i % 2 == 0) {
        somme += i
      }
    }

    somme should equal(__)
  }

  /**
  * Une boucle for peut renvoyer une liste, sur laquelle on peut appliquer des fonctions
  */
  test("Les boucles for peuvent produire une liste, peuvent être sommée facilement") {
    val quelqueNombres = Range(0, 10)

    val uneListe =
      for {
        i <- quelqueNombres
        if ((i % 2) == 0)
      }
      yield i

    uneListe.reduceLeft((i,j) => i + j) should be(__)
  }

  /**
  * Voici l'équivalent Java

  * class Tuple() {
  * private final int x;
  * private final int y; 
  *
  *   public void Tuple(int x, int y) {
  *     this.x = x;
  *     this.y = y;
  *   }
  *
  * ... on met pas tout...
  * 
  * }
  *
  * List<Tuple> coordinates = new ArrayList<Tuple>();
  *
  * for (int x = 1; i < 5; x++) {
  *   for (int y = 1; i < 3; y++) {
  *      coordinates.add(new Tuple(x, y)); 
  *   }
  * }
  * ... blablabla
  *
  */
  test("Les bouclent for peuvent être imbriquées") {
    val xValues = Range(1, 5)
    val yValues = Range(1, 3)
    val coordinates = for {
      x <- xValues
      y <- yValues
    }
    yield (x, y)
    coordinates(4) should be(__)
  }
}
package p1_2_pas_suivant

import p1_1_premiers_pas.HandsOnSuiteP1

/**
*  Puis aux MAP :http://www.scala-lang.org/api/current/index.html#scala.collection.concurrent.Map
*/

class e5_maps extends HandsOnSuiteP1 {

  /**
  * Création toute bête d'une map et première opérations
  */
  test("C'est facile de créer une map !") {
    val myMap = Map("PA" -> "Paris", "BE" -> "Besançon", "BL" -> "Belfort")
    myMap.size should be(__)
    //la tête
    myMap.head should be(__)
   // il n'y a pas de notion d'ordre dans une map
    val myMapBis = Map("BE" -> "Besançon", "BL" -> "Belfort", "PA" -> "Paris")
    myMap.equals(myMapBis) should be(__)
    // impact des 'doublons'
    val myOtherMap = Map("PA" -> "Paris", "BE" -> "Besançon", "PA" -> "Paris")
    myOtherMap.size should be(__)
  }

  /**
  * L'addition de maps se fait assez naturellement et facilement avec +
  */
  test("Addition de map") {
    val myMap = Map("PA" -> "Paris", "BE" -> "Besançon", "NA" -> "Nantes")
    // ajout d'un élément
    val aNewMap = myMap + ("BL" -> "Belfort")

    aNewMap.contains("BL") should be(__)
  }

  /**
  * Les types de clé
  */
  test("On peut mixer les types de clé") {
    val myMap = Map("Ann Arbor" -> "MI", 49931 -> "MI")
    myMap("Ann Arbor") should be(__)
    myMap(49931) should be(__)
  }

  /**
  * Quelques opérations sur les maps
  */
  test("On peut accéder/supprimer les élément d'une map") {
    val myMap = Map("PA" -> "Paris", "BE" -> "Besançon", "NA" -> "Nantes", "BL" -> "Belfort")

    // suppression d'un élément
    val aNewMap = myMap - "NA"
    aNewMap.contains("NA") should be(__)
    // suppression multiple
    val aNewOtherMap = myMap -- List("BE", "BL")
    aNewOtherMap.contains("BE") should be(__)
    aNewOtherMap.contains("BL") should be(__)
    // une exception est jetté dans le cas l'élément n'est pas présent dans la map
    intercept[NoSuchElementException] {
      aNewOtherMap("BL") should be("Belfort")
    }
  }

}

package p1_2_pas_suivant

import p1_1_premiers_pas.HandsOnSuiteP1

/**
*   Un Set est une collection qui ne contient que des éléments distincts, comme en Java.
*   
*   Quelques liens :
*     - http://www.scala-lang.org/api/current/index.html#scala.collection.immutable.Set
*     - http://docs.scala-lang.org/overviews/collections/sets.html
*/ 

class e6_sets extends HandsOnSuiteP1 {

  /**
  * Création d'un Set
  */
  test("Création d'un Set") {
    val mySet = Set("Sud", "Est", "Ouest", "Nord")
    mySet.size should be(__)

    val myOtherSet = Set("Sud", "Est", "Sud", "Nord")
    myOtherSet.size should be(__)
  }

  /**
  * Quelques opérations : les fonctions +, -, --  et contains
  */
  test("Opérations sur les Sets") {
    // addition
    val mySet = Set("Sud", "Est", "Sud")
    val aNewSet = mySet + "Nord"

    aNewSet.contains("Nord") should be(__)

    // suppression
    val mySetBis = Set("Sud", "Est", "Ouest", "Nord")
    val aNewSetBis = mySetBis - "Nord"
    // la méthode contains
    aNewSetBis.contains("Nord") should be(__)

    // suppression multiple
    val myOtherSet = Set("Sud", "Est", "Ouest", "Nord")
    val aNewOtherSet = mySet -- List("Ouest", "Nord")

    aNewOtherSet.contains("Nord") should be(__)
    aNewOtherSet.contains("Ouest") should be(__)
  }

  /**
  * Les types de clé
  */
  test("On peut mixer les types") {
    val mySet = Set("Sud", "Nord", 12)

    mySet.contains(12) should be(__)
    mySet.contains("Sud") should be(__)
  }

  /**
  *  Accesseur de Sets
  */
  test("Accesseur") {
    val mySet = Set("Nord", "Sud", 12)

    mySet(12) should be(__)
    mySet("Nord") should be(__)
  }

  /**
  * Union et Intersection de Sets
  */
  test("L'union/intersection de deux Sets") {
    val mySet1 = Set("Nord", "Sud-Est", "Nord-Ouest", "Est")
    val mySet2 = Set("Est", "Sud", "Nord")
    val aNewSet1 = mySet1 union mySet2 // à la place de "union" on peut utiliser l'opérateur "|" 

    aNewSet1.equals(Set("Nord", "Sud-Est", "Sud", "Nord-Ouest", "Est")) should be(__)

    val aNewSet2 = mySet1 intersect mySet2  // à la place de "intersect" on peut utiliser l'opérateur "&" 

    aNewSet2.equals(Set("Est", "Nord")) should be(__)
  }

  /**
  *  La différence de deux Sets avec la méthode diff
  */
  test("Différence de deux Sets") {
    val mySet1 = Set("Nord", "Sud", "Est", "Ouest")
    val mySet2 = Set("Nord", "Est")
    val aNewSet = mySet1 diff mySet2 // Note: you can use the "&~" operator if you *really* want to.

    aNewSet.equals(Set("Sud", "Ouest")) should be(__)
  } 

  /**
  * Itérateur sur un set
  */
  test("L'iterator") {
    val mySet = Set(1, 3, 4, 9)
    var sum = 0
    for (i <- mySet)
      sum = sum + i

    sum should be(__)
  }

  /**
  * L'ordre des éléments d'un Set n'est pas important pour equals
  */
  test("Equals est indépendant de l'ordre") {
    val mySet1 = Set("Nord", "Sud", "Ouest", "Est")
    val mySet2 = Set("Ouest", "Sud", "Est", "Nord")

    mySet1.equals(mySet2) should be(__)
  }
}

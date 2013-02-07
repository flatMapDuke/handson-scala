package p1_1_premiers_pas

import support.HandsOnSuite

/**
*  Quelques exos sur les cases classes
*/ 
class e2_case_classes extends HandsOnSuiteP1{
  /**
  * La création d'une instance d'une case class
  */
  test("C'est facile de créer une case classe !!") {
    case class MonChien(nom: String, race: String)

    val d1 = MonChien("Scooby", "Doberman")
    val d2 = MonChien("Rex", "Custom")
    val d3 = new MonChien("Scooby", "Doberman") // Cela marche aussi avec new !
    val d4 = MonChien.apply("Rex", "Custom") // utilisation de la méthode apply

    (d1 == d3) should be(__)
    (d1 == d2) should be(__)
    (d2 == d3) should be(__)
  }

  /**
  * Les égalités
  */
  test("Les Case classes ont une méthode equals qui 'marche'") {
    case class Personne(prénom: String, nom: String)

    val p1 = new Personne("Arsène", "Lupin")
    val p2 = new Personne("James" , "Bond")
    val p3 = new Personne("Arsène", "Lupin")

    // en fait, == en Scala est un appel à .equals de Java
    (p1 == p2) should be(__)
    (p1 == p3) should be(__)


    // eq en Scala correspond à l'égalité par référence
    // c'est à dire le '==' de Java
    (p1 eq p2) should be(__)
    (p1 eq p3) should be(__)
  }

  /**
  * La méthode hashcode
  */
  test("Les case classes ont une méthode hascode qui marche (de base)") {
    case class Personne(prénom: String, nom: String)

    val p1 = new Personne("Iron", "Man")
    val p2 = new Personne("Super", "Man")
    val p3 = new Personne("Iron", "Man")

    (p1.hashCode == p2.hashCode) should be(__)
    (p1.hashCode == p3.hashCode) should be(__)
  }

  /**
  * La méthode toString
  */
  test("Les cases classes définissent de base la méthode to String") {
    case class MonChien(nom: String, race: String)
    val d1 = MonChien("Scooby", "Doberman")

    d1.toString should be("MonChien(Scooby,Doberman)")
  }

  /**
  * Les accesseurs
  */
  test("Les cases classes définissent automatiquement les accesseurs") {
    case class MonChien(nom: String, race: String)

    val d1 = MonChien("Scooby", "Doberman")
    d1.nom should be(__)
    d1.race should be(__)

    // Qu'est ce qui se passe lorsque l'on fait ça :
    //d1.nom = "Scooby Doo"
  }

  /**
   * les cases classes peuvent avoir des propriétés mutables, mais on n'a pas envie de vous montrer ça ;)
   */

  test("On peut modifier les cases classes par copie") {
    case class MonChien(nom: String, race: String)

    val d1 = MonChien("Scooby", "Doberman")

    val d2 = d1.copy(nom = "Scooby Doo") // copie de la classe, mais avec le nom qui change

    d1.nom should be(__) // original est intact (immutabilité)
    d1.race should be(__)

    d2.nom should be(__)
    d2.race should be(__) // les autres propriétés sont copiées de l'original
  }

  
  /**
  * les cases classes peuvent avoir des paramètres nommés et des paramètres par défaut
  */
  test("les cases classes ont des paramètres par défaut et des paramètres nommés") {
    case class Personne(prénom: String, nom: String, age: Int = 0, tel: String = "")

    val p1 = Personne("Sherlock", "Holmes", 23, "06-XX-XX-XX-XX")

    // sans age ni tel
    val p2 = Personne("Doctor", "Watson")

    // l'ordre peut changer, et il n'y a toujours pas l'age
    val p3 = Personne(nom = "Professor", prénom = "Moriarty", tel = "01-XX-XX-XX-XX")

    // une copie avec des paramètres nommés
    val p4 = p3.copy(age = 23)

    p1.prénom should be("Sherlock")
    p1.nom should be("Holmes")
    p1.age should be(23)
    p1.tel should be(__)

    p2.prénom should be("Doctor")
    p2.nom should be(__)
    p2.age should be(0)
    p2.tel should be(__)

    p3.prénom should be(__)
    p3.nom should be("Professor")
    p3.age should be(0)
    p3.tel should be(__)

    (p1 == p4) should be(__)
  }
}

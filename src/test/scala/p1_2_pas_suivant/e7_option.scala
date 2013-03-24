package p1_2_pas_suivant

import p1_1_premiers_pas.HandsOnSuiteP1

/**
*   Une Option comme sont nom l’indique représente une valeur optionnelle. 
*   Une instance de Option est soit une instance de Some soit de None 
*   (None dans le cas où il n’y a aucune valeur).
*
*   Exemple :
*   Imaginons que l’on veuille trouver une personne dans une BDD. Elle n’existe peut-être pas. 
*   Dans ce cas en Scala on écrira :
*
*       def findPerson(key: Int): Option[Person]
*
*   Ca permet de dire que si la personne n’est pas trouvée, alors on renvoie None et non un 'null'
*   comme dans d’autres langages.
*   Le type Option permet donc de traiter des cas pour lesquels aucun résultat n’existe, 
*   et de se prémunir des NPE/absence de valeur.
*
*   Quelques liens :
*     - http://www.scala-lang.org/api/current/index.html#scala.Option
*/

class e7_option extends HandsOnSuiteP1 {
  /**
  * Quelques tests rapides
  */
  test("None est égal à...None") {
   None should be(__)
  }

  test("None est identique à None") {
    val a = None
    
    a should be(__)
  }

  test("On peut convertir None en une String") {
    None.toString should be(__)
  }

  test("et en une liste aussi") {
    val a = None
    a.toList should be(__)
  }

  test("None est considéré comme vide") {
    None.isEmpty should be(__)
  }

  test("On ne peut pas caster None en n'importe quel objet") {
    intercept[ClassCastException] {
      assert(None.asInstanceOf[String] === classOf[ClassCastException])
    }
  }

  test("None peut être utilisé avec le type Option, plutôt qu'avec null") {
    val optional: Option[String] = None
    optional.isEmpty should be(__)
    optional should be(__)
  }

  test("Some est l'opposé de None pour le type Option") {
    val optional: Option[String] = Some("Some Value")
    (optional == None) should be(__)
    optional.isEmpty should be(__)
  }

  test("Option.getOrElse peut-être utilisé pour fournir un comportement par défaut si on obtient un None") {
    val optional: Option[String] = Some("Some Value")
    val optional2: Option[String] = None
    optional.getOrElse("No Value") should be(__)
    optional2.getOrElse("No Value") should be(__)
  }

}

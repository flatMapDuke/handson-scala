package p1_1_premiers_pas

/**
*  1mn chrono ?
*/

/**
*  Les val et var sont des mots-clé utilisés en Scala pour déclarer des champs. 
*  On peut rajouter le mot-clé 'private' devant pour définir des champs privés. 
*  Si rien n'est spécifié, on est par défaut en 'public' en Scala.
* 
*     - var : permet de déclarer une variable muable (=que l'on pourra par la suite modifier si on le veut)
*
*     - val : permet de déclarer une variable immuable (=que l'on ne pourra plus modifier une fois initialisée)
*/ 
class e0_vars_vals extends HandsOnSuiteP1 {

  test("Les vars peuvent être réaffectées") {
    var a = 5
    a should be(__)

    a = 7
    a should be(__)
  }

  test("Par contre les vals sont immuables (équivalent de final Java), elles ne peuvent pas être réaffectées") {
    val a = 5
    a should be(__)

    /*
    *  Question supplémentaire :
    */
    // Que se passe-t-il lorsque l'on ajoute ces lignes ?
    // a = 7
    // a should be (7)
  }
}

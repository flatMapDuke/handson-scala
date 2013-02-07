package p1_1_premiers_pas

/**
*  1mn chrono ?
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

    // Qu'est-ce qui se passe lorsque l'on ajoute ces lignes ?
    // a = 7
    // a should be (7)
  }
}

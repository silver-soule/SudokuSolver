package edu.knoldus

import org.scalatest.FunSuite
/**
  * Created by Neelaksh on 13/7/17.
  */
class SudokuTestSuite extends FunSuite{

  test("empty sudoku"){
    val m = for(i<-0 to 8;
                j<-0 to 8
    )yield (i,j)->0
    val masMap  = m.toMap
    //print(masMap)
    assert(Sudoku.solve((0,0),masMap))
  }

  test("check sudoku with initial vals"){

    val inputData = List(0,0,4,8,0,0,0,1,7,6,7,0,9,0,0,0,0,0,5,0,8,0,3,0,0,0,4,3,0,0,7,4,0,1,0,0,0,6,9,0,0,0,7,8,0,0,0,1,
      0,6,9,0,0,5,1,0,0,0,8,0,3,0,6,0,0,0,0,0,6,0,9,1,2,4,0,0,0,1,5,0,0)

    val listWithIniitialData =
      for{
      i<-List.range(0,9);
      j<-List.range(0,9)
    }yield(i,j)-> inputData(i*9+j)

    val mapWithInitials = listWithIniitialData.toMap
      assert(Sudoku.solve((0,0),mapWithInitials))
  }
}

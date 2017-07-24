package edu.knoldus

/**
  * Created by Neelaksh on 13/7/17.
  */
object Sudoku {

  val UNUSED = 0
  val XMAX = 8
  val YMAX = 8


  private def isValidValue(solution: Map[(Int,Int),Int], currPos:(Int, Int),value:Int)  : Boolean =   {
    checkBox(solution,currPos,value)&& checkRow(solution,currPos._1,value) && checkCol(solution,currPos._2,value)
  }

  private def checkRow(solution: Map[(Int,Int),Int], currRow:Int,value:Int)  : Boolean = {
    List.range(0,9).forall((x)=>solution(currRow,x)!=value)
  }

  private def checkCol(solution: Map[(Int,Int),Int], currCol:Int,value:Int)  : Boolean = {
    List.range(0,9).forall((x)=>solution(x,currCol)!=value)
  }

  private def checkBox(solution: Map[(Int,Int),Int],currPos:(Int,Int),value:Int) : Boolean = {
    val boxStart = (currPos._1 - currPos._1%3,currPos._2 - currPos._2%3)

    val listofMatches =
    for(i<-Range(boxStart._1 , boxStart._1 + 3);
        j<-Range(boxStart._2 , boxStart._2 + 3)) yield solution(i,j) != value

    listofMatches.reduceLeft(_&&_)
  }


  private def next(currPos:(Int,Int)) : (Int,Int) = {
      if(currPos._2>=YMAX) (currPos._1 + 1,0) else (currPos._1,currPos._2 + 1)
  }

  def solve (currPos:(Int,Int),solution:Map[(Int,Int),Int]) : Boolean = {
    //if(isValidValue(solution,currPos))
    if(currPos._1 > XMAX) {
      println(solution)
      true
    }
    else if(solution(currPos)== UNUSED){
      for (i <- 1 to 9) {
        if (isValidValue(solution, currPos,i)) {
          if (solve(next(currPos), solution + (currPos -> i))) return true
        }
      }
      false
    }
    else {solve(next(currPos),solution)}
  }
}



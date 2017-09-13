object Sukudu extends App{
 
  class Square(boxNumber:Int, xNumber:Int, yNumber:Int,
      values:List[Int]=List(1,2,3,4),solved:Boolean=false){
    val possibleValues = values; //Public object value
    val x = xNumber;
    val y = yNumber;
    val quad = boxNumber;
    def setValue(solution:Int) = {
      new Square(this.boxNumber, this.xNumber, this.yNumber, List(solution),true);
    }
    def removeValue(notSolution:Int) = {
      new Square(this.boxNumber, this.xNumber, this.yNumber,
          this.possibleValues.filter(_ != notSolution),false);
    }
    def removeValues(notSolutions:List[Int]) = {
      new Square(this.boxNumber, this.xNumber, this.yNumber,
          this.possibleValues.filter((x:Int)=>notSolutions.contains(x) == false)
          ,false);
    }
  }
  
  
  def getSquare(x:Int,y:Int, l:List[Square]):Square = {
    return l.filter(_.x == x).filter(_.y == y)(0)
    }
  
  def printlt(l:List[Square]){
    for(x<-List(1,2,3,4)){
      for(y<-List(1,2,3,4)){
        var s = getSquare(x,y,l);
        print(s.possibleValues)
      }
      println("");
    }
  }
  
  def getBoxFromXY(x:Int, y:Int):Int = {
    if(x<=2 && y<=2){
      return 1;
    }else if(x>2 && y<=2){
      return 2;
    }else if(x<=2 && y>2){
      return 3;
    }else{
      return 4;
    }
  }
  
  def getBoxFromXY2(x:Int, y:Int) = 
  (x,y) match {
    case (1|2,1|2) => 1;
    case (3|4,1|2) => 2;
    case (1|2,3|4) => 3;
    case (x,y) => 4;
    
  }
  
  // Get squares from a column (i.e. an X value)
  def getAllFromX(i:Int):List[Square] = {
    return allSquares.filter((s:Square)=>s.x == i);
  }
  
  // Get Squares from a row (i.e. a Y value)
  def getAllFromY(i:Int):List[Square] = {
    return allSquares.filter((s:Square)=>s.y == i);
  }
  
  // Get Squares from a row (i.e. a Y value)
  def getAllFromQuadrant(i:Int):List[Square] = {
    return allSquares.filter((s:Square)=>s.quad == i);
  }
  
  def checkValid(list:List[Square]):Boolean = {
    var temp = List[Int]();
    for(sq<-list){
      if(sq.possibleValues.size == 1){
        if(temp.exists{(i:Int)=> i == sq.possibleValues(0)}){
          return false
        }
        else{
          temp = temp :+ sq.possibleValues(0);
        }
      }
      
    }
    return true;
  }
  
  var allSquares = List[Square]();
  
  for(xvalue <- List(1,2,3,4)){
    for(yvalue <- List(1,2,3,4)){
      val s = new Square(getBoxFromXY(xvalue, yvalue),xvalue,yvalue);
      allSquares = allSquares :+s;
    }
  }
  
  allSquares = allSquares.updated(0, allSquares(0).setValue(1)); 
  allSquares = allSquares.updated(1, allSquares(1).setValue(1)); 
  
  println(checkValid(getAllFromX(1)));
  // Print position of all boxes where x == 1
  //getAllFromX(1).foreach(s => println(s.x + ", "+s.y));
  
  // Print whether all squares contain 1 as a possible value
  //println(allSquares.forall((x:Square)=>x.possibleValues.contains(1)));
  
  //allSquares = allSquares.updated(0, allSquares(0).setValue(1)); 
  var sq = getAllFromX(1);
  //Checks if one of the squares has 1 (and only 1) as a possible value
  //println(sq.exists {(s:Square)=> s.possibleValues == List(1)});

  // Oppgave 3
  var intlist = List(1,2,0,-4,5);
  var intlist2 = List(2,2,3,4,5);
  intlist.foreach((i:Int)=>if (i >0) println(i))
  
  // Oppgave 4
  println(intlist.forall((i:Int)=>i>0));
  println(intlist2.forall((i:Int)=>i>0));
  
  // Oppgave 5
  var doublelist = List(1.2,47.2,0.23,91.02);
  println(doublelist.reduceLeft(_ min _));
  
  // Oppgave 6
  var intlist3 = List(3);
  def firstLast(li:List[Any]):Tuple2[Any,Any]=
  {
    return (li(0), li.last);
    //return (li(0),li(li.size-1));
  }
  
  println(firstLast(intlist));
  println(firstLast(intlist3));
  
  printlt(allSquares);
 }
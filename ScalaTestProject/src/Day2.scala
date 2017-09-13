object Day2 extends App{
/* 
  class ATM(x:Int){
    val balance:Int = x;
    def insert(nok:Int):ATM = {
      return new ATM(balance+nok);
    }
    def withdraw(nok:Int):ATM = {
      if(balance-nok < 0){
         println("You don't have enough money");
         return new ATM(balance);
      }
      else{
      return new ATM(balance-nok);
      }
   }
  }
 
  val m1 = new ATM(0);
  println(m1.balance);
  val m2 = m1.insert(400);
  println(m2.balance);
  val m3 = m2.withdraw(200);
  println(m3.balance);

  class Square_imp{
    var possibleValues = List(1,2,3,4);
    var solved = false;
    var boxValue = -1;
    var xNumber = -1;
    var yNumber = -1;
 
  
    def setValue(solution:Int){
      this.possibleValues = List(solution);
      this.solved = true;
    }
  }
  var s1 = new Square_imp();
  s1.boxValue = 1;
  s1.xNumber = 1;
  s1.yNumber = 1;
  s1.setValue(1);
 
  var s2 = new Square_imp();
  s2.boxValue = 1;
  s2.xNumber = 2;
  s2.yNumber = 1;
  s2.setValue(2);
*/
 
  class Square(boxNumber:Int, xNumber:Int, yNumber:Int,
      values:List[Int]=List(1,2,3,4),solved:Boolean=false){
    val possibleValues = values; //Public object value
    val x = xNumber;
    val y = yNumber;
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
  
  var s1 = new Square(1,1,1);
  s1 = s1.setValue(1);
  println(s1.possibleValues);
 
  var s2 = new Square(2,1,1);
  s2 = s2.removeValues(List(2,3));
  println(s2.possibleValues);
  
  var allSquares = List[Square]();
  
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
  
  for(xvalue <- List(1,2,3,4)){
    for(yvalue <- List(1,2,3,4)){
      val s = new Square(getBoxFromXY(xvalue, yvalue),xvalue,yvalue);
      allSquares = allSquares :+s;
    }
  }
  
  def getAllFromX(i:Int):List[Square] = {
    return allSquares.filter((s:Square)=>s.x == i);
  }
  
  def getAllFromY(i:Int):List[Square] = {
    return allSquares.filter((s:Square)=>s.y == i);
  }
  
  getAllFromX(1).foreach(s => println(s.x + ", "+s.y));
  
  
  //Lists
  
  val oneList = List(1,2,3,4, "Hei", false);
  val anotherList = List[Any](1,2,3,4, "Hei", false);
  
  for(i<- oneList){
    println(i);
  }
  
  def n(x:Any) = {println(x)};
  
  oneList.foreach(n);
  
  oneList.foreach((x:Any)=>println(x));
  
  oneList.foreach(println(_));
  
  def divideBy2(x:Int) = {
    x/2;
  }
  
  val l = List(1,2,3,4,5);
  
  l.foreach(x=>println(divideBy2(x)));
  l.foreach(x=>println(x/2));
  
  val winningList = List(1,2,3,4);
  val nums = List(1,2,9,28);
  
  println(nums.forall{(x:Int)=>winningList.contains(x); });
  
  println(allSquares.forall((x:Square)=>x.possibleValues.contains(1)));
  allSquares = allSquares :+ allSquares(0).setValue(2);
  println(allSquares.forall((x:Square)=>x.possibleValues.contains(1)));
  
  allSquares = allSquares.updated(0, allSquares(0).setValue(1)); 
  var sq = getAllFromX(1);
  println();
  println(sq.exists {(s:Square)=> s.possibleValues == List(1)});
  
  def squareFunc(x:Int) = x*x;
  val l2 = l.map(x => squareFunc(x));
  println(l2);
  
  // Tuple
  
  val a = (99, "Red Ballons");
  println(a._1 + " " + a._2 + "floating in the sky");
  
 //--------
  /*
  val a = List(1,5,-4,6,5)
  def square(x:Int) = x*x
  val aa = a.map(square)
  println(a)
  
  a take 2
  println(a splitAt 2)
  println(List.range(1,9))
  println(List.range(1,9, 2))
  
  val b = List("a", "b", "c")
  val c = b.zip(a)
  println(c)
  */
}
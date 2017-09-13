

object Day4Bjorn extends App
{
  /*
  class Rational(n:Int, d:Int)
  {
    require(d != 0);
    val number = n;
    val denom = d;
    println("Creating: " + n + "/" + d);
    override def toString = n + "/" + d;
    
    def +(that:Rational):Rational =
    {
      new Rational(
          number * that.denom + that.number * denom,
          denom * that.denom
      );
    }
    
    def *(that:Rational):Rational =
    {
      new Rational(number * that.number, denom * that.denom);
    }
    
    def *(that:Int):Rational =
    {
      new Rational(number * that, denom);
    }
    
    implicit def intToRational(n:Int):Rational =
    {
      return new Rational(n, 1);
    }
  }
  
  val r = new Rational(3, 4);
  println(r);
  val r2 = new Rational(3, 2);
  println(r2);
  val r3 = r + r2;
  println(r3);
  val r4 = r * r2;
  println(r4);
  val r5 = r * 4;
  println(r5);
  val r6 = 4 * r;
  println(r6);
  //new Rational(1, 0);
  
  //Program Control
  
  val x = 12;
  val y = 14;
  
  var largest = 0;
  if(x > y) largest = x;
  else largest = y;
  println(largest);
  
  
  val largest =
    if(x > y) x;
    else y;
  
  println("largest");
  
  
  val l = List(1, 2, 3, 4);
  for(i <- l)
  {
    println(i);
  }
  
  for(i <- 1 to 4)
  {
    println(i);
  }
  
  for(i <- 1 until 4)
  {
    println(i);
  }
  
  
  val l = List(1, 2, 3, 4, -2, -5);
  for(i <- l if i < 3 if i > 0)
  {
    println(i);
  }
  
  val newList =
    for(i <- l if i < 3) yield i;
  
  println(newList);
  
  val l2 = List("hi", "hello", "good day");
  
  val newList2 =
    for(i <- l2 if i.startsWith("h")) yield i;
  
  println(newList2);
  
  for(i <- 1 to 5)
  {
    for(i <- 2 to 6)
    {
      println("This runs many times");
    }
  }
  
  
  for(i <- 0 to 9)
  {
    for(j <- 0 to 9)
    {
      for(k <- 0 to 9)
      {
        for(l <- 0 to 9)
        {
          println(i, j, k, l);
        }
      }
    }
  }
  
  
  //Pattern matching
  
  def getText(x:Int):String =
  {
    return x match
    {
      case 1 => "One";
      case 2 => "Two";
      case 3 => "Three";
      case _ => "Some other number";
    }
  }
  
  println(getText(2));
  println(getText(99));
  
  
  def bb(s:String):String =
  {
    return s match
    {
      case "bit" => "bot";
      case "bot" => "bit";
      case _ => "bitbot";
    }
  }
  
  println(bb("bit") + ", " + bb("bot") + ", " + bb("a"));
  
  
  sealed abstract class Expr;
  case class Var(name:String) extends Expr;
  case class Number(num:Double) extends Expr;
  case class Op(operator:String, left:Expr, right:Expr) extends Expr;
  
  val v = new Var("x");
  val op = Op("*", Var("x"), Number(1));
  
  def simplify(expr:Expr):Expr =
  {
    expr match
    {
      case Op("+", e, Number(0)) => e;
      case Op("*", e, Number(1)) => e;
      case Op("-", e, Number(0)) => e;
      case Op(op, l, r) => Op(op, simplify(l), simplify(r));
      case _ => expr;
    }
  }
  
  def typeMatch(expr:Expr):String =
  {
    expr match
    {
      case Number(_) => "A number";
      case Var(_) => "A variable";
      case _ => "Somethingn else";
    }
  }
  
  println(op);
  println(simplify(op));
  
  println(simplify(new Op("", Var("x"), Op("", Var("x"), Number(1)))));
  */
  
  /*
  var jetSet = Set("Boing", "Airbus", "Boing");
  for(i <- jetSet)
  {
    println(i);
  }
  
  val l = List(1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4);
  val s = l.toSet[Int];
  for(i <- s)
  {
    println(i + ":" + l.count(_ == i));
  }
  
  val teacherSaying = List("exam", "test", "important", "exam", "homework", "test");
  val teacherSet = teacherSaying.toSet[String];
  for(i <- teacherSet)
  {
    println(i + " number of times: " + teacherSaying.count(_ == i));
  }
  
  //Maps
  
  val romans = Map[Int, String] (1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV");
  println(romans(2));
  
  for((arabic, roman) <- romans)
  {
    println(arabic + ":" + roman);
  }
  
  val capitals = Map[String, String] ("Norway" -> "Oslo", "Sweeden" -> "Stockholm", "France" -> "Paris", "USA" -> "Washington DC");
  for((country, capital) <- capitals)
  {
    println("The capital of " + country + " is " + capital);
  }
  
  //Singleton
  
  class Conf
  {
    var username = "Morten";
    var password = "Secret";
  }
  
  val c = new Conf();
  println(c.username);
  
  object Configuration
  {
    var username = "Morten";
    var password = "Secret";
  }
  
  println(Configuration.username);
  
  object Logger
  {
    var string = "Output string";
    var timestamp = java.util.Calendar.getInstance().getTime();
    
    def log(x:String)
    {
      println(x + ", " + this.timestamp);
    }
  }
  
  Logger.log(Logger.string);
  
  //Implicit corrections
  
  implicit def doubleToInt(x:Double):Int =
  {
    x.toInt;
  }
  
  //val i:Int = doubleToInt(3.5);
  val i:Int = 3.5;
  println(i);
  
  implicit def stringLength(s:String):Int =
  {
    return s.length;
  }
  
  //val s:Int = "Hello, World!";
  val s2:Int = "hello"/2;
  
  println("Length of s is " + s + " and length of s2 is " + s2);
  */
  
  class Square(xNumber:Int, yNumber:Int, boxNumber:Int, values:List[Int] = List(1, 2, 3, 4), solved:Boolean = false)
  {
    var possibleValues = values;
    val x = xNumber;
    val y = yNumber;
    val box = boxNumber;
    var s = solved;
    
    def setValue(solution:Int) =
    {
      this.s = true;
      this.possibleValues = List(solution);
    }
    
    def removeValue(wrongNumber:Int) =
    {
      if(this.s == false)
      {
        this.possibleValues = this.possibleValues.filter(_ != wrongNumber);
        if(this.possibleValues.length == 1)
        {
          this.setValue(this.possibleValues(0));
        }
      }
    }
    
    def getCorrectValue():Int =
    {
      if(this.s == true)
      {
        return this.possibleValues(0);
      }
      else
      {
        return 0;
      }
    }
  }
  
  implicit def intToSquare(i:Int):Square =
  {
    return new Square(1, 1, 1, List(i), true);
  }
  /*
  val s3:Square = 4;
  println(s3.possibleValues);
  */
  
  def getBoxFromXY(x:Int, y:Int) =
  {
    (x, y) match
    {
      case (1|2, 1|2) => 1;
      case (3|4, 1|2) => 2;
      case (1|2, 3|4) => 3;
      case (x, y) => 4;
    }
  }
  
  var allSquares = List[Square]();
  
  for(x <- List(1, 2, 3, 4))
  {
    for(y <- List(1, 2, 3, 4))
    {
      val s = new Square(x, y, getBoxFromXY(x, y));
      allSquares = allSquares :+ s;
    }
  }
  
  def getAllFromX(i:Int):List[Square] =
  {
    return allSquares.filter(_.x == i);
  }
  
  def getAllFromY(i:Int):List[Square] =
  {
    return allSquares.filter(_.y == i);
  }
  
  def getAllFromBox(i:Int):List[Square] =
  {
    return allSquares.filter(_.box == i);
  }
  
  def getSquare(x:Int, y:Int):Square =
  {
    allSquares.filter(_.x == x).filter(_.y == y)(0);
  }
  
  def setValue(x:Int, y:Int, solution:Int) =
  {
    var s = getSquare(x, y);
    allSquares = allSquares.filter(_ != s);
    s.setValue(solution);
    allSquares = allSquares :+ s;
  }
  
  def removeValue(x:Int, y:Int, wrongNumber:Int) =
  {
    var s = getSquare(x, y);
    allSquares = allSquares.filter(_ != s);
    s.removeValue(wrongNumber);
    allSquares = allSquares :+ s;
  }
  
  setValue(1, 1, 3);
  setValue(1, 2, 4);
  setValue(1, 3, 1);
  setValue(2, 2, 2);
  setValue(3, 3, 2);
  setValue(4, 2, 1);
  setValue(4, 3, 4);
  setValue(4, 4, 3);
  
  def printit()
  {
    println("-----------------");
    for(x <- List(1, 2, 3, 4))
    {
      for(y <- List(1, 2, 3, 4))
      {
        print("| ");
        var s = getSquare(x, y);
        if(s.s)
        {
          print(s.getCorrectValue() + " ");
        }
        else
        {
          print("  ");
        }
      }
      print("|\n-----------------\n");
    }
  }
  
  printit();
  
  def isValid(x:Int, y:Int, solution:Int):Boolean =
  {
    for(s <- (getAllFromX(x)):::getAllFromY(y):::getAllFromBox(getBoxFromXY(x, y)))
    {
      if(x != s.x || y != s.y)
      {
        if(s.s == true && s.possibleValues(0) == solution)
        {
          //println("Has solution: " + s.x + ", " +  s.y + ", " + s.possibleValues);
          return false;
        }
      }
    }
    return true;
  }
  
  def removeIfNotValid(x:Int, y:Int, solution:Int)
  {
    if(!isValid(x, y, solution))
    {
      //println("Removing " + x + ", " + y + ", " + solution + " solution");
      removeValue(x, y, solution);
    }
  }
  
  //And now for some brute force
  
  for(x <- List(1, 2, 3, 4))
  {
    for(y <- List(1, 2, 3, 4))
    {
      for(v <- List(1, 2, 3, 4))
      {
        removeIfNotValid(x, y, v);
      }
    }
  }
  
  def patternMatching(s1:Int, s2:Int, s3:Int, s4:Int):Int =
  {
    var l = List(s1, s2, s3).sortWith(_ < _);
    return l match
    {
      case List(1, 2, 3) => 4;
      case List(1, 2, 4) => 3;
      case List(1, 3, 4) => 2;
      case List(2, 3, 4) => 1;
      case List(_, _, _) => s4;
    }
  }
  
  def updateAllX()
  {
    for(x <- List(1, 2, 3, 4))
    {
      for(y <- List(1, 2, 3, 4))
      {
        val l = List(1, 2, 3, 4).filter(_ != y);
        var res = patternMatching(
            getSquare(x, l(0)).getCorrectValue(),
            getSquare(x, l(1)).getCorrectValue(),
            getSquare(x, l(2)).getCorrectValue(),
            getSquare(x, y).getCorrectValue()
        );
        if(res > 0)
        {
          setValue(x, y, res);
        }
      }
    }
  }
  
  //printit();
  updateAllX();
  //printit();
  
  
  //Partially applied functions
  
  /*
  def sum(a:Int, b:Int, c:Int) = a + b + c;
  println(sum(2, 3, 4));
  
  def b = sum(3, _:Int, 6);
  println(b(2));
  
  def multiply(a:Double, b:Double, c:Double):Double = 
  {
    return a * b * c;
  }
  println(multiply(2, 3, 4));
  
  def multiply2 = multiply(_:Double, _:Double, 1);
  println(multiply2(2, 3));
  println(multiply(2, 3, 1));
  */
  
  
  //1
  
  class Store(a:Int, b:Int)
  {
    var apples = a;
    var bananas = b;
    
    def getApples():Int =
    {
      return this.apples;
    }
    def setApples(a:Int) =
    {
      this.apples = a;
    }
    
    def getBananas():Int =
    {
      return this.bananas;
    }
    def setBananas(b:Int) =
    {
      this.bananas = b;
    }
    
    def stringify():String =
    {
      return "Number of apples: " + s.getApples() + ",\nnumber of bananas: " + s.getBananas();
    }
  }
  
  val s = new Store(5, 7);
  /*
  println(s.stringify());
  s.setApples(s.getApples() - 3);
  s.setBananas(s.getBananas() + 6);
  println(s.stringify());
  */
  
  //2
  
  def getText(x:Int):String =
  {
    return x match
    {
      case 1 => "one";
      case 2 => "two";
      case _ => "Other number";
    }
  }
  /*
  println(getText(2));
  println(getText(99));
  */
  
  //3
  
  def rmDupRow(n:Int, x:Int) =
  {
    var l = getAllFromX(x);
    for(i <- l)
    {
      var s = i.possibleValues.contains(n);
    }
  }
  printit();
}



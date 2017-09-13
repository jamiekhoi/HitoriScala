

object Day3 extends App{ 
  
  // Immutable Sets
  //import scala.collection.immutable.Set;
  // Mutable Sets
  //import scala.collection.mutable.Set;
  
  // Sets have only unique elements
  var jetSet = Set("Boeing", "Airbus", "Boeing")
  jetSet.foreach(println)
  
  val l = List(1,2,2,2,4,5,5,6,6,7,8,8,8,8,8,9,9,9,4,4,4,4,4);
  val s = l.toSet
  for(i<-s){
    println(i + ": " +l.count(_ ==i))
  }
  
  jetSet += "X-wing"
  println(jetSet)
  
  // Maps
  val romans = Map[Int, String](1->"I", 2->"II", 3->"III")
  println(romans(2))
  
  for((arabic, roman)<- romans){
    println(arabic+": " +roman)
  }
  
  // CLasses and Objects
  class Conf{
    /* This could e.g. be from a file*/
    val username = "Morten";
    val passord = "secret";
  }
  // Usage
  val c = new Conf();
  println(c.username);
  
  object Configuration {
    /* This could be e.g. be from a file */
    val username = "Morten";
    val passord = "secret";
  }
  // Usage
  println(Configuration.username)
  
  object Logger {
    def log(s:String) = {
      println(java.util.Calendar.getInstance().getTime() + " " + s)
    }
  }
  
  Logger.log("A")
  
  // Implicit corrections
  
  // Implicitly convert doubles to ints using this
  implicit def doubleToInt(x:Double): Int = {
    x.toInt
  }
  
  // Here a double value is assigned to an Int and the func doubleToInt is implicity used
  val i: Int = 3.7;
  println(i)
  
  implicit def stringToInt(x:String):Int = {
    return x.length();
  }
  
  val ii:Int = "hei";
  println("hei"/2);
  
  /*
  val s:Square = 4;
  implicit def intToSquare(i:Int):Square = {
    new Square(1,1,1,List(i))
  }  
  */
  
}
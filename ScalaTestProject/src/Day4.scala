

object Day4 extends App{
  
  class Rational(n:Int, d:Int) {
    require(d != 0)
    var numer : Int = n
    var denom : Int = d
    override def toString = numer + "/" + denom
    def add(that: Rational):Rational = {
      new Rational( numer*that.denom + that.numer*denom, denom*that.denom)
    }
    def + = add(_:Rational)
    def *(that:Rational) = new Rational(numer*that.numer, denom*that.denom)
    def *(i:Int) = new Rational(numer*i, denom)
    
  }
  
  val r = new Rational(1,5)
  val r2 = new Rational(3,2)
  val r3 = r * 2
  val r4 = 2 * r
  
  implicit def intToRational(n:Int):Rational = {
    return new Rational(n, 1);
  }
  
  println(r4)
  
  // Program control
  val x = 12
  val y = 14
  var largest = //The indentation and semicolons in the for/else are not necessary
    if(x>y) x;
    else y;
  println(largest)
  
  def salt() = {println("salt"); false}
  def pepper() = {println("pepper");true}
  
  // This prints only "salt" and returns false
  salt() && pepper();
  // This prints both "salt" and "pepper" and returns false
  salt() & pepper();
  
  
  // For-loops
  
  // With generator
  val l = List(1,2,3,4)
  for(i<-l){
    println("i"+i)
  }
  
  // With range
  for(i<-1 to 4){
    println("i"+i)
  }
  
  // Without upper bound
  for(i<-1 until 4){
    println("i"+i)
  }
  println()
  
  // Negative
  for(i<-4 until 1 by -1){
    println("i"+i)
  }
  
  println()
  // With filtering
  val ll = List(1,2,2,3,-5)
  for(i<-ll if i<3){
    println("i"+i)
  }
  
  println()
  // With multiple filters
  for(i<-ll if i<3 if i>0){
    println("i"+i)
  }
  
  // Yield
  val newlist = for(i<-ll if i<3 if i>0) yield i
  println(newlist)
  
  // Small assignment
  val lll = List("hi","hello","good day")
  val starth = for(i<-lll if i.startsWith("h")) yield i
  println(starth)
  println()
  
  // Pattern matching
  def bitBot(x:String):String = {
    return x match{
      case "bit" => "bot";
      case "bot" => "bit"
      case _ => "bitbot"
    }
  }
  println(bitBot("bot"))
  println(bitBot("bit"))
  println(bitBot("but"))
  
  abstract class Expr;
  case class Var(name:String) extends Expr;
  case class Number(num:Double) extends Expr;
  case class Op(operator:String, left:Expr, right:Expr) extends Expr;
  
  val n = Number(5);
  val v = new Var("x")
  val op =  Op("*", Var("x"), Number(1));
  
  def simplify(expr:Expr) = {
    expr match {
      case Op("+",e,Number(0)) => e
      case Op("-",e,Number(0)) => e
      case Op("*",e,Number(1)) => Number(9)
      case _ => expr
    }
  }
  val op2 = simplify(op)
  println(op2)
  println(simplify(new Op("", Var("x"), Op("", Var("x"), Number(1)))));
  
}

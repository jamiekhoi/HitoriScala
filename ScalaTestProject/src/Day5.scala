

object Day5 extends App
{
  
  /*
  abstract class SuperClass
  {
    def someMethod()
    {
      println("Hi");
    }
  }
  
  class Subclass extends SuperClass
  {
    override def someMethod()
    {
      println("Hello");
    }
  }
  
  //Traits
  
  trait Philosophical
  {
    def philosophize()
    {
      println("I conume memory, therefore I am");
    }
  }
  
  trait Animal
  {
    def heartBeat()
    {
      println("My heart is beating");
    }
    
    def philosophize()
    {
      println("My heart beats, therefore I am");
    }
  }
  
  class Frog extends Philosophical with Animal
  {
    override def toString = "green";
    override def philosophize()
    {
      println("I am overriding");
    }
    def liveAndPhilozophize()
    {
      this.philosophize;
      this.heartBeat;
    }
  }
  
  class Cat extends Philosophical
  {
    override def toString = "orange";
  }
  
  val f = new Frog();
  f.philosophize();
  f.heartBeat();
  f.liveAndPhilozophize();
  
  /*
  val c = new Cat() with Animal;
  c.philosophize();
  c.heartBeat();
  */
  */
  //New Star Wars example
  
  class Lightsaber
  {
    def properties:List[String] = List();
    override def toString = "It's a" + properties.mkString(" ", ", ", " ") + "lightsaber";
  }
  
  trait Red extends Lightsaber
  {
    override def properties() = super.properties ::: List("red");
  }
  
  trait Corrguard extends Lightsaber
  {
    override def properties() = super.properties ::: List("corrguard");
  }
  
  trait Dual extends Lightsaber
  {
    override def properties() = super.properties ::: List("dual");
  }
  
  val mySaber = new Lightsaber() with Red with Corrguard;
  println(mySaber);
  
  trait Wheels
  {
    def run()
    {
      println("Run");
    }
  }
  
  trait SteeringWheels
  {
    def steer()
    {
      println("Steer");
    }
  }
  
  abstract class Vehicle;
  
  class Car extends Vehicle with Wheels with SteeringWheels
  {
    def drive()
    {
      this.run();
      this.steer();
    }
  }
  
  val car = new Car();
  car.drive();
  
  // Extractor
  object Email{
    def apply(user:String, domain:String)=user+"@"+domain
    def unapply(str:String): Option[(String, String)] = {
      val parts = str split "@"
      if(parts.length == 2) Option(parts(0), parts(1)) else None
    }
  }
  
  def workAtUiA(s: String): Boolean = s match{
    case Email(_, "uia.no") => true;
    case _ => false;
  }
  
  println(workAtUiA("a@uia.no"));
  println(workAtUiA("a@gmail.no"));
  
  // Lazy vals
  
  class Demo{
    lazy val x = {println("Initializing x"); "done";}
    
  }
  
  val d = new Demo();
  println("Before");
  println(d.x);
  
  class Demo2{
    lazy val l = (1 to 1000).toList
  }
  val a = new Demo2();
  println("bruh")
  // Because l is lazy, it is only initialized when used, not at class initialization
  // Lazy loading helps save memory before the val is needed
  println(a.l)
}
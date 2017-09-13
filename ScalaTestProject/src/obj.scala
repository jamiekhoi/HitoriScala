

object obj extends App {
  
    /*
    println("Hello world");
    var a = 12;
    var b:Int = 12;
    
    a = 13;
    println(a);
    
    var msg = "Hi";
    println(a+msg);
    
    val c = 19;
    //c = 13;
    println(c);
    
    val big = new java.math.BigInteger("123123");
    */
    val a = 3.5f; //Alternative val a:Float = 3.5;
    val b = 3.5; //Double
    val c = 'c'; //Char
    val d = "Hi"; //String
    val e = """Ho
            in
            many
            rows
            """;
    val f = """ Text with "quotation" """;
    val g = 'symbol;
    
    println(1==1);
    println(1==1.0);
    
    def max(x:Int,y:Int):Int = {
        if(x>y)return x;
        return y;
    }
    
    println(max(2,3));
    
    def max2(x:Int,y:Int) = {
        if(x>y)x else y;
    }
    
    println(max2(2,3));
    
    var y = 0;
    def setValue(x:Int):Unit = {
        y=x;
    }
    
    println(y);
    println(5);
    println(y);
    
    def greet() = println("Hello world");
    greet();
    
    def iUnderstand():Int = {
        return 2;
    }
    
    def j = 2;
    
    val s = "Hi class in DAT233";
    println(s.indexOf('c'));
    println(s indexOf 'c');
    println(s indexOf ('c',5));
    println(5+4);
    println((5).+(4));
    println(5.+(4));
    
    def anum():Int = {
      return 2;
    }
    def anumf() = 4;
    
    if(anumf > anum()){
      println("larger than 2");
    }else{
      println("smaller than 2")
      println("so small")
    }
    
    def sqrt(x:Double) = {
      if(x>=0)
        java.lang.Math.sqrt(x);
      else{
        "Cannot do a squart rot of negative numbas"
      }
    }
    
    def sqrt2(x:Double):Any = {
      if(x>=0)
        return java.lang.Math.sqrt(x);
      else{
        return java.lang.Math.sqrt(java.lang.Math.abs(x)).toString() + "i";
      }
    }
    
    println(sqrt2(2));
    println(sqrt2(-2));
    
    // Array
    val arr = Array("Luke", "leia", "Han");
    var l = 0;
    while (l < arr.length){
      println(arr(l));
      l += 1;
    }
    
    for(arg <- arr){
      println(arg);
    }
    
    for(i <- 0 to arr.length-1){
      println(arr(i));
    }
    
    arr.foreach((arg:String)=>println(arg));
    
    def maxNumba(arr:Array[Int]) = {
      arr.max;
    }
    val m = Array(0,3,3,4,5,6,2,1,3,5,7,3);
    println(maxNumba(m));
    
    // Higher order functions
    
    def inc(x:Int):Int = {
      return x+1;
    }
    
    def applyToInt(f:(Int=>Int), i:Int):Int = {
      return f(i);
    }
    
    println(applyToInt(inc, 2));
    
    def divideBy2(x:Int):Int = {
      x/2;
    }
    
    def applyToAll(f:(Int=>Int), arr:Array[Int]):Unit = {
      arr.foreach((arg:Int)=>println(f(arg)));
    }
    println();
    applyToAll(divideBy2, m);
    applyToAll(inc, m);
    
    def p(x:String):Unit = {
      println(x);
    }
    
    //(String=>Unit)
    arr.foreach(p);
    arr.foreach(println);
    
    // Lambda
    ((x:Int)=>println(x*x))(2)
    val li = List(1,1,2,3,4,5,6,7);
    li.foreach((x:Int)=>println(x*x));

    arr.foreach((arg:String)=>println(arg));
    //((arg:String)=>println(arg))("Luke", "Leia", "Han")
    
    // Assignments
    // 1
    
    var tesar = Array(4,5,3,2,1,6,7,8)
    def average(arr:Array[Int]) = {
      var d = 0f;
      arr.foreach((arg:Int)=>d += arg);
      d/arr.length;
    }
    
    println(average(tesar))
    
    //2
    def median(arr:Array[Int]) = {
      var arr2 = arr.sorted;
      if(arr.length % 2 == 0){
        (arr2(arr.length/2).toFloat+arr2((arr.length/2)-1))/2
      }else{
        arr2((arr.length/2))
      }
    }
    /*def median2(arr:Array[Int]) = {
      var arr2 = arr.sorted;
      if(arr.length % 2 == 0){
        (arr2(arr.length/2).toFloat+arr2((arr.length/2)-1))/2
      }else{
        var var3 = arr.sortWith(_<_)
        ((arr.length/2)+1)
        //arr2((arr.length/2))
      }
    }*/
    println(tesar);
    println(median(tesar));
    
    //3
    println()
    def printCap(arr:Array[String]) = {
      arr.foreach((arg:String)=>
        arg.foreach((arg2:Char)=>if(arg2.isUpper)println(arg2))
        );
    }
    
    var stringarray = Array("Favorite", "jUmp", "baCKflip")
    printCap(stringarray);
    
    //4
    def recursiveAdd(arr:Array[Int]):Int = {
      if(arr.length > 1){
        arr(0) + arr(1) + recursiveAdd(arr.slice(2,arr.length));
      }else if(arr.length > 0){
        arr(0);
      }else{
        return 0;
      } 
    }
    
    println();
    tesar = Array(6,2,3);
    println(recursiveAdd(tesar));
    
    //5
    def factorial(x:Int) = {
      var i = x;
      var ii = 1;
      while(i > 1){
        ii *= i;
        i -= 1;
      }
      ii;
    }
    
    println();
    println(factorial(6));
    
    //6
    def even(x:Int) = {
      if(x%2==0) true else false
    }
    var teslis = List(9,8,7,6,5,4,3,2);
    var anslis = teslis.filter(even);
    println();
    anslis.foreach(print);
    
    //7
    var anslis2 = teslis.filter((arg:Int)=>arg%2==0);
    println();
    anslis.foreach(print);
    
    //8
    
}
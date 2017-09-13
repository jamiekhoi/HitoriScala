import java.util.regex.Matcher
import java.util.regex.Pattern


object SukoduSolve extends App{
  def tripletsJava(row:String):List[Int] = {
    var pattern = Pattern.compile("(.).\\1");
    var matcher = pattern.matcher(row);
    var l = List[Int]()
    while(matcher.find()){
      //println(matcher group(0))
      //println(matcher.start())
      l = l :+ matcher.start() + 1;
    }
    return l
  }
  
  def pairInductionJava(row:String):List[Int] = {
    var pattern = Pattern.compile("(.).\\1\\1");
    var pattern2 = Pattern.compile("(.)\\1.\\1");
    var matcher = pattern.matcher(row);
    var l = List[Int]()
    while(matcher.find()){
      l = l :+ matcher.start() + 1;
    }
    matcher = pattern2.matcher(row);
    while(matcher.find()){
      l = l :+ matcher.end - 2;
    }
    return l
  }
                      //0123456789
  println(tripletsJava("12322444232"))
  println(pairInductionJava("123224454"))
  println(List(3) ::: List(1))
}
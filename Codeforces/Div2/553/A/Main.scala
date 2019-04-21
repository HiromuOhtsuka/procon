import scala.math._

object Main {
  def main(args: Array[String]) = {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt
    val s = sc.next

    val tar = "ACTG"

    var ans = 26 * 4
    for(i <- 0 until n if i + 4 <= n){
      var cost = 0
      for(j <- i until i + 4){
        cost += min(abs(s(j) - tar(j - i)), 
          26 - abs(s(j) - tar(j - i)))
      }
      ans = min(ans, cost)
    }

    println(ans)
  }
}

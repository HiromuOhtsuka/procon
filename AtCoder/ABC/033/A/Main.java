import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    String line = scan.nextLine();
    boolean same = true;
    for(int i = 0; i < 4; i++){
      if(!same){
        break;
      }
      for(int j = 0; j < 4; j++){
        if(i == j){
          continue;
        }
        if(line.charAt(i) != line.charAt(j)){
          same = false;
          break;
        }
      }
    }

    if(same){
      System.out.println("SAME");
    }
    else{
      System.out.println("DIFFERENT");
    }
  }

}

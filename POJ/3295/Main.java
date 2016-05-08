import java.util.Scanner;

public final class Main {
  private int sp;
  private boolean tautology(
      char[] exp, final int len){
    char[] tmp = new char[len];
    boolean ret = true;
    for(int i = 0; i < 2; i++){
      for(int j = 0; j < 2; j++){
        for(int k = 0; k < 2; k++){
          for(int l = 0; l < 2; l++){
            for(int m = 0; m < 2; m++){
              for(int n = 0; n < len; n++){
                switch(exp[n]){
                  case 'p' : tmp[n] = (char)('0' + i); break;
                  case 'q' : tmp[n] = (char)('0' + j); break;
                  case 'r' : tmp[n] = (char)('0' + k); break;
                  case 's' : tmp[n] = (char)('0' + l); break;
                  case 't' : tmp[n] = (char)('0' + m); break;
                  default : tmp[n] = exp[n];
                }
              }
              sp = 0;
              ret = ret && expression(tmp, len);
              if(!ret){ return false; }
            }
          }
        }
      }
    }
    return ret;
  }

  private boolean expression(
      char[] exp, final int len){
    boolean ret = binaryExpression(exp, len);
    if(sp >= len){
      return ret;
    }
    return ret && expression(exp, len);
  }

  private boolean binaryExpression(
      char[] exp, final int len){
    if(binaryOperation(exp[sp])){
      char op = exp[sp];
      ++sp;
      boolean b1 = binaryExpression(exp, len);
      boolean b2 = binaryExpression(exp, len);
      switch(op){
        case 'K' : 
          return b1 && b2;
        case 'A' :
          return b1 || b2;
        case 'C' :
          return !(b1 && !b2);
        case 'E' :
          return b1 == b2;
        default :
          return false;
      }
    }
    return unaryExpression(exp, len);
  }

  private boolean unaryExpression(
    char[] exp, final int len){
    if(literal(exp[sp])){
      boolean b = (exp[sp] == '1');
      ++sp;
      return b;
    }
    if(unaryOperation(exp[sp])){
      sp++;
      return !unaryExpression(exp, len);
    }
    System.out.println("syntax error");
    return false;
  }

  private boolean binaryOperation(char ch){
    return ch == 'K' || ch == 'A' ||
      ch == 'C' || ch == 'E';
  }

  private boolean unaryOperation(char ch){
    return ch == 'N';
  }

  private boolean literal(char ch){
    return ch == '0' || ch == '1';
  }

  public Main(){
    Scanner scan = new Scanner(System.in);
    String exp = scan.next();
    while(exp != null && !exp.equals("0")){
      if(tautology(exp.toCharArray(), exp.length())){
        System.out.println("tautology");
      }
      else{
        System.out.println("not");
      }
      exp = scan.next();
    }
  }

  public static void main(String[] args){
    new Main();
  }
}

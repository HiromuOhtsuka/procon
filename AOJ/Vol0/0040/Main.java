import java.util.Scanner;

public final class Main {
  private int N;

  public Main(){
    Scanner scan = new Scanner(System.in);

    N = scan.nextInt();
    scan.nextLine();
    for(int i = 0; i < N; i++){
      String line = scan.nextLine();
      int[] ab = search(line);
      System.out.println(parse(line, ab[0], ab[1]));
    }
  }

  private int f(int a, int b, int y){
    if(!('a' <= y && y <= 'z')){
      return y;
    }
    return ((a * (y - 'a') + b)) % 26 + 'a';
  }

  private String parse(String word, int a, int b){
    char[] str = new char[word.length()];
    for(int i = 0; i < word.length(); i++){
      str[i] = (char)f(a, b, word.charAt(i));
    }
    return new String(str);
  }

  private int[] search(String line){
    final int[] a = {1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25};
    String[] words = line.split("\\s");
    for(int i = 0; i < a.length; i++){
      for(int b = 0; b < 26; b++){
        for(int j = 0; j < words.length; j++){
          String w = parse(words[j], a[i], b);
          if("this".equals(w) || "that".equals(w)){
            return new int[]{a[i], b};
          }
        }
      }
    }
    return null;
  }

  public static void main(String[] args){
    new Main();
  }
}

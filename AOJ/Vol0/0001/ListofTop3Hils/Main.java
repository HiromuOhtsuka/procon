import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int[] height = new int [10];
    for(int i=0; i<10; i++){
      height[i] = scan.nextInt();
    }
    reSort(height, 0, height.length-1);
    System.out.println(height[0]);
    System.out.println(height[1]);
    System.out.println(height[2]);
  }

  private static void reSort(int[] a, int bottom, int top){
    if(top - bottom < 1){
      return ;
    }
    int left = bottom;
    int right = top;
    int base = a[(bottom + top) / 2];
    while(left < right){
      while(base < a[left]){
        left++;
      }
      while(base > a[right]){
        right--;
      }
      if(left < right){
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
        left++;
        right--;
      }
    }
    if(left == right){
      if(base >= a[left]){
        left++;
      }
      if(base <= a[right]){
        right--;
      }
    }
    reSort(a, bottom, right);
    reSort(a, left, top);
  }
}

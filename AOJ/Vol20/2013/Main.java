mport java.util.Scanner;

public class Main {
  public static Scanner scan = new Scanner(System.in);
  public static void main(String[] args){
    for(;;){
      int n = scan.nextInt();
      if(n == 0)
        break;
      Time[] time = new Time[2*n];
      for(int i=0;i<2*n;i++){
        time[i] = scanTime(i%2 == 0);
      }
      sort(time, 2*n);
      int count = 0;
      int max = 0;
      for(int i=0;i<2*n;i++){
        if(time[i].flag){
          count++;
        }
        else{
          count--;
        }
        if(count > max){
          max = count;
        }
      }
      System.out.println(max);
    }
  }

  public static void sort(Time[] data, int size){
    boolean f;
    do{
      f = false;
      for(int i=0;i<size;i++){
        for(int j=0;j<size-i-1;j++){
          if( (data[j].h*3600+data[j].m*60+data[j].s) > (data[j+1].h*3600+data[j+1].m*60+data[j+1].s )){
            Time temp = data[j];
            data[j] = data[j+1];
            data[j+1] = temp;
            f = true;
          }
        }
      }
    }while(f);
    for(int j=0;j<size-1;j++){
      if((data[j].h*3600+data[j].m*60+data[j].s) == (data[j+1].h*3600+data[j+1].m*60+data[j+1].s) && data[j].flag == true){
        Time temp = data[j];
        data[j] = data[j+1];
        data[j+1] = temp;
      }
    }
  }
  public static Time scanTime(boolean flag){
    String str[] = scan.next().split(":");
    int h = Integer.parseInt(str[0]);
    int m = Integer.parseInt(str[1]);
    int s = Integer.parseInt(str[2]);
    return (new Time(h, m, s, flag));
  }
}

class Time {
  int h;
  int m;
  int s;
  boolean flag;

  public Time(int h, int m, int s, boolean flag){
    this.h = h;
    this.m = m;
    this.s = s;
    this.flag = flag;
  }
}

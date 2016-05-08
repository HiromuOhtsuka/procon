#include <cstdio>
using namespace std;

int main(){
  double a, b;
  while(scanf("%lf %lf", &a, &b) != EOF){
    if(a < 35.5 && b < 71){
      printf("AAA\n");
    }
    else if(a < 37.5 && b < 77){
      printf("AA\n");
    }
    else if(a < 40 && b < 83){
      printf("A\n");
    }
    else if(a < 43 && b < 89){
      printf("B\n");
    }
    else if(a < 50 && b < 105){
      printf("C\n");
    }
    else if(a < 55 && b < 116){
      printf("D\n");
    }
    else if(a < 70 && b < 148){
      printf("E\n");
    }
    else{
      printf("NA\n");
    }
  }
  return 0;
}

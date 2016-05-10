#include <cstdio>
using namespace std;

static int a, b;

int main(){
  bool first = true;
  while(true){
    scanf("%d %d", &a, &b);
    if(a == 0 && b == 0){
      return 0;
    }
    if(!first){
      printf("\n");
    }
    bool na = true;
    for(int i = a; i <= b; i++){
      if(i % 4 == 0){
        if(i % 400 == 0){
          na = false;
          printf("%d\n", i);
        }
        else if(i % 100){
          na = false;
          printf("%d\n", i);
        }
      }
    }
    if(na){
      printf("NA\n");
    }
    first = false;
  }

  return 0;
}

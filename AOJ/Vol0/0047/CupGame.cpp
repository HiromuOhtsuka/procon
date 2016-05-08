#include <cstdio>
#include <cstdlib>
using namespace std;

static bool A, B, C;

static void swap(bool *a, bool *b){
  bool tmp = *a;
  *a = *b;
  *b = tmp;
}

int main(){
  A = true;
  char from, to;
  while(scanf("%c,%c", &from, &to) != EOF){
    if(from == '\n'){
      continue;
    }
    switch(from){
      case 'A' : 
        switch(to){
          case 'B' : swap(&A, &B);  break;
          case 'C' : swap(&A, &C);  break;
          default : exit(1);
        }
        break;
      case 'B' : 
        switch(to){
          case 'A' : swap(&B, &A);  break;
          case 'C' : swap(&B, &C);  break;
          default : exit(1);
        }
        break;
      case 'C' : 
        switch(to){
          case 'A' : swap(&C, &A);  break;
          case 'B' : swap(&C, &B);  break;
          default : exit(1);
        }
        break;
      default : exit(1);
    }
  }

  if(A){
    printf("A\n");
  }
  else if(B){
    printf("B\n");
  }
  else if(C){
    printf("C\n");
  }

  return 0;
}

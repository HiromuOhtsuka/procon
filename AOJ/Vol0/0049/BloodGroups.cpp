#include <cstdio>
using namespace std;

static int A, B, AB, O;

int main(){
  int n;
  char b;

  while(scanf("%d,%c", &n, &b) != EOF){
    if(b == 'A'){
      b = getchar();
      if(b == '\n'){
        ++A;
      }
      else if(b == 'B'){
        ++AB;
      }
    }
    else{
      switch(b){
        case 'B' : ++B; break;
        case 'O' : ++O; break;
      }
    }
  }

  printf("%d\n%d\n%d\n%d\n", A, B, AB, O);

  return 0;
}

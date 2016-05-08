#include <cstdio>
using namespace std;

static int a[10];

int main(){
  while(true){
    int ch, sp = 0;
    while((ch = getchar()) != '\n'){
      if(ch == EOF){
        return 0;
      }
      a[sp++] = ch - '0';
    }
    for(int i = 1; i < 10; i++){
      for(int j = 0; j < (10 - i); j++){
        a[j] = (a[j] + a[j + 1]) % 10;
      }
    }
    printf("%d\n", a[0]);
  }

  return 0;
}

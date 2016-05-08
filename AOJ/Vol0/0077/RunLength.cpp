#include <cstdio>
#include <cstring>
#define MAX_LEN 100
using namespace std;

int main(){
  while(true){
    int ch;
    ch = getchar();

    if(ch == EOF){
      return 0;
    }

    while(ch != '\n'){
      if(ch == '@'){
        int n = getchar() - '0';
        ch = getchar();
        for(int i = 0; i < n; i++){
          putchar(ch);
        }
      }
      else{
        putchar(ch);
      }
      ch = getchar();
    }

    putchar('\n');
  }

  return 0;
}

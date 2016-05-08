#include <cstdio>
using namespace std;

int main(){
  int pass = 0, ch;

  ch = getchar();
  while(ch != EOF){
    if('0' <= ch && ch <= '9'){
      int num = ch - '0';
      ch = getchar();
      while('0' <= ch && ch <= '9'){
        num = 10 * num + (ch - '0');
        ch = getchar();
      }
      pass += num;
    }
    ch = getchar();
  }

  printf("%d\n", pass);

  return 0;
}

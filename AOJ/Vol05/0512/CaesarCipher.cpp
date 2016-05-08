#include <cstdio>
using namespace std;

int main(){
  int ch;
  while((ch = getchar()) != '\n'){
    ch = (ch - 'A' -  3) % 26;
    if(ch >= 0){
      ch += 'A';
    }
    else{
      ch += 26 + 'A';
    }
    putchar(ch);
  }
  putchar('\n');

  return 0;
}

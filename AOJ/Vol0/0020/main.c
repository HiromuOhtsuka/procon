nclude <stdio.h>
#include <ctype.h>

int main(void){
  char c;

  while((c=getchar())!=EOF){
    c=toupper(c);
    putchar(c);
  }

  return 0;
}

#include <stdio.h>

int searchInc(int a, int b){
  int count = 0;
  while(a != b){
    a = (a + 1) % 10;
    count++;
  }
  return count;
}

int searchDec(int a, int b){
  int count = 0;
  while(a != b){
    a = (a - 1) > 0 ? (a - 1) : 9;
    count++;
  }
  return count;
}

int main(void){
  int a, b, in, dec;

  scanf("%d %d", &a, &b);

  in = searchInc(a, b);
  dec = searchDec(a, b);

  if(in < dec){
    printf("%d\n", in);
  }
  else{
    printf("%d\n", dec);
  }

  return 0;
}

#include <stdio.h>
#define MAX 50

int strlen(char *str){
  int len = 0;
  while(*str != '0'){
    ++len;
    ++str;
  }
  return len;
}

int main(void){
  char str1[MAX + 1], str2[MAX + 1];

  scanf("%s %s", str1, str2);
  if(strlen(str1) < strlen(str2)){
    printf("%s\n", str2);
  }
  else{
    printf("%s\n", str1);
  }

  return 0;
}

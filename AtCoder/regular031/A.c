#include <stdio.h>
#include <stdlib.h>
#define MAX 100 + 1

char* re_str(char *str){
  char *tmp, *re;
  int len, sp;

  tmp = str;
  len = 0;
  while(*tmp != '\0'){
    ++len, ++tmp;
  }
  re = (char *)malloc(sizeof(char) * len);
  sp = 0;
  while(len > 0){
    re[sp++] = str[--len];
  }
  re[sp] = '\0';
  return re;
}

int main(void){
  char str[MAX], *tmp;

  scanf("%s", str);
  tmp = re_str(str);
  if(!strcmp(str, tmp)){
    printf("YES\n");
  }
  else{
    printf("NO\n");
  }

  return 0;
}

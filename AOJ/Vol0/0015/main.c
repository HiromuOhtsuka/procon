#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define KETA 80

short myatos(char c);

int main(void){
  short ans[KETA+1], cr;
  char  num1_sub[1024], num2_sub[1024], sub[1024];
  int   n, i, j, k, len1, len2, temp;

  scanf("%d", &n);
  for(i=0;i<n;i++){
    scanf("%s %s", num1_sub, num2_sub);
    len1=strlen(num1_sub); len2=strlen(num2_sub);
    cr=0;
    if(len1>KETA || len2>KETA){
      printf("overflow\n");
      continue;
    }
    if(len1<len2){
      strcpy(sub, num1_sub);
      strcpy(num1_sub, num2_sub);
      strcpy(num2_sub, sub);
      temp=len1;
      len1=len2;
      len2=temp;
    }
    for(j=0;j<len1;j++){
      k=len2-j-1;
      if(k>=0)
        ans[j]=myatos(num1_sub[len1-j-1])+myatos(num2_sub[k])+cr;
      else
        ans[j]=myatos(num1_sub[len1-j-1])+cr;
      if(ans[j]>=10){
        ans[j]%=10;
        cr=1;
      }
      else{
        cr=0;
      }
    }
    if(cr==1 && j==KETA){
      printf("overflow\n");
      continue;
    }
    ans[j]=cr;
    if(cr==1)
      printf("1");
    for(k=j-1;k>=0;k--){
      printf("%d", ans[k]);
    }
    putchar('\n');
  }

  return 0;
}

short myatos(char c){
  short s;
  char str[2];

  str[0]=c; str[1]=0;
  s=(short)atoi(str);

  return s;
}

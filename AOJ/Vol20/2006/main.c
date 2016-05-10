#include <stdio.h>

int main(void){
  char table[10][6]={{'\0', '.', ',', '!', '?', ' '}, 
    {'\0', 'a', 'b', 'c', '\0', '\0'},
    {'\0', 'd', 'e', 'f', '\0', '\0'},
    {'\0', 'g', 'h', 'i', '\0', '\0'},
    {'\0', 'j', 'k', 'l', '\0', '\0'},
    {'\0', 'm', 'n', 'o', '\0', '\0'},
    {'\0', 'p', 'q', 'r', 's', '\0'},
    {'\0', 't', 'u', 'v', '\0', '\0'},
    {'\0', 'w', 'x', 'y', 'z', '\0'},
    {'\0', '0', '\0', '\0', '\0', '\0'}};
  int size[10]={5, 3, 3, 3, 3, 3, 4, 3, 4, 1}, sp[10], i, j, k, n, m;
  char c;

  scanf("%d", &n);
  c=getchar();
  for(i=0;i<n;i++){
    for(j=0;j<10;j++)
      sp[j]=0;
    for(;;){
      c=getchar();
      if(c=='\n')
        break;
      m=c-'0';
      if(m==0){
        for(j=0;j<10;j++){
          if(sp[j]!=0){
            if(sp[j]%size[j]==0)
              printf("%c", table[j][size[j]]);
            else{
              printf("%c", table[j][sp[j]%size[j]]);
            }
            for(k=0;k<10;k++)
              sp[k]=0;
          }
        }
      }
      else
        sp[m-1]++;
    }
    putchar('\n');
  }

  return 0;
}

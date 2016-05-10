#include <stdio.h>

int main(void){
  int a[5], i, j, temp;

  for(i=0;i<5;i++)
    scanf("%d", &a[i]);

  for(i=0;i<5;i++){
    for(j=0;j<4-i;j++)
      if(a[j]<a[j+1]){
        temp=a[j];
        a[j]=a[j+1];
        a[j+1]=temp;
      }
  }
  for(i=0;i<4;i++)
    printf("%d ", a[i]);
  printf("%d\n", a[i]);

  return 0;
}

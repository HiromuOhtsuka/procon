#include <stdio.h>

int main(void){
  int n, i, flag;

  scanf("%d", &n);
  flag = n - 1;
  for(i=2; i*i<=n; i++){
    if(n % i == 0){
      flag = 0;
      break;
    }
  }
  if(flag){
    printf("WANWAN\n");
  }
  else{
    printf("BOWWOW\n");
  }

  return 0;
}

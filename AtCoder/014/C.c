#include <stdio.h>
#define MAX 1000000
#define N_MAX 100000

int main(void){
  int n, a[N_MAX], b[N_MAX], count, max, i, j;

  scanf("%d", &n);
  for(i=0; i<n; i++){
    scanf("%d %d", &a[i], &b[i]);
  }

  max = i = 0;
  while(i <= MAX){
    count = 0;
    for(j=0; j<n; j++){
      if(a[j] <= i && i <= b[j]){
        count++;
      }
    }
    if(max < count){
      max = count;
    }
    i++;
  }

  printf("%d\n", max);

  return 0;
}

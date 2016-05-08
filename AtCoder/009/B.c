#include <stdio.h>

int main(void){
  int n, a[100], i, max, max2;

  scanf("%d", &n);
  for(i=0; i<n; i++){
    scanf("%d", &a[i]);
  }

  max = 0;
  for(i=0; i<n; i++){
    if(max < a[i]){
      max = a[i];
    }
  }
  max2 = 0;
  for(i=0; i<n; i++){
    if(a[i] != max && max2 < a[i]){
      max2 = a[i];
    }
  }

  printf("%d\n", max2);

  return 0;
}

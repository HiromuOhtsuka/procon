#include <stdio.h>

#define N_MAX 100+1

int main(void){
  int n, k, min, tmp, i, j, c;
  char s[N_MAX], t[N_MAX], o[N_MAX];

  scanf("%d %d %s", &n, &k, s);
  for(i=0; i<n+1; i++){
    t[i] = o[i] = s[i];
  }
  i = 0;
  while(i < n){
    min = i;
    j = i;
    while(j < n){
      if(t[min] > t[j]){
        min = j;
      }
      j++;
    }
    tmp = t[i];
    t[i] = t[min];
    t[min] = tmp;
    c = 0;
    for(j=0; j<n; j++){
      if(t[j] != o[j]){
        c++;
      }
    }
    if(c <= k){
      for(j=0; j<n; j++){
        s[j] = t[j];
      }
    }
    else{
      break;
    }
    i++;
  }
  printf("%s\n", s);

  return 0;
}

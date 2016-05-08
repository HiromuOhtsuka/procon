#include <stdio.h>

#define MAX_K 100+1

unsigned int Am(unsigned int a[], unsigned int c[], int k, int m){
  unsigned int am, w[MAX_K];
  int i, n, j, l;
  if(m <= k){
    return a[m];
  }
  else{
    for(i=1; i<=k; i++){
      w[i] = a[i];
    }
    n = m - k;
    for(i=1; i<=n; i++){
      am = c[1] & w[k+1-i];
      for(j=2; j<=k; j++){
        am ^= (c[j] & w[k+1-j]);
      }
      printf("am(%d) = %u\n", i, am);
      j = 2;
      while(j <= k){
        w[j-1] = w[j];
        j++;
      }
      w[k] = am;
    }
  }
  return am;
}

int main(void){
  unsigned int a[MAX_K], c[MAX_K];
  int k, m, i;

  scanf("%d %d", &k, &m);
  for(i=1; i<=k; i++){
    scanf("%u", &a[i]);
  }
  for(i=1; i<=k; i++){
    scanf("%u", &c[i]);
  }

  printf("%u\n", Am(a, c, k, m));

  return 0;
}

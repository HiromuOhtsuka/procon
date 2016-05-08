#include <stdio.h>
#define MAX 5

int n;
int k;
int s[MAX][MAX];
int t[MAX];
int flag;

void backtrack(int i){
  int l;
  if(i == n){
    int j, tmp;
    tmp = t[0];
    for(j=1; j<n; ++j){
      tmp ^= t[j];
    }
    if(tmp == 0){
      flag = 1;
    }
    return ;
  }
  for(l=0; l<k; ++l){
    t[i] = s[i][l];
    backtrack(i+1);
  }
}

int main(void){
  int i, j;

  scanf("%d %d", &n, &k);
  for(i=0; i<n; ++i){
    for(j=0; j<k; ++j){
      scanf("%d", &s[i][j]);
    }
  }
  backtrack(0);
  if(flag){
    printf("Found\n");
  }
  else{
    printf("Nothing\n");
  }

  return 0;
}



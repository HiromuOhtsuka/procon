#include <stdio.h>
#define MAX 1000 // 100000

int max = 0;
char table[MAX][MAX] = {0};

void search(int sp, int np, int n, int count){
  int i;

  for(i=0; i<n; i++){
    if(np != i && table[np][i] == 1){
      count++;
      table[np][i]++;
      table[i][np]++;
      search(sp, i, n, count);
      count--;
      table[np][i]--;
      table[i][np]--;
    }
  }
  if(sp == np){
    if(max < count){
      max = count;
    }
  }
}

int main(void){
  int n, x, y, q, a, b, i, j;

  scanf("%d", &n);
  for(i=0; i<n-1; i++){
    scanf("%d %d", &x, &y);
    table[y][x] = table[x][y] = 1;
  }
  scanf("%d", &q);
 
  for(i=0; i<q; i++){
    scanf("%d %d", &a, &b);
    table[a][b] = table[b][a] = 1;
  
    max = 0;
    for(j=0; j<n; j++){
      search(j, j, n+1, 0);
    }

    printf("%d\n", max);

    table[a][b] = table[b][a] = 0;
  }

  return 0;
}

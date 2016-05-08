#include <stdio.h>
#include <string.h>

#define MAX_STR 10
#define MAX_N 200

int ans[2];

struct unit{
  char large[MAX_STR + 1];
  int m;
  char small[MAX_STR + 1];
};

struct unit units[MAX_N];

void toMinUnit(int n, int s){
  int sum, i, j, flag;

  i = n;
  sum = 1;
  flag = 1;
  while(flag){
    sum *= units[i].m;
    flag = 0;
    for(j=0; j<s; ++j){
      if(strcmp(units[i].small, units[j].large) == 0){
        flag = 1;
        break;
      }
    }
    if(flag)
      i = j;
  }
  ans[0] = sum;
  ans[1] = i;
}

int main(void){
  int n, i, max;
  struct unit max_unit;

  scanf("%d", &n);
  for(i=0; i<n; ++i){
    scanf("%s %d %s", units[i].large, &units[i].m, units[i].small);
  }
  max = 0;
  for(i=0; i<n; ++i){
    toMinUnit(i, n);
    if(ans[0] > max){
      max_unit.m = ans[0];
      strcpy(max_unit.large, units[ans[1]].large);
      strcpy(max_unit.small, units[ans[1]].small);
      max = ans[0];
    }
  }

  printf("1%s = %d%s\n", max_unit.large, max_unit.m, max_unit.small);

  return 0;
}

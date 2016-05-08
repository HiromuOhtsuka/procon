#include <stdio.h>
#define MAX 3650

struct day{
  double max, min;
};

int main(void){
  struct day days[MAX];
  int count[6] = {0};
  int n, i;

  scanf("%d", &n);
  for(i=0; i<n; ++i){
    scanf("%lf %lf", &days[i].max, &days[i].min);
  }

  for(i=0; i<n; ++i){
    if(days[i].max >= 35.0){
      ++count[0];
    }
    if(days[i].max >= 30 && days[i].max <= 35){
      ++count[1];
    }
    if(days[i].max >= 25 && days[i].max <= 30){
      ++count[2];
    }
    if(days[i].min >= 25){
      ++count[3];
    }
    if(days[i].min < 0 && days[i].max >= 0){
      ++count[4];
    }
    if(days[i].max < 0){
      ++count[5];
    }
  }

  printf("%d %d %d %d %d %d\n", count[0], count[1], count[2], count[3], count[4], count[5]);

  return 0;
}

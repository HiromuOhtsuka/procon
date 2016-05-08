#include <cstdio>
using namespace std;

int main(){
  double max, min, tmp;

  scanf("%lf", &tmp);
  max = min = tmp;
  while(scanf("%lf", &tmp) != EOF){
    if(max < tmp){
      max = tmp;
    }
    if(min > tmp){
      min = tmp;
    }
  }

  printf("%.1lf\n", (max - min));

  return 0;
}

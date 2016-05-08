#include <cstdio>
using namespace std;

int main(){
  int m;
  scanf("%d", &m);
  for(int i = 0; i < m; i++){
    int money, year, typenum;
    scanf("%d %d %d", &money, &year, &typenum);
    int max_money = -1;
    for(int j = 0; j < typenum; j++){
      int type, cost;
      double yearrate;
      scanf("%d %lf %d", &type, &yearrate, &cost);
      if(type == 1){
        int a = money;
        double b;
        for(int k = 0; k < year; k++){
          b = (double)((int)(a * yearrate));
          a = a + b - cost;
        }
        if(max_money < a){
          max_money = a;
        }
      }
      else if(type == 0){
        int a = money;
        double b, c = 0;
        for(int k = 0; k < year; k++){
          b = (double)((int)(a * yearrate));
          c += b;
          a -= cost;
        }
        if(max_money < a + (int)c){
          max_money = a + (int)c;
        }
      }
    }
    printf("%d\n", max_money);
  }

  return 0;
}

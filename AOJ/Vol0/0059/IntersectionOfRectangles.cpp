#include <cstdio>
using namespace std;

int main(){
  double xa1, ya1, xa2, ya2, xb1, yb1, xb2, yb2;
  while(scanf("%lf %lf %lf %lf %lf %lf %lf %lf",
          &xa1, &ya1, &xa2, &ya2, &xb1, &yb1, &xb2, &yb2)
            != EOF){
    if(!(xb2 < xa1 || xa2 < xb1 || yb1 > ya2 || yb2 < ya1)){
      printf("YES\n");
    }
    else{
      printf("NO\n");
    }
  }

  return 0;
}


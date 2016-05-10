#include <cstdio>
#include <cmath>
using namespace std;

int main(){
  for(;;){
    int tate, yoko, takasa;
    scanf("%d %d %d", &tate, &yoko, &takasa);

    if(tate == 0 && yoko == 0 && takasa == 0){
      return 0;
    }

    int n;
    scanf("%d", &n);
    for(int i = 0; i < n; i++){
      int r;
      scanf("%d", &r);
      if(sqrt(tate * tate + yoko * yoko) < 2 * r ||
          sqrt(tate * tate + takasa * takasa) < 2 * r ||
          sqrt(yoko * yoko + takasa * takasa) < 2 * r){
        printf("OK\n");
      }
      else{
        printf("NA\n");
      }
    }
  }

  return 0;
}

#include <cstdio>
using namespace std;

int main(){
  while(true){
    int a, b, n;
    if(scanf("%d %d %d", &a, &b, &n) == EOF){
      break;
    }
    int sum = 0;
    for(int i = 1; i <= n; i++){
      sum += ((10 * a) / b) % 10;
      a = (10 * a) - (b * ((10 * a) / b));
    }
    printf("%d\n", sum);
  }

  return 0;
}

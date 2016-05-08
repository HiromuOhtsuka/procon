#include <cstdio>
using namespace std;

int main(){
  int n;
  scanf("%d", &n);

  int eulers = n;
  for(int i = 2; i * i <= n; i++){
    if(n % i == 0){
      eulers -= eulers / i;
      while(n % i == 0){
        n /= i;
      }
    }
  }
  if(n > 1){
    eulers -= eulers / n;
  }
  printf("%d\n", eulers);

  return 0;
}

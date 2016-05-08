#include <cstdio>
using namespace std;

int main(){
  for(;;){
    int sum;
    scanf("%d", &sum);

    if(sum == 0){
      return 0;
    }

    for(int i = 0; i < 9; i++){
      int n;
      scanf("%d", &n);
      sum -= n;
    }

    printf("%d\n", sum);
  }

  return 0;
}

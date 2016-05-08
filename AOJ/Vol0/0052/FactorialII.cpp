#include <cstdio>
using namespace std;

int main(){
  while(true){
    int n, count = 0, val;
    scanf("%d", &n);
    if(n == 0){
      return 0;
    }
    val = 1;
    while(n >= 5){
      if(n % 5 == 0){
        int tmp = n, c = 0;
        while(tmp % 5 == 0){
          tmp /= 5;
          ++c;
        }
        count += c;
      }
      --n;
    }
    printf("%d\n", count);
  }

  return 0;
}

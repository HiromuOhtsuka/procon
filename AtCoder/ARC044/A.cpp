#include <cstdio>
using namespace std;

int main(){
  int n;
  scanf("%d", &n);
  if(n == 1){
    printf("Not Prime\n");
    return 0;
  }
  bool is_prime = true;
  for(int i = 2; i * i <= n; i++){
    if(n % i == 0){
      is_prime = false; break;
    }
  }
  if(is_prime){
    printf("Prime\n");
    return 0;
  }
  if((n % 10) % 2 != 0 && (n % 10) != 5 &&
      n % 3 != 0){
    printf("Prime\n");
  }
  else{
    printf("Not Prime\n");
  }

  return 0;
}

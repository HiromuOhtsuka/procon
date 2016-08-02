#include <cstdio>
#define MAX_N 100000
using namespace std;

int n, l;
long long a[MAX_N];

int main(){
  scanf("%d %d", &n, &l);
  for(int i = 0; i < n; i++){
    scanf("%lld", &a[i]);
  }

  for(int i = 0; i < n - 1; i++){
    long long sum = a[i] + a[i + 1];
    if(sum >= l){
      printf("Possible\n");
      for(int j = 0; j < i; j++){
        printf("%d\n", j + 1);
      }
      for(int j = n - 2; j >= i; j--){
        printf("%d\n", j + 1);
      }
      return 0;
    }
  }

  printf("Impossible\n");

  return 0;
}

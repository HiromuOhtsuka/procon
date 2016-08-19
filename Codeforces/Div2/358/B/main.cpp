#include <cstdio>
#include <algorithm>
#define MAX_N 100000
using namespace std;

int n;
int a[MAX_N];

int main(){
  scanf("%d", &n);
  for(int i = 0; i < n; i++){
    scanf("%d", &a[i]);
  }

  sort(a, a + n);
  int p = 1;
  for(int i = 0; i < n; i++){
    if(a[i] >= p){
      ++p;
    }
  }

  printf("%d\n", p);

  return 0;
}

#include <cstdio>
#include <algorithm>
#define MAX_N 100000
using namespace std;

int n;
pair< int, int > a[MAX_N];

int main(){
  scanf("%d", &n);
  for(int i = 0; i < n; i++){
    scanf("%d", &a[i].first);
    a[i].second = i;
  }

  sort(a, a + n);

  for(int i = n - 1; i >= 0; i--){
    printf("%d\n", a[i].second + 1);
  }

  return 0;
}

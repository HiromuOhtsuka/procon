#include <cstdio>
#include <algorithm>
#define MAX_N 200000
using namespace std;

int n, q;
int a[MAX_N], b[MAX_N];

int main(){
  scanf("%d %d", &n, &q);
  for(int i = 0; i < q; i++){
    int l, r;
    scanf("%d %d", &l, &r);
    ++a[l - 1]; --b[r - 1];
  }

  int c = 0;
  int ans[n];
  for(int i = 0; i < n; i++){
    ans[i] = 0;
    c += a[i];
    if(c > 0 && c % 2 == 1){
      ans[i] = 1;
    }
    c += b[i];
  }

  for(int i = 0; i < n; i++){
    printf("%d", ans[i]);
  }
  putchar('\n');

  return 0;
}

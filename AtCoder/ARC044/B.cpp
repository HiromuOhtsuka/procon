#include <cstdio>
#include <algorithm>
#define MAX_N 100000
#define MOD (1000000000 + 7)
using namespace std;

static int N, ans;
static pair< int, int > dist[MAX_N];
static void search(){
  if(dist[0].first != 0){
    return;
  }
  int d = 0, count = 1, m = 1;
  for(int i = 1; i < N; i++){
    if(dist[i].first != d + 1){
      ans = 0;
      return;
    }
    int n = 0;
    for(int j = i; j < N && dist[j].first == d + 1; j++){
      ++n;
    }
    i += n - 1;
    int tmp1 = 1;
    for(int j = 0; j < m * n; j++){
      tmp1 = (tmp1 * 2) % MOD;
    }
    //tmp1 = ((tmp1 - 1) * n) % MOD;
    m = n;
    int tmp2 = 1;
    for(int j = 0; j < n - 1; j++){
      tmp2 = (tmp2 * 2) % MOD;
    }
    count = (((tmp1 * tmp2) % MOD) * count) % MOD;
    ++d;
  }
  ans = count;
}

int main(){
  scanf("%d", &N);
  for(int i = 0; i < N; i++){
    int d;
    scanf("%d", &d);
    dist[i] = pair< int, int >(d, i);
  }
  sort(dist, dist + N);
  search();
  printf("%d\n", ans % MOD);

  return 0;
}

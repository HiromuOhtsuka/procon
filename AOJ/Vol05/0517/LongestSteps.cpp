#include <cstdio>
#define MAX_N 100000
using namespace std;

static int N, K;
static bool IS[MAX_N + 1];
static void init(){
  for(int i = 0; i < N; i++){
    IS[i] = false;
  }
}
static int max_len;
static void search(){
  int ml = -1;
  for(int i = 1; i <= N; i++){
    if(!IS[i]){
      continue;
    }
    int count = 0;
    while(i + count <= N && IS[i + count]){
      ++count;
    }
    if(count > ml){
      ml = count;
    }
  }
  if(!IS[0]){
    max_len = ml;
    return;
  }
  for(int i = 1; i <= N; i++){
    if(IS[i]){
      continue;
    }
    if(IS[i - 1] || IS[i + 1]){
      IS[i] = true;
      int count = 0, tmp = 0;
      while(i - tmp - 1 >= 0 && IS[i - tmp - 1]){
        ++tmp;
      }
      count += tmp;
      tmp = 0;
      while(i + tmp <= N && IS[i + tmp]){
        ++tmp;
      }
      count += tmp;
      if(count > ml){
        ml = count;
      }
      IS[i] = false;
    }
  }
  max_len = ml;
}

int main(){
  while(true){
    scanf("%d %d", &N, &K);
    if(N == 0 && K == 0){
      return 0;
    }
    for(int i = 0; i < K; i++){
      int n;
      scanf("%d", &n);
      IS[n] = true;
    }
    search();
    printf("%d\n", max_len);
    init();
  }
  return 0;
}

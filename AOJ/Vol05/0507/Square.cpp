#include <cstdio>
#define MAX_N 10000
using namespace std;

static int N;
static int t[MAX_N];

static void search(int i, int k, int s){
  if(s == N){
    for(int j = 0; j < k; j++){
      printf("%d%c", t[j], j ==  k - 1 ? '\n' : ' ');
    }
    return;
  }
  if(s > N || i <= 0 || k > N){
    return;
  }
  for(int j = N; j >= 0; j--){
    for(int l = 0; l < j; l++){
      t[k + l] = i;
    }
    search(i - 1, k + j, s + j * i);
  }
}

int main(){
  while(true){
    scanf("%d", &N);
    if(N == 0){
      return 0;
    }
    search(N, 0, 0);
  }

  return 0;
}

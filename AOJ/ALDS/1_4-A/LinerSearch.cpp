#include <cstdio>
#define MAX_N 10000
using namespace std;

static int N, Q, data[MAX_N];
static int C;
static bool liner_search(int tar){
  int count = 0;
  for(int i = 0; i < N; i++){
    if(data[i] == tar){
      return true;
    }
  }
  return false;
}

int main(){
  scanf("%d", &N);
  for(int i = 0; i < N; i++){
    scanf("%d", &data[i]);
  }
  scanf("%d", &Q);
  for(int i = 0; i < Q; i++){
    int d;
    scanf("%d", &d);
    if(liner_search(d)){
      ++C;
    }
  }
  printf("%d\n", C);
  return 0;
}

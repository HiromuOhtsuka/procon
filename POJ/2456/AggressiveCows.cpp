#include <cstdio>
#include <algorithm>
#define MAX_N 100000
#define MAX_X 1000000000
using namespace std;

static int N, C, X[MAX_N];
static int best;
static bool separatable(int d);
static void search();

int main(){
  scanf("%d %d", &N, &C);
  for(int i = 0; i < N; i++){
    scanf("%d", &X[i]);
  }

  search();
  
  printf("%d\n", best);

  return 0;
}

static bool separatable(int d){
  int count = 1, x = X[0], next = 1;
  for(int i = 1; i < C; i++){
    int j;
    for(j = next; j < N; j++){
      if(x + d <= X[j]){
        x = X[j];
        ++count;
        next = j + 1;
        break;
      }
    }
    if(j == N){
      return false;
    }
  }
  return count == C;
}

static void search(){
  sort(X, X + N);
  int low = 0, high = MAX_X;
  for(int i = 0; i < 30; i++){
    int mid = (low + high) / 2;
    if(separatable(mid)){
      low = mid;
    }
    else{
      high = mid;
    }
  }
  best = high - 1;
}

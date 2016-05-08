#include <cstdio>
#include <algorithm>
#define MAX_N 50000
#define MAX_L 1000000000
using namespace std;

static int L, N, M, D[MAX_N + 2];
static int best;
static bool removable(const int d);
static void search();

int main(){
  scanf("%d %d %d", &L, &N, &M);
  D[0] = 0;
  for(int i = 1; i <= N; i++){
    scanf("%d", &D[i]);
  }
  D[N + 1] = L;

  search();

  printf("%d\n", best);

  return 0;
}

static bool removable(const int d){
  int count = 0;
  for(int i = 0; i < N - 1 + 2; i++){
    if(D[i + 1] - D[i] < d){
      int j;
      for(j = i + 1; j < N + 2; j++){
        if(D[j] - D[i] >= d){
          break;
        }
      }
      if(D[j] - D[i] >= d){
        count += (j - i) - 1;
        i = j - 1;
      }
      else{
        return false;
      }
    }
  }
  return count <= M;
}

static void search(){
  sort(D, D + N + 2);
  int low = 0, high = MAX_L;

  for(int i = 0; i < 30; i++){
    int mid = (low + high) / 2;
    if(removable(mid)){
      low = mid;
    }
    else{
      high = mid;
    }
  }

  best = high - 1;
}

#include <cstdio>
#include <cmath>
#define MAX_N 10000
#define INF 100000
using namespace std;

static int N, K;
static double L[MAX_N], best;
static bool cutable(double d);
static void search();

int main(){
  scanf("%d %d", &N, &K);
  for(int i = 0; i < N; i++){
    scanf("%lf", &L[i]);
  }

  search();

  printf("%.2f\n", floor(best * 100) / 100);

  return 0;
}

static bool cutable(double d){
  int sum = 0;
  for(int i = 0; i < N; i++){
    sum += (int)(L[i] / d);
  }
  return sum >= K;
}

static void search(){
  double low = 0, high = INF;

  for(int i = 0; i < 100; i++){
    double mid = (low + high) / 2;
    if(cutable(mid)){
      low = mid;
    }
    else{
      high = mid;
    }
  }

  best = high;
}

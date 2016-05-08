#include <cstdio>
#include <cstring>
#define MAX_N 5000
using namespace std;

static int N;
static const int F = 0, B = 1;
static int DIRECT[MAX_N];
static int is_reverse[MAX_N];

static int cal(int k);

int main(){
  scanf("%d", &N);
  for(int i = 0; i < N; i++){
    char str[2];
    scanf("%s", str);
    switch(str[0]){
      case 'F' : DIRECT[i] = F; break;
      case 'B' : DIRECT[i] = B; break;
    }
  }

  int min_m = N, k = 1;
  for(int i = 1; i <= N; i++){
    int m = cal(i);
    if(m != -1 && m < min_m){
      min_m = m;
      k = i;
    }
  }

  printf("%d %d\n", k, min_m);

  return 0;
}

static int cal(int k){
  memset(is_reverse, 0, sizeof(is_reverse));
  int count = 0, sum = 0;
  for(int i = 0; i <= N - k; i++){
    if(((sum + DIRECT[i]) % 2) == B){
      is_reverse[i] = 1;
      count++;
    }
    sum += is_reverse[i];
    if(i - k + 1 >= 0){
      sum -= is_reverse[i - k + 1];
    }
  }

  for(int i = N - k + 1; i < N; i++){
    if(((sum + DIRECT[i]) % 2) == B){
      return -1;
    }
    if(i - k + 1 >= 0){
      sum -= is_reverse[i - k + 1];
    }
  }

  return count;
}

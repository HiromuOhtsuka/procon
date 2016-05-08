#include <cstdio>
#include <algorithm>
#define MAX_N 100000
using namespace std;

static int N, Q, data[MAX_N];
static int C;
static bool binary_search(int tar){
  int left = 0, right = N;
  while(right - left > 1){
    int mid = (left + right) / 2;
    if(data[mid] <= tar){
      left = mid;
    }
    else{
      right = mid;
    }
  }
  return data[left] == tar;
}

int main(){
  scanf("%d", &N);
  for(int i = 0; i < N; i++){
    scanf("%d", &data[i]);
  }
  sort(data, data + N);
  scanf("%d", &Q);
  for(int i = 0; i < Q; i++){
    int d;
    scanf("%d", &d);
    if(binary_search(d)){
      ++C;
    }
  }
  printf("%d\n", C);
  return 0;
}

#include <cstdio>
#include <climits>
using namespace std;

static const int merry[8] = {1, 2, 1, 2, 1, 4, 1, 4};

int main(){
  int ans[8], p[8], min_n;
  while(scanf("%d %d %d %d %d %d %d %d",
        &p[0], &p[1], &p[2], &p[3],
        &p[4], &p[5], &p[6], &p[7]) != EOF){
    int tmp[8];
    min_n = INT_MAX;
    for(int i = 0; i < 8; i++){
      int sum = 0;
      for(int j = 0; j < 8; j++){
        tmp[j] = merry[(i + j) % 8];
        int n = p[j] - merry[(i + j) % 8];
        if(n > 0){
          sum += n;
        }
      }
      if(sum < min_n){
        min_n = sum;
        for(int j = 0; j < 8; j++){
          ans[j] = tmp[j];
        }
      }
      else if(sum == min_n){
        int v1 = 0, v2 = 0;
        for(int j = 0; j < 8; j++){
          v1 = 10 * v1 + ans[j];
          v2 = 10 * v2 + tmp[j];
        }
        if(v2 < v1){
          min_n = sum;
          for(int j = 0; j < 8; j++){
            ans[j] = tmp[j];
          }
        }
      }
    }

    for(int i = 0; i < 8; i++){
      printf("%d%c", ans[i], (i == 7) ? '\n' : ' ');
    }
  }

  return 0;
}

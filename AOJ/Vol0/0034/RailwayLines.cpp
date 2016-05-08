#include <cstdio>
#define MAX_N 10
using namespace std;

int main(){
  int data[MAX_N], v1, v2;
  while(true){
    if(scanf("%d,", &data[0]) == EOF){
      break;
    }
    for(int i = 1; i < MAX_N; i++){
      int l;
      scanf("%d,", &l);
      data[i] = data[i - 1] + l;
    }
    scanf("%d,%d", &v1, &v2);
    int ans = -1, sum = data[MAX_N - 1];
    for(int i = 0; i < MAX_N; i++){
      if(v1 * sum <= (v1 + v2) * data[i]){
        ans = i + 1;
        break;
      }
    }
    printf("%d\n", ans);
  }

  return 0;
}

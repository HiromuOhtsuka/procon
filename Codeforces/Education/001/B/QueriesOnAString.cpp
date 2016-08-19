#include <cstdio>
#define MAX_LEN 10000
using namespace std;

char str[MAX_LEN + 1];
int M;
char tmp[MAX_LEN + 1];

int main(){
  scanf("%s", str);
  scanf("%d", &M);
  for(int t = 0; t < M; t++){
    int l, r, k;
    scanf("%d %d %d", &l, &r, &k);
    int s_len = (r - l + 1);
    k = k % s_len;
    --l, --r;
    for(int i = s_len - 1; i >= 0; i--){
      int d = (i - k);
      if(d < 0){
        tmp[i] = str[l + d + s_len];
      }
      else{
        tmp[i] = str[l + d];
      }
    }
    for(int i = l; i <= r; i++){
      str[i] = tmp[i - l];
    }
  }
  printf("%s\n", str);

  return 0;
}

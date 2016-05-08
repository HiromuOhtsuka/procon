#include <cstdio>
#include <cstring>
#define MAX_LEN 10
using namespace std;

static int N;
static char tar[MAX_LEN + 1], ring[MAX_LEN + 1];

int main(){
  scanf("%s %d", tar, &N);

  int count = 0, t_len = strlen(tar);
  for(int i = 0; i < N; i++){
    scanf("%s", ring);
    int r_len = strlen(ring);
    for(int j = 0; j < r_len; j++){
      bool flag = true;
      for(int k = 0; k < t_len; k++){
        if(tar[k] != ring[(j + k) % r_len]){
          flag = false;
          break;
        }
      }
      if(flag){
        ++count;
        break;
      }
    }
  }

  printf("%d\n", count);

  return 0;
}

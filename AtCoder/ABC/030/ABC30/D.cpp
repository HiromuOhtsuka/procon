#include <cstdio>
#include <cstring>
#define MAX_N 100000
#define MAX_K 100000
using namespace std;

static int N, a, b[MAX_N];
static char k[MAX_K + 1];
static int mem[MAX_N + 1], sp;
static int find(int tar){
  for(int i = 0; i < N; i++){
    if(mem[i] == tar){
      return i;
    }
  }
  return -1;
}

int main(){
  scanf("%d %d %s", &N, &a, k);
  for(int i = 0; i < N; i++){
    scanf("%d", &b[i]);
  }

  mem[sp++] = a;
  int T = 0, i = a, begin;
  while(true){
    i = b[i - 1];
    ++T;
    begin = find(i);
    if(begin != -1){
      T = T - begin;
      break;
    }
    mem[sp++] = i;
  }


  int t_k = 0;
  int len = strlen(k);
  for(int i = 0; i < len; i++){
    t_k = (t_k * 10 + k[i] - '0') % T;
  }

  printf("%d\n", mem[t_k + begin - 1]);

  return 0;
}

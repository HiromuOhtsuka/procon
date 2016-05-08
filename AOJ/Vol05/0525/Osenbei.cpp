#include <cstdio>
#define MAX_C 10000
using namespace std;

static int R, C, table[MAX_C];
static void init_table(){
  for(int i = 0; i < MAX_C; i++){
    table[i] = 0;
  }
}
static int bit_count(unsigned int n){
  int count = 0;
  while(n > 0){
    n -= n & -n;
    ++count;
  }
  return count;
}

int main(){
  while(true){
    scanf("%d %d", &R, &C);
    if(R == 0 && C == 0){
      return 0;
    }
    for(int i = 0; i < R; i++){
      for(int j = 0; j < C; j++){
        int n;
        scanf("%d", &n);
        table[j] |= (n << i);
      }
    }

    int max_s = -1;
    for(int i = 0; i < (1 << R); i++){
      int sum = 0;
      for(int j = 0; j < C; j++){
        int count = bit_count(i ^ table[j]);
        sum += count > (R - count) ? count : (R - count);
      }
      if(sum > max_s){
        max_s = sum;
      }
    }

    printf("%d\n", max_s);

    init_table();
  }

  return 0;
}



#include <cstdio>
#define MAX_KETA 9
using namespace std;

static int N, keta, ans;
static int t[MAX_KETA];
static void search(int i, int s){
  if(i == keta){
    int n = 0, count = 0;
    for(int j = 0; j < keta; j++){
      if(t[j] == 1){
        ++count;
      }
      n = n * 10 + t[j];
    }

    if(n <= N){
      ans += count;
    }

    return;
  }

  for(t[i] = 0; t[i] < 10; t[i]++){
    search(i + 1, s + t[i] * pow(10, i));
  }

}

int main(){
  scanf("%d", &N);
  for(int base = 1; base <=  N; base *= 10){
    ++keta;
  }

  search(0);

  printf("%d\n", ans);

  return 0;
}

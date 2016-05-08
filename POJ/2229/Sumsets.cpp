#include <cstdio>
using namespace std;

static int S;
static int ans;
static void search(int i, int k, int s){
  if(s == S){
    ++ans;
    return;
  }
  if(k > S || i > S || s > S){
    return;
  }
  for(int j = 0; j <= S; j++){
    search(2 * i, j, s + i * j);
  }
}

int main(){
  scanf("%d", &S);
  search(1, 0, 0);
  printf("%d\n", ans);
  return 0;
}

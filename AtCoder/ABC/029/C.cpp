#include <cstdio>
#define MAX_N 8
using namespace std;

static int N;
static char t[MAX_N];
static void search(int i, int k){
  if(i > N || k > N){
    return;
  }
  if(k == N){
    for(int j = 0; j < k; j++){
      putchar(t[j]);
    }
    putchar('\n');
    return;
  }
  t[i] = 'a';
  search(i + 1, k + 1);
  t[i] = 'b';
  search(i + 1, k + 1);
  t[i] = 'c';
  search(i + 1, k + 1);
}

int main(){
  scanf("%d", &N);
  search(0, 0);

  return 0;
}

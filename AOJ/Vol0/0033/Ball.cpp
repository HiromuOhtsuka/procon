#include <cstdio>
#define MAX_N 10
using namespace std;

static int N, DATA[MAX_N];
static int s1[MAX_N], s2[MAX_N];
static int sp1, sp2;
static bool is;

static void back_track(int i){
  if(i == MAX_N){
    bool order = true;
    for(int j = 0; j < sp1 - 1; j++){
      if(!(s1[j] <= s1[j + 1])){
        order = false;
        break;
      }
    }
    for(int j = 0; j < sp2 - 1; j++){
      if(!(s2[j] <= s2[j + 1])){
        order = false;
        break;
      }
    }
    if(order){
      is = true;
    }
    return;
  }
  s1[sp1++] = DATA[i];
  back_track(i + 1);
  --sp1;
  s2[sp2++] = DATA[i];
  back_track(i + 1);
  --sp2;
}

int main(){
  scanf("%d", &N);
  for(int i = 0; i < N; i++){
    for(int j = 0; j < MAX_N; j++){
      scanf("%d", &DATA[j]);
    }
    is = false;
    sp1 = sp2 = 0;
    back_track(0);
    if(is){
      printf("YES\n");
    }
    else{
      printf("NO\n");
    }
  }
  return 0;
}

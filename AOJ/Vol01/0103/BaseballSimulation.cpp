#include <cstdio>
#include <cstring>
#define STREQ(s1, s2) !strcmp(s1, s2)
using namespace std;

static int N;
static int score, out;
static bool rui[3];

int main(){
  scanf("%d", &N);
  for(int i = 0; i < N; i++){
    score = out = 0;
    rui[0] = rui[1] = rui[2] = false;
    char str[16];
    while(out < 3){
      scanf("%s", str);
      if(STREQ(str, "HIT")){
        if(rui[2]){
          ++score;
        }
        bool tmp = rui[1];
        rui[1] = rui[0];
        rui[2] = tmp;
        rui[0] = true;
      }
      else if(STREQ(str, "HOMERUN")){
        int count = 0;
        if(rui[0]){
          ++count;
        }
        if(rui[1]){
          ++count;
        }
        if(rui[2]){
          ++count;
        }
        score += count + 1;
        rui[0] = rui[1] = rui[2] = false;
      }
      else if(STREQ(str, "OUT")){
        ++out;
      }
    }
    printf("%d\n", score);
  }

  return 0;
}

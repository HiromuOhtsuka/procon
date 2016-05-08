#include <cstdio>
using namespace std;

int main(){
  int s = 0, t = 0;
  for(int i = 0; i < 4; i++){
    int score;
    scanf("%d", &score);
    s += score;
  }
  for(int i = 0; i < 4; i++){
    int score;
    scanf("%d", &score);
    t += score;
  }

  printf("%d\n", (s > t) ? s : t);

  return 0;
}

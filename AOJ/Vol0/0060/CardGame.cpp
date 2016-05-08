#include <cstdio>
using namespace std;

int main(){
  int c1, c2, c3;

  while(scanf("%d %d %d", &c1, &c2, &c3) != EOF){
    int count = 20 - (c1 + c2);
    if(count > 10){
      printf("YES\n");
      continue;
    }
    int sub = 0;
    if(c1 <= count){
      sub++;
    }
    if(c2 <= count){
      sub++;
    }
    if(c3 <= count){
      sub++;
    }
    count -= sub;
    if(2 * count - 1 >= 6){
      printf("YES\n");
    }
    else{
      printf("NO\n");
    }
  }

  return 0;
}

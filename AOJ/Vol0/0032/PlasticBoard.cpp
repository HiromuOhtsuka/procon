#include <cstdio>
using namespace std;

int main(){
  int rect = 0, thombus = 0;
  int a, b, c;
  while(scanf("%d,%d,%d", &a, &b, &c) != EOF){
    if(a * a + b * b == c * c){
      ++rect;
    }
    else if(a == b){
      ++thombus;
    }
  }

  printf("%d\n%d\n", rect, thombus);

  return 0;
}

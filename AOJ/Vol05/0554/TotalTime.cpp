#include <cstdio>
using namespace std;

static int t1, t2, t3, t4;

int main(){
  scanf("%d %d %d %d", &t1, &t2, &t3, &t4);

  int sum = t1 + t2 + t3 + t4;
  int x = sum / 60, y = sum % 60;

  printf("%d\n%d\n", x, y);

  return 0;
}

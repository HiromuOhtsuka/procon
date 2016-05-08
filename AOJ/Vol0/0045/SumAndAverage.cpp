#include <cstdio>
using namespace std;

int main(){
  int sum, p, n, count, m;
  double ave;

  sum = count = m = 0;
  while(scanf("%d,%d", &p, &n) != EOF){
    sum += p * n;
    m += n;
    ++count;
  }

  ave = (double)m / count;
  ave = (int)(ave + ((ave - (int)ave) >= 0.5));

  printf("%d\n%.lf\n", sum, ave);

  return 0;
}

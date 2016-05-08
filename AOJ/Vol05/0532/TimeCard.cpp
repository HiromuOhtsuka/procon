#include <cstdio>
using namespace std;

int main(){
  for(int i = 0; i < 3; i++){
    int h, m, s;
    scanf("%d %d %d", &h, &m, &s);
    long start = 3600 * h + 60 * m + s;
    scanf("%d %d %d", &h, &m, &s);
    long end = 3600 * h + 60 * m + s;
    long diff = end - start;
    h = diff / 3600;
    m = (diff % 3600) / 60;
    s = diff % 60;
    printf("%d %d %d\n", h, m, s);
  }

  return 0;
}

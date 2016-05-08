#include <cstdio>
using namespace std;

int main(){
  while(true){
    int h, m, s;
    scanf("%d %d %d", &h, &m, &s);

    if(s == -1 && m == -1 && s == -1){
      return 0;
    }

    long count = (3600 * 2) - (3600 * h + 60 * m + s);
    h = count / 3600;
    m = (count % 3600) / 60;
    s = (count % 60);
    printf("%.2d:%.2d:%.2d\n", h, m, s);

    count *= 3;
    h = count / 3600;
    m = (count % 3600) / 60;
    s = (count % 60);
    printf("%.2d:%.2d:%.2d\n", h, m, s);
  }

  return 0;
}

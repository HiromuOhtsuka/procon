#include <cstdio>
#define MAX_M 200
#define MAX_N 1000
using namespace std;

class Point {
  public :
    int x, y;
    Point(int x, int y){
      this->x = x;
      this->y = y;
    }
    Point(){}
    bool operator==(const Point& p) const{
      return this->x == p.x && this->y == p.y;
    }
};

static int M, N;
static Point PM[MAX_M], PN[MAX_N];

int main(){
  while(true){
    scanf("%d", &M);
    if(M == 0){
      return 0;
    }
    int ox, oy;
    scanf("%d %d", &ox, &oy);
    for(int i = 1; i < M; i++){
      int x, y;
      scanf("%d %d", &x, &y);
      PM[i].x = x - ox;
      PM[i].y = y - oy;
    }
    PM[0].x = PM[0].y = 0;
    scanf("%d", &N);
    for(int i = 0; i < N; i++){
      int x, y;
      scanf("%d %d", &x, &y);
      PN[i] = Point(x, y);
    }

    for(int i = 0; i < N; i++){
      bool flag = true;
      int dx = PN[i].x, dy = PN[i].y;
      for(int j = 0; j < M; j++){
        bool is = false;
        Point target (PM[j].x + dx, PM[j].y + dy);
        for(int k = 0; k < N; k++){
          if(target == PN[k]){
            is = true;
            break;
          }
        }
        if(!is){
          flag = false;
          break;
        }
      }
      if(flag){
        printf("%d %d\n", -ox + dx, -oy + dy);
        break;
      }
    }
  }

  return 0;
}


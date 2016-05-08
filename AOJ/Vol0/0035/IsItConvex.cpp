#include <cstdio>
using namespace std;

struct Point {
  double x, y;
  Point(double xx, double yy){
    x = xx; y = yy;
  }
};

static bool is_convex(const Point ps[], int n){
  bool is_all_left = true, is_all_right = true;
  for(int i = 0; i < n; i++){
    const Point p1 (ps[(i + 1) % n].x - ps[i].x, ps[(i + 1) % n].y - ps[i].y);
    const Point p2 (ps[(i + 2) % n].x - ps[i].x, ps[(i + 2) % n].y - ps[i].y);
    const double outpro = p1.x * p2.y - p1.y * p2.x;
    if(outpro < 0.0){
      is_all_left =  false;
    }
    else{
      is_all_right = false;
    }
  }
  return is_all_left || is_all_right;
}

int main(){
  double xa, ya, xb, yb, xc, yc, xd, yd;
  while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf", 
        &xa, &ya, &xb, &yb, &xc, &yc, &xd, &yd) != EOF){
    const Point ps[] = {Point(xa, ya), Point(xb, yb), Point(xc, yc), Point(xd, yd)};
    if(is_convex(ps, 4)){
      printf("YES\n");
    }
    else{
      printf("NO\n");
    }
  }
  return 0;
}

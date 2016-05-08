#include <iostream>
#include <cmath>
#include <cstdio>
#include <map>
#define MAX_N 6
using namespace std;

class Point {
  public :
    double x, y;

    Point(double x, double y){
      this->x = x;
      this->y = y;
    }
};

int N;

void koch(int n, Point p1, Point p2){
  if(n == 0){
    return;
  }
  Point s = Point((2 * p1.x + 1 * p2.x) / 3, (2 * p1.y + 1 * p2.y) / 3),
        t = Point((1 * p1.x + 2 * p2.x) / 3, (1 * p1.y + 2 * p2.y) / 3),
        u = Point((t.x - s.x) / 2 - (t.y - s.y) * sqrt(3) / 2 + s.x,
                  (t.x - s.x) * sqrt(3) / 2 + (t.y - s.y) / 2 + s.y);
  koch(n - 1, p1, s);
  printf("%.8lf %.8lf\n", s.x, s.y);
  koch(n - 1, s, u);
  printf("%.8lf %.8lf\n", u.x, u.y);
  koch(n - 1, u, t);
  printf("%.8lf %.8lf\n", t.x, t.y);
  koch(n - 1, t, p2);
}

int main(){
  cin >> N;
  printf("%.8lf %.8lf\n", 0.0, 0.0);
  koch(N, Point(0, 0), Point(100, 0));
  printf("%.8lf %.8lf\n", 100.0, 0.0);

  return 0;
}

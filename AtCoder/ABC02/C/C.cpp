#include <iostream>
#include <cstdio>
#include <cmath>
using namespace std;

class Point {
  public:
    double x, y;

    Point(){}
    Point(double x, double y){
      this->x = x;
      this->y = y;
    }

    Point operator-(const Point &p) const{
      return Point(x - p.x, y - p.y);
    }

    static double cross(const Point &p1, const Point &p2, const Point &p3){
      Point l1 = p2 - p1, l2 = p3 - p1;
      return l1.x * l2.y - l1.y * l2.x;
    }
};

Point a, b, c;

int main(){
  cin >> a.x >> a.y >> b.x >> b.y >> c.x >> c.y;
  double s = abs(Point::cross(a, b, c)) / 2.0;
  printf("%.1lf\n", s);
  return 0;
}

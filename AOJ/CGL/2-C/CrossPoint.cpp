#include <iostream>
#include <cstdio>
#include <cmath>
#define EPS (1e-10)
#define EQR(a, b) (fabs((a) - (b)) < EPS)
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
      return Point(this->x - p.x, this->y - p.y);
    }

    Point operator+(const Point &p) const{
      return Point(this->x + p.x, this->y + p.y);
    }

    Point operator*(double t) const{
      return Point(this->x * t, this->y * t);
    }

    static double cross(const Point &p1, const Point &p2){
      return p1.x * p2.y - p1.y * p2.x;
    }

};

Point cross_point(const Point &p0, const Point &p1,
    const Point &p2, const Point &p3){
    Point b = (p3 - p2);
    double d1 = fabs(Point::cross(b, (p0 - p2))),
           d2 = fabs(Point::cross(b, (p1 - p2)));
    double t = d1 / (d1 + d2);
    return p0 + (p1 - p0) * t;
}

int Q;

int main(){
  cin >> Q;

  for(int i = 0; i < Q; i++){
    Point p0, p1, p2, p3;
    cin >> p0.x >> p0.y >> p1.x >> p1.y >> p2.x >> p2.y >> p3.x >> p3.y;
    Point x = cross_point(p0, p1, p2, p3);
    printf("%.10lf %.10lf\n", 
        EQR(x.x, 0.0) ? fabs(x.x) : x.x, EQR(x.y, 0.0) ? fabs(x.y) : x.y);
  }

  return 0;
}

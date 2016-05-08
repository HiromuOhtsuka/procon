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

  Point operator+(const Point &p) const{
    return Point(this->x + p.x, this->y + p.y);
  }

  Point operator-(const Point &p) const{
    return Point(this->x - p.x, this->y - p.y);
  }

  Point operator*(double k) const{
    return Point(this->x * k, this->y * k);
  }

  double norm2() const{
    return this->x * this->x + this->y * this->y;
  }

  static double dot(const Point &p1, const Point &p2){
    return p1.x * p2.x + p1.y * p2.y;
  }

};

Point projection(const Point &p1, const Point &p2, const Point &p){
  return p1 + (p2 - p1) * (Point::dot((p - p1), (p2 - p1)) / (p2 - p1).norm2());
}

Point reflection(const Point &p1, const Point &p2, const Point &p){
  return (projection(p1, p2, p) - p) * 2 + p;
}

int Q;
Point p1, p2;

int main(){
  double x1, y1, x2, y2;
  cin >> x1 >> y1 >> x2 >> y2;
  p1 = Point(x1, y1); p2 = Point(x2, y2);
  cin >> Q;

  for(int i = 0; i < Q; i++){
    double x_i, y_i;
    cin >> x_i >> y_i;
    Point p (x_i, y_i);
    Point ref = reflection(p1, p2, p);
    printf("%.10lf %.10lf\n", 
      EQR(ref.x, 0.0) ? fabs(ref.x) : ref.x,
      EQR(ref.y, 0.0) ? fabs(ref.y) : ref.y);
  }

  return 0;
}

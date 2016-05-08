#include <iostream>
#include <cstdio>
#include <cmath>
#include <algorithm>
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

    double norm() const{
      return sqrt(this->x * this->x + this->y * this->y);
    }

    double norm2() const{
      return this->x * this->x + this->y * this->y;
    }

    static double cross(const Point &p1, const Point &p2){
      return p1.x * p2.y - p1.y * p2.x;
    }

    static double dot(const Point &p1, const Point &p2){
      return p1.x * p2.x + p1.y * p2.y;
    }

};

#define COUNTER_CLOCKWISE (1)
#define CLOCK_WISE (-1)
#define ONLINE_BACK (2)
#define ONLINE_FRONT (-2)
#define ON_SEGMENT (0)
double ccw(const Point &p1, const Point &p2, const Point &p3){
  Point l1 = (p2 - p1), l2 = (p3 - p1);
  double val = Point::cross(l1, l2);
  if(val > EPS){
    return COUNTER_CLOCKWISE;
  }
  if(val < -EPS){
    return CLOCK_WISE;
  }
  if(Point::dot(l1, l2) < -EPS){
    return ONLINE_BACK;
  }
  if(l1.norm2() < l2.norm2()){
    return ONLINE_FRONT;
  }
  return ON_SEGMENT;
}

bool crossed(const Point &p1, const Point &p2,
  const Point &p3, const Point &p4){
  return (ccw(p1, p2, p3) * ccw(p1, p2, p4) <= 0.0 &&
          ccw(p3, p4, p1) * ccw(p3, p4, p2) <= 0.0);
}

double distp2l(const Point &p1, const Point &p2, const Point &p){
  return fabs(Point::cross((p2 - p1), (p - p1)) / (p2 - p1).norm());
}

double distp2seg(const Point &p1, const Point &p2, const Point &p){
  if(Point::dot((p2 - p1), (p - p1)) < 0.0){
    return fabs((p - p1).norm());
  }
  if(Point::dot((p1 - p2), (p - p2)) < 0.0){
    return fabs((p - p2).norm());
  }
  return distp2l(p1, p2, p);
}

double distseg2seg(const Point &p1, const Point &p2,
  const Point &p3, const Point &p4){
  if(crossed(p1, p2, p3, p4)){
    return 0.0;
  }
  return min(distp2seg(p1, p2, p3), min(distp2seg(p1, p2, p4),
    min(distp2seg(p3, p4, p1), distp2seg(p3, p4, p2))));
}

int Q;

int main(){
  cin >> Q;

  for(int i = 0; i < Q; i++){
    Point p0, p1, p2, p3;
    cin >> p0.x >> p0.y >> p1.x >> p1.y >> p2.x >> p2.y >> p3.x >> p3.y;
    double d = distseg2seg(p0, p1, p2, p3);
    printf("%.10lf\n", (EQR(d, 0.0)) ? fabs(d) : d);
  }

  return 0;
}

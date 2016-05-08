#include <iostream>
#include <cmath>
#define EPS (1e-10)
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

int Q;

int main(){
  cin >> Q;

  for(int i = 0; i < Q; i++){
    double x1_i, y1_i, x2_i, y2_i, x3_i, y3_i, x4_i, y4_i;
    cin >> x1_i >> y1_i >> x2_i >> y2_i >> x3_i >> y3_i >> x4_i >> y4_i;
    Point p1 (x1_i, y1_i), p2 (x2_i, y2_i), 
          p3 (x3_i, y3_i), p4 (x4_i, y4_i);
    if(crossed(p1, p2, p3, p4)){
      cout << "1" << endl;
    }
    else{
      cout << "0" << endl;
    }
  }

  return 0;
}

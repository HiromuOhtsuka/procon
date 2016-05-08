#include <iostream>
#include <cstdio>
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

  static double dot(const Point &p1, const Point &p2){
    return p1.x * p2.x + p1.y * p2.y;
  }

  static double cross(const Point &p1, const Point &p2){
    return p1.x * p2.y - p1.y * p2.x;
  }

};

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
    double ref = Point::cross((p2 - p1), (p - p1));
    if(ref < -EPS){
      cout << "CLOCKWISE" << endl;
    }
    else if(ref > EPS){
      cout << "COUNTER_CLOCKWISE" << endl;
    }
    else if(Point::dot((p2 - p1), (p - p1)) < -EPS){
      cout << "ONLINE_BACK" << endl;
    }
    else if((p2 - p1).norm2() < (p - p1).norm2()){
      cout << "ONLINE_FRONT" << endl;
    }
    else{
      cout << "ON_SEGMENT" << endl;
    }
  }

  return 0;
}

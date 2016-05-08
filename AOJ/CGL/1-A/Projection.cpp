#include <iostream>
#include <cstdio>
#include <cmath>
#define EPS (1e-10)
#define EQR(a, b) (fabs((a) - (b)) < EPS)
using namespace std;

class Point {
  public :
    double x, y;

  Point(){}
  Point(double x, double y){
    this->x = x;
    this->y = y;
  }

  Point operator*(double k) const{
    return Point(this->x * k, this->y * k);
  }

  Point operator-(const Point &p) const{
    return Point(this->x - p.x, this->y - p.y);
  }

  Point operator+(const Point &p) const{
    return Point(this->x + p.x, this->y + p.y);
  }

  double norm2() const{
    return this->x * this->x + this->y * this->y;
  }

  static double dot(const Point &p1, const Point &p2){
    return p1.x * p2.x + p1.y * p2.y;
  }


};

Point p1, p2;
int Q;

int main(){
  double x1, y1, x2, y2;
  cin >> x1 >> y1 >> x2 >> y2;
  p1 = Point(x1, y1); p2 = Point(x2, y2);
  cin >> Q;
  for(int i = 0; i < Q; i++){
    double x_i, y_i;
    cin >> x_i >> y_i;
    Point p_i (x_i, y_i);
    Point x = p1 + (p2 - p1) * (Point::dot((p_i - p1), (p2 - p1)) / (p2 - p1).norm2());
    printf("%.10lf %.10lf\n", (EQR(x.x, 0.0)) ? fabs(x.x) : x.x, (EQR(x.y, 0.0)) ? fabs(x.y) : x.y); 
  }

  return 0;
}

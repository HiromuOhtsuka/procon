#include <iostream>
#include <map>
#include <algorithm>
#define MAX_N 100
using namespace std;

typedef pair< double, double > P;

class Line;
Line base;

class Point {
  public :
    double x, y;

  Point(double x, double y){
    this->x = x;
    this->y = y;
  }

  Point(){}

  Point operator-(const Point &p) const{
    return Point(this->x - p.x, this->y - p.y);
  }

  static double outer(const Point &p1, const Point &p2){
    return p1.y * p2.x - p1.x * p2.y;
  }

  bool operator<(const Point &p) const{
    Point p1 = *this - base.s, p2 = p - base.s;
    return outer(p1, p2) >= 0;
  }

};

class Line {
  public :
    Point s, t;

  Line(Point s, Point t){
    this->s = s;
    this->t = t;
  }
};

int N;
Point ps[MAX_N];
P tmp[MAX_N];


int main(){
  cin >> N;
  for(int i = 0; i < N; i++){
    double x, y;
    cin >> x >> "," >> y;
    ps[i] = Point(x, y);
    tmp[i] = P(x, y);
  }

  sort(tmp, tmp + N);
  base.s = Point(tmp[N - 1].first, tmp[N - 1].second);
  base.t = Point(tmp[N - 2].first, tmp[N - 2].second);

  sort(ps, ps + N);


  return 0;
}

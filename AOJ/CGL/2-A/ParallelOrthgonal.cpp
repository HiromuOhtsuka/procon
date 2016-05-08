#include <cstdio>
#include <cmath>
using namespace std;

#define EPS (1e-10)
bool equal_double(double a, double b){
  return abs(a - b) <= EPS;
}

class Point {
  public:
    double x, y;

    Point(){};

    Point(int x, int y){
      this->x = x;
      this->y = y;
    }

};

typedef Point Vector;

double inner(const Vector &v1, const Vector &v2){
  return v1.x * v2.x + v1.y * v2.y;
}

double outer(const Vector &v1, const Vector &v2){
  return v1.y * v2.x - v1.x * v2.y;
}

int Q;

int main(){
  scanf("%d", &Q);

  for(int i = 0; i < Q; i++){
    Point p0, p1, p2, p3;
    scanf("%lf %lf %lf %lf %lf %lf %lf %lf", 
      &p0.x, &p0.y, &p1.x, &p1.y, &p2.x, &p2.y, &p3.x, &p3.y);
    Vector v1(p1.x - p0.x, p1.y - p0.y), v2(p3.x - p2.x, p3.y - p2.y);
    if(equal_double(inner(v1, v2), 0)){
      printf("1\n");
    }
    else if(equal_double(outer(v1, v2), 0)){
      printf("2\n");
    }
    else{
      printf("0\n");
    }
  }

  return 0;
}

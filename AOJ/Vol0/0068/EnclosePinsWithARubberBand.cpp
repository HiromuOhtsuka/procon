#include <cstdio>
#define MAX_N 100
using namespace std;

class Point {
  public :
    double x, y;

    Point(){}

    Point(double x, double y){
      this->x = x;  this->y = y;
    }

    Point operator-(const Point& p) const{
      Point ret (this->x - p.x, this->y - p.y);
      return ret;
    }

    bool operator==(const Point& p) const{
      return this->x == p.x && this->y == p.y;
    }
};

static int N, COUNT;
static Point P[MAX_N], t[MAX_N];
static double cross(Point p1, Point p2){
  return (p1.x * p2.y - p1.y * p2.x);
}
static bool is_hantokei(Point p1, Point p2, Point p3){
  Point v12 = (p2 - p1), v13 = (p3 - p1);
  return cross(v12, v13) > 0.0;
}
static bool is_hull(int c){
  for(int i = 0; i < c; i++){
    for(int j = 0; j < N; j++){
      if(!(P[j] == t[i] || P[j] == t[(i + 1) % c])){
        if(cross(t[(i + 1) % c] - t[i], P[j] - t[i]) < 0.0){
          return false;
        }
      }
    }
  }
  return true;
}

static void search(int i, int j, int k, int l, int c){
  if(l >= N || c > N){
    return;
  }
  if(c <= 3){
    if(!is_hantokei(t[0], t[1], t[2])){
      return;
    }
  }
  else{
    if(!is_hantokei(t[c - 1], t[c - 2], t[c - 3])){
      return;
    }
  }
  if(is_hull(c)){
    COUNT = c;
    return;
  }

  search(i, j, k, l + 1, c);
  if(l != i && l != j && l != k){
    t[c] = P[l];
    search(i, j, k, l + 1, c + 1);
  }
}

int main(){
  while(true){
    scanf("%d", &N);
    if(N == 0){
      return 0;
    }
    for(int i = 0; i < N; i++){
      double x, y;
      scanf("%lf,%lf", &x, &y);
      P[i] = Point(x, y);
    }
    for(int i = 0; i < N; i++){
      t[0] = P[i];
      for(int j = 0; j < N; j++){
        if(i == j){
          continue;
        }
        t[1] = P[j];
        for(int k = 0; k < N; k++){
          if(j == k || i == k){
            continue;
          }
          t[2] = P[k];
          COUNT = 0;
          search(i, j, k, 0, 3);
          if(COUNT != 0){
            printf("%d\n", COUNT);
            return 0;
          }
        }
      }
    }
    printf("%d\n", 0);
  }

  return 0;
}

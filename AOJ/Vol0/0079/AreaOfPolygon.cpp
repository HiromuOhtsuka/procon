#include <cstdio>
#include <cmath>
#include <map>
#define MAX_N 20
using namespace std;

static int N;
static pair< double, double > P[MAX_N];
static pair< double, double > make_vector(
    pair< double, double > a, pair< double, double > b){
  return pair< double, double >(
      b.first - a.first, b.second - a.second);
}

int main(){
  double x, y;
  while(scanf("%lf,%lf", &x, &y) != EOF){
    P[N++] = pair< double, double >(x, y);
  }
  double s = 0;
  for(int i = 2; i < N; i++){
    pair< double, double > la = make_vector(P[0], P[i]),
      lb = make_vector(P[0], P[i - 1]),
      lc = make_vector(P[i], P[i - 1]);
    double a = sqrt(la.first * la.first + la.second * la.second),
           b = sqrt(lb.first * lb.first + lb.second * lb.second),
           c = sqrt(lc.first * lc.first + lc.second * lc.second);
    double z = (a + b + c) / 2.0;
    s += sqrt(z * (z - a) * (z - b) * (z - c));
  }
  printf("%.6lf\n", s);
  return 0;
}

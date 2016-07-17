#include <cstdio>
#include <cmath>
#define MAX_N 100000
using namespace std;

int n;
double a[MAX_N][2], b[MAX_N][2];

double dist(double p1[], double p2[]){
  return sqrt((p2[0] - p1[0]) * (p2[0] - p1[0]) +
    (p2[1] - p1[1]) * (p2[1] - p1[1]));
}

int main(){
  scanf("%d", &n);
  for(int i = 0; i < n; i++){
    scanf("%lf %lf", &a[i][0], &a[i][1]);
  }
  for(int i = 0; i < n; i++){
    scanf("%lf %lf", &b[i][0], &b[i][1]);
  }

  double ap[2];
  ap[0] = ap[1] = 0;
  for(int i = 0; i < n; i++){
    ap[0] += a[i][0];
    ap[1] += a[i][1];
  }
  ap[0] /= (double)n; ap[1] /= (double)n;

  double da = 0;
  for(int i = 0; i < n; i++){
    da = fmax(da, dist(ap, a[i]));
  }

  double bp[2];
  bp[0] = bp[1] = 0;
  for(int i = 0; i < n; i++){
    bp[0] += b[i][0];
    bp[1] += b[i][1];
  }
  bp[0] /= (double)n; bp[1] /= (double)n;

  double db = 0;
  for(int i = 0; i < n; i++){
    db = fmax(db, dist(bp, b[i]));
  }

  double p = db / da;

  printf("%f\n", p);

  return 0;
}

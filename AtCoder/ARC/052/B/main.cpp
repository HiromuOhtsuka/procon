#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#include <cmath>
#include <string>
#define INF (INT_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

double cone(double r, double h){
  return r * r * M_PI * h / 3.0;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, q;
  cin >> n >> q;
  double x[n], r[n], h[n];
  for(int i = 0; i < n; i++){
    cin >> x[i] >> r[i] >> h[i];
  }
  double a[q], b[q];
  for(int i = 0; i < q; i++){
    cin >> a[i] >> b[i];
  }

  double sum[q];
  for(int i = 0; i < q; i++){
    sum[i] = 0;
    for(int j = 0; j < n; j++){
      if(b[i] <= x[j] || a[i] >= (x[j] + h[j])) continue;
      double ra, ha;
      if(a[i] >= x[j]){
        ha = h[j] - (a[i] - x[j]);
        ra = r[j] * ha / h[j];
      }
      else{
        ha = h[j];
        ra = r[j];
      }
      double rb, hb;
      if(b[i] <= (x[j] + h[j])){
        hb = h[j] - (b[i] - x[j]);
        rb = r[j] * hb / h[j];
      }
      else{
        hb = rb = 0;
      }
      sum[i] += cone(ra, ha) - cone(rb, hb);
    }
  }

  string ans;
  for(double s: sum){
    ans += to_string(s) + "\n";
  }

  cout << ans << endl;

  return 0;
}

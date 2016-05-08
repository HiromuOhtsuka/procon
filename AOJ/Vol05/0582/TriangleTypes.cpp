#include <iostream>
#include <algorithm>
#include <cmath>
#define EPS (1e-10)
#define EQR(a, b) (fabs((a) - (b)) < EPS)
using namespace std;

int n, ei, tyo, don;

int main(){
  for(;;){
    double a[3];
    cin >> a[0] >> a[1] >> a[2];
    if(!(a[0] + a[1] > a[2] && a[1] + a[2] > a[0] && a[2] + a[0] > a[1])){
      cout << n << " " << tyo << " " << ei << " " << don << endl;
      break;
    }
    n++;
    sort(a, a + 3);
    double val = (a[0] * a[0] + a[1] * a[1] - a[2] * a[2]) / (2 * a[0] * a[1]);
    if(EQR(val, 0.0)){
      ++tyo;
    }
    else if(val > 0.0){
      ++ei;
    }
    else{
      ++don;
    }
  }

  return 0;
}

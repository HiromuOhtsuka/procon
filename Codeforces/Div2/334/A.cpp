#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

double x[5] = {500, 1000, 1500, 2000, 2500};

int main(){
  int m[5];
  for(int i = 0; i < 5; i++){
    cin >> m[i];
  }
  int w[5];
  for(int i = 0; i < 5; i++){
    cin >> w[i];
  }
  int hs, hu;
  cin >> hs >> hu;

  double score = 0.0;
  for(int i = 0; i < 5; i++){
    score += max(0.3 * x[i], (1.0 - m[i] / 250.0) * x[i] - 50.0 * w[i]);
  }

  score += hs * 100.0;
  score -= hu * 50.0;

  cout << ceil(score) << endl;

  return 0;
}

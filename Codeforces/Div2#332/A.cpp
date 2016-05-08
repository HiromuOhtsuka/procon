#include <iostream>
#include <algorithm>
using namespace std;

int d1, d2, d3;

int main(void){
  cin >> d1;
  cin >> d2;
  cin >> d3;

  cout << min(d1 + d2 + d3,
    min(2 * d1 + 2 * d2, 
    min(2 * (d1 + d3), 2 * (d2 + d3)))) << endl;

  return 0;
}

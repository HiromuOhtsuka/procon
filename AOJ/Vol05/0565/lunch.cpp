#include <iostream>
#include <algorithm>
#include <climits>
using namespace std;

int pasta[3], drink[2];

int main(){
  for(int i = 0; i < 3; i++){
    cin >> pasta[i];
  }
  for(int i = 0; i < 2; i++){
    cin >> drink[i];
  }

  int min_cost = INT_MAX;
  for(int i = 0; i < 3; i++){
    for(int j = 0; j < 2; j++){
      int cost = pasta[i] + drink[j] - 50;
      min_cost = min(min_cost, cost);
    }
  }

  cout << min_cost << endl;

  return 0;
}

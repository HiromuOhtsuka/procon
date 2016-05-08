#include <iostream>
#include <algorithm>
using namespace std;

int L, A, B, C, D;

int main(){
  cin >> L; cin >> A; cin >> B; cin >> C; cin >> D;

  int cost = (A / C + ((A % C != 0) ? 1 : 0));
  cost = max(cost, (B / D + (((B % D != 0)) ? 1 : 0)));

  cout << (L - cost) << endl;

  return 0;
}

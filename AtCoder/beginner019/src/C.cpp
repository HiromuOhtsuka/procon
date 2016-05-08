#include <iostream>
#include <set>
using namespace std;

int main(){
  set<int> black_set;
  set<int> int_set;

  int n;
  cin >> n;
  for(int i=0; i<n; i++){
    int x;
    cin >> x;
    if(black_set.count(x) == 0){
      int_set.insert(x);
    }
    black_set.insert(2*x);
  }
  cout << int_set.size();

  return 0;
}

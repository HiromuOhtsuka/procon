#include <iostream>
using namespace std;

int L, H, N;

int main(){
  cin >> L >> H;
  cin >> N;
  for(int i = 0; i < N; i++){
    int a;
    cin >> a;
    if(a > H){
      cout << -1 << endl;
    }
    else if(a < L){
      cout << L - a << endl;
    }
    else{
      cout << 0 << endl;
    }
  }

  return 0;
}

#include <iostream>
#define MAX_N 10
#define MAX_BX 40
#define MAX_M 10
#define MAX_BY 40
using namespace std;

typedef unsigned long long ULL;

int N, M;
ULL b_x, b_y;


int main(){
  cin >> N >> b_x;
  ULL x = 0;
  for(int i = N - 1; i >= 0; i--){
    int d;
    cin >> d;
    x = x * b_x + d;
  }
  cin >> M >> b_y;
  ULL y = 0;
  for(int i = M - 1; i >= 0; i--){
    int d;
    cin >> d;
    y = y * b_y + d;
  }

  if(x < y){
    cout << '<' << endl;
  }
  else if(x > y){
    cout << '>' << endl;
  }
  else{
    cout << '=' << endl;
  }

  return 0;
}

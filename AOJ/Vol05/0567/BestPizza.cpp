#include <iostream>
#include <algorithm>
#include <climits>
#define MAX_N 100
using namespace std;

int N, A, B, C, CC[MAX_N];
bool ok(int ave){
  int c_sum = 0, k = 0;
  for(int i = N - 1; i >= 0; i--){
    c_sum += CC[i];
    k++;
    if((C + c_sum - ave * (A + k * B)) >= 0){
      return true;
    }
  }
  return false;
}

int main(){
  cin >> N;
  cin >> A >> B;
  cin >> C;
  for(int i = 0; i < N; i++){
    cin >> CC[i];
  }
  sort(CC, CC + N);
  int left = 0, right = 10000 * (MAX_N + 2);
  while(right - left > 1){
    int mid = (right + left) / 2;
    if(ok(mid)){
      left = mid;
    }
    else{
      right = mid;
    }
  }
  cout << left << endl;

  return 0;
}



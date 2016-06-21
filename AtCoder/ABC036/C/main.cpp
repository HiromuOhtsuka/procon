nclude <iostream>
#include <climits>
#include <algorithm>
using namespace std;

int main(){
  int N;
  int A[100000];

  cin >> N;
  int B[N];
  for(int i = 0; i < N; i++){
    cin >> A[i];
    B[i] = A[i];
  }
  sort(B, B + N);
  for(int i = 0; i < N; i++){
    for(int j = i + 1; j < N; j++){
      if(B[i] == B[j]){
        B[j] = INT_MAX;
      }
      else{
        break;
      }
    }
  }
  sort(B, B + N);

  for(int i = 0; i < N; i++){
    int b = lower_bound(B, B + N, A[i]) - B;
    cout << b << endl;
  }

  return 0;
}

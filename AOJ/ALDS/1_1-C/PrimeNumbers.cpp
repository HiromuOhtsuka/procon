#include <iostream>
#define MAX_N 10000
using namespace std;

int N, a[MAX_N];

bool is_prime(int n){
  for(int i = 2; i * i <= n; i++){
    if(n % i == 0){
      return false;
    }
  }
  return true;
}

int main(){
  cin >> N;
  for(int i = 0; i < N; i++){
    cin >> a[i];
  }

  int count = 0;
  for(int i = 0; i < N; i++){
    if(is_prime(a[i])){
      count++;
    }
  }

  cout << count << endl;

  return 0;
}

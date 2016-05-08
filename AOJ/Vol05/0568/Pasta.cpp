#include <iostream>
#define MAX_N 100
using namespace std;

int N, K, a[MAX_N];

int mypow(int x, int y){
  for(int i = 1; i < y; i++){
    x = (x * x) % 10000;
  }
  return x;
}

int main(){
  cin >> N >> K;
  for(int i = 0; i < K; i++){
    int aa, b;
    cin >> aa >> b;
    a[aa - 1] = b;
  }

  int count = mypow(3, N - K);

  for(int i = 2; i < N; i++){
    if(a[i - 2] == 0 && a[i - 1] == 0 && a[i] == 0){
      count = (count - 3 * mypow(3, N - K - 3)) % 10000;
    }
    else if(a[i - 2] == 0 && a[i - 1] == 0){
      count = (count - mypow(3, N - K - 2)) % 10000;
    }
    else if(a[i - 1] == 0 && a[i] == 0){
      count = (count - mypow(3, N - K - 2)) % 10000;
    }
    else if(a[i - 2] == 0 && a[i] == 0){
      count = (count - mypow(3, N - K - 2)) % 10000;
    }
    else if(a[i - 2] == 0 && a[i - 1] == a[i]){
      count = (count - mypow(3, N - K - 1)) % 10000;
    }
    else if(a[i - 1] == 0 && a[i - 2] == a[i]){
      count = (count - mypow(3, N - K - 1)) % 10000;
    }
    else if(a[i] == 0 && a[i - 2] == a[i - 1]){
      count = (count - mypow(3, N - K - 1)) % 10000;
    }
  }


  cout << count << endl;

  return 0;
}

#include <iostream>
#include <climits>
#define MAX_N 100000
#define MAX_K (MAX_N / 2)
#define MAX_S 1000000
using namespace std;

typedef unsigned long long ULL;

int N, K, s[MAX_N];

bool ok(ULL size){
  int count = 1;
  ULL sum = s[0];
  if(s[0] > size){
    return false;
  }
  int num = 1;
  for(int i = 1; i < N; i++){
    if(s[i] > size){
      return false;
    }
    if(num == 1){
      if(sum + s[i] <= size){
        sum += s[i];
        num++;
      }
      else{
        ++count;
        sum = s[i];
      }
    }
    else{
      ++count;
      sum = s[i];
      num = 1;
    }
  }

  return count <= K;
}

int main(){
  cin >> N >> K;
  for(int i = 0; i < N; i++){
    cin >> s[i];
  }

  ULL low = 0, high = 100000000000ul;
  while(high - low > 1){
    ULL mid = (low + high) / 2;
    if(ok(mid)){
      high = mid;
    }
    else{
      low = mid;
    }
  }

  cout << high << endl;

  return 0;
}

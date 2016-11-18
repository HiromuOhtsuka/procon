#include <iostream>
using namespace std;

long long n;

int main(){
  cin >> n;

  long long count = 0;
  bool flag = true;
  for(long long i = 10; flag && i <= 10000000000L; i *= 10L){
    count += (n / i) * (i / 10L);
    long long r = n % i + 1L;
    if(n < i){
      r = n + 1L;
      flag = false;
    }
    if(r >= 2L * (i / 10L)){
      count += i / 10L;
    }
    else if(r > (i / 10L)){
      count += r % (i / 10L);
    }
  }

  cout << count << endl;

  return 0;
}

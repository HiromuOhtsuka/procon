#include <iostream>
#include <climits>
#include <algorithm>
#define MAX_N 100000
using namespace std;

int N, a[MAX_N];

int main(){
  cin >> N;
  for(int i = 0; i < N; i++){
    cin >> a[i];
  }

  int m = a[0], M = a[0], m_i = 0, M_i = 0,
      s = 0, t = 0, l_max = 1;
  while(s <= t && t < N - 1){
    if(M - m <= 1){
      t++;
      if(a[t] <= m){
        m = a[t];
        m_i = t;
      }
      if(a[t] >= M){
        M = a[t];
        M_i = t;
      }
    }
    if(M - m <= 1){
      l_max = max(l_max, t - s + 1);
    }
    else{
      s++;
      if(m_i == s - 1){
        m++;
        for(int i = s; i <= t; i++){
          if(m >= a[i]){
            m = a[i];
            m_i = i;
          }
        }
      }
      if(M_i == s - 1){
        M--;
        for(int i = s; i <= t; i++){
          if(M <= a[i]){
            M = a[i];
            M_i = i;
          }
        }
      }
    }
  }

  cout << l_max << endl;

  return 0;
}

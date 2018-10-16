#include <iostream>
#include <climits>
#include <cmath>
#include <algorithm>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <string>
#include <deque>
#define INF_INT (INT_MAX / 2)
#define INF_LONG (LONG_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

const int MAX = 100001;
const int MOD = 1000000007;

typedef long long ll;
typedef pair< int, int > pii;
typedef pair< ll, ll > pll;
typedef pair< ll, int > pli;
typedef pair< int, ll > pil;

int ceil(int x, int y){
  return (x % y == 0) ? x / y : x / y + 1;
}

int gcd(int x, int y){
  return y ? gcd(y, x % y) : x;
}

int lcm(int x, int y){
  return x / gcd(x, y) * y;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  int a[n];
  for(int i = 0; i < n; i++) cin >> a[i];

  int count1[MAX], count2[MAX];
  fill(count1, count1 + MAX, 0);
  fill(count2, count2 + MAX, 0);
  for(int i = 0; i < n; i += 2){
    ++count1[a[i]];
    ++count2[a[i + 1]];
  }

  int m1_1 = 0, m1_2 = 0, m2_1 = 0, m2_2 = 0;
  for(int i = 1; i < MAX; i++){
    if(count1[i] > count1[m1_1]){
      m1_2 = m1_1; m1_1 = i;
    }
    else if(count1[i] > count1[m1_2]){
      m1_2 = i;
    }
    if(count2[i] > count2[m2_1]){
      m2_2 = m2_1; m2_1 = i;
    }
    else if(count2[i] > count2[m2_2]){
      m2_2 = i;
    }
  }

  int count = 0;
  if(m1_1 != m2_1){
    for(int i = 0; i < n; i += 2){
      if(a[i] != m1_1) ++count;
      if(a[i + 1] != m2_1) ++count;
    }
  }
  else{
    int c1 = 0, c2 = 0;
    for(int i = 0; i < n; i += 2){
      if(a[i] != m1_1) ++c1;
      if(a[i + 1] != m2_2) ++c1;
    }
    for(int i = 0; i < n; i += 2){
      if(a[i] != m1_2) ++c2;
      if(a[i + 1] != m2_1) ++c2;
    }
    count = min(c1, c2);
  }

  cout << count << endl;

  return 0;
}

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

int pow(int x, int y){
  int r = 1;
  for(int i = 0; i < y; i++){
    r *= x;
  }
  return r;
}

bool check(int i, int n){
  if(i > n) return false;
  bool seven = false, five = false, three = false;
  while(i != 0){
    int j = i % 10;
    if(j == 7) seven = true;
    else if(j == 5) five = true;
    else if(j == 3) three = true;
    else return false;
    i /= 10;
  }
  return seven && five && three;
}

int f(int i, int s, int d, int max_d, int n){
  if(d == max_d){
    if(check(s, n)) return 1;
    else return 0;
  }
  int sum = 0;
  int t = s + pow(10, i) * 7;
  sum += f(i + 1, t, d + 1, max_d, n);
  t = s + pow(10, i) * 5;
  sum += f(i + 1, t, d + 1, max_d, n);
  t = s + pow(10, i) * 3;
  sum += f(i + 1, t, d + 1, max_d, n);
  return sum;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;

  int sum = 0;
  for(int i = 0; i < 10; i++){
    sum += f(0, 0, 0, i, n);
  }

  cout << sum << endl;

  return 0;
}

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

  int a[3], b[3];
  for(int i = 0; i < 3; i++) cin >> a[i] >> b[i];

  bool graph[4][4];
  for(int i = 0; i < 4; i++){
    fill(graph[i], graph[i] + 4, false);
  }

  for(int i = 0; i < 3; i++){
    graph[a[i] - 1][b[i] - 1] = graph[b[i] - 1][a[i] - 1] = true;
  }

  bool ans = false;
  int p[4] = {0, 1, 2, 3};
  do{
    if(graph[p[0]][p[1]] && graph[p[1]][p[2]] && 
        graph[p[2]][p[3]]){
      ans = true;
      break;
    }
  }while(next_permutation(p, p + 4));

  if(ans) cout << "YES" << endl;
  else cout << "NO" << endl;

  return 0;
}

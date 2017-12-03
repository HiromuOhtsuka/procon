#include <iostream> 
#include <climits>
#define INF (INT_MAX / 2)
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  int f[n][5][2];
  for(int i = 0; i < n; i++){
    for(int j = 0; j < 5; j++){
      cin >> f[i][j][0];
      cin >> f[i][j][1];
    }
  }
  int p[n][11];
  for(int i = 0; i < n; i++){
    for(int j = 0; j <= 10; j++){
      cin >> p[i][j];
    }
  }

  int ans = -INF;
  for(int s = 1; s < (1 << 10); s++){
    int c[n];
    fill(c, c + n, 0);
    for(int i = 0; i < n; i++){
      for(int j = 0; j < 5; j++){
        for(int k = 0; k < 2; k++){
          if(f[i][j][k] == 1 && 
              (s & (1 << (2 * j + k))) != 0){
            c[i]++;
          }
        }
      }
    }
    int sum = 0;
    for(int i = 0; i < n; i++){
      sum += p[i][c[i]];
    }
    ans = max(ans, sum);
  }

  cout << ans << endl;

  return 0;
}

#include <cstdio>
#include <vector>
#include <algorithm>
#define MAX_R 100000
#define MAX_C 100000
using namespace std;

static int R[MAX_R], C[MAX_C];
static vector< pair< int, int > > rc;
static int r, c, n, k;
static int ans;

static void solve();

int main(){
  scanf("%d %d %d", &r, &c, &k);
  scanf("%d", &n);

  fill(R, R + r, 0);
  fill(C, C + c, 0);
  for(int i = 0; i < n; i++){
    int tmp_r, tmp_c;
    scanf("%d %d", &tmp_r, &tmp_c);
    pair< int, int > tmp_rc (tmp_r - 1, tmp_c - 1);
    rc.push_back(tmp_rc);
    ++R[tmp_r - 1];
    ++C[tmp_c - 1];
  }

  solve();

  printf("%d\n", ans);

  return 0;
}

static void solve(){
  sort(rc.begin(), rc.end());
  ans = 0;

  for(int w = 0; w <= k; w++){
    int w_a[r];
    int sp_w_a = 0, w_cnt = 0;
    for(int j = 0; j < r; j++){
      if(R[j] == w){
        w_a[sp_w_a++] = j;
        ++w_cnt;
      }
    }
    int w_k_a[c];
    int sp_w_k_a = 0, w_k_cnt = 0;
    for(int j = 0; j < c; j++){
      if(C[j] == (k - w)){
        w_k_a[sp_w_k_a++] = j;
        ++w_k_cnt;
      }
    }
    int sum = w_cnt * w_k_cnt, sub_cnt = 0;
    for(int l = 0; l < sp_w_a; l++){
      for(int m = 0; m < sp_w_k_a; m++){
        pair< int, int > target(w_a[l], w_k_a[m]);
        if(binary_search(rc.begin(), rc.end(), target)){
          ++sub_cnt;
        }
      }
    }
    sum -= sub_cnt;
    ans += sum;
  }

  for(int w = 0; w <= k + 1; w++){
    int w_a[r];
    int sp_w_a = 0;
    for(int j = 0; j < r; j++){
      if(R[j] == w){
        w_a[sp_w_a++] = j;
      }
    }
    int w_k_a[c];
    int sp_w_k_a = 0;
    for(int j = 0; j < c; j++){
      if(C[j] == (k - w)){
        w_k_a[sp_w_k_a++] = j;
      }
    }
    int cnt = 0;
    for(int l = 0; l < sp_w_a; l++){
      for(int m = 0; m < sp_w_k_a; m++){
        pair< int, int > target(w_a[l], w_k_a[m]);
        if(binary_search(rc.begin(), rc.end(), target)){
          ++cnt;
        }
      }
    }
    ans += cnt;
  }
     
}


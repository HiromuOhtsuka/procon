#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n;
vector< int > a, b, c;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> n;
  a.resize(n);
  b.resize(n);
  c.resize(n);
  for(int i = 0; i < n; i++){
    cin >> a[i];
  }
  for(int i = 0; i < n; i++){
    cin >> b[i];
  }
  for(int i = 0; i < n; i++){
    cin >> c[i];
  }

  vector< pair< int, int > > all;
  for(int i = 0; i < n; i++){
    all.push_back(pair< int, int >(a[i], 2));
    all.push_back(pair< int, int >(b[i], 1));
    all.push_back(pair< int, int >(c[i], 0));
  }
  sort(all.begin(), all.end());

  long da[3 * n + 1];
  long db[3 * n + 1];
  long dc[3 * n + 1];
  da[0] = 0;
  for(int i = 1; i <= 3 * n; i++){
    if(all[i - 1].second == 2){
      da[i] = da[i - 1] + 1;
    }
    else{
      da[i] = da[i - 1];
    }
  }
  db[0] = 0;
  for(int i = 1; i <= 3 * n; i++){
    if(all[i - 1].second == 1){
      db[i] = db[i - 1] + da[i];
    }
    else{
      db[i] = db[i - 1];
    }
  }
  dc[0] = 0;
  for(int i = 1; i <= 3 * n; i++){
    if(all[i - 1].second == 0){
      dc[i] = dc[i - 1] + db[i];
    }
    else{
      dc[i] = dc[i - 1];
    }
  }

  cout << dc[3 * n] << endl;

  return 0;
}

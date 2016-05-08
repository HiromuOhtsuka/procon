// ref : http://www.slideshare.net/chokudai/abc019
// #木の直径の求め方（double sweep アルゴリズム）
#include <iostream>
using namespace std;

int main(){
  int n;
  cin >> n;
  int max_to_1 = 0;
  int j;
  for(int i=2; i<=n;i++){
    int dist;
    cout << "?" << "1" << " " << i << endl;
    cin >> dist;
    if(dist > max_to_1){
      max_to_1 = dist;
      j = i;
    }
  }
  int max = max_to_1;
  for(int i=1; i<=n; i++){
    if(i != j){
      int dist;
      cout << "?" << j << " " <<  i << endl;
      cin >> dist;
      if(dist > max){
        max = dist;
      }
    }
  }
  cout << "!" << " " << max << endl;

  return 0;
}


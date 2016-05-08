#include <iostream>
#define MAX_N 200
using namespace std;

int N, n[3][MAX_N];
int score[MAX_N];

int main(){
  cin >> N;
  for(int i = 0; i < N; i++){
    cin >> n[0][i] >> n[1][i] >> n[2][i];
  }

  for(int i = 0; i < 3; i++){
    for(int j = 0; j < N; j++){
      bool flag = true;
      for(int k = 0; k < N; k++){
        if(j == k){
          continue;
        }
        if(n[i][j] == n[i][k]){
          flag = false;
          break;
        }
      }
      if(flag){
        score[j] += n[i][j];
      }
    }
  }

  for(int i = 0; i < N; i++){
    cout << score[i] << endl;
  }

  return 0;
}

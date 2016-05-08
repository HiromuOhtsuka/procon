#include <iostream>
#include <string>
#define MAX_N 100
using namespace std;

int N;
string S, old[MAX_N];

int main(){
  cin >> N;
  cin >> S;
  for(int i = 0; i < N; i++){
    cin >> old[i];
  }

  int count = 0;
  for(int i = 0; i < N; i++){
    bool ok = false;
    for(int t = 0; !ok && t <= (old[i].length() - S.length()) / (S.length() - 1); t++){
      unsigned int j = old[i].find_first_of(string(1, S[0]), 0);
      while(j < old[i].length()){
        bool flag = true;
        int l = 1;
        for(int k = j + t + 1;
            k < old[i].length() && l < S.length();
            k += (t + 1)){
          if(old[i][k] != S[l++]){
            flag = false; break;
          }
        }
        if(l == S.length() && flag){ 
          ok = true;
          ++count; break;
        }
        j = old[i].find_first_of(string(1, S[0]), j + 1);
      }
    }
  }

  cout << count << endl;

  return 0;
}

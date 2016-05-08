#include <iostream>
#include <vector>
#include <string>
using namespace std;

string S, T;
const char re[7] = {'a', 't', 'c', 'o', 'd', 'e', 'r'};

bool bak(string s, string t, int i, int j){
  if(i >= s.length() && j >= t.length()){
    return s == t;
  }
  if(s[i] != '@' && t[j] != '@'){
    if(s[i] != t[j]){
      return false;
    }
    else{
      return bak(s, t, i + 1, j + 1);
    }
  }
  if(s[i] == '@' && t[j] != '@'){
    if(t[j] == 'a' || t[j] == 't' || t[j] == 'c' ||
        t[j] == 'o' || t[j] == 'd' || t[j] == 'e' || t[j] == 'r'){
      s[i] = t[j];
    }
    else{
      return false;
    }
  }
  else if(s[i] != '@' && t[j] == '@'){
    if(s[j] == 'a' || s[j] == 't' || s[j] == 'c' ||
        s[j] == 'o' || s[j] == 'd' || s[j] == 'e' || s[j] == 'r'){
      t[j] = s[i];
    }
    else{
      return false;
    }
  }
  return bak(s, t, i + 1, j + 1);
}

int main(){
  cin >> S;
  cin >> T;

  if(S.length() != T.length()){
    cout << "You will lose" << endl;
  }
  else if(bak(S, T, 0, 0)){
    cout << "You can win" << endl;
  }
  else{
    cout << "You will lose" << endl;
  }

  return 0;
}

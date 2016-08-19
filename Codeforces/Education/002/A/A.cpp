#include <iostream>
#include <string>
#define MAX_LEN 100000
using namespace std;

string S, a, b;

int main(){
  cin >> S;

  int s_len = S.length();
  bool e_a = true, e_b = true;
  for(int i = 0; i < s_len;){
    if(S[i] == '.' || 'a' <= S[i] && S[i] <= 'z' ||
        'A' <= S[i] && S[i] <= 'Z'){
      string tmp;
      while(S[i] != ',' && S[i] != ';' && i < s_len){
        tmp += S[i++];
      }
      b += tmp + ",";
      e_b = false;
      i++;
    }
    else if('0' <= S[i] && S[i] <= '9'){
      bool is_digit = true;
      if(i + 1 < s_len && S[i] == '0' && S[i + 1] != ',' && S[i + 1] != ';'){
        is_digit = false;
      }
      string tmp;
      while(S[i] != ',' && S[i] != ';' && i < s_len){
        if(S[i] == '.' || 'a' <= S[i] && S[i] <= 'z' ||
            'A' <= S[i] && S[i] <= 'Z'){
          is_digit = false;
        }
        tmp += S[i++];
      }
      if(is_digit){
        a += tmp + ",";
        e_a = false;
      }
      else{
        b += tmp + ",";
        e_b = false;
      }
      i++;
    }
    else{
      b += ",";
      e_b = false;
      i++;
    }
  }
  if(S[s_len - 1] == ',' || S[s_len - 1] == ';'){
    b += ",";
    e_b = false;
  }

  if(a.length() != 0){
    a.erase(a.length() - 1);
  }
  if(b.length() != 0){
    b.erase(b.length() - 1);
  }

  if(!e_a){
    cout << "\"" << a << "\"" << endl;
  }
  else{
    cout << "-" << endl;
  }
  if(!e_b){
    cout << "\"" << b << "\""<< endl;
  }
  else{
    cout << "-" << endl;
  }

  return 0;
}

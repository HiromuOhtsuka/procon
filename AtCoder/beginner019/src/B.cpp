#include <iostream>
#include <string>
#include <vector>
using namespace std;

static vector<string>* divide(string str);
static string compress(string str);

int main(){
  string str;
  cin >> str;
  vector<string>* list = divide(str);
  vector<string>::iterator it = list->begin();
  string ans;
  while(it != list->end()){
    ans.append(compress(*it));
    ++it;
  }
  cout << ans << endl;

  return 0;
}

static vector<string>* divide(string str){
  vector<string>* list = new vector<string>();
  const char* tmp = str.c_str();

  for(int i=0; i<str.length(); i++){
    string sub;
    sub.append(1, tmp[i]);
    int j = i;
    for(; j+1<str.length(); j++){
      if(tmp[j] == tmp[j+1]){
        sub.append(1, tmp[j+1]);
      }
      else{
        break;
      }
    }
    list->push_back(sub);
    i = j;
  }

  return list;
}

static string compress(string str){
  const char* tmp = str.c_str();
  char ans[3];
  ans[0] = tmp[0];
  ans[1] = '0' + str.length();
  ans[2] = '\0';

  return string(ans);
}

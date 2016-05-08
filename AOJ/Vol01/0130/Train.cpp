#include <iostream>
#include <cstring>
#include <list>
#define MAX_LEN 1024
using namespace std;

int N;
char str[MAX_LEN + 1];

int main(){
  cin >> N;
  for(int i = 0; i < N; i++){
    cin >> str;

    list< char > l; int cur = 0;
    l.push_back(str[0]);
    for(int j = 1, len = strlen(str); j < len; j += 2){
      if(str[j] == '-'){
        j++;
        if(cur == l.size() - 1){
          l.push_back(str[j + 1]);
        }
        ++cur;
      }
      else{
        ++j;
        if(cur == 0){
          l.push_front(str[j + 1]);
        }
        else{
          --cur;
        }
      }
    }

    for(list< char >::iterator it = l.begin(); it != l.end(); it++){
      cout << *it;
    }
    cout << endl;
  }

  return 0;
}

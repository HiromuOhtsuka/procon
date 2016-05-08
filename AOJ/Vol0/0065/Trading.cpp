#include <iostream>
#include <cstring>
#include <string>
#include <cstdlib>
#include <cstdio>
#include <map>
using namespace std;

static map< int, int > count1, count2;

int main(){
  string str;

  while(getline(cin, str) && str.size() != 0){
    const char *s = str.c_str();
    int no = atoi(s);
    count1[no] = count1[no] + 1;
  }

  while(getline(cin, str) && str.size() != 0){
    const char *s = str.c_str();
    int no = atoi(s);
    count2[no] = count2[no] + 1;
  }

  map< int, int >::iterator it = count2.begin();
  while(it != count2.end()){
    int no = it->first;
    if(it->second >= 1 && count1[no] >= 1){
      printf("%d %d\n", no, it->second + count1[no]);
    }
    it++;
  }

  return 0;
}

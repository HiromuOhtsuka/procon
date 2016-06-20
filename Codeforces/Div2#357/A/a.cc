#include <stdio.h>
#include <iostream>
#include <string>

using namespace std;

int main(){

  int n;
  int a,b;
  bool flag = false;
  string name;
  name = "";

  cin >> n;
  
  for(int i=0;i<n;i++){
    name.clear();
    char tmp;
    scanf("%c",&tmp);
    while(tmp != ' '){
      name.push_back(tmp);
      scanf("%c",&tmp);
    }
    cin >> a >> b;
    if(b<=a)
      continue;
    else if (a>= 2400){
      flag = true;
      break;
    }
  }

  if(flag)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;

  return 0;
}

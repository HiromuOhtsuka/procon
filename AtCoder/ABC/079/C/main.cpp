#include <iostream>
#include <string>
using namespace std;

int main(){
  string in;
  cin >> in;
  int a = in[0] - '0', b = in[1] - '0', c = in[2] - '0', d = in[3] - '0';
  int s;
  for(s = 0; s < (1 << 3); s++){
    int sum = a + ((s & 1) ? b : -b) + ((s & 2) ? c : -c) + ((s & 4) ? d : -d);
    if(sum == 7){
      break;
    }
  }
  string ans;
  ans += to_string(a);
  ans += (s & 1) ? "+" : "-";
  ans += to_string(b);
  ans += (s & 2) ? "+" : "-";
  ans += to_string(c);
  ans += (s & 4) ? "+" : "-";
  ans += to_string(d);
  ans += "=7";
  cout << ans << endl;
  return 0;
}

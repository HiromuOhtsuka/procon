#include <iostream>
using namespace std;

int W, H;

int main(){
  cin >> W >> H;
  if(4 * H == 3 * W){
    cout << "4 3" << endl;
  }
  else{
    cout << "16 9" << endl;
  }
  return 0;
}

#include <stdio.h>
#include <iostream>

using namespace std;

static int n,h,k;

int main(){
  
  cin >> n >> h >> k;

  int potato[n];
  for(int i=0;i<n;i++){
    cin >> potato[i];
  }

  int i = 0;
  int space = h;
  int time = 0;
  

  while(i < n){
    while(potato[i] <= space){
      space -= potato[i]; 
      i++;
      if (i >= n)
        break;
    }
    if(h - space <= k )
      space = h;
    else
     space += k;
    time++;
  }

  while(space < h){
    space += k;
    time++;
  }


  cout << time << endl;
  return 0;
}

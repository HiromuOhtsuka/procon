#include <iostream>
using namespace std;

static void sort(int* a, int n){
  int i = 0;
  while(i < n){
    int w = a[i];
    int k = i;
    while(k - 1 >= 0 && a[k - 1] < w){
      a[k] = a[k - 1];
      --k;
    }
    a[k] = w;
    ++i;
  }
}

int main(){
  int n;
  cin >> n;
  int data[n];
  for(int i = 0; i < n; i++){
    cin >> data[i];
  }

  sort(data, n);

  int sum = 0;
  for(int i = 0; 2 * i < n; i++){
    sum += data[2 * i];
  }

  cout << sum << endl;

  return 0;
}

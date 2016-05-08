#include <iostream>
using namespace std;

static void swap_i(int *a, int *b){
  int tmp = *a;
  *a = *b;
  *b = tmp;
}

int main(){
  int a[6] = {1, 2, 3, 4, 5, 6};
  int n;

  cin >> n;
  n %= 30;
  for(int i = 0; i < n; i++){
    swap_i(&a[(i % 5)], &a[(i % 5) + 1]);
  }

  for(int i = 0; i < 6; i++){
    cout << a[i];
  }
  cout << endl;

  return 0;
}

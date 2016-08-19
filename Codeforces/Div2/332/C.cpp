#include <iostream>
#define MAX_N 100000
using namespace std;

int N, h[MAX_N];
int count, buf[MAX_N];
void merge_sort(int low, int high){
  if(high - low <= 0){
    return;
  }
  int mid = (low + high) / 2;
  merge_sort(low, mid);
  merge_sort(mid + 1, high);
  bool sorted = true;
  int i = low, j = mid, sp = 0;
  while(i < mid && j < high){
    if(h[i] < h[j]){
      buf[sp++] = h[i++];
    }
    else{
      buf[sp++] = h[j++];
      sorted = false;
    }
  }
  while(i < mid){
    buf[sp++] = h[i++];
  }
  while(j < high){
    buf[sp++] = h[j++];
  }
  for(int i = 0; i < sp; i++){
    h[low + i] = buf[i];
  }
  if(sorted){
    ++count;
  }
}

int main(){
  cin >> N;
  for(int i = 0; i < N; i++){
    cin >> h[i];
  }
  merge_sort(0, N);
  cout << count << endl;
  return 0;
}

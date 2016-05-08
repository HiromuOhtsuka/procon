#include <iostream>
#include <climits>
#define INF INT_MAX
#define MAX_N 500000
using namespace std;

int N;
int S[MAX_N];
int count;

void merge(int a[], int left, int mid, int right){
  static int L[MAX_N + 1], R[MAX_N + 1];
  int n1 = mid - left,
      n2 = right - mid;
  for(int i = 0; i < n1; i++){
    L[i] = S[left + i];
  }
  for(int i = 0; i < n2; i++){
    R[i] = S[mid + i];
  }
  L[n1] = INF;  R[n2] = INF;
  int i = 0, j = 0;
  for(int k = left; k < right; k++){
    if(L[i] <= R[j]){
      S[k] = L[i++];
    }
    else{
      S[k] = R[j++];
    }
    count++;
  }
}

void merge_sort(int a[], int left, int right){
  if(left + 1 < right){
    int mid = (left + right) / 2;
    merge_sort(a, left, mid);
    merge_sort(a, mid, right);
    merge(a, left, mid, right);
  }
}

int main(){
  cin >> N;
  for(int i = 0; i < N; i++){
    cin >> S[i];
  }
  merge_sort(S, 0, N);

  for(int i = 0; i < N; i++){
    cout << S[i] << ((i == N - 1) ? '\n' : ' ');
  }
  cout << count << endl;

  return 0;
}

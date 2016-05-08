#include <cstdio>
#include <algorithm>
using namespace std;

static int N[14];
static bool is_complete(int n);
static bool cmb(const int *a, int n);

int main(){
  int original[14];
  while(true){
    for(int i = 0; i < 14; i++){
      int ch = getchar();
      if(ch == EOF){
        return 0;
      }
      if(ch == '\n'){
        continue;
      }
      original[i] = N[i] = ch - '0';
    }
    int ans[9], sp = 0;
    for(int i = 1; i <= 9; i++){
      if(is_complete(i)){
        ans[sp++] = i;
      }
      for(int j = 0; j < 13; j++){
        N[j] = original[j];
      }
    }
    if(sp == 0){
      printf("0\n");
    }
    else{
      for(int i = 0; i < sp - 1; i++){
        printf("%d ", ans[i]);
      }
      printf("%d\n", ans[sp - 1]);
    }
  }

  return 0;
}

static bool is_complete(int n){
  N[13] = n;
  sort(N, N + 14);
  for(int i = 0; i < 14; i++){
    int count = 0;
    for(int j = 0; j < 14; j++){
      if(N[i] == N[j]){
        ++count;
      }
    }
    if(count - 1 >= 4){
      return false;
    }
  }

  for(int i = 0; i < 14; i++){
    for(int j = i + 1; j < 14; j++){
      if(N[i] == N[j]){
        int a[14], sp = 0;
        for(int k = 0; k < 14; k++){
          if(k != i && k != j){
            a[sp++] = N[k];
          }
        }
        if(cmb(a, sp)){
          return true;
        }
      }
    }
  }

  return false;
}

static bool cmb(const int *a, int n){
  if(n == 3){
    return a[0] == a[1] && a[1] == a[2] ||
            a[0] + 1 == a[1] && a[1] + 1 == a[2];
  }
  for(int i = 0; i < n; i++){
    for(int j = i + 1; j < n; j++){
      for(int k = j + 1; k < n; k++){
        if(a[i] == a[j] && a[j] == a[k] ||
            a[i] + 1 == a[j] && a[j] + 1 == a[k]){
          int b[14], sp = 0;
          for(int l = 0; l < n; l++){
            if(l != i && l != j && l != k){
              b[sp++] = a[l];
            }
          }
          if(cmb(b, sp)){
            return true;
          }
        }
      }
    }
  }

  return false;
}

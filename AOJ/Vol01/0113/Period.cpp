#include <cstdio>
#define MAX_LEN 80
using namespace std;

static int P, Q;
static int a[MAX_LEN];
static int mem[MAX_LEN], sp;
static int search(int r){
  for(int i = 0; i < sp; i++){
    if(mem[i] == r){
      return i;
    }
  }
  return -1;
}

int main(){
  while(scanf("%d %d", &P, &Q) != EOF){
    bool circle = false;
    int t = 0, p = P, q = Q, at;
    while(true){
      int r = p % q;
      a[t] = p / q;
      ++t;
      if(r == 0){
        break;
      }
      else if((at = search(r)) != -1){
        circle = true;
        break;
      }
      else{
        p -= q * a[t - 1];
        p *= 10;
        mem[sp++] = r;
      }
    }
    for(int i = 1; i < t; i++){
      printf("%d", a[i]);
    }
    putchar('\n');
    if(circle){
      for(int i = 1; i <= at; i++){
        putchar(' ');
      }
      for(int i = at + 1; i < t; i++){
        putchar('^');
      }
      putchar('\n');
    }

    sp = 0;
  }
  return 0;
}

#include <cstdio>
#include <algorithm>
#define MAX_N 100000
using namespace std;

struct A {
  int type, no;
  A(){}
  A(int t, int n){
    type = t;
    no = n;
  }
  bool operator<(const A &a) const{
    return type < a.type;
  }
};


static int N;
static A a[MAX_N];

int main(){
  scanf("%d", &N);

  for(int i = 0; i < N; i++){
    scanf("%d", &a[i].type);
    a[i].no = i;
  }

  sort(a, a + N);
  int count = 0;
  for(int i = 0; i < N; i++){
    const A *upper = upper_bound(a, a + N, a[i]);
    for(A *j = lower_bound(a, a + N, a[i]); j < upper; j++){
      if(j->type == a[i].type && j->no < a[i].no){
        count++;
        break;
      }
    }
  }

  printf("%d\n", count);

  return 0;
}


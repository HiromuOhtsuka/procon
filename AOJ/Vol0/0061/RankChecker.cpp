#include <cstdio>
#include <functional>
#include <algorithm>
#define MAX_N 100
using namespace std;

static pair< int, int > data[MAX_N + 1];
static int rank[MAX_N + 1];

int main(){
  int sp = 0;
  while(true){
    int n, c;
    scanf("%d,%d", &n, &c);
    if(n == 0 && c == 0){
      break;
    }
    data[sp++] = pair< int, int > (c, n);
  }

  sort(data, data + sp, greater< pair< int, int > >());
  rank[data[0].second] = 1;
  int count = 1;
  for(int i = 1; i < sp; i++){
    int num = data[i].second;
    if(data[i - 1].first > data[i].first){
      rank[num] = ++count;
    }
    else{
      rank[num] = count;
    }
  }

  int n;
  while(scanf("%d", &n) != EOF){
    printf("%d\n", rank[n]);
  }

  return 0;
}

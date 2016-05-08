#include <cstdio>
#include <algorithm>
#include <map>
#include <set>
#define MAX_P 1000000
using namespace std;

static int P;
static int INDEX[MAX_P];
static set< int > S;

int main(){
  scanf("%d", &P);
  for(int i = 0; i < P; i++){
    scanf("%d", &INDEX[i]);
    S.insert(INDEX[i]);
  }

  int m = S.size();
  int s, t, min_len;
  map< int, int > tmap;
  s = t = 0;
  min_len = P;
  while(true){
    while(t < P && tmap.size() < m){
      if(tmap.find(INDEX[t]) == tmap.end()){
        tmap[INDEX[t++]] = 1;
      }
      else{
        tmap[INDEX[t++]]++;
      }
    }
    if(tmap.size() >= m){
      min_len = min(min_len, t - s);
    }
    else{
      break;
    }
    if(tmap[INDEX[s]] == 1){
      tmap.erase(INDEX[s++]);
    }
    else{
      tmap[INDEX[s++]]--;
    }
  }

  printf("%d\n", min_len);

  return 0;
}

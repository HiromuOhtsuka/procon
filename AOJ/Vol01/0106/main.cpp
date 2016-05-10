#include <cstdio>
#include <climits>
#define MAX_W 5000
using namespace std;

static int W;
static const int pa = 380, pb = 550, pc = 850;
static const int wa = 200, wb = 300, wc = 500;
static const int ua = 5, ub = 4, uc = 3;
static const double ra = 0.2, rb = 0.15, rc = 0.12;

int main(){
  while(true){
    scanf("%d", &W);

    if(W == 0){
      return 0;
    }

    int best = INT_MAX;
    for(int x = 0; wa * x <= W; x++){
      for(int y = 0; wb * y <= W; y++){
        for(int z = 0; wc * z <= W; z++){
          if(wa * x + wb * y + wc * z != W){
            continue;
          }

          int ca = pa * (x - (int)((x / ua)) * ua) + 
            pa * (1.0 - ra) * ((int)((x / ua)) * ua);
          int cb = pb * (y - (int)((y / ub)) * ub) + 
            pb * (1.0 - rb) * ((int)((y / ub)) * ub);
          int cc = pc * (z - (int)((z / uc)) * uc) + 
            pc * (1.0 - rc) * ((int)((z / uc)) * uc);

          int cost = ca + cb + cc;

          if(cost < best){
            best = cost;
          }
        }
      }
    }
    printf("%d\n", best);
  }
  return 0;
}

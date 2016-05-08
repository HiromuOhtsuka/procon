#include <iostream>
#define MAX_N 100
using namespace std;

class Mobile {
  public:
    int ll, rl, ln, rn, w;

    Mobile(){}
    Mobile(int ll, int rl, int ln, int rn){
      this->ll = ll;
      this->rl = rl;
      this->ln = ln;
      this->rn = rn;
      this->w = 0;
    }
};

int N;
Mobile M[MAX_N + 1];

int GCD(int a, int b){
  if(a == 0){
    return b;
  }
  return GCD(b % a, a);
}

int LCD(int a, int b){
  return a / GCD(a, b) * b;
}

int rec(Mobile &m){
  if(m.w != 0){
    return m.w;
  }
  int moment = LCD(rec(M[m.ln]) * m.ll, rec(M[m.rn]) * m.rl);
  return m.w = (moment / m.ll + moment / m.rl);
}

int main(){
  M[0].w = 1;

  for(;;){
    cin >> N;

    if(N == 0){
      return 0;
    }

    fill(M + 1, M + 1 + MAX_N, Mobile(0, 0, 0, 0));

    for(int i = 1; i <= N; i++){
      int ll, rl, ln, rn;
      cin >> ll >> rl >> ln >> rn;
      M[i] = Mobile(ll, rl, ln, rn);
    }

    int ans = 0;
    for(int i = 1; i <= N; i++){
      ans = max(ans, rec(M[i]));
    }

    cout << ans << endl;
  }

  return 0;
}

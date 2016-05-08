#include <iostream>
#include <map>
#include <algorithm>
#define MAX_N 3000
#define MAX_W 5000
#define MAX_H 5000
using namespace std;

typedef pair< int, int > P;

int N;
bool table[MAX_H + 1][MAX_W + 1];
P points[MAX_N];

int main(){
  for(;;){
    cin >> N;

    if(N == 0){
      return 0;
    }

    for(int i = 0; i < N; i++){
      int x, y;
      cin >> x >> y;
      points[i] = P(x, y);
      table[y][x] = true;
    }

    int max_s = 0;
    for(int i = 0; i < N; i++){
      for(int j = i + 1; j < N; j++){
        P p1 = points[i], p2 = points[j];
        P p3 = P(p2.first - (p2.second - p1.second), p2.second + (p2.first - p1.first));
        P p4 = P(p1.first - (p2.second - p1.second), p1.second + (p2.first - p1.first));
        if(!(0 <= p3.first && p3.first <= MAX_W && 0 <= p3.second && p3.second <= MAX_H)){
          continue;
        }
        if(!(0 <= p4.first && p4.first <= MAX_W && 0 <= p4.second && p4.second <= MAX_H)){
          continue;
        }
        if(table[p3.second][p3.first] && table[p4.second][p4.first]){
          int s = (p2.first - p1.first + p2.second - p1.second) * 
            (p2.first - p1.first + p2.second - p1.second) 
            - 2 * (p2.first - p1.first) * (p2.second - p1.second);
          max_s = max(max_s, s);
        }
      }
    }

    cout << max_s << endl;

    for(int i = 0; i < MAX_H; i++){
      fill(table[i], table[i] + MAX_W, false);
    }
  }

  return 0;
}

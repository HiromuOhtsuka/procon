#include <cstdio>
#include <queue>
#include <map>
using namespace std;

class Table {
  public :
    int a[2][4];
    int x0, y0;

    Table(){};
    Table(const Table &t){
      for(int i = 0; i < 2; i++){
        for(int j = 0; j < 4; j++){
          this->a[i][j] = t.a[i][j];
        }
      }
      this->x0 = t.x0;
      this->y0 = t.y0;
    }

    bool operator<(const Table &t) const{
      for(int i = 0; i < 2; i++){
        for(int j = 0; j < 4; j++){
          if(a[i][j] != t.a[i][j]){
            return a[i][j] > t.a[i][j];
          }
        }
      }
      return false;
    }

    bool operator==(const Table &t) const{
      for(int i = 0; i < 2; i++){
        for(int j = 0; j < 4; j++){
          if(a[i][j] != t.a[i][j]){
            return false;
          }
        }
      }
      return true;
    }
};

bool complete(const Table &t){
  int count = 0;
  for(int i = 0; i < 2; i++){
    for(int j = 0; j < 4; j++){
      if(t.a[i][j] != count){
        return false;
      }
      ++count;
    }
  }
  return true;
}

typedef pair< Table, int > P;

int search(Table s){
  static const int dx[] = {-1, 0, 0, 1},
               dy[] = {0, -1, 1, 0};
  queue< P > que;
  map< Table, bool > V;

  int count = 0;
  que.push(P(s, 0));
  V[s] = true;
  while(!que.empty()){
    P p = que.front();  que.pop();
    Table t = p.first;
    if(complete(t)){
      return p.second;
    }
    for(int i = 0; i < 4; i++){
      Table tmp_t(t);
      int x = tmp_t.x0 + dx[i], y = tmp_t.y0 + dy[i];
      if(0 <= x && x < 4 && 0 <= y && y < 2){
        tmp_t.a[tmp_t.y0][tmp_t.x0] = tmp_t.a[y][x];
        tmp_t.a[y][x] = 0;
        tmp_t.x0 = x, tmp_t.y0 = y;
        if(!V[tmp_t]){
          V[tmp_t] = true;
          que.push(P(tmp_t, p.second + 1));
        }
      }
    }
  }
  return -1;
}

int main(){
  for(;;){
    Table t;
    for(int i = 0; i < 2; i++){
      for(int j = 0; j < 4; j++){
        if(scanf("%d", &t.a[i][j]) == EOF){
          return 0;
        }
        if(t.a[i][j] == 0){
          t.x0 = j, t.y0 = i;
        }
      }
    }
    printf("%d\n", search(t));
  }

  return 0;
}

#include <iostream>
using namespace std;

static bool judge(int i, int j, bool is_fore, const bool **map, int n, int m);
static bool movable(int i, int j, const bool **map, int n, int m);

int main(){

  return 0;
}

static bool judge(int i, int j, bool is_fore, const bool **map, int n, int m){
  if(is_fore && !movable(i, j, map, n, m)){
    return false;
  }
  if(!is_fore && !movable(i, j, map, n, m)){
    return true;
  }

  bool under, right, right_down;
  under = right = right_down = true;
  if(i + 1  < n && map[i + 1][j]){
    under = judge(i + 1, j, !is_fore, map, n, m);
  }
  if(j + 1 < m && map[i][j + 1]){
    right = judge(i, j + 1, !is_fore, map, n, m);
  }
  if(i + 1 < n && j + 1 < m && map[i + 1][j + 1]){
    right_down = judge(i + 1, j + 1, !is_fore, map, n, m);
  }

  return under & right & right_down;
}

static bool movable(int i, int j, const bool **map, int n, int m){
  return  ((i + 1  < n && map[i + 1][j]) || 
           (j + 1 < m && map[i][j + 1]) || 
           (i + 1 < n && j + 1 < m && map[i + 1][j + 1]);
}

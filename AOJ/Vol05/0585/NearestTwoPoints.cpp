#include <iostream>
#include <climits>
#include <algorithm>
#include <queue>
#define MAX_N 500000
#define MIN_X (-10000)
#define MAX_X 10000
#define MIN_Y (-10000)
#define MAX_Y 10000
using namespace std;

class Point {
  public:
    int x, y;

  Point(int x, int y){
    this->x = x;
    this->y = y;
  }
  Point(){}

  static int len2(const Point &p1, const Point &p2){
    return (p2.x - p1.x) * (p2.x - p1.x) + 
      (p2.y - p1.y) * (p2.y - p1.y);
  }
};

int N;
bool table[MAX_Y * 2 + 2][MAX_X * 2 + 2];
bool visited[MAX_Y * 2 + 2][MAX_X * 2 + 2];
Point points[MAX_N];

int bfs(Point s){
  static const int dx[] = {-1, 0, 0, 1},
             dy[] = {0, 1, -1, 0};
  queue< Point > que;

  for(int i = 0; i < MAX_Y * 2 + 2; i++){
    fill(visited[i], visited[i] + MAX_X * 2 + 2, false);
  }

  table[s.y][s.x] = false;
  que.push(s);
  while(!que.empty()){
    Point p = que.front(); que.pop();
    if(!(0 <= p.x && p.x < MAX_X * 2 + 2 &&
         0 <= p.y && p.y < MAX_Y * 2 + 2)){
      continue;
    }
    if(visited[p.y][p.x]){
      continue;
    }
    visited[p.y][p.x] = true;
    if(table[p.y][p.x]){
      return Point::len2(s, p);
    }
    for(int i = 0; i < 4; i++){
      que.push(Point(p.x + dx[i], p.y + dy[i]));
    }
  }
}

int main(){
  cin >> N;
  for(int i = 0; i < N; i++){
    cin >> points[i].x >> points[i].y;
    points[i].x += MAX_X;
    points[i].y += MAX_Y;
    table[points[i].y][points[i].x] = true;
  }

  int m_len = INT_MAX;
  for(int i = 0; i < N; i++){
    m_len = min(m_len, bfs(points[i]));
  }

  cout << m_len << endl;

  return 0;
}

#include <iostream>
#include <cstdio>
#define MAX_M 1000
#define MAX_N 1000
#define MAX_K 1000000
using namespace std;

int M, N, K;
char table[MAX_M][MAX_N];
int I[MAX_M][MAX_N], O[MAX_M][MAX_N];

int main(){
  cin >> M >> N;
  cin >> K;
  getchar();
  for(int i = 0; i < M; i++){
    for(int j = 0; j <= N; j++){
      int ch = getchar();
      if(ch == '\n'){
        continue;
      }
      table[i][j] = ch;
    }
  }

  if(table[0][0] == 'I'){
    I[0][0] = 1;
  }
  else if(table[0][0] == 'O'){
    O[0][0] = 1;
  }
  for(int i = 1; i < M; i++){
    if(table[i][0] == 'I'){
      I[i][0] = 1;
    }
    if(table[i][0] == 'O'){
      O[i][0] = 1;
    }
    I[i][0] += I[i - 1][0];
    O[i][0] += O[i - 1][0];
  }
  for(int j = 1; j < N; j++){
    if(table[0][j] == 'I'){
      I[0][j] =  1;
    }
    else if(table[0][j] == 'O'){
      O[0][j] =  1;
    }
    I[0][j] += I[0][j - 1];
    O[0][j] += O[0][j - 1];
  }

  for(int i = 1; i < M; i++){
    for(int j = 1; j < N; j++){
      int count_i = 0, count_o = 0;
      for(int k = 0; k < j; k++){
        if(table[i][k] == 'I'){
          count_i++;
        }
        else if(table[i][k] == 'O'){
          count_o++;
        }
      }
      for(int k = 0; k <= i; k++){
        if(table[k][j] == 'I'){
          count_i++;
        }
        else if(table[k][j] == 'O'){
          count_o++;
        }
      }
      I[i][j] = I[i - 1][j - 1] + count_i;
      O[i][j] = O[i - 1][j - 1] + count_o;
    }
  }

  for(int i = 0; i < K; i++){
    int a, b, c, d;
    cin >> a >> b >> c >> d;
    a--, b--, c--, d--;
    int count_i = I[c][d],
        count_o = O[c][d];
    if(a - 1 >= 0){
      count_i -= I[a - 1][d];
      count_o -= O[a - 1][d];
    }
    if(b - 1 >= 0){
      count_i -= I[c][b - 1];
      count_o -= O[c][b - 1];
    }
    if(a - 1 >= 0 && b - 1 >= 0){
      count_i += I[a - 1][b - 1];
      count_o += O[a - 1][b - 1];
    }
    int count_j = (c - a + 1) * (d - b + 1) - count_i - count_o;
    cout << count_j << " " << count_o << " " << count_i << endl;
  }

  return 0;
}

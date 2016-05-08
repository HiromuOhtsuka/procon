#include <cstdio>
using namespace std;

static int table[3][3];
static const int O = 'o', X = 'x', S = 's';
static bool judge(const int ch){
  for(int i = 0; i < 3; i++){
    if(table[i][0] == ch && table[i][1] == ch &&
        table[i][2] == ch){
      return true;
    }
    if(table[0][i] == ch && table[1][i] == ch &&
        table[2][i] == ch){
      return true;
    }
  }
  if(table[0][0] == ch && table[1][1] == ch &&
      table[2][2] == ch){
    return true;
  }
  if(table[0][2] == ch && table[1][1] == ch &&
      table[2][0] == ch){
    return true;
  }
  return false;
}

int main(){
  int ch;
  while(true){
    for(int i = 0; i < 10; i++){
      ch = getchar();
      if(ch == '\n'){
        break;
      }
      if(ch == EOF){
        return 0;
      }
      table[i / 3][i % 3] = ch;
    }
    if(judge(O)){
      printf("o\n");
    }
    else if(judge(X)){
      printf("x\n");
    }
    else{
      printf("d\n");
    }
  }

  return 0;
}

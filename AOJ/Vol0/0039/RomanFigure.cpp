#include <cstdio>
using namespace std;

static int parse(char ch){
  switch(ch){
    case 'I' : return 1;
    case 'V' : return 5;
    case 'X' : return 10;
    case 'L' : return 50;
    case 'C' : return 100;
    case 'D' : return 500;
    case 'M' : return 1000;
  }
  return -1;
}

int main(){
  int c0, c1;

  while(c0 != EOF){
    int sum = 0;
    c0 = getchar();
    c0 = parse(c0);
    while(true){
      c1 = getchar();
      if(c1 == EOF){
        return 0;
      }
      if(c1 == '\n'){
        sum += c0;
        printf("%d\n", sum);
        break;
      }
      c1 = parse(c1);
      if(c0 < c1){
        sum -= c0;
      }
      else{
        sum += c0;
      }
      c0 = c1;
    }
  }

  return 0;
}

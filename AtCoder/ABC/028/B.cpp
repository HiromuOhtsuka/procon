#include <cstdio>
using namespace std;

enum{
  A, B, C, D, E, F
};
static int count[6];

int main(){
  int ch;

  while((ch = getchar()) != '\n'){
    switch(ch){
      case 'A' : count[A]++; break;
      case 'B' : count[B]++; break;
      case 'C' : count[C]++; break;
      case 'D' : count[D]++; break;
      case 'E' : count[E]++; break;
      case 'F' : count[F]++; break;
    }
  }
  for(int i = 0; i < 5; i++){
    printf("%d ", count[i]);
  }
  printf("%d\n", count[5]);

  return 0;
}

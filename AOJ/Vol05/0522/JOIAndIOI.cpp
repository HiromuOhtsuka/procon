#include <cstdio>
#define MAX_LEN 10000
using namespace std;

static char str[MAX_LEN + 1];

int main(){
  while(scanf("%s", str) != EOF){
    int joi = 0, ioi = 0;
    for(int i = 0; 
      str[i] != '\0' && str[i + 1] != '\0' && str[i + 2] != '\0';
        i++){
      if(str[i] == 'J'){
        if(str[i + 1] == 'O' && str[i + 2] == 'I'){
          ++joi;
        }
      }
      else if(str[i] == 'I'){
        if(str[i + 1] == 'O' && str[i + 2] == 'I'){
          ++ioi;
        }
      }
    }
    printf("%d\n%d\n", joi, ioi);
  }

  return 0;
}

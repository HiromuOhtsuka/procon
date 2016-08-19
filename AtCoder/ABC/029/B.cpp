#include <cstdio>
#include <cstring>
#define MAX_LEN 10
using namespace std;

static char s[MAX_LEN + 1];
static int count;

int main(){
  for(int i = 0; i < 12; i++){
    scanf("%s", s);
    int len = strlen(s);
    for(int i = 0; i < len; i++){
      if(s[i] == 'r'){
        ++count;
        break;
      }
    }
  }

  printf("%d\n", count);

  return 0;
}

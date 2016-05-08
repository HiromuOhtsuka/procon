#include <cstdio>
#include <cstring>
#define MAX_LEN 100
using namespace std;

static char s[MAX_LEN + 1];

int main(){
  scanf("%s", s);
  s[strlen(s) - 1] = '5';
  printf("%s\n", s);

  return 0;
}

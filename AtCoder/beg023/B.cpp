#include <cstdio>
#include <cstdlib>
#define MAX_N 100
using namespace std;

static int ans;
static bool search(char *s, int len, int step, int depth);

int main(){
  int n;
  char s[MAX_N + 1];

  scanf("%d", &n);
  scanf("%s", s);

  int step = (n / 2);
  ans = 0;
  if(search(s, n, step, 0)){
    printf("%d\n", ans);
  }
  else{
    printf("-1\n");
  }

  return 0;
}

static bool search(char *s, int len, int step, int depth){
  if(ans < depth){
    ans = depth;
  }
  if(len != 1 && len < 3){
    exit(EXIT_FAILURE);
  }

  if(len == 1){
    return s[0] == 'b';
  }
  if(step % 3 == 1){
    if(!(s[0] == 'a' && s[len - 1] == 'c')){
      return false;
    }
    ++s;
    s[len - 1] = '\0';
    return search(s, len - 2, step - 1, depth + 1);
  }
  else if(step % 3 == 2){
    if(!(s[0] == 'c' && s[len - 1] == 'a')){
      return false;
    }
    ++s;
    s[len - 1] = '\0';
    return search(s, len - 2, step - 1, depth + 1);
  }
  else{
    if(!(s[0] == 'b' && s[len - 1] == 'b')){
      return false;
    }
    ++s;
    s[len - 1] = '\0';
    return search(s, len - 2, step - 1, depth + 1);
  }
  return false;
}


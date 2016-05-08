#include <cstdio>
#include <cstring>
#include <cstdlib>
#define MAX_N 200
using namespace std;

static char s[MAX_N + 1];
static int stack[MAX_N], sp;
static void push(int v){
  stack[sp++] = v;
}
static int pop(){
  return stack[--sp];
}

int main(){
  while(scanf("%s", s) != EOF){
    if(s[0] == '+'){
      int a = pop(), b = pop();
      push(b + a);
    }
    else if(s[0] == '-'){
      int a = pop(), b = pop();
      push(b - a);
    }
    else if(s[0] == '*'){
      int a = pop(), b = pop();
      push(b * a);
    }
    else if(s[0] == '/'){
      int a = pop(), b = pop();
      push(b / a);
    }
    else{
      push(atoi(s));
    }
  }
  printf("%d\n", pop());

  return 0;
}

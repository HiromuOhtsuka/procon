#include <cstdio>
#include <cstring>
#define MAX_LEN 100
using namespace std;

static char str[MAX_LEN + 1];

bool check(const char *head, const char *tail){
  if(tail == head){
    return true;
  }
  if((tail - head) == 1){
    return *head == *tail;
  }
  if(*head != *tail){
    return false;
  }
  return check(head + 1, tail - 1);
}

int main(){
  int count = 0;
  while(scanf("%s", str) != EOF){
    int len = strlen(str);
    if(check(str, str + (len - 1))){
      ++count;
    }
  }

  printf("%d\n", count);

  return 0;
}


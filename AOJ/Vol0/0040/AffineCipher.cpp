#include <cstdio>
#include <cstring>
#define MAX_M 128
using namespace std;

static int N;
static int A, B;

static void change(char *str){
  int len = strlen(str);
  for(int i = 0; i < len; i++){
    str[i] -= 'a';
  }
}
static int f(int a, int b, int y){
  if(!('a' <= y && y <= 'z')){
    return y;
  }
  return (a * y + b) % 26;
}

static bool search(const char *str, int len){
  if(len != 4){
    return false;
  }
  static const int a[] = {1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25};
  for(int i = 0; i < 12; i++){
    for(int b = 0; b < 26; b++){
      char word[len + 1];
      for(int l = 0; l < len; l++){
        word[l] = f(a[i], b, str[l]);
      }
      word[len] = '\0';
      if(!strcmp(word, "this") || !strcmp(word, "that")){
        A = a[i]; B = b;
        return true;
      }
    }
  }
  return false;
}

int main(){
  scanf("%d", &N);
  char str[256 + 1];
  for(int i = 0; i < N; i++){
    gets(str);
  }
  for(int i = 0; i < N; i++){
    for(int j = 0; j < strlen(strs[i]); j++){
      strs[i][j] = f(A, B, strs[i][j]);
    }
  }
  for(int i = 0; i < N - 1; i++){
    printf("%s ", strs[i]);
  }
  printf("%s\n", strs[N - 1]);

  return 0;
}

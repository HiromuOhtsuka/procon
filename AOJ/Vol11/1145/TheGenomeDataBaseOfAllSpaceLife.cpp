#include <cstdio>
#include <cstdlib>
#include <cstring>
#define MAX_LEN 100
using namespace std;

static int expression();
static int dna_expression();
static int term_expression();

static char exp[MAX_LEN + 1];
static char t[MAX_LEN + 1];
static int I;
static int sp;
static long long count;
static bool p;

static int expression(){
  //printf("expression(");
  int ret = dna_expression();
  if(exp[sp] == '\0' || exp[sp] == ')'){
    //printf(")");
    return ret;
  }
  ret += expression();
  //printf(")");
  return ret;
}

static int dna_expression(){
  int ret;
  //printf("dna_expression(");
  if('A' <= exp[sp] && exp[sp] <= 'Z'){
    ret = term_expression();
    if(count <= 1000000){
      count += ret;
    }
    if(!p && count > I && count <= 1000000){
      //
      p = true;
    }
    return ret;
  }
  int sum = 0;
  while('0' <= exp[sp] && exp[sp] <= '9'){
    sum = sum * 10 + exp[sp] - '0';
    sp++;
  }
  ret = term_expression();
  char tmp[MAX_LEN + 1];
  strcpy(tmp, t);
  for(int i = 0; i < sum; i++){
    strcat(t, tmp);
  }
  if(count <= 1000000){
    count += ret * sum;
  }
  if(!p && count > I && count <= 1000000){
    //
    p = true;
  }
  //printf(")");
  return ret * sum;
}
static int term_expression(){
  //printf("term_expression(");
  int ret;
  if(exp[sp] == '('){
    sp++;
    ret = expression();
    if(count <= 1000000){
      count = 0;
    }
    if(exp[sp] == ')'){
      sp++;
      //printf(")");
      return ret;
    }
    else{
      printf("error\n");
      exit(EXIT_FAILURE);
    }
  }
  ret = 0;
  while('A' <= exp[sp] && exp[sp] <= 'Z'){
    ret++, sp++;
  }
  //printf(")");
  return ret;
}

int main(){
  while(true){
    scanf("%s %d", exp, &I);

    if(exp[0] == '0' && I == 0){
      return 0;
    }

    count = sp = 0;
    p = false;
    expression();
    if(!p){
      printf("0\n");
    }

    printf("count:%llu\n", count);
  }

  return 0;
}


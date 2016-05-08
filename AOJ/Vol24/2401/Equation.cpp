#include <cstdio>
#define MAX_LEN 1024
using namespace std;

static bool val[11];
static char exp[MAX_LEN + 1];
int sp;

static bool formula(){
  switch(exp[sp++]){
    case 'T' : return true;
    case 'F' : return false;
    case 'a' : return val[0];
    case 'b' : return val[1];
    case 'c' : return val[2];
    case 'd' : return val[3];
    case 'e' : return val[4];
    case 'f' : return val[5];
    case 'g' : return val[6];
    case 'h' : return val[7];
    case 'i' : return val[8];
    case 'j' : return val[9];
    case 'k' : return val[10];
    case '-' : return !formula();
    case '(' : 
               bool r1 = formula(), r2;
               switch(exp[sp++]){
                 case '*' : 
                   r2 = formula();
                   sp++;
                   return r1 && r2;
                 case '+' : 
                   r2 = formula();
                   sp++;
                   return r1 || r2;
                 case '-' : 
                  if(exp[sp++] == '>'){
                     r2 = formula();
                     sp++;
                     return !r1 || r2;
                  }
               }
  }
  return false;
}

static bool equation(){
  bool ret = formula();
  sp++;
  return ret == formula();
}

static bool search(int l){
  if(l == 11){
    sp = 0;
    return equation();
  }
  val[l] = true;
  if(!search(l + 1)){
    return false;
  }
  val[l] = false;
  if(!search(l + 1)){
    return false;
  }
  return true;
}

int main(){
  while(true){
    scanf("%s", exp);

    if(exp[0] == '#'){
      return 0;
    }

    if(search(0)){
      printf("YES\n");
    }
    else{
      printf("NO\n");
    }
  }

  return 0;
}


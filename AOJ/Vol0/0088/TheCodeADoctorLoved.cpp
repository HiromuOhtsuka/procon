#include <cstdio>
#include <cstring>
#define MAX_LEN 9
using namespace std;

static char str[MAX_LEN];
static int sp;
static void table1(char ch){
  switch(ch){
    case ' ' : 
      strcpy(str + sp, "101"); 
      sp += 3;
      break;
    case ''' : 
      strcpy(str + sp, "000000");
      sp += 6;
      break;
    case '`' :
      strcpy(str + sp, "000011");
      sp += 6;
      break;
    case '-' : 
      strcpy(str + sp, "10010001");
      sp += 8;
      break;
    case '.' :
      strcpy(str + sp, "010001");
      sp += 6;
      break;
    case '?' :
      strcpy(str + sp, "000001");
      sp += 6;
      break;
}


int main(){
  int ch;

  while((ch = getchar()) != '\n'){

  }

  return 0;
}

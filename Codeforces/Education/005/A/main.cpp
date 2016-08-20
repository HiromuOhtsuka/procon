#include <cstdio>
#include <cstring>
#include <algorithm>
#define MAX_N 1000001
using namespace std;

char a[MAX_N], b[MAX_N];

int main(){
  scanf("%s %s", a, b);

  int al = strlen(a), bl = strlen(b);
  char an[al + 1], bn[bl + 1];

  int s = 0;
  while(s + 1 < al && a[s] == '0'){
    ++s;
  }
  int sp = 0;
  for(int i = s; i < al; i++){
    an[sp++] = a[i];
  }
  an[sp++] = '\0';

  s = 0;
  while(s + 1 < bl && b[s] == '0'){
    ++s;
  }
  sp = 0;
  for(int i = s; i < bl; i++){
    bn[sp++] = b[i];
  }
  bn[sp++] = '\0';

  if(strcmp(an, bn) == 0){
    printf("=\n");
    return 0;
  }

  al = strlen(an);  bl = strlen(bn);
  int len = max(al, bl);

  char aa[len + 1], bb[len + 1];
  s = 0;
  while(al + s < len){
    aa[s++] = '0';
  }
  for(int i = s; i < s + al; i++){
    aa[i] = an[i - s];
  }
  aa[len] = '\0';

  s = 0;
  while(bl + s < len){
    bb[s++] = '0';
  }
  for(int i = s; i < s + bl; i++){
    bb[i] = bn[i - s];
  }
  bb[len] = '\0';

  if(strcmp(aa, bb) < 0){
    printf("<\n");
  }
  else{
    printf(">\n");
  }

  return 0;
}

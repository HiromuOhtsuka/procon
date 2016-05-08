#include <cstdio>
#include <cstring>
#include <algorithm>
#define MAX_LEN 4128
using namespace std;

char s[MAX_LEN + 1], t[MAX_LEN + 1];
char str[MAX_LEN * 2 + 1];
int sa[MAX_LEN + 1], rank[MAX_LEN + 1], len, k, tmp[MAX_LEN + 1], lcp[MAX_LEN + 1];

bool compare(int i, int j){
  if(rank[i] != rank[j]){
    return rank[i] < rank[j];
  }
  int ri = (i + k <= len) ? rank[i + k] : -1;
  int rj = (j + k <= len) ? rank[j + k] : -1;
  return ri < rj;
}

void construct_sa(){
  for(int i = 0; i <= len; i++){
    sa[i] = i;
    rank[i] = (i < len) ? str[i] : -1;
  }

  for(k = 1; k <= len; k <<= 1){
    sort(sa, sa + len + 1, compare);
    tmp[sa[0]] = 0;
    for(int i = 1; i <= len; i++){
      tmp[sa[i]] = tmp[sa[i - 1]] + (compare(sa[i - 1], sa[i]) ? 1 : 0);
    }
    for(int i = 0; i <= len; i++){
      rank[i] = tmp[i];
    }
  }
}

void construct_lcp(){
  for(int i = 0; i <= len; i++){
    rank[sa[i]] = i;
  }

  int h = 0;
  lcp[0] = 0;
  for(int i = 0; i < len; i++){
    int j = sa[rank[i] - 1];

    if(h > 0){
      --h;
    }
    for( ; j + h < len && i + h < len; h++){
      if(str[j + h] != str[i + h]){
        break;
      }
    }
    lcp[rank[i] - 1] = h;
  }
}

int main(){
  while(scanf("%s %s", s, t) != EOF){
    int sl = strlen(s);

    strcpy(str, s);
    strcat(str, "$");
    strcat(str, t);

    len = strlen(str);

    construct_sa();
    construct_lcp();

    printf("sa:\n");
    for(int i = 0; i <= len; i++){
      printf("%d ", sa[i]);
    }
    putchar('\n');
    printf("lcp:\n");
    for(int i = 0; i <= len; i++){
      printf("%d ", lcp[i]);
    }
    putchar('\n');

    int max_len = 0;
    for(int i = 0; i < len; i++){
      if((sa[i] < sl) != (sa[i + 1] < sl)){
        max_len = max(max_len, lcp[i]);
      }
    }
    printf("%d\n", max_len);

    str[0] = '\0';
  }

  return 0;
}

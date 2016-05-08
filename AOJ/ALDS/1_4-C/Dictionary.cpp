#include <cstdio>
#include <cstdlib>
#define MAX_N 1000000
#define MAX_LEN 12
using namespace std;

typedef struct _Recode {
  char str[MAX_LEN + 1];
} Recode;

static Recode dict[MAX_N];
static void init(){
  for(int i = 0; i < MAX_N; i++){
    dict[i].str[0] = '\0';
  }
}

static int hash1(int key){
  return key % MAX_N;
}

static int hash2(int key){
  return 1 + (key % (MAX_N - 1));
}

static int hash(int key, int i){
  return (hash1(key) + i * hash2(key)) % MAX_N;
}

static int get_char(char ch){
  switch(ch){
    case 'A' : return 1;
    case 'C' : return 2;
    case 'G' : return 3;
    case 'T' : return 4;
  }
  return 0;
}

static int get_key(const char *str){
  long long sum = 0, p = 1, len = strlen(str);

  for(int i = 0; i < len; i++){
    sum += p * get_char(str[i]);
    p *= 5;
  }

  return sum;
}

static int insert(Recode rec){
  int i = 0, key = get_key(rec.str);

  while(true){
    int j = hash(key, i);
    if(dict[j].str[0] == '\0'){
      strcpy(dict[j].str, rec.str);
      return j;
    }
    ++i;
  }

}

static int search(Recode rec){
  int i = 0, key = get_key(rec.str);

  while(true){
    int j = hash(key, i);
    if(!strcmp(dict[j].str, rec.str)){
      return j;
    }
    else if(dict[j].str[0] == '\0' ||
        i >= MAX_N){
      return -1;
    }
    ++i;
  }

}

static int N;

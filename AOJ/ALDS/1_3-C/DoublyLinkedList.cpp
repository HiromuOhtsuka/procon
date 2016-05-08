#include <cstdio>
#include <cstdlib>
#include <cstring>
#define STREQ(s1, s2) !strcmp(s1, s2)
using namespace std;

static int N;
static char command[16];

typedef struct _Recode {
  int val;
  struct _Recode *pre, *next;
} Recode;

Recode *NIL;

static void init(){
  NIL = (Recode*)malloc(sizeof(Recode));
  NIL->pre = NIL->next = NIL;
}

static void insert(int x){
  Recode *new_rec = (Recode*)malloc(sizeof(Recode));
  new_rec->val = x;
  new_rec->pre = NIL;
  new_rec->next = NIL->next;
  NIL->next->pre = new_rec;
  NIL->next = new_rec;
  if(NIL->pre == NIL){
    NIL->pre = new_rec;
  }
}

static void remove(int x){
  Recode *rec = NIL->next;

  while(rec != NIL){
    if(rec->val == x){
      rec->pre->next = rec->next;
      rec->next->pre = rec->pre;
      free(rec);
      break;
    }
    rec = rec->next;
  }
}

static void remove_first(){
  Recode *head = NIL->next;
  NIL->next = head->next;
  head->next->pre = NIL;
  free(head);
}

static void remove_last(){
  Recode *last = NIL->pre;
  last->pre->next = NIL;
  NIL->pre = last->pre;
  free(last);
}

static void print_list(){
  Recode *rec = NIL->next;

  while(rec != NIL){
    printf("%d%c", rec->val, rec->next == NIL ? '\n' : ' ');
    rec = rec->next;
  }
}

int main(){
  scanf("%d", &N);
  init();
  for(int i = 0; i < N; i++){
    scanf("%s", command);
    if(STREQ(command, "insert")){
      int x;
      scanf("%d", &x);
      insert(x);
    }
    else if(STREQ(command, "delete")){
      int x;
      scanf("%d", &x);
      remove(x);
    }
    else if(STREQ(command, "deleteFirst")){
      remove_first();
    }
    else if(STREQ(command, "deleteLast")){
      remove_last();
    }
  }
  print_list();
  return 0;
}

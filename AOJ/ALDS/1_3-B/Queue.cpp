#include <cstdio>
#define MAX_N 1000001
#define MAX_LEN 10
using namespace std;

static int N, Q;

typedef struct _P {
  char name[MAX_LEN + 1];
  int time;
} P;

static P queue[MAX_N];
static int head, tail;

static bool empty(){
  return head == tail;
}

static void euqueue(P v){
  queue[tail] = v;
  tail = (tail + 1) % MAX_N;
}

static P dequeue(){
  P ret = queue[head];
  head = (head + 1) % MAX_N;
  return ret;
}

int main(){
  scanf("%d %d", &N, &Q);
  for(int i = 0; i < N; i++){
    P p;
    scanf("%s %d", p.name, &p.time);
    euqueue(p);
  }

  int sum_time = 0;
  while(!empty()){
    P p = dequeue();
    if(p.time - Q <= 0){
      sum_time += p.time;
      printf("%s %d\n", p.name, sum_time);
    }
    else{
      sum_time += Q;
      p.time -= Q;
      euqueue(p);
    }
  }

  return 0;
}


#include <cstdio>
using namespace std;
static void swap(int *a, int *b){
  int tmp = *a;
  *a = *b;
  *b = tmp;
}

int main(){
  int m1, m2, m3;
  m1 = m2 = m3 = -1;
  for(int i = 0; i < 10; i++){
    int s;
    scanf("%d", &s);
    if(s > m1){
      swap(&m1, &m2);
      swap(&m1, &m3);
      m1 = s;
    }
    else if(s > m2){
      swap(&m2, &m3);
      m2 = s;
    }
    else if(s > m3){
      m3 = s;
    }
  }
  printf("%d ", m1 + m2 + m3);

  m1 = m2 = m3 = -1;
  for(int i = 0; i < 10; i++){
    int s;
    scanf("%d", &s);
    if(s > m1){
      swap(&m1, &m2);
      swap(&m1, &m3);
      m1 = s;
    }
    else if(s > m2){
      swap(&m2, &m3);
      m2 = s;
    }
    else if(s > m3){
      m3 = s;
    }
  }
  printf("%d\n", m1 + m2 + m3);

  return 0;
}

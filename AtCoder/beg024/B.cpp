#include <cstdio>

int main(){
  int n, t;
  int sum, t_n;

  scanf("%d %d", &n, &t);
  sum = t_n = 0;
  for(int i = 0; i < n; i++){
    int a;
    scanf("%d", &a);
    if(t_n <= a){
      sum += t;
    }
    else{
      sum += (a + t) - t_n;
    }
    t_n = a + t;
  }

  printf("%d\n", sum);

  return 0;
}


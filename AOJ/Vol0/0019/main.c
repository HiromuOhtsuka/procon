#include <stdio.h>
#define KETA 64
#define N (KETA/4+1)


short ans[N];

void mul(short n, short num[N], short s[N]);
void factorial(int n);

int main(void){
  int n, i, count=0;

  scanf("%d", &n);
  factorial(n);

  for(i=0;i<N;i++){
    if(ans[i])
      count++;
    if(count==1){
      printf("%d", ans[i]);
      count++;
    }
    else{
      if(count>2)
        printf("%04d", ans[i]);
    }
  }
  putchar('\n');

  return 0;
}

void mul(short n, short num[N], short s[N]){
  int i;
  long l, cy=0;
  for(i=N-1;i>=0;i--){
    l=num[i];
    s[i]=(n*l+cy)%10000;
    cy=(n*l+cy)/10000;
  }
}

void factorial(int n){
  int i;

  if(n==1){
    for(i=0;i<N;i++){
      ans[i]=0;
    }
    ans[N-1]=1;
  }
  else{
    factorial(n-1);
  }
  mul(n, ans, ans);
}

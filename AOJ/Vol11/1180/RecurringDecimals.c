#include <stdio.h>

#define MAX_L 6
#define MAX_I 20

int transrate(char a[], int digit){
  int i, ans = 0, w = 1;
  for(i = 0; i<digit; i++){
    ans += a[i]*w;
    w *= 10;
  }
  return ans;
}


int aiPlusOne(int ai, int digit){
  char num[MAX_L] = {0}, num_sub[MAX_L] = {0};
  int i, aMax, aMin, k;
  for(i = 0; i<digit; i++){
    int w = ai%10;
    int k = i;
    while(k-1 >= 0 && num[k-1] > w){
      num[k] = num[k-1];
      k--;
    }
    num[k] = w;
    ai /= 10;
  }
  aMax = transrate(num, digit);
  for(i = 0; i<digit; i++){
    num_sub[i] = num[digit-i-1];
  }
  aMin = transrate(num_sub, digit);

  return aMax - aMin;
}

int main(void){
  int a, a0, digit, i, j, k, w[MAX_I], flag;

  for(;;){
    scanf("%d %d", &a0, &digit);
    if(a0 == 0 && digit == 0){
      break;
    }
    i = 1;
    w[0] = a = a0;
    for(;;){
      a = aiPlusOne(a, digit);
      flag = 0;
      for(j=0; j<i; j++){
        if(a == w[j]){
          flag = 1;
          break;
        }
      }
      if(flag){
        break;
      }
      w[i++] = a;
    }
    printf("%d %d %d\n", j, a, i-j);
  }
  return 0;
}


#include <stdio.h>

#define MaxX 10000
#define MinX -10000
#define MaxY 10000
#define MinY -10000
#define MaxN 128
#define MaxM 16

struct PolygonalLine{
  int x[MaxM], y[MaxM];
  int num;
};

struct PolygonalLine move(struct PolygonalLine a, int num);
struct PolygonalLine spin(struct PolygonalLine a);
int check(struct PolygonalLine a, struct PolygonalLine b);

int main(void){
  struct PolygonalLine N[MaxN], sub, ori;
  int n, m, i, j, k, x, y, ans[MaxM], s, temp;

  for(;;){
    scanf("%d", &n);
    if(n==0)
      break;
    s=0;
    for(i=0;i<=n;i++){
      scanf("%d", &m);
      N[i].num=m;
      for(j=0;j<m;j++){
        scanf("%d %d", &N[i].x[j], &N[i].y[j]);
      }
    }
    ori=move(N[0], 0);
    for(i=1;i<=n;i++){
      for(k=0;k<N[i].num;k++){
        sub=move(N[i], k);
        for(j=0;j<4;j++){
          if(check(ori, sub)){
            ans[s++]=i;
          }
          sub=spin(sub);
        }
      }
    }
    //sort
    for(i=0;i<s;i++){
      for(j=0;j<s-i-1;j++){
        if(ans[j]>ans[j+1]){
          temp=ans[j];
          ans[j]=ans[j+1];
          ans[j+1]=temp;
        }
      }
    }
    for(i=0;i<s;i++){
      printf("%d\n", ans[i]);
    }
    printf("+++++\n");
  }

  return 0;
}
//(0, 0)
struct PolygonalLine move(struct PolygonalLine a, int num){
  struct PolygonalLine ans;
  int i;

  ans.num=a.num;
  for(i=0;i<a.num;i++){
    ans.x[i]=a.x[i]-a.x[num];
    ans.y[i]=a.y[i]-a.y[num];
  }
  return ans;
}
//90 or 180 or 270
struct PolygonalLine spin(struct PolygonalLine a){
  int temp, i;

  for(i=0;i<a.num;i++){
    temp=a.x[i];
    a.x[i]=-a.y[i];
    a.y[i]=temp;
  }

  return a;
}

int check(struct PolygonalLine a, struct PolygonalLine b){
  int flag, i;

  if(a.num==b.num){
    flag=1;
    for(i=0;i<a.num;i++){
      if(flag){
        if(a.x[i]==b.x[i] && a.y[i]==b.y[i]){
          flag=1;
        }
        else{
          flag=0;
        }
      }
    }
    if(flag)
      return 1;
    flag=1;
    for(i=0;i<a.num;i++){
      if(flag){
        if(a.x[i]==b.x[a.num-i-1] && a.y[i]==b.y[a.num-i-1]){
          flag=1;
        }
        else{
          flag=0;
        }
      }
    }
    if(flag)
      return 1;
  }

  return 0;
}

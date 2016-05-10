#include <stdio.h>
#include <string.h>

int Dtable[2][4]={{'m', 'c', 'x', 'i'}, {1000, 100, 10, 1}};
int Ntable[2][9]={{'2', '3', '4', '5', '6', '7', '8', '9'}, {2, 3, 4, 5, 6, 7, 8, 9}};

int TRtoDigit(char str[]);
void TRtoMCXI(int num, char ans[]);

int main(void){
  int n, a, b, ans, i;
  char str1[16], str2[16], kai[16];

  scanf("%d", &n);
  for(i=0;i<n;i++){
    scanf("%s %s", str1, str2);
    a=TRtoDigit(str1);
    b=TRtoDigit(str2);
    ans=a+b;
    TRtoMCXI(ans, kai);
    printf("%s\n", kai);
  }

  return 0;
}

int TRtoDigit(char str[]){
  char ch, flag;
  int len=strlen(str), i, j, num=1, let, ans=0;

  for(i=0;i<len;i++){
    ch=str[i];
    flag=0;
    for(j=0;j<9;j++){
      if(ch==Ntable[0][j]){
        num=Ntable[1][j];
        flag=1;
        break;
      }
    }
    if(flag){
      continue;
    }
    for(j=0;j<4;j++){
      if(ch==Dtable[0][j]){
        let=Dtable[1][j];
        break;
      }
    }
    ans+=num*let;
    num=1;
  }

  return ans;
}

void TRtoMCXI(int num, char ans[]){
  int i, j, k, sub=num;

  for(i=0, j=0;i<4;i++){
    if(sub/Dtable[1][i]>=1){
      if(sub/Dtable[1][i]==1){
        ans[j++]=Dtable[0][i];
        sub%=Dtable[1][i];
      }
      else{
        for(k=0;k<9;k++){
          if(Ntable[1][k]==(sub/Dtable[1][i])){
            ans[j++]=Ntable[0][k];
            ans[j++]=Dtable[0][i];
            sub%=Dtable[1][i];
            break;
          }
        }
      }
    }
  }
  ans[j]=0;
}

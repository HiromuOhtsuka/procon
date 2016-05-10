#include <stdio.h>
#include <string.h>

#define TextSize 128
int table[3][256];

void shift(int n, char *str);

int main(void){
  char text[TextSize], *keyw[3]={"the", "this", "that"}, w[TextSize], *ptr;
  int i, j, k, text_len, key_len[3], flag;

  for(i=0;i<3;i++){
    key_len[i]=strlen(keyw[i]);
    for(j=0;j<256;j++){
      table[i][j]=key_len[i];
    }
    for(j=0;j<key_len[i]-1;j++){
      table[i][keyw[i][j]]=key_len[i]-j-1;
    }
  }
  while(gets(text)!=NULL){
    text_len=strlen(text);
    for(i=0;i<26;i++){
      strcpy(w, text);
      shift(i, w);
      for(j=0;j<3;j++){
        flag=0;
        ptr=w+key_len[j]-1;
        while(ptr<w+text_len){
          if(*ptr==keyw[j][key_len[j]-1]){
            if(strncmp(ptr-key_len[j]+1, keyw[j], key_len[j])==0){
              flag=1;
              goto end;
            }
          }
          ptr=ptr+table[j][*ptr];
        }
      }
    }
end: if(flag)printf("%s\n", w);
  }
  return 0;
}

void shift(int n, char *str){
  int len=strlen(str), i, j;

  for(i=0;i<len;i++){
    if(str[i]<'a' || str[i]>'z')
      continue;
    if(str[i]+n<='z')
      str[i]+=n;
    else
      str[i]=str[i]+n-'z'+'a'-1;
  }
}

#include <stdio.h>
#define MAX 10

struct Mass {
  int is;
  struct Mass *represent;
};

void merge(struct Mass *m1, struct Mass *m2);
void partion(struct Mass *m1, struct Mass *m2);
struct Mass *getRepresent(struct Mass *m);
void setReperesent(struct Mass *m);
void paint(struct Mass ms[], int w, int h, int x, int y);
void repaint(struct Mass ms[], int w, int h, int x, int y);
int count_island(struct Mass ms[], int w, int h);

int main(void){
  int i, j, c, flag;
  struct Mass table[1 + MAX + 1][1 + MAX + 1];

  // initial
  for(i=0; i< 1 + MAX + 1; ++i){
    table[i][0].is = table[0][i].is = 0;
    table[i][0].represent = table[0][i].represent = NULL;
  }

  // scan
  for(i=1; i<=MAX; ++i){
    for(j=1; j<=MAX; ++j){
      scanf("%c", &c);
      table[i][j].is = (c == 'o') ? 1 : 0;
      table[i][j].represent = NULL;
    }
  }

  // merge
  for(i=1; i<=MAX; ++i){
    for(j=1; j<=MAX; ++j){
      if(table[i][j].is){
        if(table[i-1][j].is){
          merge(&table[i][j], &table[i-1][j]);
        }
        if(table[i+1][j].is){
          merge(&table[i][j], &table[i+1][j]);
        }
        if(table[i][j-1].is){
          merge(&table[i][j], &table[i][j-1]);
        }
        if(table[i][j+1].is){
          merge(&table[i][j], &table[i][j+1]);
        }
      }
    }
  }

  // search
  flag = 0;
  for(i=0; i<MAX; ++i){
    for(j=0; j<MAX; ++j){
      if(!table[i][j].is){
        // paint
        if(table[i-1][j].is){
          merge(&table[i-1][j], &table[i][j]);
        }
        if(table[i+1][j].is){
          merge(&table[i+1][j], &table[i][j]);
        }
        if(table[i][j-1].is){
          merge(&table[i][j-1], &table[i][j]);
        }
        if(table[i][j+1].is){
          merge(&table[i][j+1], &table[i][j]);
        }
        table[i][j].is = 1;
        if(count_island == 1){
          flag = 1;
        }
        else{
          // repaint
          if(table[i-1][j].is){
            partion(&table[i-1][j], &table[i][j]);
          }
          if(table[i+1][j].is){
            partion(&table[i+1][j], &table[i][j]);
          }
          if(table[i][j-1].is){
            partion(&table[i][j-1], &table[i][j]);
          }
          if(table[i][j+1].is){
            partion(&table[i][j+1], &table[i][j]);
          }
          table[i][j].is = 0;
        }
      }
      if(flag){
        break;
      }
    }
  }

  if(flag){
    printf("YES\n");
  }
  else{
    printf("NO\n");
  }

  return 0;


}

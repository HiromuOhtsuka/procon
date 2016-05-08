#include <cstdio>
using namespace std;

static bool is_fourcard(const int hand[]);
static bool is_fullhouse(const int hand[]);
static bool is_stright(const int hand[]);
static bool is_threecard(const int hand[]);
static bool is_twopair(const int hand[]);
static bool is_onepair(const int hand[]);

int main(){
  int hand[5];
  while(true){
    if(scanf("%d,%d,%d,%d,%d",
          &hand[0], &hand[1], &hand[2], 
          &hand[3], &hand[4]) == EOF){
      return 0;
    }
    for(int i = 0; i < 5; i++){
      --hand[i];
      int w = hand[i], k = i;
      while(k - 1 >= 0 && hand[k - 1] > w){
        hand[k] = hand[k - 1];
        k--;
      }
      hand[k] = w;
    }
    if(is_fourcard(hand)){
      printf("four card\n");
    }
    else if(is_fullhouse(hand)){
      printf("full house\n");
    }
    else if(is_stright(hand)){
      printf("straight\n");
    }
    else if(is_threecard(hand)){
      printf("three card\n");
    }
    else if(is_twopair(hand)){
      printf("two pair\n");
    }
    else if(is_onepair(hand)){
      printf("one pair\n");
    }
    else{
      printf("null\n");
    }
  }
}

static bool is_fourcard(const int hand[]){
  int count = 0;
  for(int i = 0; i < 5; i++){
    for(int j = i + 1; j < 5; j++){
      for(int k = 0; k < 5; k++){
        if(k == i || k == j){
          continue;
        }
        for(int l = 0; l < 5; l++){
          if(l == i || l == j || l == k){
            continue;
          }
          if(hand[i] == hand[j] && hand[j] == hand[k] && hand[k] == hand[l]){
            ++count;
          }
        }
      }
    }
  }
  return count >= 1;
}

static bool is_fullhouse(const int hand[]){
  int count = 0, t1, t2, t3;
  for(int i = 0; i < 5; i++){
    for(int j = i + 1; j < 5; j++){
      for(int k = 0; k < 5; k++){
        if(k == i || k == j){
          continue;
        }
        if(hand[i] == hand[j] && hand[j] == hand[k]){
          t1 = i; t2 = j; t3 = k;
          ++count;
        }
      }
    }
  }
  if(count == 0){
    return false;
  }
  for(int i = 0; i < 5; i++){
    for(int j = i + 1; j < 5; j++)
      if(i != t1 && i != t2 && i != t3
          && j != t1 && j != t2 && j != t3){
        return hand[i] == hand[j];
      }
  }
  return false;
}

static bool is_stright(const int hand[]){
  // sorted
  if(hand[4] == 12){
    if(hand[0] == 0 &&
      hand[2] == hand[1] + 1 &&
      hand[3] == hand[2] + 1 &&
      hand[4] == hand[3] + 1){
      return true;
    }
  }
  return hand[1] == hand[0] + 1 &&
    hand[2] == hand[1] + 1 &&
    hand[3] == hand[2] + 1 &&
    hand[4] == hand[3] + 1;
}

static bool is_threecard(const int hand[]){
  int count = 0;
  for(int i = 0; i < 5; i++){
    for(int j = i + 1; j < 5; j++){
      for(int k = 0; k < 5; k++){
        if(k == i || k == j){
          continue;
        }
        if(hand[i] == hand[j] && hand[j] == hand[k]){
          ++count;
        }
      }
    }
  }
  return count >= 1;
}
static bool is_twopair(const int hand[]){
  int count = 0;
  for(int i = 0; i < 5; i++){
    for(int j = i + 1; j < 5; j++){
      if(hand[i] == hand[j]){
        ++count;
      }
    }
  }
  return count == 2;
}
static bool is_onepair(const int hand[]){
  int count = 0;
  for(int i = 0; i < 5; i++){
    for(int j = i + 1; j < 5; j++){
      if(hand[i] == hand[j]){
        ++count;
      }
    }
  }
  return count == 1;
}


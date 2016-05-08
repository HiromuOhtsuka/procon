#include <cstdio>
using namespace std;

int main(){
  while(true){
    int p;
    scanf("%d", &p);
    if(p == 0){
      return 0;
    }
    p = 1000 - p;
    int count = 0;
    if(p - 500 >= 0){
      count++;
      p -= 500;
    }
    while(p - 100 >= 0){
      count++;
      p -= 100;
    }
    while(p - 50 >= 0){
      count++;
      p -= 50;
    }
    while(p - 10 >= 0){
      count++;
      p -= 10;
    }
    while(p - 5 >= 0){
      count++;
      p -= 5;
    }
    count += p;

    printf("%d\n", count);
  }

  return 0;
}

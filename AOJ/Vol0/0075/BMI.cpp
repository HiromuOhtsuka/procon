#include <cstdio>
using namespace std;

int main(){
  while(true){
    int n;
    double w, l;
    if(scanf("%d,%lf,%lf", &n, &w, &l) == EOF){
      return 0;
    }
    double bmi = w / (l * l);
    if(bmi >= 25.0){
      printf("%d\n", n);
    }
  }
  return 0;
}

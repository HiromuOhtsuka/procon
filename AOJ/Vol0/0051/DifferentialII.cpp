#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <functional>
using namespace std;

int main(){
  int n;
  char str[9];

  scanf("%d", &n);
  for(int i = 0; i < n; i++){
    scanf("%s", str);
    sort(str, str + 8);
    int min = atoi(str);
    sort(str, str + 8, greater< int >());
    int max = atoi(str);
    printf("%d\n", max - min);
  }

  return 0;
}

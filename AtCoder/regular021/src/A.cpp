#include <iostream>
using namespace std;

int N;
int t[9];
int m;
int sum;
bool done;
void search(int i);

int main(){
  cin >> N;

  search(1);

  if(done){
    for(int i = 0; i < 9; i++){
      if(t[i]){
        ++m;
      }
    }

    cout << m << endl;
    for(int i = 0; i < 9; i++){
      if(t[i]){
        for(int j = 0; j < t[i]; j++){
          cout << i << endl;
        }
      }
    }

  }

  return 0;
}

void search(int i){
  if(sum == N){
    done = true;
    return;
  }

  if(sum > N){
    sum = 0;
    return;
  }

  for(; !done && i <= 8; i <<= 1){
    for(int k = 0; !done && k <= N / i; k++){
      sum += i * k;
      t[i] = k;
      search(i << 1);
      if(!done){
        t[i] = 0;
      }
    }
  }

}


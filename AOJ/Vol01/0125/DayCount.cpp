#include <iostream>
using namespace std;

class Date {
  public:
    int y, m, d;

    Date(){}
    Date(int y, int m, int d){
      this->y = y;
      this->m = m;
      this->d = d;
    }

    static int cday(int y, int m){
      switch(m){
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
          return 31;
        case 2:
          if(urue(y)){
            return 29;
          }
          else{
            return 28;
          }
        default:
          return 30;
      }
    }

    static bool urue(int y){
      if(y % 4 != 0){
        return false;
      }
      if(y % 100 == 0 && y % 400 != 0){
        return false;
      }
      return true;
    }
};

Date day1, day2;

int main(){
  for(;;){
    int y1, m1, d1, y2, m2, d2;
    cin >> y1 >> m1 >> d1 >> y2 >> m2 >> d2;
    if(y1 == -1){
      return 0;
    }
    day1 = Date(y1, m1, d1);  day2 = Date(y2, m2, d2);

    int sum = 0;
    if(day1.y == day2.y && day1.m == day2.m){
      sum = day2.d - day1.d;
    }
    else{
      sum += Date::cday(day1.y, day1.m) - day1.d;
      sum += day2.d;
      for(int i = day1.y; i <= day2.y; i++){
        int j = (i == day1.y) ? day1.m + 1 : 1,
            n = (i == day2.y) ? day2.m - 1 : 12;
        for(; j <= n; j++){
          sum += Date::cday(i, j);
        }
      }
    }

    cout << sum << endl;
  }

  return 0;
}

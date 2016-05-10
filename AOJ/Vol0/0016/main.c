#include <stdio.h>
#include <math.h>

int main(void){
  double x, y, l, angle, radian;

  x=y=0.0; angle=90.0;
  do{
    scanf("%lf,", &l);
    radian+=angle*M_PI/180.0;
    x+=l*cos(radian); y+=l*sin(radian);
    scanf("%lf", &angle);
    angle=-angle;
  }while(l!=0.0 && angle!=0.0);

  printf("%d\n%d\n", (int)x, (int)y);

  return 0;
}

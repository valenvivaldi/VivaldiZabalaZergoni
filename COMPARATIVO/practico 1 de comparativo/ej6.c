#include <stdio.h>
extern int y;
extern void inc_y(); 
int main(void){
	y=1;
	inc_y();
	printf("%d\n",y);
}

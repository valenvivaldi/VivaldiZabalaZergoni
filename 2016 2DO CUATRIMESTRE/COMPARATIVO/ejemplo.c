#include <stdio.h>
#define Pi 3.14

float  circle_area(float r){
	return Pi*(r*r);
}

int main (void){
	float result;
	result = circle_area(10.0);
	printf("Area:%f\n",result );
	return 0;



}
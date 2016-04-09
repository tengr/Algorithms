#include <stdio.h>
#include <time.h>
#define MAX 1000000000
int main(){
	clock_t begin, end;
	double time_spent;

	begin = clock();
	/* here, do your time-consuming job */
	int sum = 0, i = 0;
	for(i = 0;i < MAX; i++){
		sum += i;
	}

	end = clock();
	time_spent = (double)(end - begin) / CLOCKS_PER_SEC;
	//time_spent = (double)(end - begin);
	printf("time_spent = %lfs\n", time_spent);

}
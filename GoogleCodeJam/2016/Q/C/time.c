#include <stdio.h>
#include <time.h>
#include <string.h>
#include <stdlib.h>
#define MAX 1000000000
int main(){
	// clock_t begin, end;
	// double time_spent;

	// begin = clock();
	// /* here, do your time-consuming job */
	// int sum = 0, i = 0;
	// for(i = 0;i < MAX; i++){
	// 	sum += i;
	// }

	// end = clock();
	// time_spent = (double)(end - begin) / CLOCKS_PER_SEC;
	// //time_spent = (double)(end - begin);
	// printf("time_spent = %lfs\n", time_spent);
	// char s[2] = "ab";
	// s[2] = '\0';
	// printf("%ld\n", strlen(s));
	char *tmp[10];
	int i = 0, j = 0;
	for(j = 0; j < 10; j++) {
		tmp[j] = malloc(20 * sizeof(char));
		for(i = 99; i < 120; i++) sprintf(tmp[j] + strlen(tmp[j]), " %d", i);
	}
	for(j = 0; j < 10; j++) printf("%s", tmp[j]);
}
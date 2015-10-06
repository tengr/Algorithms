#include<stdio.h>
void print_arrays(int *a, int len);
void print_arrays2(int a[][5], int len1, int len2);

int main(){
	int test[3];
	int i = 0;
	for (i = 0; i < 3; i++){
		test[i] = i;
	}
	int test2[3][5];
	int j = 0;
	for(i = 0; i < 3; i++){
		for(j = 0; j < 5; j++){
			test2[i][j] = 10 * i + j;
		}
	}
	print_arrays2(test2,3,5);

	//printf("%lf\n",3.0/0.0);
}

void print_arrays(int *a, int len){
	int i = 0;
	for (i = 0; i < len; i++){
		printf("%d\n",a[i]);
	}
}

void print_arrays2(int a[][5], int len1, int len2){
	int i = 0,j = 0;
	for(i = 0; i < len1; i++){
		for(j = 0; j < len2; j++){
			printf("%d\n",a[i][j]);
		}
	}
}
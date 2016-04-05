#include <stdio.h>
#include <time.h>

int fib[1000] = {0};

int ways(int n){
	//f(n) = f(n - 1) + f(n - 2)
	if (n == 0) return 1;
	if (n == 1) return 1;
	int fn_1 = 1, fn_2 = 1;
	int f_n, i;
	for(i = 1; i < n; i++){
		f_n = fn_1 + fn_2;
		fn_2 = fn_1;
		fn_1 = f_n;
	}
	return f_n;
}

int ways2(int n){
	if (fib[n] != 0) return fib[n];
	int i = 0;
	fib[0] = 1, fib[1] = 1;

	for(i = 2; i < 1000; i++){
		fib[i] = fib[i - 1] + fib[i - 2];
	}
	return fib[n];
}

int main(){
	int i;

	clock_t begin, end;
	double time_spent;

	begin = clock();
	for (i = 0; i < 10; i++)
		printf("%d ", ways(i));
	end = clock();
	time_spent = (double)(end - begin) / CLOCKS_PER_SEC;
	printf("%lf s\n", time_spent);
////////////////////////////////////////////////////////////
	begin = clock();

	for (i = 0; i < 10; i++)
		printf("%d ", ways2(i));

	end = clock();
	time_spent = (double)(end - begin) / CLOCKS_PER_SEC;
	printf("%lf ss\n", time_spent);

}
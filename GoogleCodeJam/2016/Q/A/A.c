#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
int nums[10] = {0};
int count = 0;

void check(long long N){
	//asumption: N > 0
	while(N > 0){
		int digit = N % 10;
		if (nums[digit] == 0) {
			nums[digit] = 1;
			count++;
		}
		N /= 10;
	}
}

void solve(long long N) {
	if(N == 0) {
		printf("INSOMNIA\n"); 
		return;
	}
	/*reset*/
	int i = 0;
	for(i = 0; i < 10; i++) nums[i] = 0;
	count = 0;
	/*reset*/
	long long  upper = LLONG_MAX / N;
	for(i = 1; ; i++){
		check(N * i);
		if(count == 10) {printf("%lld\n", N * i); return;}
	}
}


int main () {
	int T;
	long long N;
	scanf("%d", &T);
	//printf("INT_MAX = %d\n", INT_MAX);
	int t = 0;
	for(t = 0; t < T; t++) {
		printf("Case #%d: ", t + 1);
		scanf("%lld", &N);
		solve(N);
	}
	return 0;
}
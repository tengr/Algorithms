#include <stdio.h>
#include <stdlib.h>
#define MAX_N 200
long long nums[MAX_N + 1];
long long dp[MAX_N + 1][5000];

int mod(int a, int c){
	if (a < 0) a = -a;
	return a % c;
}

long long solve(long long * nums, int N, int M, int D){
	int MAX_SUM = 0, a[N + 1];
	int i, j, k;	
	for(i = 1; i <= N; i++) {
		a[i] = mod(nums[i], D);
		MAX_SUM += a[i];	
	} 

	for(i = 0; i <= N; i++){
		for(j = 0; j <= MAX_SUM; j++){
			dp[i][j] = 0;
		}
	}
	dp[0][0] = 1;

	for(i = 1; i <= N; i++){
		for(j = MAX_SUM; j >= a[i]; j--){
			//if it is possible to take item i
				//look at all the possible ways to generate sum j - nums[i]
			for(k = i - 1; k >= 0; k--) {
					if(dp[k][j - a[i]] > 0) /*there is some ways for k items to get sum j - nums[i] */{
						dp[k + 1][j] +=  dp[k][j - a[i]];
				}	
			}
		}
		// int p,q;
		// for(p = N; p >= 1; p--) printf("%d ", a[p]);
		// printf("\n");
		// for(p = N; p >= 0; p--)  printf("- ");
		// printf("\n");
		// for(q = 0; q <= 8; q++){
		// 	for(p = N; p >= 0; p--){
		// 		printf("%d ", dp[p][q]);
		// 	}
		// 	printf("[%d]\n", q);
		// }
		// printf("===========\n");
	}

	long long res = 0;
	for(j = 0; j <= MAX_SUM; j++) {
		if(j % D == 0) res += dp[M][j];
	}

	// for(i = N; i >= 1; i--) printf("%d ", a[i]);
	// printf("\n");
	// for(i = N; i >= 0; i--)  printf("- ");
	// printf("\n");
	// for(j = 0; j <= 8; j++){
	// 	for(i = N; i>= 0; i--){
	// 		printf("%d ", dp[i][j]);
	// 	}
	// 	printf("[%d]\n", j);
	// }

	//printf("%lld\n", res);
	return res;
}


int main () {

	int N, M, Q, D, n, q;
	int set = 0;

	while(1) {
		scanf("%d%d", &N, &Q);
		if(N == 0 && Q == 0) break;
		printf("SET %d:\n", ++set);
		for(n = 1; n <= N; n++) scanf("%lld", &(nums[n]));
		for(q = 1; q <= Q; q++) {
			int D,M;
			scanf("%d%d", &D, &M);
			printf("QUERY %d: %lld\n", q, solve(nums, N, M, D));
		}
	}

	return 0;
}
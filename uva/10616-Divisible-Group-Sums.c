#include <stdio.h>
#include <stdlib.h>
#define MAX_N 200
long long nums[MAX_N + 1];
long long dp[MAX_N + 1][5000];
long long ans[MAX_N + 1][21];
int mod(int a, int c){
	if (a < 0) a = -a;
	return a % c;
}

long long solve(long long * nums, int N, int M, int D){
	if (ans[M][D] >= 0) {
		//printf("ASDFASDFASdfas");
		return ans[M][D];
	}
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
		for(j = MAX_SUM; j >= 0; j--){
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
	int m = 0, sum = 0;
	for(m = 0; m <= N; m++){
		ans[m][D] = dp[m][0];
		for(sum = D; sum <= MAX_SUM; sum += D)
			ans[m][D] += dp[m][sum];
	}

	//res = dp[M][0] + dp[M][D];
	

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
	return ans[M][D];
}

void clear_ans(){
	int i, j;
	for(i = 0; i <= MAX_N; i++){
		for(j = 0; j <= 20; j++){
			ans[i][j] = -1;
		}
	}
}

int main () {

	int N, M, Q, D, n, q;
	int set = 0;

	while(1) {
		scanf("%d%d", &N, &Q);
		if(N == 0 && Q == 0) break;
		printf("SET %d:\n", ++set);
		for(n = 1; n <= N; n++) scanf("%lld", &(nums[n]));
		//memset(ans, 0, 201 * 21 *(sizeof(int)));
		clear_ans();
		for(q = 1; q <= Q; q++) {
			int D,M;
			scanf("%d%d", &D, &M);
			printf("QUERY %d: %lld\n", q, solve(nums, N, M, D));
		}
	}

	return 0;
}
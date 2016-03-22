#include <stdio.h>
#include <stdlib.h>

int max(int a, int b){
	return a > b ? a : b;
}

void solve(int * d, int * v, int N, int t, int w) {
	int dp[N + 1][t + 1], i, j;

	for(j = 0; j <= t; j++) dp[0][j] = 0; //no items
	for(i = 1; i <= N; i++) dp[i][0] = 0; //no capacity
	
	for(i = 1; i <= N; i++){
		for(j = 1; j <= t; j++){
			int time_left = j - 3 * w * d[i];
			if (time_left >= 0) dp[i][j] = max(dp[i - 1][j], dp[i - 1][time_left] + v[i]);
			else dp[i][j] = dp[i - 1][j];
		}
	}
	printf("%d\n", dp[N][t]);
	
	int taken[N + 1], count = 0;
	for(i = 0; i <= N; i++) taken[i] = 0;
	//printf("res = %d\n", dp[N][t]);
	for(i = N; i >= 1; i--){
		if (t - 3 * w * d[i] >= 0 && dp[i][t] != dp[i - 1][t]) {
			t -= 3 * w * d[i];
			taken[i] = 1;
			count += 1;
		}
	}
	//printf("res becomes %d\n", dp[N][t]);
	printf("%d\n", count);
	
	for(i = 1; i <= N; i++) {
		if(taken[i] == 1)
		printf("%d %d\n", d[i], v[i]);	
	}
}

int main () {
	int t, w, N;
	if(scanf("%d%d%d", &t, &w, &N) == EOF) return 0;
	while(1){
		int d[N + 1], v[N + 1];		
		int i = 0;
		for(i = 1; i <= N; i++) scanf("%d%d", &(d[i]), &(v[i]));
		solve(d, v, N, t, w);
		if(scanf("%d%d%d", &t, &w, &N) == EOF) break;
		else printf("\n");
	}
	return 0;
}
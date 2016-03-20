#include <stdio.h>
#include <stdlib.h>
#define MAX_CAP 30
int answer[MAX_CAP + 1];
int max(int a, int b){
	return a > b ? a : b;
}

void solve(int p[], int w[], int N) {
	int dp[N + 1][MAX_CAP + 1];
	int i = 0,j = 0;
	for(j = 0; j <= MAX_CAP; j++) dp[0][j] = 0;
	
	for(i = 1; i <= N; i++) {
		for(j = 0; j <= MAX_CAP; j++) {
			dp[i][j] = max(dp[i - 1][j], j - w[i] >= 0 ? dp[i - 1][j - w[i]] + p[i] : 0);
			//printf("%d ", dp[i][j]);
		}
		//printf("\n");
	}
	//printf("stop");
	// answer [MAX_CAP + 1];
	for(j = 0; j <= MAX_CAP; j++) {
		answer[j] = dp[N][j];
	}
	return;
}

int main () {
	int T;
	scanf("%d", &T);
	
	int t = 0, n = 0, g = 0;
	for(t = 0; t < T; t++) {
		int N, G;
		scanf("%d", &N);
		int p[N + 1], w[N + 1];
		for(n = 1; n <= N; n++) {
			scanf("%d%d", &(p[n]), &(w[n]));
		}
		scanf("%d", &G);
		//printf("G = %d\n", G);
		solve(p, w, N);
		//printf("answer received\n");
		int ans = 0;
		for(g = 0; g < G; g++) {
			int MW;
			scanf("%d", &MW);
			//printf("MW = %d\n", MW);
			ans += answer[MW];
		}
		printf("%d\n", ans);
		// for(n = 0; n < 31; n++)
		// 	printf("%d ", answer[n]);
		// printf("case %d\n", t);
	}
	return 0;
}
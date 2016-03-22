#include <stdio.h>
#include <stdlib.h>
#define MAX_M 100
#define MAX_SUM 50000
int dp[MAX_M + 1][MAX_SUM + 1];

int max(int a, int b){
	return a > b ? a : b;
}
int abs(int a){
	if (a < 0) return -a;
	return a;
}
void solve(int * c, int m, unsigned int sum){
	int cap = (int) ((sum + 1) / 2); 
	int i, j;

	for(j = 0; j <= cap; j++) dp[0][j] = 0; //no items
	for(i = 0; i <= m; i++) dp[i][0] = 0; //no capacity
	
	for(i = 1; i <= m; i++){
		for(j = 1; j <= cap; j++){
			if(j - c[i] >= 0)
				dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - c[i]] + c[i]);
			else dp[i][j] = dp[i - 1][j];
		}
		if(dp[i][cap] == cap) {
			printf("%d\n", sum % 2 == 0 ? 0 : 1);
			return;
		}
	}
	//printf("%d", dp[m][cap]);
	//dp[m][cap] = 0;
	printf("%d\n", abs((int)(sum - 2 * dp[m][cap])) );
}

int main () {
	int n, i;
	scanf("%d", &n);
	for(i = 0; i < n; i++){
		int m;
		scanf("%d", &m);
		int c[m + 1], j;
		unsigned int sum = 0;
		for(j = 1; j <= m; j++) {
			scanf("%d", &(c[j]));
			sum += c[j];
		}
		solve(c, m, sum);
		//printf("0\n");}
	}


	return 0;
}
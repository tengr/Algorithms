#include <stdio.h>
#include <stdlib.h>
#define MAX_SUM 7489
int dp[6][MAX_SUM + 1];

void solve(){
	int c[6] = {0, 50, 25, 10, 5, 1};
	int i, j;

	for(i = 0; i <= 5; i++) dp[i][0] = 1; //one way to generate zero sum
	for(j = 1; j <= MAX_SUM; j++) dp[0][j] = 0; //no coins

	for(i = 1; i <= 5; i++){
		for(j = 1; j <= MAX_SUM; j++){
			if(j - c[i] >= 0)
				dp[i][j] = dp[i - 1][j] + dp[i][j - c[i]];
			else dp[i][j] = dp[i - 1][j];
		}
	}
}

int main () {
	int money;
	solve();
	while(1){
		if(scanf("%d", &money) == EOF) break;
		if(money < 0) printf("0\n");
		else if(money == 0) printf("1");
		else printf("%d\n", dp[5][money]);
	}

	return 0;
}
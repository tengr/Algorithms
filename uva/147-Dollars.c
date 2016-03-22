#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_LEN 100
#define MAX_SUM 6000
#define DIVISOR 5
#define CENTS_IN_DOLLAR 100
#define NUM_COIN 11
long dp[NUM_COIN + 1][MAX_SUM + 1];
char s[MAX_LEN];
void solve(){
	int c[] = {0, 
				100 * CENTS_IN_DOLLAR / DIVISOR, 50 * CENTS_IN_DOLLAR / DIVISOR, 
				20 * CENTS_IN_DOLLAR / DIVISOR, 10 * CENTS_IN_DOLLAR / DIVISOR, 
				5 * CENTS_IN_DOLLAR / DIVISOR, 2 * CENTS_IN_DOLLAR / DIVISOR, 
				1 * CENTS_IN_DOLLAR / DIVISOR, 
				50 / DIVISOR, 20 / DIVISOR, 10 / DIVISOR, 5 / DIVISOR };
	int i, j;

	for(i = 0; i <= NUM_COIN; i++) dp[i][0] = 1; //one way to generate zero sum
	for(j = 1; j <= MAX_SUM; j++) dp[0][j] = 0; //no coins

	for(i = 1; i <= NUM_COIN; i++){
		//printf("c = %d", c[i]);
		for(j = 1; j <= MAX_SUM; j++){
			if(j - c[i] >= 0)
				dp[i][j] = dp[i - 1][j] + dp[i][j - c[i]];
			else dp[i][j] = dp[i - 1][j];
		}
	}
}

int main () {
	solve();
	while(1){
		int i = 0, num = 0, num_int = 0, num_frac = 0;
		scanf("%s", s);
		for(i = 0; i < strlen(s); i++){
			if (s[i] != '.') num_int = num_int * 10 + (s[i] - '0');
			else break;
		}
		if (i + 1 < strlen(s)) num_frac = num_frac * 10 + (s[i + 1] - '0');
		if (i + 2 < strlen(s)) num_frac = num_frac * 10 + (s[i + 2] - '0');
		if(num_frac % 5 != 0) num_frac *= 10;
		int sum = (num_int * CENTS_IN_DOLLAR + num_frac) / DIVISOR;
		//printf("sum = %d\n", sum);
		if(sum == 0) break;
		else {
			printf("%6.2f%17lu\n", (float)sum * DIVISOR / CENTS_IN_DOLLAR, dp[NUM_COIN][sum]);
		}
	}

	return 0;
}
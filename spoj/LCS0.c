//LCS0 - Longest Common Subsequence
#include <stdio.h>
#include <string.h>
#define MAXLEN 50000 
#define MAX(a,b) a > b ? a : b
char a[MAXLEN], b[MAXLEN];
int score[MAXLEN][MAXLEN] = {0};
void solve(){
	int i = 0, j = 0;
	int lenA = strlen(a), lenB = strlen(b);
	for(;i < lenA; i++) {
		for(;j < lenB; j++) {
			;
		}
	}
	printf("%ld", MAX(strlen(a), strlen(b)));
}
int main(){
	scanf("%s", a);
	scanf("%s", b);
	solve();
}
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <string.h>
#define MAXLEN 200
char s[MAXLEN];

//-+ => - 1
//+- => 1 + (-+) => 2
//-+- => +-- => ++- => --- => +++
//-+- => +-+ => 1 + (+-) 3
//-+-+- => +-+-+ => -+-++ => 2 + (-+-) = 5
//+-+- => -+-+ => 1 + (-+-) => 4

void solve(){
	int i = 0;
	int num = 1;
	if(s[0] == '+') num = 0; 
	for(i = 1; i < strlen(s); i++){
		if(s[i] != s[i - 1] && s[i] == '-') num++;
	}
	if(s[0] == '+') num *= 2;
	else num = num * 2 - 1;
	printf("%d\n", num);
}


int main () {
	int T;
	scanf("%d", &T);
	int t = 0;
	for(t = 0; t < T; t++) {
		printf("Case #%d: ", t + 1);
		scanf("%s", s);
		solve();
	}
	return 0;
}
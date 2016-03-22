#include <stdio.h>
#define max(a, b) a > b ? a : b
void solve(int * a, int N){
	long max_so_far = 0;
	long sum = 0;
	int i = 0;
	for(i = 0; i < N; i++){
		if (max_so_far >= 0) max_so_far += a[i];
		else max_so_far = a[i];
		sum = max(sum, max_so_far);
	}
	if(sum == 0) printf("Losing streak.\n");
	else printf("The maximum winning streak is %ld.\n", sum);
}

int main(){
	while(1) {
		int N, i;
		scanf("%d", &N);
		if(N == 0) break;
		int a[N];
		for(i = 0; i < N; i++) scanf("%d", &(a[i]));
		solve(a, N);
	}
	return 0;
}
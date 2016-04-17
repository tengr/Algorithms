#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_N 1000
#define MAX_M 2000
#define INF 2000
int e[MAX_M] = {INF};
int from[MAX_M], to[MAX_M];

void solve(int n, int m){
	int i, j, k;

	for(k = 0; k < n; k++){
		int dist[MAX_N]; //distance from k
		for(i = 0; i < n; i++) dist[i] = INF;	
		dist[k] = 0;
		for(i = 0; i < n; i++){
			//int ii;
			//for(ii = 0; ii < n; ii++) printf("%d ", dist[ii]);
			//printf("\n");
			for(j = 0; j < m; j++){
				if (dist[from[j]] + e[j] < dist[to[j]])
					dist[to[j]] = dist[from[j]] + e[j]; 
			}
		}


		for(j = 0; j < m; j++){
			if (dist[from[j]] + e[j] < dist[to[j]]){
				printf("possible\n");
				return;
			}
		}

	}

	printf("not possible\n");

}


int main () {

	int c, n, m;
	scanf("%d", &c);
	while(c--) {
		scanf("%d%d", &n, &m);
		int i = 0;
		for(i = 0; i < m; i++){
			scanf("%d%d%d", &(from[i]), &(to[i]), &(e[i]));
		}
		//printf("%d %d\n", n, m);
		solve(n, m);
	}

	return 0;
}
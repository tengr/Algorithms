#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_N 100 + 1
#define MAX_M 100100
#define INF 20000
int e[MAX_M];
int nb[MAX_N + 1][MAX_N + 1] = {0};
int from[MAX_M], to[MAX_M];
int visited[MAX_N + 1] = {0};

void dfs(int n, int node){
	int j;
	if(visited[n] || visited[node]) return;
	visited[node] = 1;
	for(j = 0; j < n; j++){
		if(nb[node][j] == 0) return;
		else if(!visited[nb[node][j]]){
			dfs(n, nb[node][j]);
		}
	}
}

void solve(int n, int m, int * energy){
	int i, j, k;
	int dist[MAX_N]; //distance from k
	for(i = 1; i <= n; i++) dist[i] = 0;	
	dist[1] = 100;
	for(i = 1; i <= n; i++){
		// int ii;
		// for(ii = 1; ii <= n; ii++) printf("dist = %d ", dist[ii]);
		// printf("\n");
		for(j = 0; j < m; j++){
			if (dist[from[j]] > 0 && dist[from[j]] + e[j] > dist[to[j]])
				dist[to[j]] = dist[from[j]] + e[j]; 
		}
	}


	for(j = 0; j < m; j++){
		if (dist[from[j]] > 0 && dist[from[j]] + e[j] > dist[to[j]]){
			memset(visited, 0, sizeof(visited));
			dfs(n, to[j]);
			if(visited[n]) {
				printf("winnable\n");
				return;
			}
		}
	}

	if(dist[n] <= 0) printf("hopeless\n");
	else {
		// reachable = 0;
		// bfs(n, 100, 0, energy);
		// if(reachable == 0) printf("hopeless\n");
		// else printf("winnable\n");
		printf("winnable\n");
	}

}


//void solve()

// 5
// 0 1 2 -60 1 3 -60 1 4 20 1 5 0 0
// 5
// 0 1 2
// 20 1 3 -60 1 4 -60 1 5 0 0
// 5
// 0 1 2
// 21 1 3 -60 1 4 -60 1 5 0 0
// 5
// 0 1 2
// 20 2 1 3 -60 1 4 -60 1 5 0 0
// -1


int main () {

	while(1) {
		int n;
		scanf("%d", &n);
		if(n == -1) break;
		int energy[n + 1];
		int i, edge_num = 0;
		memset(nb, 0, sizeof(nb));
		memset(e, 0, sizeof(e));
		memset(energy, 0, sizeof(energy));
		for(i = 1; i <= n; i++){
			scanf("%d", &(energy[i]));
			int doors, j;
			scanf("%d", &doors);
			for(j = 0; j < doors; j++){
				from[edge_num] = i;
				scanf("%d", &(to[edge_num]));
				nb[i][j] = to[edge_num]; 
				//printf(" to %d ", to[edge_num]);
				edge_num++;
			}
		}
		// for(i = 0; i < edge_num; i++) printf("%d", to[i]);
		// printf("\n");
		// for(i = 1; i <= n; i++) printf("%d ", energy[i]);
		// printf("\n");

		for(i = 0; i < edge_num; i++){
			//printf("from %d to %d ", from[i], to[i]);
			e[i] = energy[to[i]];
			//printf("edge = %d ", e[i]);
		}
		//printf("\n");
		solve(n, edge_num, energy);


		//printf("%d %d\n", n, m);
		//solve(n, m);
	}

	return 0;
}
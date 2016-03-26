#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_N 100 + 1
#define MAX_M 100100
#define INF 20000
int e[MAX_M];
int nb[MAX_N + 1][MAX_N + 1] = {0};
int from[MAX_M], to[MAX_M];
int reachable = 0;
int visited[MAX_N + 1] = {0};

void dfs(int n, int node){
	int j;
	if(visited[node]) return;
	// if(node == n) {
	// 	reachable = 1;
	// 	printf("check\n");
	// 	return;
	// }
	visited[node] = 1;
	for(j = 0; j < n; j++){
		if(nb[node][j] == 0) break;
		else if(!visited[nb[node][j]]){
			dfs(n, nb[node][j]);
		}
		else return;
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
			reachable = 0;
			memset(visited, 0, sizeof(visited));
			dfs(n, to[j]);
			if(visited[n]) {
				printf("winnable\n");
				return;
			}
		}
	}

	// for(j = 0; j < m; j++){
	// 	if()
	// }
	// for(i = 2; i <= n; i++) {
	// 	for(j = 0; j < m; j++){
	// 		if(from[j] == 1 && )
	// 	}
	// }
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
		for(i = 1; i <= n; i++){
			scanf("%d", &(energy[i]));
			int num_ways, j;
			scanf("%d", &num_ways);
			for(j = 0; j < num_ways; j++){
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
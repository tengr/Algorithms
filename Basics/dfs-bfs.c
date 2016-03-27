#include <stdio.h>
#include <string.h>
//A,B,C,D,E,F,G undirected graph in https://en.wikipedia.org/wiki/Depth-first_search
#define MAX_N 7
#define A 1
#define B 2
#define C 3
#define D 4
#define E 5
#define F 6
#define G 7

int g[MAX_N + 1][MAX_N + 1];
int visited[MAX_N + 1];
char dic[MAX_N + 1] = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
int Q[MAX_N + 1], S[2 * MAX_N + 1];
int end, start;

void initialize(){
	memset(visited, 0, sizeof(visited));
	memset(Q, 0, sizeof(Q));
	memset(S, 0, sizeof(S));
	end = 0;
	start = 0;
	g[A][B] = g[B][A] = g[A][C] = g[C][A] = g[A][E] = g[E][A] = 1;
	g[B][D] = g[D][B] = g[B][F] = g[F][B] = 1;
	g[C][G] = g[G][C] = 1;
	g[E][F] = g[F][E] = 1;
}

void inq(int node){
	Q[end++] = node;
}

int dq(){
	int temp = Q[start];
	Q[start++] = 0;
	return temp;
}

void push(int node){
	S[end++] = node;
}

int pop(){
	if(end == start) {
		printf("no elements to pop"); 
		return -1;
	}
	int temp = S[end - 1];
	S[--end] = 0;
	return temp;
}

void dfsRecursive(int node){
	if (node > G || node < A) {
		printf("wrong input\n");
		return;
	}

	visited[node] = 1;
	printf("%c ", dic[node]);
	int i;
	for(i = A; i <= G; i++){
		if(g[node][i] && !visited[i]) dfsRecursive(i);
	}
}

void bfsIterative(int node){
	inq(node);
	// visited[node] = 1;
	// printf("%c ", dic[node]);
	while(start < end){
		//printf("%d %d\n", start , end);
		int next_node = dq();
		if(!visited[next_node]){
			visited[next_node] = 1;
			printf("%c ", dic[next_node]);
			int i;
			for(i = A; i <= G; i++) if(!visited[i] && g[next_node][i]) inq(i);
		}
		// int j;
		// for(j = 0; j <= MAX_N; j++) printf("%c ", dic[Q[j]]);
		// printf("\n");
	}
}


void dfsIterative(int node){
	push(node);
	while(start < end){
		int next_node = pop();
		if(!visited[next_node]){
			visited[next_node] = 1;
			printf("%c ", dic[next_node]);
			int i;
			for(i = A; i <= G; i++) if(!visited[i] && g[next_node][i]) push(i);
		}
		// int j;
		// for(j = 0; j <= 2 * MAX_N; j++) printf("%c ", dic[S[j]]);
		// printf("\n");
	}
}


int main(){
	initialize();
	printf("\nDFS Recursive: \n");
	dfsRecursive(A);
	
	initialize();
	printf("\nDFS Iterative: \n");
	dfsIterative(A);
	
	initialize();
	printf("\nBFS Iterative: \n");
	bfsIterative(A);
	return 0;
}
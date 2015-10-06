#include<stdio.h>
#include<stdlib.h>

int find_max(int len, int a[][len]){
	int i = 0, j = 0, max_ind, max_deg = 0;
	int count = 0;
	for(i = 0; i < len; i++){
		for(j = 0; j < len; j++){
			if(a[i][j] != 0) count++;
			//printf("%d\n\n", a[i][j]);

		}
		if(count > max_deg) {
			//printf("count = %d\n", count);
			max_ind = i;
			max_deg = count;
		}
		//printf("%d\n\n", count);
		//printf("max deg  = %d\n", max_deg);
		count = 0;
	}
	return max_ind;
}



int main()
{
	//you can define any ajacency matrix
	//note that it has to be symmetric
	int adjacency_matrix1[4][4] = {  
		 {0, 1, 1, 1} ,   
		 {1, 0, 1, 0} ,   
		 {1, 1, 0, 0},
		 {1, 0, 0, 0},  
		};

	int adjacency_matrix2[5][5] = {  
		 {0, 0, 0, 0, 0,} ,   
		 {0, 0, 1, 0, 1} ,   
		 {0, 1, 0, 0, 0},
		 {0, 0, 0, 0, 0},  
		 {0, 1, 0, 0, 0}
		};

	int adjacency_matrix3[5][5] = {  
	 {0, 0, 0, 0, 0,} ,   
	 {0, 0, 1, 0, 1} ,   
	 {0, 1, 0, 1, 1},
	 {0, 0, 1, 1, 0},  
	 {0, 1, 0, 0, 0}
	};
	printf("graph1: %d\n", find_max(4, adjacency_matrix1));
	printf("graph2: %d\n", find_max(5, adjacency_matrix2));
	printf("graph3: %d\n", find_max(5, adjacency_matrix3));
	
	return 0;
}
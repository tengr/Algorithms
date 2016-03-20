#include <stdio.h>
#include <stdlib.h>


int min(int a, int b, int c, int d) {
	int m = a < b ? a : b;
	int n = c < d ? c : d;
	return m < n ? m : n;
}




int main () {
	int twos, threes, fives, sevens;
	twos = threes = fives = sevens = 1;
	int n = 1;
	long nums[5842 + 1];

	nums[1] = 1;
	while (n < 5842) {
		nums[++n] = min(nums[twos] * 2, nums[threes] * 3, nums[fives] * 5, nums[sevens] * 7); 
		if(nums[n] == nums[twos] * 2) twos++;
		if(nums[n] == nums[threes] * 3) threes++;
		if(nums[n] == nums[fives] * 5) fives++;
		if(nums[n] == nums[sevens] * 7) sevens++;
	}

	//printf("%lu\n", nums[5842]);

	while(1) {
		int i;
		scanf("%d", &i);
		if (i == 0) break;
		else if( i % 100 >= 10 && i % 100 <= 20) printf("The %dth humble number is %lu.\n", i, nums[i]);
		else if (i % 10 == 1) printf("The %dst humble number is %lu.\n", i, nums[i]);
		else if(i % 10 == 2) printf("The %dnd humble number is %lu.\n", i, nums[i]);
		else if(i % 10 == 3) printf("The %drd humble number is %lu.\n", i, nums[i]);
		else printf("The %dth humble number is %lu.\n", i, nums[i]);

	}

	return 0;
}
#include <stdio.h>
#include <stdlib.h>
void check_carry(unsigned long a, unsigned long b) {

	int pre = 0, count = 0;
	int digit_a, digit_b;

	while(1) {
		if(a == 0 && b == 0) break;
		digit_a = a - a / 10 * 10;
		digit_b = b - b / 10 * 10;
		if(digit_a + digit_b + pre >= 10) {
			count++;
			pre = 1;
		}
		else pre = 0;
		a = a / 10;
		b = b / 10;
	}

	if (count == 0) printf("No carry operation.\n");
	else if(count == 1) printf("1 carry operation.\n");
	else printf("%d carry operations.\n", count);
	return;
}

int main () {
	unsigned long m , n ;
	while(1) {
		scanf("%lu%lu", &m, &n);
		//printf("%lu %lu\n", m, n);
		if (m == 0 && n == 0) break;

		check_carry(m,n);

	}
	return 0;
}
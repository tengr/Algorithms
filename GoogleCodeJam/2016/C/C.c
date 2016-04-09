#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <string.h>
#include <stdbool.h>
#define PMAX 8000
#define POW2_32 4294967296
#define POW2_16 65536
int PRIMES[PMAX];
bool isPrime[PMAX] = {false};
int count = 0;

/* reverse:  reverse string s in place */
 void reverse(char s[])
 {
     int i, j;
     char c;
 
     for (i = 0, j = strlen(s)-1; i<j; i++, j--) {
         c = s[i];
         s[i] = s[j];
         s[j] = c;
     }
 }


/* itoa:  convert n to characters in s */
 void itoa(long long n, char s[], int len)
 {
     int i, sign;
 
     if ((sign = n) < 0)  /* record sign */
         n = -n;          /* make n positive */
     i = 0;
     do {       /* generate digits in reverse order */
         s[i++] = n % 2 + '0';   /* get next digit */
     } while ((n /= 2) > 0);     /* delete it */
     
     if (sign < 0)
         s[i++] = '-';

     while(i < len) s[i++] = '0';
     
     s[len] = '\0';
     
     reverse(s);
 }

 

/*tested*/
int getInterp(char s[], int base){
	int i = 0;
	int num = 0;
	for(i = 0; i < strlen(s); i++){
		num = num * base + (s[i] - '0');
	}
	return num;
}
/*tested*/

int* isJam(char s[]){
	//int bases[] = {2,4,6,8,10}; //with odd numbers the result will be even, hence not prime
	int i = 0;
	int * divisors = malloc(5 * sizeof(int));
	printf("coin = %s\n", s);
	for(i = 2; i <= 10; i++){
		int interp = getInterp(s, bases[i]);
		printf("base = %d interp = %d ", i, interp);
		int j = 0;
		for(j = 0; PRIMES[j] * PRIMES[j] <= interp; j++){
			if(interp % PRIMES[j] == 0) {
				divisors[i] = PRIMES[j];
				printf("factor = %d \n", PRIMES[j]);
				j = PMAX;
				break;
			}
		}
		if(j != PMAX) {divisors[i] = -1; printf("factor = -1 \n");}
		printf("base = %d factor = 2\n", bases[i] + 1);
	}
	printf("\n\n");

	return divisors;
}

void printResults(char s[]){
	int i = 0;
	int * divisors = isJam(s);
	//printf("%s\n", s);
	for(i = 0; i < 5; i++){
		//printf("%d 2 ", divisors[i]);
	}
	//printf("\n");
}



int main () {
	FILE *fp = fopen("first_1000_prime.txt", "r" );
	int i = 0, num;
	while(fscanf(fp, "%d", &num) != -1) {
		PRIMES[i++] = num;
		isPrime[num] = true;
	}
	fclose(fp);
	/*tests*/
	//for(i = 0; i < PMAX; i++) printf("%d ", isPrime[i]);
	//for(i = 0; i < PMAX; i++) printf("%d ", PRIMES[i]);

	//for(i = PMAX - 1; i >= 0; i--) if(isPrime[i]){printf("\n%d\n",i);break; }
	//for(i = 2; i < 10; i++)
	//printf("%d ", getInter("1001", i));

	// printf("%d\n", isJam("1101"));
	// printf("%d\n", isJam("1011"));
	// printf("%d\n", isJam("1111"));
	// printResults("1001");
	// printResults("1101");
	// printResults("1011");
	// printResults("1111");

	// printResults("11011101");
	// printResults("11011011");
	// printResults("10111011");
	// printResults("10111101");

	long long j;

	for(j = 0; j < POW2_16; j++){
		char tmp[16];
		itoa (j, tmp, 16);
		//printf("%s\n", tmp);
		isJam(tmp);
	}


	// char s1 = "1111", s2 = "1101";
	// int dvs = [3,2,5,2,7,2,3,2,11];
	// char strdvs = "3 2 5 2 7 2 3 2 11";

	// int m,n;
	// for(m = 0; m < 2; m++){
	// 	for(n = 0; n < 2; n++){

	// 	}
	// }


	return 0;
}
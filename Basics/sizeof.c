#include <stdio.h>
#include <limits.h>
int main(){
	char* pmsg = "A";
	char msg[] = "A";
	char ch = 'a';
	printf("sizeof(pmsg) = %lu\n", sizeof(pmsg));
	printf("sizeof(msg) = %lu\n", sizeof(msg));
	printf("sizeof(ch) = %lu\n", sizeof(ch));

	printf("%s\n", pmsg);
	printf("%d\n",CHAR_BIT);
}
#include <stdio.h>
#include <stdlib.h>



int main () {
	int pair = 0;//expecting begin

	while(1) {

		char c = getchar();

		if (c == EOF) break;
		else if(c == '"') {
			if(pair == 0) {
				printf("``");
				pair = 1; //expecting end
			}
			else {
				printf("''");
				pair = 0; //expecting begin
			}

		}
		else putchar(c);

	}

	return 0;
}
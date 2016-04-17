#include <stdio.h>

void reverse(char * s) {
	int i = 0, len;
	for(i = 0; s[i] != '\0'; i++)

	len = i;
	
	for(i = 0; i < len / 2; i++){
		char temp = s[i];
		s[i] = s[len - 1 - i];
		s[len - 1 - i] = temp;
	}
}


int main(){
	char s[] = "asdfasdfasdfasdfasdf"; 
	reverse(s)
	printf("%s", s);
}
#include <stdio.h>

void reverse(char * s) {
	int i = 0, len;
	for(i = 0; s[i] != '\0'; i++)

	len = i + 1;
	
	for(i = 0; i < len / 2; i++){
		char temp = s[i];
		s[i] = s[len - 1 - i];
		s[len - 1 - i] = temp;
	}
}

void reverse_sentence(char * ss) {
	// int len = 0;
	// while(ss[len++] != '\0'){;}
	int start = 0, i = 0;
	for(i = 0; ss[i] != '\0'; i++) {
		if (ss[i] == ' ' && ss[i - 1] != ' '){
			ss[i] = '\0';
			reverse(ss + start);
			ss[i] = ' ';
			start = i + 1;
		}
	}
	reverse(ss + start);
}


int main(){
	char s[] = "asdf asdf asdfas       dfasdf"; 
	printf("%s\n", s);
	reverse_sentence(s);
	printf("%s\n", s);
}
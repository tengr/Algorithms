#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define STACK_MAX_LEN 100


typedef struct aStack {
    char     data[STACK_MAX_LEN];
    int     size;
} Stack;

void Stack_Init(Stack *S)
{
    S->size = 0;
}

void Stack_Push(Stack *S, char d)
{
    if (S->size < STACK_MAX_LEN)
        S->data[S->size++] = d;
    else
        fprintf(stderr, "Error: stack full\n");
}

char Stack_Pop(Stack *S)
{
	char return_char;
    if (S->size == 0) {
        fprintf(stderr, "Error: stack empty\n");
    	return ' ';
    }
    else {
    	return_char = S->data[S->size - 1];
    	S->size--;
    	return return_char;
    }
}

int Stack_Empty(Stack *S){
	if (S->size == 0){
		return 1;
	}
	else return 0;
}

// void Stack_Destroy(Stack *S){
// 	///S->data = "";
// 	S->size = 0;
// }

int is_anagram(char* word){
	Stack* S = (Stack* ) malloc(sizeof(Stack));
	Stack_Init(S);
	int i, return_val = 1;
 	for(i = 0; i < strlen(word) / 2; i++){
 		Stack_Push(S, word[i]);
 		//printf("%c", word[i]);
 	}
 	for(i = (strlen(word) + 1) / 2; i < strlen(word); i++){
 		// if(1 == 1){
 		// 	return 0;
 		// }
 		//char char_pop = Stack_Pop(S);
 		if( word[i] != Stack_Pop(S) ){
 			return_val = 0;
 		}
 		//printf("%c\t", word[i]);
 		//printf("%c", Stack_Pop(S));
 	}

 	//Stack_Init(S);
 	//S = NULL;
 	// while(!Stack_Empty(S)){
 	// 	char c = Stack_Pop(S);
 	// }
 	//delete S;
 	return return_val;

}

int main(){

	char* word1 = "abcba";
	//puts(word1);
	printf("%d\n", is_anagram(word1));

	//printf("%d\n", is_anagram(word1));

	char* word2 = "abccba";

	printf("%d\n", is_anagram(word2));


	char* word3 = "asdfadsdfasfd";

	printf("%d\n", is_anagram(word3));



	return 0;
}
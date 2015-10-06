#include<stdio.h>
#include<stdlib.h>
typedef struct aNode {
  int value;
  struct aNode *next;
} node;

node* copy_list(node* list) {
    if (list == NULL) return NULL;

    node* result = (node*) malloc(sizeof(node));
    result->value = list->value;
    result->next = copy_list(list->next);
    return result;
}

void print_list(node* list){
	if (list == NULL) {
		printf("\n");
		return;
	}
	printf("%d\t", list->value);

	print_list(list->next);

}
int main() {

	node* head = (node*) malloc(sizeof(node));
	node* second = (node*) malloc(sizeof(node));
	node* third = (node*) malloc(sizeof(node));
	head->value = 1;
	head->next = second; 
	second->value = 2;
	second->next = third;
	third->value = 3;
	third->next = NULL;

	print_list(head);

	node* copyed_head = copy_list(head);

	print_list(copyed_head);

	return 0;

}
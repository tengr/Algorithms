void testfork(){
if(0 == fork()){
	printf("created new process");
}
printf("testfork ok:\n");
}
int main(){
testfork();
return 0;
}

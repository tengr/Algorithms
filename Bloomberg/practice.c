#include <string.h>
#include <stdio.h>
int main(int argc, char *argv[])
{
    char    abc[27];
    char    *ptr = abc;
    strcpy(abc, "abcdefgxyz");
    printf("%c", *(abc + 10));
     /*
     * What are the types and values of expressions:
     *
  
     * 1. abc
     * 2. *abc
     * 3. abc[2]
     * 4. &abc[3] //&abc[3] = abc + 3*sizeof(char)
     * 5. abc+4
     * 6. *(abc+5) + 20000  //h  long long x = int * 1LL * int
     * 7. abc[10] //'\0'
     * 8. abc[12] //memset ()
     * 9. &ptr //char**
     */
     return 0;
}
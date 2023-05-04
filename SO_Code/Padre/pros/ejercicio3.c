#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(){
    printf("\nPrueba procesos: \n");
    int x, n=5;
    
    
    while(n>0){
        switch(x=fork()){
                case -1:
                    printf("error\n");
                    exit(0);
                    break;
                case 0:
                    //printf("\tSoy un proceso hijo: padre id: %d, mi id: %d\n", getppid(), getpid());
                    exit(0);
                    break;
                default:
                    printf("\tSoy el proceso padre: padre id: %d, mi hijo es id: %d\n", getpid(), getpid());
                    n--;
                    
                    break;
        }  
    }
    
    return 1;
}

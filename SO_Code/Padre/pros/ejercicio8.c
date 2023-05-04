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
                    printf("\tSoy el proceso hijo(pid: %d y mi padre es: %d\n", getpid(), getppid());
                    n--;
                    break;
                default:
                    //printf("\tSoy un proceso padre: padre id: %d, mi id: %d\n", getppid(), getpid());
                    exit(0);
                    
                    
                    break;
        }  
    }
    
    return 1;
}
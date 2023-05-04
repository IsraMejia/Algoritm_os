#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include<sys/wait.h>
//Abanico con wait
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
                    sleep(5);
                    exit(0);
                    break;
                default:
                    //printf("\tSoy un proceso padre: padre id: %d, mi id: %d\n", getppid(), getpid());
                    n--;
                    
                    break;
        }  
    }
    wait(NULL);
    printf("\nTERMINO el proceso padre %i\n", getpid());
    return 1;
}
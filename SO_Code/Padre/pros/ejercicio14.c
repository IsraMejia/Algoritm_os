#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include<sys/wait.h>
//Abanico con wait
int main(){
    printf("\nPrueba procesos: \n");
    int x, n=5;
    int i;
    int j=0;
    while(n>j){
        switch(x=fork()){
                case -1:
                    printf("error\n");
                    exit(0);
                    break;
                case 0:
                    printf("\tTermine Soy el proceso hijo(pid: %d y mi padre es: %d\n", getpid(), getppid());
                    exit(0);
                    break;
                default:
                    //printf("\tSoy un proceso padre: padre id: %d, mi id: %d\n", getppid(), getpid());
                    j++;
                    break;
        }  
    }
    while(waitpid(-1, NULL, 0)>0){
        printf("Padre: Esperando... %d hijos.\n", --n);
    }
    printf("\nTERMINO el proceso padre %i\n", getpid());
    return 1;
}
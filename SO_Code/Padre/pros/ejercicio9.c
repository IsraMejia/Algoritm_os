#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(){
    printf("\nPrueba procesos: \n");
    int x, n=10;
    int m=2;
    int i,j;
    int pid;
    while(n>0){
        switch(x=fork()){
                case -1:
                    printf("error\n");
                    exit(0);
                    break;
                case 0:
                    printf("Soy el proceso hijo pid=%i y mi ppadre es %i\n",getpid(), getppid());
                    for(i=1; i<=m; i++){
                        switch(pid=fork()){
                            case -1:
                                printf("error\n");
                                exit(0);
                                break;
                            case 0:
                                printf("SOY EL PROCESO NIETO(pid=%i) y mi padre es(pid=%i)\n ", getpid(), getppid());
                                exit(0);
                                break;
                        }
                    }
                    exit(0);
                    break;
                default:
                    //printf("\tSoy un proceso padre %d, mi hijo id: %d\n", getppid(), getpid());
                    n--;
                    break;
        }  
    }
    printf("\nTERMINO el proceso padre\n");
    return 1;
}

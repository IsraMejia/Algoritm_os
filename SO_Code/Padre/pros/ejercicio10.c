#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(){
    printf("\nPrueba procesos: \n");
    int x, n=10;
    int m=2;
    int i,j=0;
    int pid;
    while(j<n){
        switch(x=fork()){
                case -1:
                    printf("error\n");
                    exit(0);
                    break;
                case 0:
                    printf("Soy el proceso hijo pid=%i y mi padre es %i\n",getpid(), getppid());
                    if(j==0){
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
                    }
                    
                    exit(0);
                    break;
                default:
                    //printf("\tSoy un proceso padre %d, mi hijo id: %d\n", getppid(), getpid());
                    j++;
                    break;
        }  
    }
    printf("\nTERMINO el proceso padre\n");
    return 0;
}
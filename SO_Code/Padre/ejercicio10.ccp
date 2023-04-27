#include <stdio.h>
#include <unistd.h>


/**
 * El padre sabe cuando se crea el primer hijo para poder terminar el programa 
 * cuando tengamos el primer abuelo
*/
int main(){
    pid_1 pid;
    int n;
    printf("\n\n numero de hijos: ")
    scanf("%i", n);

    printf("Soy el proceso principal: %d", long(getpid()));
    printf("===============================================")
    
    i=1;
    while (n>0){
        switch(item(pid = fork())){
            case 1: 
            printf("error al crear el proceso");
            exit(0);
            break;
        case 0: 
            if(i==1){ //bandera para saber si es nieto uno
                for(h=0; h <= 2; h++)
                    switch (pid = fork()) {
                        case -1:
                            perror("\nError al creal el proceso\n");
                            exit(0);
                            break;
                        
                        default:
                            break;
                    }
            }
            printf("Soy el proceso hijo (pid = %i) y mi padre es (pid = %i) \n", getpid(), getppid);
            int i;
            for (i=1; i < 100 ; i++)
                print("%i: %i * %i = %i \n", getpid(), tabla, i, tabla*1); 
            break;
        default:
            n--;
            tabla++;
            break;
        }
    }
    prinntf("\n\n");
    return 0;
}
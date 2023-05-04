#include <stdio.h>
#include <unistd.h>

int main(){
    printf("\nPrueba procesos: \n");
    int x, y;
    x = fork();
    y = fork();
    //pid_t getppid(void);
    //pid_t getpid(void);
    //getuid(void) id del usuario
    //Procesos huerfanos: Cuando el padre muere antes del hijo. El proceso init es el que lo adopta.
    //Para evitar huerfanos, hay que crear un wait para sincronizar.
    switch(x){
 
            

        case 0:
            switch(y){
                case -1:
                    printf("error\n");
                    break;
                case 0:
                    printf("\tSe ha creado un proceso hijo-hijo: padre id: %d, mi id: %d\n", getppid(), getpid());
                    break;
                default:
                    printf("\tSe ha creado un proceso hijo-padre: padre id: %d, mi id: %d\n", getppid(), getpid());
                    break;
            }  
            break;
        default:
                
            switch(y){
                case -1:
                    printf("error\n");
                    break;
                case 0:
                    printf("\tSe ha creado un proceso padre-hijo: padre id: %d, mi id: %d\n", getppid(), getpid());
                    break;
                default:
                    printf("\tSe ha creado un proceso padre-padre: padre id: %d, mi id: %d\n", getppid(), getpid());
                    break;
            }  
            break;
    }
        
    
    
    return 1;
}
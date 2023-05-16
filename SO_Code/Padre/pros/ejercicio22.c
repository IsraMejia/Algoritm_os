#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include<sys/wait.h>
#include <string.h>

int main(){
    //paso 1
    int pdf[2];
    char msg[256]; //aqui se resibe el mensaje del padre
    pid_t pid;
    int status;
    system ("clear");

    //paso2
    //creamos la tuberia pipe 
    if (pipe(pdf)< 0){
        perror("\nError al crear el pipe");
        exit(1);
    }
    printf("\nSoy el PADRE con pid = %i \n", getpid());
    printf("===============================");

    //paso3 : crear el hijo
    pid = fork();
    switch (pid)
    {
    case -1: //eror
        printf("No se ha podido crear un hijo");
        exit(-1);
        break;
    
    case  0 : //Hijo
        close(pdf[1]);              //4a
        printf("\n\t Hijo (pid = %i) : Esperando de mi padre",getpid());
        read(pdf[0], msg, 256);     //5a LLamada bloqueante 
        /*En caso de que el padre aun no escriba algo (no hay nada en el buffer), 
        el hijo se suspende, cuando llegan datos (el padre hace un write), el hijo se desboquea 
        dondeLeo, Mensaje , maximo256*/
        printf("\n\t Hijo (pid = %i) : Leyendo de mi padre %s", getpid(), msg );
        close(pdf[0]);              //6a Cierro el pipe
        exit(0);
        break;
    
    default: 
        //El padre, en este cerramos al 0 -> paso 4b
        /*Padre envia mensaje al hijo  */
        close(pdf[0]);
        strcpy(msg, "Hola hijo...");  //tengo entendido que esto es opcional para meter los datos de otra forma 
        printf("\n PADRE (pid = %i) , enviando mensaje : \n Hola hijo...", getpid() );
        /*printf("Padre (pid = %i) , mensaje a enviar ", getpid());
        fgets(msg, 256, stdin);
        */
        //5b write -> mandar mensaje al hijo, se le puede poner desde la terminal para ingresar mensaje
        write(pdf[1], msg , sizeof(msg) );
        
        //6b Cierra al 1, su propio pipe
        close(pdf[1]);   
    
        break;
    }
    wait(&status); // se actualiza el status en el exit(0); del case 0
    printf("\nPADRE(pid= %i), Termino mi hijho con estatus: %i \n Padre (pid= %i)", getpid(), status, getppid());
    return 0; 
}
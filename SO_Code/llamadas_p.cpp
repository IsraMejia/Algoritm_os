#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
    //pid_t getpid(void());
    //pid_t getppid(void());
    //uid_t getuid(void());
    //pid_t es un entero largo con ID del proceso llamante (getpid) o del padre del proceso llamante (getppid)
    //uid_t es un entero con el que el ID del usuario propetiario del proceso llamante
    //En caso de error se devuelve -1

int main(){
    int pid;
    printf("hola xd");
    printf("\nPrueba de procesos :\n");

    fork(); 
    fork();//Segundo Fork agregado, AHORA hay 4 procesos en total en ejecucion y visible solo 3
    printf("\t.......Se ha creado un proceso:  padre= %i, yo= %i\n", getppid(), getpid());
    //Cuando el padre termina antes que el hijo "muere", entonces el nuevo padre del hijo es reasignado por el proceso init
    //waitpid(-1, NULL, 0);
    return 0;
}


/*
Prueba de procesos :
    Se ha creado un proceso
    Se ha creado un proceso
*/
//El padre imprime "Prueba de procesos :" y 
//El proceso que gana el procesador es el primero en imprimir "Se ha creado un proceso"

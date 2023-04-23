#include <stdio.h>
#include <unitstd.h>

pid_t getpid(void());
pid_t getppid(void());
uid_t getuid(void());
//pid_t es un entero largo con ID del proceso llamante (getpid) o del padre del proceso llamante (getppid)
//uid_t es un entero con el que el ID del usuario propetiario del proceso llamante
//En caso de error se devuelve -1

int main(){

    printf("\nPrueba de procesos :\n");

    fork(); 
    printf("\tSe ha creado un proceso\n")
    return 1;

}


/*
Prueba de procesos :
    Se ha creado un proceso
    Se ha creado un proceso
*/
//El padre imprime "Prueba de procesos :" y 
//El proceso que gana el procesador es el primero en imprimir "Se ha creado un proceso"

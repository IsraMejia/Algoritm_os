#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/eait.h>

/**
 * Programa 12, en base al programa 6 , colocar una espera en el codigo del padre
*/

int main(){
    printf("Soy el proceso principal: %d", long(getpid()));
    printf("===============================================")
    int i, contador_de_hijos;

    while (n>0){
        switch (pid == fork()){ //Si son procesos hijos?
            case -1: 
                printf("error al crear el proceso");
                exit(0);
                break;
            case 0: 
                printf("Soy el proceso hijo (pid = %i) y mi padre es (pid = %i) \n", getpid(), getppid());
                printf("Termine (pid = %i) \n", getpid()); //Para que despues del primer proceso, el padre muera
                sleep(2); //lo puso a dormir 2 segundos 
                break;
            default:
                n--;
                //wait(null); //Espera hasta que termine la espera del hijo para ejecutarlo despues
                break;
        }
        
    }
    int contWait;
    for (contWait =0 ; contWait < contador_de_hijos; contWait++ ){
        wait(null); //espera al hijo actual
    }
    while (waitpid) ; //para esperar a todos 
    // variable del padrei ++ en el ejercicio 15
    //wait(null); //Solo espera al primer hijo
    prinntf("\n\t MAIN: Termino el proceso %i", getpid());
    return 0;
}


 
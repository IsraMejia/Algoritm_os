#include<stdio.h>
#include<unistd.h>
//obtener tablas de multicplicar, compartidas entre los nietos


int main(){
	pid_t pid;
//por alguna razón no dejo declarar el contador c en el caso del hijo
	int n,c,t,m;
	t=1;
//pedimos y guardamos el valor de los hijos a tener
	printf("\ninserte el numero de tablas a resolver[empieza en la del 1]: ");
	fflush(stdin);
	scanf("%d",&n);
//ciclo externo de padre-hijo
	while (n>0){
		switch(pid=fork()){
			case -1:
				printf("\nError");
				break;
        //si es un hijo, abriremos el ciclo interno de nieto-hijo
			case 0:
                
				for(c=0;c<2;c++){
					switch(pid=fork()){
						case -1:
							printf("\nerror");
							break;
						case 0:
					//Si es el primer nieto, hace del 1 al 5
							if(c==0){
								for(m=1;m<6;m++){
									printf("%d x %d = %d ",t,m,(t*m));
								}
							}
					//si es el segundo nieto, hace del 6 al 10
							if(c==1){
								for(m=6;m<11;m++){
									printf("%d x %d = %d ",t,m,(t*m));
								}
							}
							exit(0);
                        default:
                            break;
					}
				}
				exit(0);
    //solo el padre ira recorriendo el contador de hijos y tablas
            default:
               n--;
               t++;
               break;
		}

	}
	printf("\nSoy el proceso %d",getpid());
return 0;
}

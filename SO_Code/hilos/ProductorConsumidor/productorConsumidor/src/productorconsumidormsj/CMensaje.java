package productorconsumidormsj;
public class CMensaje {
	private int []codigos;
	//private String textoMensaje;
	//private boolean disponible = false; 
	int indice = -1; // La ultima posicion usada en el arreglo, cuando inicia no puede ser cero
	
	public CMensaje( int n ){ //constructor 
		codigo = new int[n];
		indice =-1 ;
	}

	privatevoid imprimirCodigos(){
		for (int i=0; i<= indice; i++){ //codigos validos no basura
			System.out.println(" \t Codigo:"+codigos[i] + "\n");
		}
	}
	
	public synchronized void Almacenar(int nmsj, String hilo) {
		while (indice == codigos.length -1 ) { //Mientras este lleno el arreglo de codigos
		    //el �ltimo mensaje no ha sido mostrado
		    try {
				System.out.println(hilo + " BLOQUEADO - Esperando al consumidor" );
		  		wait(); //se pone a dormir y cede el monitor
		   } catch (InterruptedException e) {} 
		}
        
		indice ++;
		codigos[indice] = nmsj;
		//colocar el c�digo correpondiente para buscar el mensaje 
		System.out.println("Productor " + hilo + ":  Almacena el mensaje : " + nmsj); 
		imprimirCodigos();
		notifyAll(); //Notifica siempredespues desl wait
	}	

	

	public synchronized String Obtener () {
		String mensaje;
		while (disponible == false) {
		    //no hay mensaje
		    try {
		  	wait(); //se pone a dormir y cede el monitor
		    } catch (InterruptedException e) {} 
		}
		disponible = false;
		notifyAll();
		mensaje = textoMensaje + " #" + codigos;
		return (mensaje);
	}
}

package productorconsumidormsj;
public class CMensaje {
	private int numMsj;
	private String textoMensaje;
	private boolean disponible = false; 
	
	
	public synchronized void Almacenar(int nmsj, String hilo) {
		while (disponible == true) {
		    //el �ltimo mensaje no ha sido mostrado
		    try {
				System.out.println(hilo + " BLOQUEADO - Esperando al consumidor" );
		  		wait(); //se pone a dormir y cede el monitor
		   } catch (InterruptedException e) {} 
		}
                
		numMsj = nmsj;
		//colocar el c�digo correpondiente para buscar el mensaje 
		System.out.println("Productor " + hilo + ":  Almacena el mensaje : " + nmsj);
		//en una tabla de mensajes  
		//textoMensaje = "mensaje ";
		disponible = true;
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
		mensaje = textoMensaje + " #" + numMsj;
		return (mensaje);
	}
}

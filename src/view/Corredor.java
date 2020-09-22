package view;
import controller.ThreadPessoa;
import java.util.concurrent.Semaphore;
public class Corredor {

	public static void main(String[] args) {
		int permissao = 1, distancia = 200;
		Semaphore semaforo = new Semaphore(permissao);
		for(int idPessoa=1;idPessoa<5;idPessoa++){
			Thread tPessoa = new ThreadPessoa(idPessoa, semaforo, distancia);
			tPessoa.start();
		}
	}

}

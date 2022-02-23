package view;
import controller.ThreadCarro;
import java.util.concurrent.Semaphore;

public class Cruzamento {

	public static void main(String[] args) {
			int permissao = 1;
			Semaphore semaforo = new Semaphore(permissao);
			for (int idCarro=1;idCarro<5;idCarro++){
				switch(idCarro){
				case 1:
					Thread t1 = new ThreadCarro(idCarro,semaforo,"oeste");
					t1.start();
					break;
				case 2:
					Thread t2 = new ThreadCarro(idCarro,semaforo,"leste");
					t2.start();
					break;
				case 3:
					Thread t3 = new ThreadCarro(idCarro,semaforo, "sul");
					t3.start();
					break;
				case 4:
					Thread t4 = new ThreadCarro(idCarro, semaforo, "norte");
					t4.start();
					break;
				}
				
			}

	}

}

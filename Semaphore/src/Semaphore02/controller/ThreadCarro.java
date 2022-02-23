package controller;
import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread{
	private int idCarro;
	private String sentido;
	private Semaphore semaforo;
	public ThreadCarro(int idCarro,Semaphore semaforo, String sentido){
		this.idCarro = idCarro;
		this.sentido = sentido;
		this.semaforo = semaforo;
	}
	public void run(){
		try{
			semaforo.acquire();
			cruzar();
		}catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			semaforo.release();
		}
	}
	public void cruzar(){
		System.out.println("O carro "+idCarro+" está passando pelo cruzamento sentido "+ sentido);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
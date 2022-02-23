package Semaphore01.controller;
import java.util.concurrent.Semaphore;
import java.util.Random;

public class ThreadPessoa extends Thread{
	private int idPessoa;
	private int distancia;
	private static int pos;
	private Semaphore semaforo;
	
	public ThreadPessoa(int idPessoa,Semaphore semaforo, int distancia){
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
		this.distancia = distancia;
	}
	public void run(){
		pessoaAndando();
		try {
			semaforo.acquire();
			abrirPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}
	public void pessoaAndando(){
		Random random = new Random();
		int velocidade = random.nextInt(3)+4;
		int distanciaPercorrida = 0;
		
		while (distanciaPercorrida < distancia){
			distanciaPercorrida+= velocidade;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("A pessoa "+idPessoa+ " já andou "+distanciaPercorrida+" metros.");
		}
		System.out.println("A pessoa "+idPessoa+" chegou a porta.");
		
		
	}
	public void abrirPorta(){
		Random random = new Random();
		int tempo = random.nextInt(1000)+1001;
		System.out.println("A pessoa "+idPessoa+" está abrindo a porta.");
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("A pessoa "+idPessoa+" terminou de abrir a porta.");
	}
}
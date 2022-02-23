package Semaphore04.controller;

import java.util.concurrent.Semaphore;

public class ThreadOperacoes extends Thread {
	private int op;
	private int qtd;
	private int i;
	private Semaphore semaforo;
	private Semaphore[] semaforoOpc;
	private Conta[] conta;

	public ThreadOperacoes(int op, Conta[] conta,int i, int qtd, Semaphore semaforo, Semaphore[] semaforoOpc ){
		this.op = op;
		this.qtd = qtd;
		this.i = i;
		this.semaforo = semaforo;
		this.semaforoOpc = semaforoOpc;
		this.conta = conta;
	}
	
	public void run(){
		try {
			semaforo.acquire();
			semaforoOpc[op].acquire();
			saque();
			deposito();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			semaforo.release();
			semaforoOpc[op].release();
	

		}
		
	}
	
	public void saque(){
		if (op == 1){
			System.out.println("Saldo R$"+conta[i].getSaldo()+"Saque realizado na conta corrente "+conta[i].getConta()+" no valor de R$"+qtd+". Novo saldo R$"+(conta[i].getSaldo()-qtd));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void deposito(){
		if (op == 2){
			System.out.println("Saldo R$"+conta[i].getSaldo()+"Deposito realizado para conta corrente "+conta[i].getConta()+" no valor de R$"+qtd+". Novo saldo R$"+(+conta[i].getSaldo()+qtd));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

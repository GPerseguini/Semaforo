package Semaphore04.view;
import Semaphore04.controller.Conta;

import java.util.Random;
import java.util.concurrent.Semaphore;

import Semaphore04.controller.ThreadOperacoes;

public class CaixaEletronico {

	public static void main(String[] args) {
		Random random = new Random();
		Conta[] conta = new Conta[20];
		Semaphore semaforo = new Semaphore(2);
		Semaphore[] semaforoOpc = new Semaphore[3];
		int opc,saldoConta;
		for (int i=0;i<3;i++){
			semaforoOpc[i] = new Semaphore(1);
		}
		for (int i=0;i<20;i++){
			opc = random.nextInt(2)+1;	
			switch(opc){
			case 1:
				conta[i] = new Conta();
				conta[i].setConta(random.nextInt(100));
				conta[i].setSaldo(random.nextInt(1000));
				int qtdSaque = random.nextInt(200)+1;
				Thread saque = new ThreadOperacoes(opc,conta,i, qtdSaque,semaforo,semaforoOpc);
				saque.start();
				break;
			case 2:
				conta[i] = new Conta();
				conta[i].setConta(random.nextInt(100));
				conta[i].setSaldo(random.nextInt(1000));
				int qtdDeposito = random.nextInt(200)+1;
				Thread deposito = new ThreadOperacoes(opc,conta, i,qtdDeposito,semaforo, semaforoOpc);
				deposito.start();
				break; 
			} 
		}
	}
}

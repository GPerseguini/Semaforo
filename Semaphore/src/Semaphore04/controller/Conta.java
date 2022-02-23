package Semaphore04.controller;

public class Conta {
	private int codConta;
	private int saldo;
	private int saque;
	
	public Conta (){
		this.codConta = codConta;
		this.saldo = saldo;
	}
	public int getConta(){
		return this.codConta;
	}
	public int getSaldo(){
		return this.saldo;
	}
	public void setConta(int codConta){
		this.codConta = codConta;
	}
	public void setSaldo(int saldo){
		this.saldo = saldo;
	}
	
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettothreadprelevaodeposita;

/**
 *
 * @author andre
 */
public class Conto {
    private double saldo;
    
    public Conto(double saldoIniziale) {
	this.saldo = saldoIniziale;
    }
    
    public boolean preleva(double somma) {
	if (somma <= saldo) { 
	    saldo = saldo - somma;
	    return true;
	}
	return false;
    }
    
    public void versa(double somma) {
	saldo = saldo + somma;
    }
    
    public boolean bonifico(Conto conto, double somma) {
	if (somma <= saldo) {
	    saldo = saldo - somma;
	    conto.versa(somma);
	    return true;
	}
	return false;
    }
}

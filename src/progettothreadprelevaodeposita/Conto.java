/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettothreadprelevaodeposita;

import java.util.logging.Level;
import java.util.logging.Logger;

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
	    try {
		Thread.sleep(100);
	    } catch (InterruptedException ex) {
		Logger.getLogger(Conto.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    saldo = saldo - somma;
	    return true;
	}
	return false;
    }
    
    public void versa(double somma) {
	double nuovo_saldo = saldo + somma;
	try {
	    Thread.sleep(100);
	} catch (InterruptedException ex) {
	    Logger.getLogger(Conto.class.getName()).log(Level.SEVERE, null, ex);
	}
	saldo = nuovo_saldo;
    }
    
    public boolean bonifico(Conto conto, double somma) {
	if (somma <= saldo) {
	    try {
		Thread.sleep(100);
	    } catch (InterruptedException ex) {
		Logger.getLogger(Conto.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    saldo = saldo - somma;
	    conto.versa(somma);
	    return true;
	}
	return false;
    }
}

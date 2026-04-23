/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package progettothreadprelevaodeposita;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class ProgettoThreadPrelevaODeposita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	//Crea due conti con 10000 come saldo iniziale
	Conto conto1 = new Conto(10000);
	Conto conto2 = new Conto(10000);
	//Crea un array di operatori
	Operatore[] ops = new Operatore[6];
	//Crea 3 operatori che lavorano sul conto1 e fanno bonifici sul conto2
	for (int i = 0; i < 3; ++i) {
	    Operatore op = new Operatore(conto1, conto2);
	    //Mermorizza l'operatore
	    ops[i] = op;
	    //Avvia l'operatore
	    op.start();
	}
	//Crea tre operatori che lavorano sul conto2 e fanno bonifici sul conto1
	for (int i = 0; i < 3; ++i) {
	    Operatore op = new Operatore(conto2, conto1);
	    //Memorizza l'operatore
	    ops[i+3] = op;
	    //Avvia l'operatore
	    op.start();
	}
	//Aspetta che tutti terminino (in realtà non succederà mai per il while(true)
	for (Operatore op : ops) {
	    try {
		op.join();
	    } catch (InterruptedException ex) {
		Logger.getLogger(ProgettoThreadPrelevaODeposita.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }
    
}

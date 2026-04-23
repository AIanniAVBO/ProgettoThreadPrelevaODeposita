/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettothreadprelevaodeposita;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class Operatore extends Thread{
    //Conto su cui fare le operazioni
    private Conto conto;
    //Altro conto su cui fare i bonifici
    private Conto altroConto;
    
    public Operatore(Conto conto, Conto altroConto) {
	this.conto = conto;
	this.altroConto = altroConto;
    }
    
    @Override
    public void run() {
	//Crea un generatore di numeri casuali
	Random random = new Random();
	//Ottiene l'id del thread
	long tID = Thread.currentThread().threadId();
	//Avvia un ciclo infinito che terrà il thread sempre attivo
	while(true) {
	    //Ottiene una somma casuale tra 100 e 499.99
	    double somma = random.nextDouble(100, 500);
	    //Prende un numero casuale tra 0, 1 e 2
	    switch (random.nextInt(3)) {
		case 0:
		    //Versa una somma casuale
		    conto.versa(somma);
			System.out.println("Sono il thread " + tID + " ho versato la somma " + somma + " sul mio conto");
		    break;
		case 1:
		    if (conto.preleva(somma)) {
			System.out.println("Sono il thread " + tID + " ho prelevato la somma " + somma + " dal mio conto");
		    } else {
			System.out.println("Sono il thread " + tID + " non ho potuto prelevare la somma " + somma + " dal mio conto");
		    }
		    break;
		case 2:
		    if (conto.bonifico(altroConto, somma)) {
			System.out.println("Sono il thread " + tID + " ho versato la somma " + somma + " sull'altro conto");
		    } else {
			System.out.println("Sono il thread " + tID + " non ho potuto versare la somma " + somma + " sull'altro conto");
		    }
		    break;
	    }
	    try {
		//Mette il thread in attesa per un tempo casuale
		Thread.sleep(random.nextInt(100, 800));
	    } catch (InterruptedException ex) {
		Logger.getLogger(Operatore.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }
    
}

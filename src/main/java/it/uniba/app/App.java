package it.uniba.app;

/**
 * Classe principale dell'applicazione.
 */
public final class App {
    
    public static void main(final String[] args)  {
        Wordle wordle = new Wordle(new Utente("aurora"));
        
        wordle.gioca();
    }
}

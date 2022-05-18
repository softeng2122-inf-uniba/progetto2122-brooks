package it.uniba.app;

/**
 * Classe principale dell'applicazione.
 */
public final class App {
    
    public static void main(final String[] args) {
        if (args.length==1) {
            if (args[0].equalsIgnoreCase("-h") || args[0].equalsIgnoreCase("--help")) {
                Wordle.aiuto();
            }
        }
        Wordle game = new Wordle(new Utente("User"));
        game.distributore();
    }
}
package it.uniba.app;

public final class App {

    private App() {
    }

/**
 * Classe principale dell'applicazione.
 *
 * @param args
 */
    public static void main(final String[] args) {
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("-h")
            || args[0].equalsIgnoreCase("--help")) {
                Wordle.aiuto();
            }
        }
        Wordle game = new Wordle(new Utente("User"));
        game.distributore();
    }
}

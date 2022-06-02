package it.uniba.app;

import java.util.regex.Pattern;

public final class Controllore {

    private Controllore() {
    }
/**
 *Espressione regolare.
 */
    public static final String REGEX = "[a-z][a-z][a-z][a-z][a-z]";
/**
 *Classe necessaria per controllare che le regole definite
 *per la parola segreta del gioco siano rispettate.
 *
 * @param parolaRic
 *
 * @return ritorna true se la parola rispetta le regole definite
 */
    public static boolean controlloParola(
        final String parolaRic
        ) throws IllegalArgumentException {
        if (!Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE).
            matcher(parolaRic).matches()) {
            throw new IllegalArgumentException();
        } else {
            return true;
        }
    }
}

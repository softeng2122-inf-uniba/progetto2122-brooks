package it.uniba.app;

import java.util.Map;
import java.util.HashMap;

enum ColoreCella {
/**
 *Colore giallo per la cella.
 */
    GIALLO,
/**
 *Colore grigio per la cella.
 */
    GRIGIO,
/**
 *Colore verde per la cella.
 */
    VERDE
}
/**
 *Contiene le informazioni riguardante i colori
 *che la casella assumerà durante il gioco.
 */
final class ColoriConsole {

    private ColoriConsole() {
    }
/**
 *Reimpostare il colore originale.
 */
    public static final String RESET = "\u001B[37;0m";
/**
 *Informazioni sul colore grigio.
 */
    public static final String GRIGIO = "\u001B[30;100m";
/**
 *Informazioni sul colore verde.
 */
    public static final String VERDE = "\u001B[30;42m";
/**
 *Informazioni sul colore giallo.
 */
    public static final String GIALLO = "\u001B[30;103m";
}
/**
 *Rappresenterà la lettera della matrice.
 */
public class Lettera {
/**
 *Carattere lettera.
 */
    private char lettera;
/**
 *Colore della cella.
 */
    private ColoreCella colore;
/**
 *Mapping fra colore e codice ansi corrispondente.
 */
    private Map<ColoreCella, String> mColori;

    Lettera(final char letteraRic, final ColoreCella coloreRic) {
        this.lettera = letteraRic;
        this.colore = coloreRic;
        this.init();
    }

    Lettera() {
        this.lettera = 0;
        this.colore = ColoreCella.GRIGIO;
        this.init();
    }

    private void init() {
        this.mColori = new HashMap<>();
        this.mColori.put(ColoreCella.GIALLO, ColoriConsole.GIALLO);
        this.mColori.put(ColoreCella.GRIGIO, ColoriConsole.GRIGIO);
        this.mColori.put(ColoreCella.VERDE, ColoriConsole.VERDE);
    }

    @Override
    public final String toString() {
        return this.mColori.get(this.colore)
        + Character.toString(this.lettera) + ColoriConsole.RESET;
    }

/**
 *Restituisce l'attributo lettera della classe.
 * @return lettera
 */
    public char getLettera() {
        return this.lettera;
    }
/**
 *Modifica l'attributo lettera della classe.
 * @param letteraRic
 */
    public void setLettera(final char letteraRic) {
        this.lettera = letteraRic;
    }
/**
 *Restituisce l'attributo colore della classe.
 * @return colore
 */
    public ColoreCella getColore() {
        return this.colore;
    }
/**
 *Modifica l'attributo colore della classe.
 * @param coloreRic
 */
    public void setColore(final ColoreCella coloreRic) {
        this.colore = coloreRic;
    }
}

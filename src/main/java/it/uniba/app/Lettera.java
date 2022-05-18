package it.uniba.app;

import java.util.Map;
import java.util.HashMap;

enum COLORE_CELLA {
    GIALLO,
    GRIGIO,
    VERDE
}

class ColoriConsole {

    public final static String RESET = "\u001B[0m";
    public final static String GRIGIO = "\u001B[100m";
    public final static String VERDE = "\u001B[102m";
    public final static String GIALLO = "\u001B[103m";
}

public class Lettera {
    
    public char lettera;
    public COLORE_CELLA colore;
    private Map<COLORE_CELLA, String> mColori;

    Lettera(char letteraRic, COLORE_CELLA coloreRic) {
        this.lettera = letteraRic;
        this.colore = coloreRic;
        this.init();
    }

    Lettera() {
        this.lettera = 0;
        this.colore = COLORE_CELLA.GRIGIO;
        this.init();
    }

    private void init()
    {
        this.mColori = new HashMap<>();
        this.mColori.put(COLORE_CELLA.GIALLO, ColoriConsole.GIALLO);
        this.mColori.put(COLORE_CELLA.GRIGIO, ColoriConsole.GRIGIO);
        this.mColori.put(COLORE_CELLA.VERDE, ColoriConsole.VERDE);
    }

    @Override
    public String toString()
    {
        return this.mColori.get(this.colore) + Character.toString(this.lettera) + ColoriConsole.RESET;
    }

}
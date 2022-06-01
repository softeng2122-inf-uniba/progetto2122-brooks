package it.uniba.app;

class ParolaSegreta implements Cloneable {
/**
 *Parola segreta.
 */
    private String parola;
/**
 *Definisce la lunghezza parola.
 */
    public static final Integer LUNGH_PAROLA = 5;

    ParolaSegreta(final String parolaRic) throws IllegalArgumentException {
        this.setParola(parolaRic);
    }

    public String getParola() {
        return this.parola;
    }

    public void setParola(
        final String parolaRic
        ) throws IllegalArgumentException {
        if (Controllore.controlloParola(parolaRic)) {
            this.parola = parolaRic;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

package it.uniba.app;

class ParolaSegreta {

     private String parola;
    public static final Integer LUNGH_PAROLA = 5;

    ParolaSegreta(String parolaRic) throws IllegalArgumentException {
        this.setParola(parolaRic);
    }

    public String getParola() {
        return this.parola;
    }

    public void setParola(String parolaRic) throws IllegalArgumentException {
        if(Controllore.controlloParola(parolaRic)) {
            this.parola = parolaRic;
        }
    }
}
package it.uniba.app;

import java.util.regex.Pattern;

class ParolaSegreta {

    private String parola;
    static public final Integer LUNGH_PAROLA = 5;
    public final String REGEX = "[a-z][a-z][a-z][a-z][a-z]";

    ParolaSegreta(String parolaRic) throws IllegalArgumentException {
        this.setParola(parolaRic);
    }

    public String getParola() {
        return this.parola;
    }

    public void setParola(String parolaRic) throws IllegalArgumentException {
        if(Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE).matcher(parolaRic).matches() == false)
        {
            throw new IllegalArgumentException();
        }
        
        else
        {
            this.parola = parolaRic;
        }
    }
}
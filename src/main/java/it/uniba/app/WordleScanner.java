package it.uniba.app;

import java.util.regex.*;

enum WordleToken {
    INDOVINA_PAROLA,
    USCITA_PROGRAMMA,
    USCITA_PARTITA,
    NUOVA_PARTITA,
    AIUTO,
    MOSTRA_PAROLA,
    NUOVA_PAROLA,
    INVALIDO
};

class WordleScanner implements Scanner<WordleToken> {

    static final public String ESCI_CMD = "esc";
    static final public String FINE_PARTITA_CMD = "abbandona";
    static final public String NUOVA_PARTITA_CMD = "gioca";
    static final public String AIUTO_CMD = "help";
    static final public String MOSTRA_PAROLA_CMD = "mostra";
    static final public String NUOVA_PAROLA_CMD = "nuova";

    static final public String ESCI_REGEX = "/" + ESCI_CMD + "[ ]*";
    static final public String FINE_PARTITA_REGEX = "/" + FINE_PARTITA_CMD + "[ ]*";
    static final public String NUOVA_PARTITA_REGEX = "/" + NUOVA_PARTITA_CMD + "[ ]*";
    static final public String AIUTO_REGEX = "/" + AIUTO_CMD + "[ ]*";
    static final public String MOSTRA_PAROLA_REGEX = "/" + MOSTRA_PAROLA_CMD + "[ ]*";
    static final public String NUOVA_PAROLA_REGEX = "/" + NUOVA_PAROLA_CMD + "[ ]+" + ".+" + "[ ]*";

    public WordleToken scan(String cmd) {

        Pattern esciPattern = Pattern.compile(ESCI_REGEX, Pattern.CASE_INSENSITIVE);
        Pattern finePartitaPattern = Pattern.compile(FINE_PARTITA_REGEX, Pattern.CASE_INSENSITIVE);
        Pattern nuovaPartitaPattern = Pattern.compile(NUOVA_PARTITA_REGEX, Pattern.CASE_INSENSITIVE);
        Pattern aiutoPattern = Pattern.compile(AIUTO_REGEX, Pattern.CASE_INSENSITIVE);
        Pattern mostraParolaPattern = Pattern.compile(MOSTRA_PAROLA_REGEX, Pattern.CASE_INSENSITIVE);
        Pattern nuovaParolaPattern = Pattern.compile(NUOVA_PAROLA_REGEX, Pattern.CASE_INSENSITIVE);

        if(esciPattern.matcher(cmd).matches())
            return WordleToken.USCITA_PROGRAMMA;
        if(finePartitaPattern.matcher(cmd).matches())
            return WordleToken.USCITA_PARTITA;
        else if(nuovaPartitaPattern.matcher(cmd).matches())
            return WordleToken.NUOVA_PARTITA;
        else if(aiutoPattern.matcher(cmd).matches())
            return WordleToken.AIUTO;
        else if(mostraParolaPattern.matcher(cmd).matches())
            return WordleToken.MOSTRA_PAROLA;
        else if(nuovaParolaPattern.matcher(cmd).matches())
            return WordleToken.NUOVA_PAROLA;
        else
            return WordleToken.INDOVINA_PAROLA;
    }
}
package it.uniba.app;

import java.util.regex.Pattern;

enum WordleToken {
/**
 *WordleToken per indovinare la parola.
 */
    INDOVINA_PAROLA,
/**
 *WordleToken per uscire dal programma.
 */
    USCITA_PROGRAMMA,
/**
 *WordleToken per uscire dalla partita.
 */
    USCITA_PARTITA,
/**
 *WordleToken per iniziare una nuova partita.
 */
    NUOVA_PARTITA,
/**
 *WordleToken per avere aiuto.
 */
    AIUTO,
/**
 *WordleToken per mostrare la parola.
 */
    MOSTRA_PAROLA,
/**
 *WordleToken per inserire una nuova parola segreta.
 */
    NUOVA_PAROLA,
/**
 *WordleToken per indicare un tentativo invalido.
 */
    INVALIDO
};

class WordleScanner implements Scanner<WordleToken> {
/**
 *Attributo escape.
 */
    public static final String ESCAPE = "/";
/**
 *Attributo per indicare il comando EsciCmd.
 */
    public static final String ESCI_CMD = "esci";
/**
 *Attributo per indicare il comando finePartitaCmd.
 */
    public static final String FINE_PARTITA_CMD = "abbandona";
/**
 *Attributo per indicare il comando NuovaPartitaCmd.
 */
    public static final String NUOVA_PARTITA_CMD = "gioca";
/**
 *Attributo per indicare il comando AiutoCmd.
 */
    public static final String AIUTO_CMD = "help";
/**
 *Attributo per indicare il comando MostraParolaCmd.
 */
    public static final String MOSTRA_PAROLA_CMD = "mostra";
/**
 *Attributo per indicare il comando NuovaParolaCmd.
 */
    public static final String NUOVA_PAROLA_CMD = "nuova";
/**
 *Attributo per indicare l'espressione regolare Esci.
 */
    public static final String ESCI_REGEX = ESCAPE + ESCI_CMD + "[ ]*";
/**
 *Attributo per indicare l'espressione regolare FinePartita.
 */
    public static final String FINE_PARTITA_REGEX =
        ESCAPE + FINE_PARTITA_CMD + "[ ]*";
/**
 *Attributo per indicare l'espressione regolare NuovaPartita.
 */
    public static final String NUOVA_PARTITA_REGEX =
        ESCAPE + NUOVA_PARTITA_CMD + "[ ]*";
/**
 *Attributo per indicare l'espressione regolare Aiuto.
 */
    public static final String AIUTO_REGEX =
        ESCAPE + AIUTO_CMD + "[ ]*";
/**
 *Attributo per indicare l'espressione regolare MostraParola.
 */
    public static final String MOSTRA_PAROLA_REGEX =
        ESCAPE + MOSTRA_PAROLA_CMD + "[ ]*";
/**
 *Attributo per indicare l'espressione regolare NuovaParola.
 */
    public static final String NUOVA_PAROLA_REGEX =
        ESCAPE + NUOVA_PAROLA_CMD + "[ ]+" + ".+" + "[ ]*";
    public WordleToken scan(final String cmd) {

        Pattern esciPattern = Pattern.compile(
            ESCI_REGEX, Pattern.CASE_INSENSITIVE);
        Pattern finePartitaPattern = Pattern.compile(
            FINE_PARTITA_REGEX, Pattern.CASE_INSENSITIVE);
        Pattern nuovaPartitaPattern = Pattern.compile(
            NUOVA_PARTITA_REGEX, Pattern.CASE_INSENSITIVE);
        Pattern aiutoPattern = Pattern.compile(
            AIUTO_REGEX, Pattern.CASE_INSENSITIVE);
        Pattern mostraParolaPattern = Pattern.compile(
            MOSTRA_PAROLA_REGEX, Pattern.CASE_INSENSITIVE);
        Pattern nuovaParolaPattern = Pattern.compile(
            NUOVA_PAROLA_REGEX, Pattern.CASE_INSENSITIVE);

        if (esciPattern.matcher(cmd).matches()) {
            return WordleToken.USCITA_PROGRAMMA;
        }
        if (finePartitaPattern.matcher(cmd).matches()) {
            return WordleToken.USCITA_PARTITA;
        } else if (nuovaPartitaPattern.matcher(cmd).matches()) {
            return WordleToken.NUOVA_PARTITA;
        } else if (aiutoPattern.matcher(cmd).matches()) {
            return WordleToken.AIUTO;
        } else if (mostraParolaPattern.matcher(cmd).matches()) {
            return WordleToken.MOSTRA_PAROLA;
        } else if (nuovaParolaPattern.matcher(cmd).matches()) {
            return WordleToken.NUOVA_PAROLA;
        } else if (cmd.startsWith(ESCAPE)) {
            return WordleToken.INVALIDO;
        } else {
            return WordleToken.INDOVINA_PAROLA;
        }
    }
}

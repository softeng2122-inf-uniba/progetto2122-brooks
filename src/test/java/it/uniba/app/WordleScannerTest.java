package it.uniba.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class WordleScannerTest {

    /**
     * Oggetto su cui eseguire operazioni di testing.
     */
    private WordleScanner ws;

    /**
     * Inizializza l'oggetto prima di utilizzarlo.
     */
    @BeforeAll
    void init() {
        ws = new WordleScanner();
    }

    /**
     * L'iniziatore di un comando senza argomento
     * dovrebbe essere riconosciuto come
     * un invalido token.
     */
    @Test
    void invalidTokenJustSlash() {
        assertEquals(WordleToken.INVALIDO, this.ws.scan("/"));
    }

    /**
     * Un comando non esistente dovrebbe essere riconosciuto come
     * un invalido token.
     */
    @Test
    void invalidCommand() {
        assertEquals(WordleToken.INVALIDO, this.ws.scan("/ThisIsNotACommand"));
    }

    /**
     * Il comando /esci dovrebbe essere riconosciuto come
     * un token valido.
     */
    @Test
    void esciCommand() {
        assertEquals(WordleToken.USCITA_PROGRAMMA, this.ws.scan("/esci"));
    }

    /**
     * Il comando /nuova <parola> dovrebbe essere riconosciuto come
     * un token valido.
     */
    @Test
    void nuovaCommand() {
        assertEquals(WordleToken.NUOVA_PAROLA, this.ws.scan("/nuova parola"));
    }

    /**
     * Il comando /gioca dovrebbe essere riconosciuto come
     * un token valido.
     */
    @Test
    void giocaCommand() {
        assertEquals(WordleToken.NUOVA_PARTITA, this.ws.scan("/gioca"));
    }

    /**
     * Il comando /abbandona dovrebbe essere riconosciuto come
     * un token valido.
     */
    @Test
    void abbandonaCommand() {
        assertEquals(WordleToken.USCITA_PARTITA, this.ws.scan("/abbandona"));
    }

    /**
     * Il comando /mostra dovrebbe essere riconosciuto come
     * un token valido.
     */
    @Test
    void mostraCommand() {
        assertEquals(WordleToken.MOSTRA_PAROLA, this.ws.scan("/mostra"));
    }

    /**
     * Il comando /aiuto dovrebbe essere riconosciuto come
     * un token valido.
     */
    @Test
    void aiutoCommand() {
        assertEquals(WordleToken.AIUTO, this.ws.scan("/help"));
    }

    /**
     * Il tentativo di indovinare la parola
     * dovrebbe essere riconosciuto come
     * un token valido.
     */
    @Test
    void indovinaCommand() {
        assertEquals(WordleToken.INDOVINA_PAROLA,
        this.ws.scan("IWaNNaGuessAWord"));
    }

    /**
     * Lo scanner dovrebbe essere case-insensitive.
     */
    @Test
    void caseInsensitiveCommand() {
        assertEquals(WordleToken.AIUTO, this.ws.scan("/HelP"));
    }

    /**
     * Un comando seguito da altri simboli non validi dovrebbe essere
     * un token invalido.
     */
    @Test
    void moreSymCommand() {
        assertEquals(WordleToken.AIUTO, this.ws.scan("/help "));
    }

    /**
     * Il comando \nuova non seguito da altri simboli dovrebbe essere
     * un token invalido.
     */
    @Test
    void nuovaWrongForm() {
        assertEquals(WordleToken.INVALIDO, this.ws.scan("/nuova"));
    }

    /**
     * Il comando \nuova seguito da solo uno spazio dovrebbe essere
     * un token invalido.
     */
    @Test
    void nuovaMoreSpaceForm() {
        assertEquals(WordleToken.INVALIDO, this.ws.scan("/nuova "));
    }
}

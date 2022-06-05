package it.uniba.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ControlloreTest {

    /**
     * Un input di corretta lunghezza ma che non rispetta il pattern dovrebbe
     * sollevare un'eccezione.
     */
    @Test
    void WrongPattern() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Controllore.controlloParola("12 45");
                });
    }

    /**
     * Un input che rispetta il pattern ma troppo lungo dovrebbe sollevare
     * un'eccezione.
     */
    @Test
    void MajorSize() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Controllore.controlloParola("ILOVEYOUWORM");
                });
    }

    /**
     * Un input che rispetta il pattern ma troppo corto dovrebbe sollevare
     * un'eccezione.
     */
    @Test
    void MinorSize() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Controllore.controlloParola("BAD");
                });
    }

    /**
     * Un input corretto non dovrebbe sollevare un'eccezione.
     */
    @Test
    void CorrectInput() {

        Assertions.assertDoesNotThrow(
                () -> {
                    Controllore.controlloParola("MYGOD");
                },
                "Test su un input corretto");
    }

    /**
     * Test sul caso limite di una parola che rispetta il pattern ma contenente 6
     * lettere.
     */
    @Test
    void LimitMajorSize() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Controllore.controlloParola("abcdef");
                });
    }

    /**
     * Test sul caso limite di una parola che rispetta il pattern ma contenente 4
     * lettere.
     */
    @Test
    void LimitMinorSize() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Controllore.controlloParola("abcdef");
                });
    }
}

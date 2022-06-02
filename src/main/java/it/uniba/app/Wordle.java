package it.uniba.app;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Wordle {
/**
 *Numero massimo di tentaivi per giocare.
 */
    public static final Integer MAX_TENTATIVI = 6;
/**
 *Utente che si interfaccia al gioco.
 */
    private Utente utente;
/**
 *Parola segreta del gioco.
 */
    private ParolaSegreta parolaSegr;
/**
 *Matrice dei tentativi.
 */
    private Lettera[][] tentativo;
/**
 *Numero dei tentativi effettuati.
 */
    private Integer numTentativo;
/**
 *Indica se la partita è stata avviata o meno.
 */
    private Boolean partitaAvviata;
/**
 *Indica se la parola segreta è stata impostata o meno.
 */
    private Boolean parolaImpostata;

    Wordle(final Utente utenteRic, final ParolaSegreta parolaSegrRic) {
        this.tentativo = new Lettera[MAX_TENTATIVI][ParolaSegreta.LUNGH_PAROLA];
        this.utente = utenteRic;
        this.parolaSegr = parolaSegrRic;
        this.numTentativo = 0;
        this.partitaAvviata = false;
        this.parolaImpostata = true;
    }
    Wordle(final Utente utenteRic) {
        this.tentativo = new Lettera[MAX_TENTATIVI][ParolaSegreta.LUNGH_PAROLA];
        this.utente = utenteRic;
        this.parolaSegr = null;
        this.numTentativo = 0;
        this.partitaAvviata = false;
        this.parolaImpostata = false;
    }
/**
 *Restituisce una copia dell'utente.
 * @return utente
 * @throws CloneNotSupportedException
 */
    public final Utente getUtente() throws CloneNotSupportedException {
        return (Utente) this.utente.clone();
    }
/**
 *Restituisce una copia della parola segreta.
 * @return parolaSegr
 * @throws CloneNotSupportedException
 */
    public final ParolaSegreta getParolaSegr()
    throws CloneNotSupportedException {
        return (ParolaSegreta) this.parolaSegr.clone();
    }
/**
 *Restituisce il numero dei tentativi effettuati.
 * @return numTentativo
 */
    public final Integer getNumTentativo() {
        return this.numTentativo;
    }
/**
 *Aumenta il numero dei tentativi effettuati.
 */
    public void aumentaNumTentativo() {
        this.numTentativo++;
    }
/**
 *Restituisce true se la partita è stata avviata, false altrimenti.
 * @return partitaAvviata
 */
    public Boolean isAvviata() {
        return this.partitaAvviata;
    }
/**
 *Restituisce true se la parola segreta è stata impostata, false altrimenti.
 * @return parolaImpostata
 */
    public Boolean isParolaImpostata() {
        return this.parolaImpostata;
    }
/**
 *Mostra a schermo la matrice dei tentativi.
 */
    public final void mostraMatrice() {
        int i = 0;
        int j = 0;
        int x = 0;
        System.out.print(" ");
        for (x = 0; x < ParolaSegreta.LUNGH_PAROLA; x++) {
            System.out.print(" " + (x + 1));
        }

        System.out.println();

        for (i = 0; i < MAX_TENTATIVI; i++) {
            System.out.print(i + 1 + " ");
            for (j = 0; j < ParolaSegreta.LUNGH_PAROLA; j++) {
                if (tentativo[i][j] == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(this.tentativo[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
/**
 *Consente di iniziare una nuova partita.
 */
    public void gioca() {
        if (partitaAvviata) {
            Output.error("E' gia'in corso una partita");
        } else {
            partitaAvviata = true;
            mostraMatrice();
        }
    }
/**
 *Consente di mostrare la parola segreta.
 */
    public void mostraParola() {
        if (parolaImpostata) {
            Output.success("Parola segreta: " + parolaSegr.getParola());
        } else {
            Output.error("La parola non e' ancora stata impostata");
        }
    }
/**
 *Consente di uscire dal gioco.
 */
    public void esci() {
        String risposta = "";
        Scanner scanner = new Scanner(System.in);

        do {
            Output.loading("Sicuro di voler uscire? (S/N)");
            risposta = scanner.nextLine();
        } while (!risposta.equalsIgnoreCase("S")
        && !risposta.equalsIgnoreCase("N"));

        if (risposta.compareTo("S") == 0 || risposta.compareTo("s") == 0)  {
            Output.loading("Uscita dal gioco");
            System.exit(0);
        }
    }
/**
 *Consente di impostare una parola segreta.
 * @param nuovaParola
 */
    public void impostaParola(final String nuovaParola) {
        if (!this.partitaAvviata) {
            if (nuovaParola.length() < ParolaSegreta.LUNGH_PAROLA) {
                Output.error("Parola troppo corta");
            } else if (nuovaParola.length() > ParolaSegreta.LUNGH_PAROLA) {
                Output.error("Parola troppo lunga");
            } else if (!Pattern.compile(Controllore.REGEX,
            Pattern.CASE_INSENSITIVE).matcher(nuovaParola).matches()) {
                Output.error("Parola segreta non valida");
            } else {
                this.parolaImpostata = true;
                this.parolaSegr = new ParolaSegreta(nuovaParola);
            }
        } else {
            Output.error("La partita e' in corso");
        }
    }
/**
 *Consente di abbandonare la partita in corso.
 */
    public final void abbandonaPartita() {
        String risposta = "";
        Scanner scanner = new Scanner(System.in);

        if (this.partitaAvviata) {
            do {
                Output.loading("Sicuro di voler"
                + "abbandonare questa partita? (S/N)");
                risposta = scanner.nextLine();
            } while (!risposta.equalsIgnoreCase("S")
                && !risposta.equalsIgnoreCase("N"));

            if (risposta.compareTo("S") == 0 || risposta.compareTo("s") == 0) {
                Output.loading("Partita abbandonata");
                this.pulisci();
            }
        } else {
            Output.error("Nessuna partita in corso!");
        }
    }
/**
 *Restituisce true se la parola segreta è stata indovinata, false altrimenti.
 * @param tentativoRic
 * @return boolean
 */
    public final Boolean indovinaParola(final String tentativoRic) {
        Integer i = 0;

        if (!this.partitaAvviata) {
            Output.error("Partita non avviata!");
            return false;
        } else if (!this.parolaImpostata) {
            Output.error("Parola non impostata!");
            return false;
        } else if (tentativoRic.length() < ParolaSegreta.LUNGH_PAROLA) {
            Output.error("Tentativo incompleto!");
            return false;
        } else if (tentativoRic.length() > ParolaSegreta.LUNGH_PAROLA) {
            Output.error("Tentativo eccessivo!");
            return false;
        } else if ((!Pattern.compile(Controllore.REGEX,
            Pattern.CASE_INSENSITIVE).matcher(tentativoRic).matches())) {
            Output.error("Tentativo non valido");
            return false;
        } else {
            for (i = 0; i < ParolaSegreta.LUNGH_PAROLA; ++i) {
                this.tentativo[this.numTentativo][i] = new Lettera();
                this.tentativo[this.numTentativo][i]
                .setLettera(tentativoRic.charAt(i));
                if (Character.toLowerCase(this.parolaSegr.getParola().charAt(i))
                == Character.toLowerCase(tentativoRic.charAt(i))) {
                    this.tentativo[this.numTentativo][i].
                    setColore(ColoreCella.VERDE);
                } else if (this.parolaSegr.getParola()
                .contains(Character.toString(tentativoRic.charAt(i)))) {
                    this.tentativo[this.numTentativo][i]
                    .setColore(ColoreCella.GIALLO);
                } else {
                    this.tentativo[this.numTentativo][i]
                    .setColore(ColoreCella.GRIGIO);
                }
            }
        }

        this.mostraMatrice();
        this.aumentaNumTentativo();

        if (this.parolaSegr.getParola().equalsIgnoreCase(tentativoRic)) {
            Output.success("Parola segreta indovinata!");
            Output.success("Numero tentativo: " + this.numTentativo);
            this.pulisci();
            return true;
        } else if (this.numTentativo.equals(MAX_TENTATIVI)) {
            Output.error("Hai raggiunto il numero massimo di tentativi.");
            Output.loading("La parola segreta e' <"
            + this.parolaSegr.getParola() + ">");
            this.pulisci();
        }

        return false;
    }
/**
 *Consente di reimpostare tutto al formato di default.
 */
    public final void pulisci() {
        this.numTentativo = 0;
        this.partitaAvviata = false;
        this.tentativo = new Lettera[MAX_TENTATIVI][ParolaSegreta.LUNGH_PAROLA];
    }
/**
 *Consente di invocare il metodo adatto a seconda del comando ottenuto.
 */
    public final void distributore() {

        Scanner input = new Scanner(System.in);
        String cmd;
        WordleScanner parser = new WordleScanner();
        WordleToken token;

        while (true) {
            System.out.print("Inserisci un comando: ");
            cmd = input.nextLine();
            token = parser.scan(cmd);

            switch (token) {
                case USCITA_PROGRAMMA:
                    esci();
                    break;
                case USCITA_PARTITA:
                    abbandonaPartita();
                    break;
                case NUOVA_PARTITA:
                    gioca();
                    break;
                case AIUTO:
                    aiuto();
                    break;
                case MOSTRA_PAROLA:
                    mostraParola();
                    break;
                case NUOVA_PAROLA:
                    impostaParola(cmd.substring(("/"
                    + WordleScanner.NUOVA_PAROLA_CMD).length() + 1));
                    break;
                case INDOVINA_PAROLA:
                    indovinaParola(cmd);
                    break;
                case INVALIDO:
                    Output.error("Comando inserito errato!");
                    Wordle.aiuto();
                    break;
                default:
                    break;
            }
        }
    }
/**
 *Consente di mostrare i comandi possibili con le relative descrizioni.
 */
    public static void aiuto() {
        System.out.println("Ecco la lista di comandi disponibili: "
                            + "\n /gioca --> avvia una nuova partita"
                            + "\n /abbandona --> abbandona partita in corso"
                            + "\n /esci --> esci dalla partita"
                            + "\n /help --> mostra lista comandi"
                            + "\n Comandi Paroliere:"
                            + "\n /mostra --> visualizza la parola segreta"
                            + "\n /nuova <parola> --> "
                            + "imposta nuova parola segreta");
    }
}

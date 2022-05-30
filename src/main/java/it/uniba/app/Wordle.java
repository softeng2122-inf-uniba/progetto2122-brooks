package it.uniba.app;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Wordle {

    public final Integer MAX_TENTATIVI = 6;
    private Utente utente;
    private ParolaSegreta parolaSegr;
    private Lettera tentativo[][];
    private Integer numTentativo;
    private Boolean partitaAvviata;
    private Boolean parolaImpostata;

    Wordle(Utente utenteRic, ParolaSegreta parolaSegrRic) {
        this.tentativo = new Lettera[MAX_TENTATIVI][ParolaSegreta.LUNGH_PAROLA];
        this.utente = utenteRic;
        this.parolaSegr = parolaSegrRic;
        this.numTentativo = 0;
        this.partitaAvviata = false;
        this.parolaImpostata = true;
    }
    
    Wordle(Utente utenteRic) {
        this.tentativo = new Lettera[MAX_TENTATIVI][ParolaSegreta.LUNGH_PAROLA];
        this.utente = utenteRic;
        this.parolaSegr = null;
        this.numTentativo = 0;
        this.partitaAvviata = false;
        this.parolaImpostata = false;  
    }

    public Utente getUtente() {
        return this.utente;
    }

    public ParolaSegreta getParolaSegr() {
        return this.parolaSegr;
    }

    public Lettera[][] getTentativo() {
        return this.tentativo;
    }

    public Integer getNumTentativo() {
        return this.numTentativo;
    }

    public void aumentaNumTentativo() {
        this.numTentativo++;
    }

    public Boolean isAvviata() {
        return this.partitaAvviata;
    }

    public Boolean isParolaImpostata() {
        return this.parolaImpostata; 
    }

    public void mostraMatrice() {
        int i = 0;
        int j = 0;
        int x = 0;
        System.out.print(" ");
        for(x = 0; x<ParolaSegreta.LUNGH_PAROLA; x++) {
            System.out.print(" " + (x + 1));
        }

        System.out.println();

        for(i = 0; i<MAX_TENTATIVI; i++) {
            System.out.print(i + 1 + " ");
            for(j = 0; j<ParolaSegreta.LUNGH_PAROLA; j++) {
                if(tentativo[i][j]==null) {
                    System.out.print(" ");
                } 
                else {
                    System.out.print(this.tentativo[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    
    public void gioca() {
        if(partitaAvviata == true) {
            Output.error("E' gia'in corso una partita");
        }
        else {
            partitaAvviata=true;
            mostraMatrice();
        }
    }

    public void mostraParola() {
        if(parolaImpostata == true) {
            Output.success("Parola segreta: " + parolaSegr.getParola());
        }
        else {
            Output.error("La parola non e' ancora stata impostata");
        }
    }

    public void esci() {
        String risposta = new String();
        Scanner scanner = new Scanner(System.in);

        do {
            Output.loading("Sicuro di voler uscire? (S/N)");
            risposta = scanner.nextLine();
        } while(!risposta.equalsIgnoreCase("S") && !risposta.equalsIgnoreCase("N"));

        if(risposta.compareTo("S") == 0 || risposta.compareTo("s") == 0)  {
            Output.loading("Uscita dal gioco");
            System.exit(0);
        } 
    }

    public void impostaParola(String nuovaParola) {
        if(this.partitaAvviata == false)
        {
            if (nuovaParola.length() < 5) {
                Output.error("Parola troppo corta");
            } else if(nuovaParola.length() > 5) {
                Output.error("Parola troppo lunga");
            } else if(Pattern.compile(Controllore.REGEX , Pattern.CASE_INSENSITIVE).matcher(nuovaParola).matches() == false) {
                Output.error("Parola segreta non valida");
            } else {
                this.parolaImpostata = true;
                this.parolaSegr = new ParolaSegreta(nuovaParola);
            }
        }
        else
        {
            Output.error("La partita e' in corso");
        }
    }

    public void abbandonaPartita() {
        String risposta = new String();
        Scanner scanner = new Scanner(System.in);

        if(this.partitaAvviata == true) {
            do {
                Output.loading("Sicuro di voler abbandonare questa partita? (S/N)");
                risposta = scanner.nextLine();
            } while(!risposta.equalsIgnoreCase("S") && !risposta.equalsIgnoreCase("N"));

            if(risposta.compareTo("S") == 0 || risposta.compareTo("s") == 0) {
                Output.loading("Partita abbandonata");
                this.pulisci();
            }
        }
        else {
            Output.error("Nessuna partita in corso!");
        }
    }

    public Boolean indovinaParola(String tentativoRic)
    {
        Integer i = 0;

        if(this.partitaAvviata == false)
        {
            Output.error("Partita non avviata!");
            return false;
        }
        if(this.parolaImpostata == false)
        {
            Output.error("Parola non impostata!");
            return false;
        }
        if(tentativoRic.length() < ParolaSegreta.LUNGH_PAROLA) {
            Output.error("Tentativo incompleto!");
            return false;
        }
        else if(tentativoRic.length() > ParolaSegreta.LUNGH_PAROLA) {
            Output.error("Tentativo eccessivo!");
            return false;
        }
        else if((Pattern.compile(Controllore.REGEX, Pattern.CASE_INSENSITIVE).matcher(tentativoRic).matches()) == false) {
            Output.error("Tentativo non valido");
            return false;
        }
        else {
            for(i = 0; i < ParolaSegreta.LUNGH_PAROLA; ++i) {
                this.tentativo[this.numTentativo][i] = new Lettera();
                this.tentativo[this.numTentativo][i].lettera = tentativoRic.charAt(i);

                if(Character.toLowerCase(this.parolaSegr.getParola().charAt(i)) == Character.toLowerCase(tentativoRic.charAt(i)))
                    this.tentativo[this.numTentativo][i].colore = COLORE_CELLA.VERDE;
                else if(this.parolaSegr.getParola().contains(Character.toString(tentativoRic.charAt(i))))
                    this.tentativo[this.numTentativo][i].colore = COLORE_CELLA.GIALLO;
                else
                    this.tentativo[this.numTentativo][i].colore = COLORE_CELLA.GRIGIO;
                }
        }

        this.mostraMatrice();
        this.aumentaNumTentativo();

        if(this.parolaSegr.getParola().equalsIgnoreCase(tentativoRic)) {
            Output.success("Parola segreta indovinata!");
            Output.success("Numero tentativo: " + this.numTentativo);
            this.pulisci();
            return true;
        }
        else if(this.numTentativo == this.MAX_TENTATIVI) {
            Output.error("Hai raggiunto il numero massimo di tentativi.");
            Output.loading("La parola segreta e' <" + this.parolaSegr.getParola() + ">");
            this.pulisci();
        }

        return false;
    }

    public void pulisci()
    {
        this.numTentativo = 0;
        this.partitaAvviata = false;
        this.tentativo = new Lettera[MAX_TENTATIVI][ParolaSegreta.LUNGH_PAROLA];
    }

    public void distributore() {
         
        Scanner input = new Scanner(System.in);
        String cmd;
        WordleScanner parser = new WordleScanner();
        WordleToken token;

        while(true) {
            System.out.print("Inserisci un comando: ");
            cmd = input.nextLine();
            token = parser.scan(cmd);


            switch(token) {
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
                    impostaParola(cmd.substring(("/" + WordleScanner.NUOVA_PAROLA_CMD).length()+1));
                    break;
                case INDOVINA_PAROLA:
                    indovinaParola(cmd);
                    break;
                case INVALIDO:
                    Output.error("Comando inserito errato!");
                    break;
                default:
                    break;
            }
        }
    }

    public static void aiuto() {
        System.out.println("Ecco la lista di comandi disponibili: " +
                             "\n /gioca --> avvia una nuova partita" + 
                             "\n /abbandona --> abbandona partita in corso" +
                             "\n /esc --> esci dalla partita" +
                             "\n /help --> mostra lista comandi" +
                             "\n Comandi Paroliere:" +
                             "\n /mostra --> visualizza la parola segreta" +
                             "\n /nuova <parola> --> imposta nuova parola segreta");
     }
 
}
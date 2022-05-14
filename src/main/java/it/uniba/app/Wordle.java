package it.uniba.app;

public class Wordle {

    public final Integer MAX_TENTATIVI = 6;
    private Utente utente;
    private ParolaSegreta parolaSegr;
    private Lettera tentativo[][];
    private Integer numTentativo;
    private Boolean partitaAvviata;
    private Boolean parolaImpostata;

    Wordle(Utente utenteRic, ParolaSegreta parolaSegrRic) {
        tentativo = new Lettera[MAX_TENTATIVI][parolaSegr.LUNGH_PAROLA];
        this.utente = utenteRic;
        this.parolaSegr = parolaSegrRic;
        this.numTentativo = 0;
        this.partitaAvviata = false;
        this.parolaImpostata = true;
    }
    
    Wordle(Utente utenteRic) {
        tentativo = new Lettera[MAX_TENTATIVI][parolaSegr.LUNGH_PAROLA];
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

    public void mostraMatrice(){
        
    }
    
    public void gioca(String input){
        if(partitaAvviata==true){
            Output.error("E' già in corso una partita");
        }
        else{
            partitaAvviata=true;
            mostraMatrice();
        }
    }
    
}

package it.uniba.app;

public class Wordle 
{
    private Utente utente;
    private ParolaSegreta parolaSegr;
    private Lettera tentativo[][];
    private Integer numTentativo;
    private Boolean partitaAvviata;
    private Boolean parolaImpostata;

    Wordle(Utente utenteRic, ParolaSegreta parolaSegrRic, Integer numTentativoRic, Boolean partitaAvviataRic, Boolean parolaImpostataRic)
    {
        this.utente = utenteRic;
        this.parolaSegr = parolaSegrRic;
        this.numTentativo = numTentativoRic;
        this.partitaAvviata = partitaAvviataRic;
        this.parolaImpostata = parolaImpostataRic;
    }

    public Utente getUtente()
    {
        return this.utente;
    }

    public ParolaSegreta getParolaSegr()
    {
        return this.parolaSegr;
    }

    public Lettera[][] getTentativo()
    {
        return this.tentativo;
    }

    public Integer getNumTentativo()
    {
        return this.numTentativo;
    }

    public void aumentaNumTentativo()
    {
        this.numTentativo++;
    }

    public Boolean IsAvviata()
    {
        return this.partitaAvviata;
    }

    public void setPartitaAvviata()
    {
        if(this.partitaAvviata)
            this.partitaAvviata = false;
        else
            this.partitaAvviata = true;
    }

    public Boolean getIsParolaImpostata()
    {
        return this.parolaImpostata;
    }

    public void setParolaImpostata()
    {
        if(this.parolaImpostata)
            this.parolaImpostata = false;
        else
            this.parolaImpostata = true;
    }
}


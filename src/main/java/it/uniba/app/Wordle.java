package it.uniba.app;

public class Wordle 
{
    private Lettera tentativo[][];
    private Integer numTentativo;
    private Boolean avviata;
    private Boolean impostata;

    Wordle(Lettera tentativoRic[][], Integer numTentativoRic, Boolean avviataRic, Boolean impostataRic)
    {
        this.tentativo = tentativoRic;
        this.numTentativo = numTentativoRic;
        this.avviata = avviataRic;
        this.impostata = impostataRic;
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

    public Boolean getAvviata()
    {
        return this.avviata;
    }

    public void setAvviata()
    {
        if(this.avviata)
            this.avviata = false;
        else
            this.avviata = true;
    }

    public Boolean getImpostata()
    {
        return this.impostata;
    }

    public void setImpostata()
    {
        if(this.impostata)
            this.impostata = false;
        else
            this.impostata = true;
    }
}


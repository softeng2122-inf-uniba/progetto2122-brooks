package it.uniba.app;

class ParolaSegreta
{
    private String parola;
    private final Integer LUNGH_PAROLA = 5;

    ParolaSegreta(String parolaRic)
    {
        if(parola.length()>LUNGH_PAROLA)
            this.parola = parolaRic;
    }

    public String getParola()
    {
        return this.parola;
    }

    public void setParola(String parolaRic)
    {
        this.parola = parolaRic;
    }
}
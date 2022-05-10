package it.uniba.app;

class ParolaSegreta
{
    private String parola;

    ParolaSegreta(String parolaRic)
    {
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
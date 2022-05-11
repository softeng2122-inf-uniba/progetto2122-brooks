package it.uniba.app;

enum COLORE_CELLA
{
    GIALLO,
    GRIGIO,
    VERDE
}

public class Lettera
{
    public char lettera;
    public COLORE_CELLA colore;

     Lettera()
     {
         this.lettera = 0;
         this.colore = COLORE_CELLA.GRIGIO;
     }
    
     Lettera(char letteraRic, COLORE_CELLA coloreRic)
     {
         this.lettera = letteraRic;
         this.colore = coloreRic;
     }
}

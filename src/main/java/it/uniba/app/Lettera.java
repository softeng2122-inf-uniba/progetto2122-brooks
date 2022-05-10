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

     Lettera(char letteraRic, COLORE_CELLA coloreRic)
     {
         this.lettera = letteraRic;
         this.colore = coloreRic;
     }

     public char getLettera()
     {
         return this.lettera;
     }

     public void setLettera(char letteraRic)
     {
         this.lettera = letteraRic;
     }

     public COLORE_CELLA getColore()
     {
         return this.colore;
     }

     public void setColore(COLORE_CELLA coloreRic)
     {
         this.colore = coloreRic;
     }
}
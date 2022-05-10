package it.uniba.app;

public class Lettera
{
    private char lettera;
    private String stato;

     Lettera(char letteraRic, String statoRic)
     {
         this.lettera = letteraRic;
         this.stato = statoRic;
     }

     public char getLettera()
     {
         return this.lettera;
     }

     public void setLettera(char letteraRic)
     {
         this.lettera = letteraRic;
     }

     public String getStato()
     {
         return this.stato;
     }

     public void setStato(String statoRic)
     {
         this.stato = statoRic;
     }
}
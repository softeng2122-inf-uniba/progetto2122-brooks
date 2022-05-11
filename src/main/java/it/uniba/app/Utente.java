package it.uniba.app;

public class Utente 
{
        private String nome;

        Utente(String nomeRic)
        {
            this.nome = nomeRic;
        }

        public String getNome()
        {
            return this.nome;
        }

        public void setNome(String nomeRic)
        {
            this.nome = nomeRic;
        }
}

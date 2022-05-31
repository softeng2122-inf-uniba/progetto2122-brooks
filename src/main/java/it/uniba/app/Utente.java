package it.uniba.app;

public class Utente implements Cloneable{
    
        private String nome;

        Utente(String nomeRic) {
            this.nome = nomeRic;
        }

        public String getNome() {
            return this.nome;
        }

        public void setNome(String nomeRic) {
            this.nome = nomeRic;
        }
        
        @Override
        public Object clone() throws CloneNotSupportedException{
            return super.clone();
        }
}

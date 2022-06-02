package it.uniba.app;

public class Utente implements Cloneable {
/**
 *Nome dell'utente.
 */
    private String nome;

    Utente(final String nomeRic) {
        this.nome = nomeRic;
    }
/**
 *Restituisce l'attributo nome della classe.
 * @return nome
 */
    public String getNome() {
        return this.nome;
    }
/**
 *Modifica l'attributo nome della classe.
 * @param nomeRic
 */
    public void setNome(final String nomeRic) {
        this.nome = nomeRic;
    }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

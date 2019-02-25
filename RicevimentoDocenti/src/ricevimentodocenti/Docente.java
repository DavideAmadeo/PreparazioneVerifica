/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ricevimentodocenti;

/**
 *
 * @author davide
 */
public class Docente {
    private String nome;
    private String giorno;
    private String ora;

    public Docente(String nome, String giorno, String ora) {
        this.nome = nome;
        this.giorno = giorno;
        this.ora = ora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }
    
    
}

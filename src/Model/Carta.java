/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Nilson Augusto
 */
public class Carta {
    private Estado estado;
    private Forma forma;

    public Carta(Estado estado, Forma forma) {
        this.estado = estado;
        this.forma = forma;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Forma getForma() {
        return forma;
    }

    public void setForma(Forma forma) {
        this.forma = forma;
    }
    
    
}

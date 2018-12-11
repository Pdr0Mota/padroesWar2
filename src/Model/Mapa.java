/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Nilson Augusto
 */
public class Mapa {
    private ArrayList<Estado> estados;
    private ArrayList<Regiao> regioes;  

    public Mapa(ArrayList<Estado> estados, ArrayList<Regiao> regioes) {
        this.estados = estados;
        this.regioes = regioes;
    }

    public ArrayList<Estado> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<Estado> estados) {
        this.estados = estados;
    }

    public ArrayList<Regiao> getRegioes() {
        return regioes;
    }

    public void setRegioes(ArrayList<Regiao> regioes) {
        this.regioes = regioes;
    }
    
    
    
}

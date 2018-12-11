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
public class Regiao {
    private String nome;
    private ArrayList<Estado> estados;

    public Regiao(String nome) {
        this.nome = nome;
        this.estados = new ArrayList<Estado>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Estado> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<Estado> estados) {
        this.estados = estados;
    }       
    
}

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
public class Jogador {
    private ArrayList<Carta> cartas;
    private Cor cor;
    private int qtdDeTerritorios;

    public Jogador(ArrayList<Carta> cartas, Cor cor) {
        this.cartas = cartas;
        this.cor = cor;
        qtdDeTerritorios = 0;
    }
    
    public Jogador(Cor cor) {
        this.cartas = null;
        this.cor = cor;
    }
    
    public Jogador() {
        this.cartas = null;
        this.cor = null;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public int getQtdDeTerritorios() {
        return qtdDeTerritorios;
    }

    public void setQtdDeTerritorios(int qtdDeTerritorios) {
        this.qtdDeTerritorios = qtdDeTerritorios;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Carta;
import Model.Cor;
import Model.Estado;
import Model.Exercito;
import Model.Forma;
import Model.Jogador;
import Model.Mapa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Nilson Augusto
 */
public class JogoController {

    private MapaController mapaController;
    private Mapa mapa;
    private ArrayList<Carta> baralho;
    private ArrayList<Cor> cores;
    private ArrayList<Jogador> jogadores;

    public JogoController() {
        this.mapaController = new MapaController();
        this.baralho = new ArrayList<Carta>();
        this.mapa = null;
        this.cores = new ArrayList<Cor>();
        jogadores = new ArrayList<Jogador>();
    }

    public void iniciar(int numJogadores) {
        this.carregarMapa();
        this.carregarBaralho();
        cores = this.carregarCores();
        jogadores = this.carregarJogadores(numJogadores);
        this.distribuicaoInicial();
        this.atualizarQtdDeTerritorio();
    }

    private void carregarMapa() {
        mapa = mapaController.carregar();
    }

    private void distribuicaoInicial() {
        int qtdTropasPorEstado = mapa.getEstados().size() / jogadores.size();
        int resto = mapa.getEstados().size() % jogadores.size();
        int a = 0;
        Collections.shuffle(mapa.getEstados());
        for (int i = 0; i < jogadores.size(); i++) {
            for (int j = 0; j < qtdTropasPorEstado; j++) {
                mapa.getEstados().get(a).getTropas().add(new Exercito(jogadores.get(i).getCor()));
                a++;
            }
        }

        for (int i = 0; i < jogadores.size(); i++) {
            for (int j = 0; j < resto; j++) {
                mapa.getEstados().get(a).getTropas().add(new Exercito(jogadores.get(i).getCor()));
                a++;
            }
        }
    }

    private void carregarBaralho() {
        for (int i = 0; i < mapa.getEstados().size(); i++) {
            if (i < 8) {
                baralho.add(new Carta(mapa.getEstados().get(i), new Forma("circulo")));
            } else if (i >= 8 && i < 16) {
                baralho.add(new Carta(mapa.getEstados().get(i), new Forma("quadrado")));
            } else if (i >= 16 && i < 24) {
                baralho.add(new Carta(mapa.getEstados().get(i), new Forma("triangulo")));
            }

        }
    }

    public void listarMapa() {
        for (int i = 0; i < mapa.getRegioes().size(); i++) {
            System.out.print(mapa.getRegioes().get(i).getNome() + ": ");
            for (int j = 0; j < mapa.getRegioes().get(i).getEstados().size(); j++) {
                int indexOf = mapa.getEstados().indexOf(mapa.getRegioes().get(i).getEstados().get(j));
                System.out.print("[" + mapa.getRegioes().get(i).getEstados().get(j).getNome());
                if (mapa.getEstados().get(indexOf).getTropas().isEmpty()) {
                    System.out.print(" - Nao ha tropas -");
                } else {
                    System.out.print(" " + mapa.getEstados().get(indexOf).getTropas().get(0).getCor().getNome() + " - " + (mapa.getEstados().get(indexOf).getTropas().size()));
                }
                System.out.print("]");
            }
            System.out.print("\n");
        }
    }

    public ArrayList<Cor> carregarCores() {
        cores.add(new Cor("verde"));
        cores.add(new Cor("vermelho"));
        cores.add(new Cor("amarelo"));
        cores.add(new Cor("azul"));
        cores.add(new Cor("branco"));
        cores.add(new Cor("preto"));
        return cores;
    }

    public void atualizarQtdDeTerritorio() {
        for (int j = 0; j < jogadores.size(); j++) {
            int qtdDeTerritorio = 0;
            for (int i = 0; i < mapa.getEstados().size(); i++) {
                if (jogadores.get(j).getCor().equals(mapa.getEstados().get(i).getTropas().get(0).getCor())) {
                    qtdDeTerritorio++;
                }                
            }
            jogadores.get(j).setQtdDeTerritorios(qtdDeTerritorio);
        }
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    private ArrayList<Jogador> carregarJogadores(int numJogadores) {
        for (int i = 0; i < numJogadores; i++) {
            jogadores.add(new Jogador(cores.get(i)));
            System.out.println("Jogador " + (i + 1) + " tem a cor " + cores.get(i).getNome());
        }
        return jogadores;
    }

    public void distribuirTropas(String estado, int qtdTropas) {
        int index = mapa.getEstados().indexOf(new Estado(estado));
        for (int i = 0; i < qtdTropas; i++) {
            mapa.getEstados().get(index).getTropas().add(new Exercito(mapa.getEstados().get(index).getCor()));
        }

    }

    public boolean ataque(String estadoOrigem, String estadoDestino) {
        int dadoAtaque, dadoDefesa;
        dadoAtaque = (new Random().nextInt(7)) + 1;
        dadoDefesa = (new Random().nextInt(7)) + 1;
        return dadoAtaque > dadoDefesa;
    }

    public void moverTropa(String estadoOrigem, String estadoDestino, int qtdMoverTropa) {
        int indexOrigem = mapa.getEstados().indexOf(new Estado(estadoOrigem));
        int indexDestino = mapa.getEstados().indexOf(new Estado(estadoDestino));
        mapa.getEstados().get(indexDestino).setTropas(new ArrayList<Exercito>());
        for (int i = 0; i < qtdMoverTropa; i++) {
            mapa.getEstados().get(indexOrigem).getTropas().remove(0);
            mapa.getEstados().get(indexDestino).getTropas().add(new Exercito(mapa.getEstados().get(indexOrigem).getCor()));
        }
    }

    public boolean verificarVencedor() {
        boolean dominacaoTotal = false;
        for (int i = 0; i < jogadores.size(); i++) {
            if (jogadores.get(i).getQtdDeTerritorios() == mapa.getEstados().size()) {
                dominacaoTotal = true;
                System.out.println("Parabens, o jogardor " + (i + 1) + " venceu!");
            }
        }
        return dominacaoTotal;
    }

}

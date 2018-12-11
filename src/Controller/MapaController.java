/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Estado;
import Model.Mapa;
import Model.Regiao;
import java.util.ArrayList;

/**
 *
 * @author Nilson Augusto
 */
public class MapaController {    
   
    private RegiaoController regiaoController;
    private EstadoController estadoController;
    private ArrayList<Regiao> regioes;
    private ArrayList<Estado> estados;
    private Mapa mapa;

    public MapaController() {
        regiaoController = new RegiaoController();
        estadoController = new EstadoController();
        regioes = new ArrayList<Regiao>();
        estados = new ArrayList<Estado>();
        mapa = null;        
    } 
    
    public Mapa carregar(){
        carregarRegioes();
        carregarEstados();
        carregarVizinhos();
        mapa = new Mapa(estados, regioes);
        return mapa;
    }
    
    public void carregarRegioes(){
        regioes.add(regiaoController.criarRegiao("norte"));
        regioes.add(regiaoController.criarRegiao("nordeste"));
        regioes.add(regiaoController.criarRegiao("centrooeste"));
        regioes.add(regiaoController.criarRegiao("sul"));
        regioes.add(regiaoController.criarRegiao("sudeste"));
    }
    
    public void carregarEstados(){
       estados.add(estadoController.criarEstado("AC"));
       estados.add(estadoController.criarEstado("AM"));
       estados.add(estadoController.criarEstado("AP"));
       estados.add(estadoController.criarEstado("PA"));
       estados.add(estadoController.criarEstado("RO"));
       estados.add(estadoController.criarEstado("RR"));
       estados.add(estadoController.criarEstado("AL"));
       estados.add(estadoController.criarEstado("BA"));
       estados.add(estadoController.criarEstado("CE"));
       estados.add(estadoController.criarEstado("MA"));
       estados.add(estadoController.criarEstado("PE"));
       estados.add(estadoController.criarEstado("PB"));
       estados.add(estadoController.criarEstado("PI"));
       estados.add(estadoController.criarEstado("RN"));
       estados.add(estadoController.criarEstado("SE"));
       estados.add(estadoController.criarEstado("ES"));
       estados.add(estadoController.criarEstado("MG"));
       estados.add(estadoController.criarEstado("RJ"));
       estados.add(estadoController.criarEstado("SP"));
       estados.add(estadoController.criarEstado("GO"));
       estados.add(estadoController.criarEstado("MT"));
       estados.add(estadoController.criarEstado("PR"));
       estados.add(estadoController.criarEstado("RS"));
       estados.add(estadoController.criarEstado("SC"));
    }
    
    public void carregarVizinhos(){
        for (int i = 0; i < estados.size(); i++){
            estados.get(i).addVizinhos();
        }
    }

    public ArrayList<Estado> getEstados() {
        return estados;
    }    
    
}

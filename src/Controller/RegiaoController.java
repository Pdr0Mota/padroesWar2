/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Estado;
import Model.Regiao;
import Model.Regioes.CentroOeste;
import Model.Regioes.Nordeste;
import Model.Regioes.Norte;
import Model.Regioes.Sudeste;
import Model.Regioes.Sul;
import java.util.ArrayList;

/**
 *
 * @author naugu
 */
public class RegiaoController {
    private Regiao regiao;
    private ArrayList<Estado> estados;
    private EstadoController estadosController;

    public RegiaoController() {
        estadosController = new EstadoController();
        this.regiao = null;
    }
    
    public Regiao criarRegiao(String nome){
        if (nome.equals("nordeste")){
            regiao = new Nordeste();
            regiao.getEstados().add(estadosController.criarEstado("BA"));
            regiao.getEstados().add(estadosController.criarEstado("PE"));
            regiao.getEstados().add(estadosController.criarEstado("MA"));
            regiao.getEstados().add(estadosController.criarEstado("CE"));
            regiao.getEstados().add(estadosController.criarEstado("RN"));
            regiao.getEstados().add(estadosController.criarEstado("PB"));
            regiao.getEstados().add(estadosController.criarEstado("PE"));
            regiao.getEstados().add(estadosController.criarEstado("AL"));
            regiao.getEstados().add(estadosController.criarEstado("SE"));
        }else if(nome.equals("norte")){
            regiao = new Norte();
            regiao.getEstados().add(estadosController.criarEstado("AM"));
            regiao.getEstados().add(estadosController.criarEstado("AC"));
            regiao.getEstados().add(estadosController.criarEstado("RR"));
            regiao.getEstados().add(estadosController.criarEstado("RO"));
            regiao.getEstados().add(estadosController.criarEstado("AP"));
            regiao.getEstados().add(estadosController.criarEstado("PA"));
        }else if(nome.equals("centrooeste")){
            regiao = new CentroOeste();
            regiao.getEstados().add(estadosController.criarEstado("MT"));
            regiao.getEstados().add(estadosController.criarEstado("GO"));
            
        }else if(nome.equals("sudeste")){
            regiao = new Sudeste();
            regiao.getEstados().add(estadosController.criarEstado("SP"));
            regiao.getEstados().add(estadosController.criarEstado("MG"));
            regiao.getEstados().add(estadosController.criarEstado("RJ"));
            regiao.getEstados().add(estadosController.criarEstado("ES"));
        }else if(nome.equals("sul")){
            regiao = new Sul();
            regiao.getEstados().add(estadosController.criarEstado("PR"));
            regiao.getEstados().add(estadosController.criarEstado("SC"));
            regiao.getEstados().add(estadosController.criarEstado("RS"));
        }        
        return regiao;
    }
    
    
}

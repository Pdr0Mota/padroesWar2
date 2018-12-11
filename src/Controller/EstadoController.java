/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Estado;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class EstadoController {
    private Estado estado;

    public EstadoController() {
        this.estado = null;
    }    
                
    public Estado criarEstado(String nome){
        Estado estado = new Estado (nome);        
        return estado;
    }   
    
}

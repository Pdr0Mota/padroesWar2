/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Nilson Augusto
 */
public class Estado {
    private String nome;
    private ArrayList<Estado> vizinhos;
    private ArrayList<Exercito> tropas;

    public Estado(String nome) {
        this.nome = nome;
        this.vizinhos = new ArrayList<Estado>();
        this.tropas = new ArrayList<Exercito>();
    }
    
    public void addVizinhos(){
        if (nome.equals("AC")){
            this.vizinhos.add(new Estado("AM"));
            this.vizinhos.add(new Estado("RO"));
        }else if(nome.equals("AM")){
            this.vizinhos.add(new Estado("AC"));
            this.vizinhos.add(new Estado("RO"));
            this.vizinhos.add(new Estado("RR"));
            this.vizinhos.add(new Estado("PA"));
            this.vizinhos.add(new Estado("MT"));
        }else if(nome.equals("AP")){
            this.vizinhos.add(new Estado("PA"));
        }else if(nome.equals("PA")){
            this.vizinhos.add(new Estado("AP"));
            this.vizinhos.add(new Estado("MA"));
            this.vizinhos.add(new Estado("GO"));
            this.vizinhos.add(new Estado("AM"));
            this.vizinhos.add(new Estado("MT"));
        }else if(nome.equals("RO")){
            this.vizinhos.add(new Estado("AC"));
            this.vizinhos.add(new Estado("AM"));
            this.vizinhos.add(new Estado("MT"));
        }else if(nome.equals("RR")){
            this.vizinhos.add(new Estado("AM"));            
            this.vizinhos.add(new Estado("PA"));
        }else if(nome.equals("AL")){
            this.vizinhos.add(new Estado("PE"));
            this.vizinhos.add(new Estado("BA"));
            this.vizinhos.add(new Estado("SE"));
        }else if(nome.equals("BA")){
            this.vizinhos.add(new Estado("GO"));
            this.vizinhos.add(new Estado("PI"));
            this.vizinhos.add(new Estado("PE"));
            this.vizinhos.add(new Estado("MA"));
            this.vizinhos.add(new Estado("AL"));
            this.vizinhos.add(new Estado("SE"));
            this.vizinhos.add(new Estado("MG"));
            this.vizinhos.add(new Estado("ES"));
        }else if(nome.equals("CE")){
            this.vizinhos.add(new Estado("AC"));
            this.vizinhos.add(new Estado("RO"));
            this.vizinhos.add(new Estado("RR"));
            this.vizinhos.add(new Estado("PA"));
            this.vizinhos.add(new Estado("MT"));
        }else if(nome.equals("MA")){
            this.vizinhos.add(new Estado("AC"));
            this.vizinhos.add(new Estado("RO"));
            this.vizinhos.add(new Estado("RR"));
            this.vizinhos.add(new Estado("PA"));
            this.vizinhos.add(new Estado("MT"));
        }else if(nome.equals("PE")){
            this.vizinhos.add(new Estado("AC"));
            this.vizinhos.add(new Estado("RO"));
            this.vizinhos.add(new Estado("RR"));
            this.vizinhos.add(new Estado("PA"));
            this.vizinhos.add(new Estado("MT"));
        }else if(nome.equals("PB")){
            this.vizinhos.add(new Estado("AC"));
            this.vizinhos.add(new Estado("RO"));
            this.vizinhos.add(new Estado("RR"));
            this.vizinhos.add(new Estado("PA"));
            this.vizinhos.add(new Estado("MT"));
        }else if(nome.equals("PI")){
            this.vizinhos.add(new Estado("AC"));
            this.vizinhos.add(new Estado("RO"));
            this.vizinhos.add(new Estado("RR"));
            this.vizinhos.add(new Estado("PA"));
            this.vizinhos.add(new Estado("MT"));
        }else if(nome.equals("RN")){
            this.vizinhos.add(new Estado("AC"));
            this.vizinhos.add(new Estado("RO"));
            this.vizinhos.add(new Estado("RR"));
            this.vizinhos.add(new Estado("PA"));
            this.vizinhos.add(new Estado("MT"));
        }else if(nome.equals("SE")){
            this.vizinhos.add(new Estado("AC"));
            this.vizinhos.add(new Estado("RO"));
            this.vizinhos.add(new Estado("RR"));
            this.vizinhos.add(new Estado("PA"));
            this.vizinhos.add(new Estado("MT"));
        }else if(nome.equals("ES")){
            this.vizinhos.add(new Estado("AC"));
            this.vizinhos.add(new Estado("RO"));
            this.vizinhos.add(new Estado("RR"));
            this.vizinhos.add(new Estado("PA"));
            this.vizinhos.add(new Estado("MT"));
        }else if(nome.equals("MG")){
            this.vizinhos.add(new Estado("AC"));
            this.vizinhos.add(new Estado("RO"));
            this.vizinhos.add(new Estado("RR"));
            this.vizinhos.add(new Estado("PA"));
            this.vizinhos.add(new Estado("MT"));
        }else if(nome.equals("RJ")){
            this.vizinhos.add(new Estado("AC"));
            this.vizinhos.add(new Estado("RO"));
            this.vizinhos.add(new Estado("RR"));
            this.vizinhos.add(new Estado("PA"));
            this.vizinhos.add(new Estado("MT"));
        }else if(nome.equals("SP")){
            this.vizinhos.add(new Estado("AC"));
            this.vizinhos.add(new Estado("RO"));
            this.vizinhos.add(new Estado("RR"));
            this.vizinhos.add(new Estado("PA"));
            this.vizinhos.add(new Estado("MT"));
        }else if(nome.equals("GO")){
            this.vizinhos.add(new Estado("AC"));
            this.vizinhos.add(new Estado("RO"));
            this.vizinhos.add(new Estado("RR"));
            this.vizinhos.add(new Estado("PA"));
            this.vizinhos.add(new Estado("MT"));
        }else if(nome.equals("MT")){
            this.vizinhos.add(new Estado("AC"));
            this.vizinhos.add(new Estado("RO"));
            this.vizinhos.add(new Estado("RR"));
            this.vizinhos.add(new Estado("PA"));
            this.vizinhos.add(new Estado("MT"));
        }else if(nome.equals("PR")){
            this.vizinhos.add(new Estado("AC"));
            this.vizinhos.add(new Estado("RO"));
            this.vizinhos.add(new Estado("RR"));
            this.vizinhos.add(new Estado("PA"));
            this.vizinhos.add(new Estado("MT"));
        }else if(nome.equals("RS")){
            this.vizinhos.add(new Estado("AC"));
            this.vizinhos.add(new Estado("RO"));
            this.vizinhos.add(new Estado("RR"));
            this.vizinhos.add(new Estado("PA"));
            this.vizinhos.add(new Estado("MT"));
        }else if(nome.equals("SC")){
            this.vizinhos.add(new Estado("AC"));
            this.vizinhos.add(new Estado("RO"));
            this.vizinhos.add(new Estado("RR"));
            this.vizinhos.add(new Estado("PA"));
            this.vizinhos.add(new Estado("MT"));
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Estado> getVizinhos() {
        return vizinhos;
    }

    public void setVizinhos(ArrayList<Estado> vizinhos) {
        this.vizinhos = vizinhos;
    }

    public ArrayList<Exercito> getTropas() {
        return tropas;
    }

    public boolean isVizinho(Estado estado){
        return vizinhos.contains(estado);
    }
    
    public Cor getCor(){
        return tropas.get(0).getCor();
    }

    public void setTropas(ArrayList<Exercito> tropas) {
        this.tropas = tropas;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}

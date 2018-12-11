/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brasilwar;

import Controller.JogoController;
import Model.Cor;
import Model.Estado;
import Model.Jogador;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class BrasilWar {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        JogoController controller = new JogoController();
        String destribuicao = "";        
        int numJogadores = 0;
        
        System.out.println("Bem vindo ao BrasilWar");
        System.out.println("Por favor, selecione o numero de jogadores: (de 2 a 6)");
        numJogadores = Integer.parseInt(scanner.nextLine());
        while (numJogadores < 2 || numJogadores > 6){
            System.out.println("Por favor, selecione o numero de jogadores validos (de 2 a 6)");
            numJogadores = scanner.nextInt();
        }
        controller.iniciar(numJogadores);
        
        boolean finalizar = false;
        System.out.println("COMEÇANDO A PARTIDA");
        
        while(!finalizar){
            for (int i = 0; i < numJogadores; i++){
                controller.listarMapa();                
                finalizar = controller.verificarVencedor();
                if (finalizar == true){
                    break;
                }
                int tropasParaDestribuir = (controller.getJogadores().get(i).getQtdDeTerritorios()/2);
                System.out.println("Jogador " + (i+1) + " você tem " + tropasParaDestribuir + " tropas para distribuir");
                int qtdTotalTropas = 0;                
                if (qtdTotalTropas > tropasParaDestribuir){
                    System.out.println("Você selecionou mais tropas do que possui.");
                    System.out.println("Selecione um total de " + tropasParaDestribuir + " tropas");
                }else{
                    System.out.println("Por favor selecione os estados e quantidades, separados por virgula:");
                }
                destribuicao = scanner.nextLine();
                destribuicao = destribuicao.replace(" ","");
                String[] destribuicoes = destribuicao.split(",");                
                for (int a = 0; a < destribuicoes.length; a++){
                    String[] parametros = destribuicoes[a].split(":");
                    String estado = parametros[0].toUpperCase();
                    int qtdTropas = Integer.parseInt(parametros[1]);                    
                    controller.distribuirTropas(estado, qtdTropas);
                    qtdTotalTropas += qtdTropas;
                }                    
            }
            for (int i = 0; i < controller.getJogadores().size(); i++){
                if (finalizar == true){
                    break;
                }
                controller.atualizarQtdDeTerritorio();
                finalizar = controller.verificarVencedor();                
                controller.listarMapa();
                System.out.println("Vez do jogador" + (i+1));
                System.out.println("SELECIONE A OPCAO DESEJADA:");
                System.out.println("1 - Atacar");
                System.out.println("2 - Encerrar");
                
                int opcao = Integer.parseInt(scanner.nextLine());
                if (opcao == 1){
                    System.out.println("Selecione a origdem e destino dos seus ataques, separados por ',' (ex: XX:YY,AA:BB) :");
                    String ataque = scanner.nextLine();
                    String[] ataques = ataque.split(",");                
                        for (int a = 0; a < ataques.length; a++){
                            String[] parametros = ataques[a].split(":");
                            String estadoOrigem = parametros[0].toUpperCase();
                            String estadoDestino = parametros[1].toUpperCase();                    
                            if (controller.ataque(estadoOrigem, estadoDestino)){
                                System.out.println("Você venceu, indique quantas tropas quer mover: ");
                                int qtdMoverTropa = Integer.parseInt(scanner.nextLine());
                                controller.moverTropa(estadoOrigem, estadoDestino, qtdMoverTropa);
                            } else {
                                System.out.println("Você perdeu o ataque");
                            }
                        }
                }else if (opcao == 2){
                    finalizar = true;
                }
            }            
            //finalizar = true;
        }
        
    }
    
    
}

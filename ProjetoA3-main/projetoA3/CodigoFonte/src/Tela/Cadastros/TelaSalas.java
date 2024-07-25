package Tela.Cadastros;

import java.util.Scanner;
import DAO.DAO_Salas;
import EduPack.Salas;

public class TelaSalas {
    
    public void exibir() throws InterruptedException {
        String local;
        int capacidade;

        Scanner teclado = new Scanner(System.in);

        System.out.println("//--------------------//");
        System.out.println("   CADASTRAR SALAS");
        System.out.print("Capacidade de Alunos: ");
        capacidade = teclado.nextInt();
        teclado.nextLine();
        System.out.print("\nLocal: ");
        local = teclado.nextLine();
        System.out.println("       CONCLUIDO");
        System.out.println("//--------------------//\n");

        Salas salas = new Salas(0, capacidade, local);
        salas.setCapacidade(capacidade);
        salas.setLocal(local);
        
        DAO_Salas daoSalas = new DAO_Salas();
        daoSalas.cadastrarSalas(salas);

        clearTerminal();
    }

    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}

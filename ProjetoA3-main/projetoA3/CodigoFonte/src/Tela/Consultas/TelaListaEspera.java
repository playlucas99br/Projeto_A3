package Tela.Consultas;

import java.util.List;
import java.util.Scanner;
import DAO.DAO_ListaEspera;
import EduPack.ListaEspera;

public class TelaListaEspera {
    
    public void exibir() {
        int opc;
        Scanner teclado = new Scanner(System.in);
        DAO_ListaEspera daoEspera = new DAO_ListaEspera();

        do {
            System.out.println("//----------------------//");
            System.out.println("     LISTA DE ESPERA");        

            List<ListaEspera> listaEspera = daoEspera.listar();

            for (ListaEspera espera : listaEspera) {
                System.out.println("\nRA: " + espera.getID());
                System.out.println("Nome: " + espera.getAlunos());
                System.out.println("Sobrenome: " + espera.getTurmas());
                System.out.println("CPF: " + espera.getMatricula());
                System.out.println("-------------------------------------------------------------");
            }

            System.out.println("\n\nDigite 0 para sair.");
            opc = teclado.nextInt();

        } while (opc != 0);
        clearTerminal();
    }

    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
}
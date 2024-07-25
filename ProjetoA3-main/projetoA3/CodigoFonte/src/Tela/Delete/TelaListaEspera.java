package Tela.Delete;


import java.util.Scanner;
import DAO.DAO_ListaEspera;

public class TelaListaEspera {
    
    public void exibir() {
        int ra;
        Scanner teclado = new Scanner(System.in);

        System.out.println("//--------------------//");
        System.out.print("ID do Aluno: ");
        ra = teclado.nextInt();

        DAO_ListaEspera daoEspera = new DAO_ListaEspera();
        daoEspera.remover(ra);

        System.out.println("Deletado com sucesso!");

    }

}

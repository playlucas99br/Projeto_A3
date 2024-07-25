package Tela.Delete;


import java.util.Scanner;
import DAO.DAO_Turmas;

public class TelaTurmas {
    
    public void exibir() {
        int ID;
        Scanner teclado = new Scanner(System.in);

        System.out.println("//--------------------//");
        System.out.print("ID da Turma: ");
        ID = teclado.nextInt();

        DAO_Turmas daoTurmas = new DAO_Turmas();
        daoTurmas.remover(ID);

        clearTerminal();

        System.out.println("Deletado com sucesso!");

    }

    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
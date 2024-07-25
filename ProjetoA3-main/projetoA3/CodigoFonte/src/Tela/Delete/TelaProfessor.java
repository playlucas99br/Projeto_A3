package Tela.Delete;


import java.util.Scanner;
import DAO.DAO_Professor;

public class TelaProfessor {
    
    public void exibir() {
        int id;
        Scanner teclado = new Scanner(System.in);

        System.out.println("//--------------------//");
        System.out.print("ID do Professor: ");
        id = teclado.nextInt();

        DAO_Professor daoProfessor = new DAO_Professor();
        daoProfessor.remover(id);

        System.out.println("Deletado com sucesso!");

        
    }

}

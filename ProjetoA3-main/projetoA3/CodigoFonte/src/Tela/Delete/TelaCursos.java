package Tela.Delete;


import java.util.Scanner;
import DAO.DAO_Cursos;

public class TelaCursos {
    
    public void exibir() {
        int ra;
        Scanner teclado = new Scanner(System.in);

        System.out.println("//--------------------//");
        System.out.print("ID do curso: ");
        ra = teclado.nextInt();

        DAO_Cursos daoCurso = new DAO_Cursos();
        daoCurso.remover(ra);

        System.out.println("Deletado com sucesso!");

    }

}

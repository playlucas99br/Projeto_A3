package Tela.Delete;


import java.util.Scanner;
import DAO.DAO_Aluno;

public class TelaAlunos {
    
    public void exibir() {
        int ra;
        Scanner teclado = new Scanner(System.in);

        System.out.println("//--------------------//");
        System.out.print("RA do Aluno: ");
        
            ra = teclado.nextInt();
        
            DAO_Aluno daoAluno = new DAO_Aluno();
            daoAluno.remover(ra);

            System.out.println("Deletado com sucesso!");

    }

}

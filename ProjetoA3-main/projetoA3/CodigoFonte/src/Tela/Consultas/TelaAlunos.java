package Tela.Consultas;

import java.util.List;
import java.util.Scanner;
import DAO.DAO_Aluno;
import PessoaPack.Aluno;

public class TelaAlunos {
    
    public void exibir() throws InterruptedException {
        int opc;
        Scanner teclado = new Scanner(System.in);
        DAO_Aluno daoAluno = new DAO_Aluno();

        do {
            System.out.println("//----------------------//");
            System.out.println("     LISTA DE ALUNOS");        

            List<Aluno> listaAluno = daoAluno.listar();

            for (Aluno aluno : listaAluno) {
                System.out.println("\nRA: " + aluno.getRa());
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Sobrenome: " + aluno.getSobrenome());
                System.out.println("CPF: " + aluno.getCPF());
                System.out.println("Fone: " + aluno.getfone());
                System.out.println("Endereco: " + aluno.getendereço());
                System.out.println("CEP: " + aluno.getcep());
                System.out.println("Curso: " + aluno.getCurso());
                System.out.println("--------------------------------------------------------------------");
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

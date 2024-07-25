package Tela.Consultas;

import java.util.List;
import java.util.Scanner;
import DAO.DAO_Turmas;
import EduPack.Turmas;

public class TelaTurmas {
    
    public void exibir() {
        int opc;
        Scanner teclado = new Scanner(System.in);
        DAO_Turmas daoTurmas = new DAO_Turmas();

        do {
            System.out.println("//-------------------------//");
            System.out.println("       LISTA DE TURMAS");        

            List<Turmas> listaTurma = daoTurmas.listar();

            for (Turmas curso : listaTurma) {
                System.out.println("\nID: " + curso.getId());
                System.out.println("Semestre: " + curso.getSemestre());
                System.out.println("Ano: " + curso.getAno());
                System.out.println("Curso: " + curso.getCurso());
                System.out.println("Professor: " + curso.getProfessor());
                System.out.println("Sala: " + curso.getSala());
                System.out.println("Alunos: " + curso.getListaAlunos());
                System.out.println("Hora: " + curso.getHora());
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
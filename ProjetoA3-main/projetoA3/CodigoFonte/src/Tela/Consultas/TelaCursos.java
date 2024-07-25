package Tela.Consultas;

import java.util.List;
import java.util.Scanner;
import DAO.DAO_Cursos;
import EduPack.Cursos;

public class TelaCursos {
    
    public void exibir() {
        int opc;
        Scanner teclado = new Scanner(System.in);
        DAO_Cursos daoCursos = new DAO_Cursos();

        do {
            System.out.println("//-------------------------//");
            System.out.println("       LISTA DE CURSOS");        

            List<Cursos> listaCurso = daoCursos.listar();

            for (Cursos curso : listaCurso) {
                System.out.println("\nID: " + curso.getId());
                System.out.println("Nome: " + curso.getNome());
                System.out.println("Carga Horario: " + curso.getCargaHoraria());
                System.out.println("Descricao: " + curso.getDescriçãoSobre());
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

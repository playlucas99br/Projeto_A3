package Tela.Cadastros;

import java.util.Scanner;
import DAO.DAO_Cursos;
import EduPack.Cursos;

public class TelaCursos {
    
    public void exibir() throws InterruptedException {
        String nome, desc;
        int carga;

        Scanner teclado = new Scanner(System.in);

        System.out.println("//--------------------//");
        System.out.println("  CADASTRAR CURSOS");
        System.out.print("\nNome: ");
        nome = teclado.nextLine();
        System.out.print("\nCarga Horaria: ");
        carga = teclado.nextInt();
        teclado.nextLine();
        System.out.print("\nDescricao: ");
        desc = teclado.nextLine();
        System.out.println("       CONCLUIDO");
        System.out.println("//--------------------//\n");

        Cursos cursos = new Cursos(0, nome, carga, desc);
        cursos.setNome(nome);
        cursos.setCargaHoraria(carga);
        cursos.setDescriçãoSobre(desc);
        
        
        DAO_Cursos daoCursos = new DAO_Cursos();
        daoCursos.cadastrarCursos(cursos);

        clearTerminal();
    }

    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}

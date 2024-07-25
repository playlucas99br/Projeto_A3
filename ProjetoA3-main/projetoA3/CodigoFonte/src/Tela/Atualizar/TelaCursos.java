package Tela.Atualizar;

import java.util.List;
import java.util.Scanner;
import DAO.DAO_Cursos;
import EduPack.Cursos;

public class TelaCursos {
    
    public void exibir() {
        String nome, desc;
        int id, carga;

        Scanner teclado = new Scanner(System.in);

        System.out.println("//--------------------//");
        System.out.println("   ATUALIZAR DADOS");
        System.out.print("ID do Curso: ");
        id = teclado.nextInt();
        teclado.nextLine();
        System.out.print("\nNome: ");
        nome = teclado.nextLine();
        System.out.print("\nCarga Horario: ");
        carga = teclado.nextInt();
        teclado.nextLine();
        System.out.print("\nDescricao: ");
        desc = teclado.nextLine();
        

        Cursos cursos = new Cursos(id, nome, carga, desc);
        DAO_Cursos daocCursos = new DAO_Cursos();

        cursos.setId(id);
        cursos.setNome(nome);
        cursos.setCargaHoraria(carga);
        cursos.setDescriçãoSobre(desc);

        daocCursos.atualizar(cursos);

        System.out.println("\nAtualizado com sucesso!");

    }

}

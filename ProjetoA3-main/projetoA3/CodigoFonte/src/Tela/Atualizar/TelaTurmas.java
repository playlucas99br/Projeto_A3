package Tela.Atualizar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.DAO_Aluno;
import DAO.DAO_Cursos;
import DAO.DAO_Professor;
import DAO.DAO_Salas;
import DAO.DAO_Turmas;
import EduPack.Cursos;
import EduPack.Salas;
import EduPack.Turmas;
import PessoaPack.Aluno;
import PessoaPack.Professor;

public class TelaTurmas {

    public void exibir() {
        String hora;
        int semestre, ano, ID, professor, sala, curso;

        Scanner teclado = new Scanner(System.in);

        DAO_Cursos daoCursos = new DAO_Cursos();
        DAO_Professor daoProfessor = new DAO_Professor();
        DAO_Salas daoSala = new DAO_Salas();
        DAO_Aluno daoAluno = new DAO_Aluno();

        List<Cursos> listaCurso = daoCursos.listar();
        List<Professor> listaProfessor = daoProfessor.listar();
        List<Salas> listaSala = daoSala.listar();
        List<Aluno> listaAluno = daoAluno.listar();

        System.out.println("//--------------------//");
        System.out.println("   ATUALIZAR DADOS");
        System.out.print("ID da Turma: ");
        ID = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Semestre: ");
        semestre = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Ano: ");
        ano = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Curso: ");
        curso = teclado.nextInt();
        System.out.println("Professor: ");
        professor = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Sala: ");
        sala = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Alunos (separados por vírgula): ");
        String alunosSelecionados = teclado.nextLine();
        System.out.println("Horario: ");
        hora = teclado.nextLine();

        // Converter os IDs dos alunos selecionados em uma lista de inteiros
        List<Integer> alunosIds = new ArrayList<>();
        String[] alunosIdsArray = alunosSelecionados.split(",");
        for (String id : alunosIdsArray) {
            alunosIds.add(Integer.parseInt(id.trim()));
        }

        Turmas turmas = new Turmas(ID, semestre, ano, curso, professor, sala, hora, alunosIds, alunosSelecionados);

        DAO_Turmas daoTurmas = new DAO_Turmas();

        daoTurmas.atualizar(turmas);

        System.out.println("\nAtualizado com sucesso!");

    }

}
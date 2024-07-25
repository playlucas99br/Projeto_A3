package Tela.Cadastros;

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

    public void exibir() throws InterruptedException {
        String hora;
        int semestre, ano, curso, professor, sala, listaAlunos;

        DAO_Cursos daoCursos = new DAO_Cursos();
        DAO_Professor daoProfessor = new DAO_Professor();
        DAO_Salas daoSala = new DAO_Salas();
        DAO_Aluno daoAluno = new DAO_Aluno();

        List<Cursos> listaCurso = daoCursos.listar();
        List<Professor> listaProfessor = daoProfessor.listar();
        List<Salas> listaSala = daoSala.listar();
        List<Aluno> listaAluno = daoAluno.listar();

        Scanner teclado = new Scanner(System.in);

        System.out.println("//--------------------//");
        System.out.println("   CADASTRAR TURMAS");
        System.out.print("Semestre: ");
        semestre = teclado.nextInt();
        teclado.nextLine();
        System.out.print("\nAno: ");
        ano = teclado.nextInt();
        teclado.nextLine();

        clearTerminal();

        System.out.print("\nEscolha o curso pelo ID: \n");

        for (Cursos cursoDTO : listaCurso) {
            System.out.println("\nID: " + cursoDTO.getId());
            System.out.println("Nome: " + cursoDTO.getNome());
            System.out.println("Carga Horario: " + cursoDTO.getCargaHoraria());
            System.out.println("Descricao: " + cursoDTO.getDescriçãoSobre());
            System.out.println("--------------------------------------------------------------------------------");
        }

        curso = teclado.nextInt();
        teclado.nextLine();

        clearTerminal();

        System.out.print("\nEscolha o professor pelo ID: \n");

        for (Professor profDTO : listaProfessor) {
            System.out.println("\nID: " + profDTO.getId());
            System.out.println("Nome: " + profDTO.getNome());
            System.out.println("Sobrenome: " + profDTO.getSobrenome());
            System.out.println("CPF: " + profDTO.getCPF());
            System.out.println("Fone: " + profDTO.getfone());
            System.out.println("Endereco: " + profDTO.getendereço());
            System.out.println("CEP: " + profDTO.getcep());
            System.out.println("--------------------------------------------------------------------");
        }

        professor = teclado.nextInt();
        teclado.nextLine();

        clearTerminal();

        System.out.print("\nEscolha a sala pelo ID: ");

        for (Salas salas : listaSala) {
            System.out.println("\nID: " + salas.getID());
            System.out.println("Capacidade: " + salas.getCapacidade());
            System.out.println("Local: " + salas.getLocal());
            System.out.println("--------------------------------------------------------------------");
        }

        sala = teclado.nextInt();
        teclado.nextLine();

        clearTerminal();

        System.out.print("\nEscolha o aluno pelo RA: ");

        for (Aluno aluno : listaAluno) {
            System.out.println("\nRA: " + aluno.getRa());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Sobrenome: " + aluno.getSobrenome());
            System.out.println("CPF: " + aluno.getCPF());
            System.out.println("Fone: " + aluno.getfone());
            System.out.println("Endereco: " + aluno.getendereço());
            System.out.println("CEP: " + aluno.getcep());
            System.out.println("--------------------------------------------------------------------");
        }

        
            // Exibir lista de alunos para o usuário escolher
            System.out.println("\nEscolha os alunos pelo RA (separados por vírgula): ");
            for (Aluno aluno : listaAluno) {
                System.out.println("\nRA: " + aluno.getRa() + " - Nome: " + aluno.getNome());
            // exibir outros detalhes do aluno, se necessário
        }

        String alunosSelecionados = teclado.nextLine();

        clearTerminal();

        System.out.print("\nHorario: ");
        hora = teclado.nextLine();
        System.out.println("       CONCLUIDO");
        System.out.println("//--------------------//\n");

        // Converter os IDs dos alunos selecionados em uma lista de inteiros
        List<Integer> alunosIds = new ArrayList<>();
        String[] alunosIdsArray = alunosSelecionados.split(",");
        for (String id : alunosIdsArray) {
            alunosIds.add(Integer.parseInt(id.trim()));
    }
        Turmas turmas = new Turmas(0, 0, 0, 0, 0, 0, hora, alunosIds, alunosSelecionados);

        turmas.setSemestre(semestre);
        turmas.setAno(ano);
        turmas.setCurso(curso);
        turmas.setProfessor(professor);
        turmas.setSala(sala);
        turmas.setHora(hora);
        turmas.setAlunos(alunosIds);

        DAO_Turmas daoTurmas = new DAO_Turmas();

        // Verifica disponibilidade da sala
        if (!daoTurmas.verificarSala(sala, hora)) {
            System.out.println("\nErro: A sala ja esta alocada para outra turma no mesmo horario.");
            return; // Retorna sem adicionar a turma ao banco de dados
        }

        // Verifica disponibilidade do professor
        if (!daoTurmas.verificarProf(professor, hora)) {
            System.out.println("\nErro: O professor ja esta alocado para outra turma no mesmo horario.");
            return; // Retorna sem adicionar a turma ao banco de dados
        }

        daoTurmas.cadastrarTurmas(turmas);

        clearTerminal();
    }

    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
package Tela.Cadastros;

import java.util.List;
import java.util.Scanner;
import DAO.DAO_Aluno;
import DAO.DAO_Cursos;
import EduPack.Cursos;
import PessoaPack.Aluno;

public class TelaAlunos {
    
    public void exibir() throws InterruptedException {
        String nome, sobrenome, CPF, fone, endereco;
        int cep, curso;

        DAO_Cursos daoCursos = new DAO_Cursos();
        
        List<Cursos> listaCurso = daoCursos.listar();

        Scanner teclado = new Scanner(System.in);

        System.out.println("//--------------------//");
        System.out.println("    CADASTRAR ALUNO");
        System.out.print("Nome: ");
        nome = teclado.nextLine();
        System.out.print("\nSobrenome: ");
        sobrenome = teclado.nextLine();
        System.out.print("\nCPF: ");
        CPF = teclado.nextLine();
        System.out.print("\nFone: ");
        fone = teclado.nextLine();
        System.out.print("\nEndereco: ");
        endereco = teclado.nextLine();
        System.out.print("\nCEP: ");
        cep = teclado.nextInt();

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
        System.out.println("       CONCLUIDO");
        System.out.println("//--------------------//\n");

        Aluno aluno = new Aluno(0, nome, sobrenome, CPF, fone, endereco, cep, curso);
        aluno.setNome(nome);
        aluno.setSobrenome(sobrenome);
        aluno.setCPF(CPF);
        aluno.setFone(fone);
        aluno.setEndereço(endereco);
        aluno.setCep(cep);
        aluno.setCurso(curso);

        DAO_Aluno daoAluno = new DAO_Aluno();
        daoAluno.cadastrarAluno(aluno);

        clearTerminal();
    }

    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}

package Tela.Atualizar;

import java.util.List;
import java.util.Scanner;
import DAO.DAO_Professor;
import PessoaPack.Professor;

public class TelaProfessor {
    
    public void exibir() {
        String nome, sobrenome, CPF, fone, endereco;
        int id, cep;

        Scanner teclado = new Scanner(System.in);

        System.out.println("//--------------------//");
        System.out.println("   ATUALIZAR DADOS");
        System.out.print("ID do Professor: ");
        id = teclado.nextInt();
        teclado.nextLine();
        System.out.print("\nNome: ");
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
        

        Professor aluno = new Professor(id, nome, sobrenome, CPF, fone, endereco, cep);
        DAO_Professor daoAluno = new DAO_Professor();

        aluno.setId(id);
        aluno.setNome(nome);
        aluno.setSobrenome(sobrenome);
        aluno.setCPF(CPF);
        aluno.setFone(fone);
        aluno.setEndereço(endereco);
        aluno.setCep(cep);

        daoAluno.atualizar(aluno);

        System.out.println("\nAtualizado com sucesso!");

    }

}

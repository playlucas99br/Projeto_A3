package Tela.Cadastros;

import java.util.Scanner;
import DAO.DAO_Professor;
import PessoaPack.Professor;

public class TelaProfessor {
    
    public void exibir() throws InterruptedException {
        String nome, sobrenome, CPF, fone, endereco;
        int cep;

        Scanner teclado = new Scanner(System.in);

        System.out.println("//--------------------//");
        System.out.println("  CADASTRAR PROFESSOR");
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
        System.out.println("       CONCLUIDO");
        System.out.println("//--------------------//\n");

        Professor Professor = new Professor(0, nome, sobrenome, CPF, fone, endereco, cep);
        Professor.setNome(nome);
        Professor.setSobrenome(sobrenome);
        Professor.setCPF(CPF);
        Professor.setFone(fone);
        Professor.setEndereço(endereco);
        Professor.setCep(cep);

        DAO_Professor daoProfessor = new DAO_Professor();
        daoProfessor.cadastrarProfessor(Professor);

        clearTerminal();
    }

    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}

package Tela.Delete;


import java.util.Scanner;
import DAO.DAO_Salas;

public class TelaSalas {
    
    public void exibir() {
        int ID;
        Scanner teclado = new Scanner(System.in);

        System.out.println("//--------------------//");
        System.out.print("ID da Sala: ");
        ID = teclado.nextInt();

        DAO_Salas daoSalas = new DAO_Salas();
        daoSalas.remover(ID);

        System.out.println("Deletado com sucesso!");

    }

}

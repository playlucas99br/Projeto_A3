package Tela.Atualizar;

import java.util.Scanner;
import DAO.DAO_Salas;
import EduPack.Salas;
import java.util.List;

public class TelaSalas {
    
    public void exibir() {
        String local;
        int id, capacidade;

        Scanner teclado = new Scanner(System.in);

        System.out.println("//--------------------//");
        System.out.println("   ATUALIZAR DADOS");
        System.out.print("ID da Sala: ");
        id = teclado.nextInt();
        teclado.nextLine();
        System.out.print("\nCapacidade: ");
        capacidade = teclado.nextInt();
        teclado.nextLine();
        System.out.print("\nLocal: ");
        local = teclado.nextLine();
        

        Salas salas = new Salas(id, capacidade, local);
        DAO_Salas daosSalas = new DAO_Salas();

        salas.setID(id);
        salas.setCapacidade(capacidade);
        salas.setLocal(local);

        daosSalas.atualizar(salas);

        System.out.println("\nAtualizado com sucesso!");

    }

}

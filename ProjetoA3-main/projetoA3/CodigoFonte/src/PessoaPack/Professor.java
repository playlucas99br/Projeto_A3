package PessoaPack;

public class Professor extends Pessoa {
    
    private int id;


    public Professor(int id, String nome, String sobrenome, String cPF, String fone, String endereço, int cep) {
        super(nome, sobrenome, cPF, fone, endereço, cep);
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

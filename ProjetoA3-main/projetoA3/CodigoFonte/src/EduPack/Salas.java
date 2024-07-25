package EduPack;

public class Salas {

    private int id, capacidade;
    private String local;


    public Salas(int id, int capacidade, String local) {
        this.id = id;
        this.capacidade = capacidade;
        this.local = local;
    }

    
    public int getID() {
        return id;
    }
    public void setID(int id) {
        this.id = id;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public int getCapacidade() {
        return capacidade;
    }
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}

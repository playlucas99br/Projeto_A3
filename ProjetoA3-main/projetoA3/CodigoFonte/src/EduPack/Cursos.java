package EduPack;

public class Cursos {

    private int id;
    private String nome;
    private int cargaHoraria;
    private String DescriçãoSobre;


    public Cursos(int id, String nome, int cargaHoraria, String descriçãoSobre) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        DescriçãoSobre = descriçãoSobre;
    }

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    public String getDescriçãoSobre() {
        return DescriçãoSobre;
    }
    public void setDescriçãoSobre(String descriçãoSobre) {
        DescriçãoSobre = descriçãoSobre;
    }
    
}

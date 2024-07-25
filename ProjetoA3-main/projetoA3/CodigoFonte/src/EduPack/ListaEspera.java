package EduPack;

public class ListaEspera {
    
    private int ID;
    private String alunos;
    private String turmas;


    public ListaEspera(int iD, String alunos, String turmas, String matricula) {
        ID = iD;
        this.alunos = alunos;
        this.turmas = turmas;
        Matricula = matricula;
    }

    
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getAlunos() {
        return alunos;
    }
    public void setAlunos(String alunos) {
        this.alunos = alunos;
    }
    public String getTurmas() {
        return turmas;
    }
    public void setTurmas(String turmas) {
        this.turmas = turmas;
    }
    public String getMatricula() {
        return Matricula;
    }
    public void setMatricula(String matricula) {
        Matricula = matricula;
    }
    private String Matricula; 
}

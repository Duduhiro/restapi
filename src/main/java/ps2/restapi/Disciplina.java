package ps2.restapi;

public class Disciplina {
    private long id;
    private String nome; 
    private String sigla;
    private String curso;
    private int semestre;

    public Disciplina(){}

    public Disciplina(long id, String nome, String sigla, String curso, int semestre) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.curso = curso;
        this.semestre = semestre;
    }

    public String getCurso() {
        return curso;
    }
    public long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public int getSemestre() {
        return semestre;
    }
    public String getSigla() {
        return sigla;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}

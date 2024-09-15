package SistemaDeCadastroDeAlunos.aline.dcx.Ufpb;

import java.util.Objects;

public class Curso {
    private String nomeCurso;


    // Construtor com parâmetros para inicializar 'nome' e 'codigo'
    public Curso(String nomeCurso) {
        this.nomeCurso = nomeCurso;

    }
    // Getter para acessar o nome do curso
    public String getNomeCurso() {
        return nomeCurso;
    }
    // Setter para modificar o nome do curso
    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Curso curso = (Curso) o;
        return nomeCurso.equals(curso.nomeCurso);
    }

    @Override
    public int hashCode() {
        return nomeCurso.hashCode();
    }

    // Método toString para exibir o nome do curso
    @Override
    public String toString() {
        return nomeCurso;
    }
}
// fim do codigo

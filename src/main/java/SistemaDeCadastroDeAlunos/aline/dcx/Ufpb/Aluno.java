package SistemaDeCadastroDeAlunos.aline.dcx.Ufpb;

import java.io.Serializable;

public class Aluno implements Serializable {
   private String nome;  // Nome do aluno
   private String matricula;// Matrícula do aluno d
   private Curso curso; // Curso associado ao aluno


    // Construtor da classe Aluno
   public Aluno(String nome, String matricula, Curso curso){
       this.nome = nome;
       this.matricula = matricula;
       this.curso = curso;
   }

   // Métodos getters para acessar os atributos privados
    public String getNome() {
        return nome;
    }
    public String getMatricula() {
        return matricula;
    }
    public Curso getCurso() {
        return curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aluno aluno = (Aluno) o;
        return nome.equals(aluno.nome) && matricula.equals(aluno.matricula) && curso.equals(aluno.curso);
    }

    @Override
    public int hashCode() {
        int result = nome.hashCode();
        result = 31 * result + matricula.hashCode();
        result = 31 * result + curso.hashCode();
        return result;
    }

    // Método toString para facilitar a exibição dos dados do aluno
    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", curso=" + curso.toString() +
                '}';
    }
}//Fim do codigo
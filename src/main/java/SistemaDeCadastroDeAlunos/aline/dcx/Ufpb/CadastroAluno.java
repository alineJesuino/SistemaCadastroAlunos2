package SistemaDeCadastroDeAlunos.aline.dcx.Ufpb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CadastroAluno {
    // Armazena os alunos cadastrados (matrícula -> Aluno)
    private Map<String, Aluno> alunos = new HashMap<>();

    // Método para cadastrar um aluno no sistema
    public boolean cadastraAluno(String nome, String matricula,Curso curso) {
        if (alunos.containsKey(matricula)) {
            return false;   // Se já existe um aluno com essa matrícula, retorna false
        }
        Aluno aluno = new Aluno(nome, matricula,curso);
        alunos.put(matricula, aluno); // adiciona o aluno ao mapa
        return true;
    }
    //Método para pesquisar uma aluno pela matricula
    public Aluno pesquisaAluno(String matricula) {
        return alunos.get(matricula);
    }

    // Método para listar todos os alunos cadastrados
    public List<Aluno> listarAlunos() {
        return new ArrayList<>(alunos.values());  // Retorna uma lista de todos os alunos
    }

    // Método para listar todos os alunos cadastrados
    public boolean removeAluno(String matricula) {
        return alunos.remove(matricula) != null; // Retorna true se o aluno foi removido
    }


}//Fim do codigo

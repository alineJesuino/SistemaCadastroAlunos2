package SistemaDeCadastroDeAlunos.aline.dcx.Ufpb;
import java.util.List;
import java.util.Map;

public interface SistemaCadastro {
    void cadastrarAluno(Aluno aluno);  // Método para cadastrar um aluno
    Aluno pesquisarAluno(String matricula);  // Método para pesquisar um aluno
    void removerAluno(String matricula);  // Método para remover um aluno
    List<Aluno> listarAlunos();  // Método para listar todos os alunos
}

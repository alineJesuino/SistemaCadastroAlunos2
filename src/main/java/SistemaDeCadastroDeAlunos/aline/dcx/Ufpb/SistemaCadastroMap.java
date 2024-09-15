package SistemaDeCadastroDeAlunos.aline.dcx.Ufpb;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class SistemaCadastroMap implements SistemaCadastro{

    private Map<String, Aluno> alunos = new HashMap<>(); // Mapa para armazenar alunos


    private GravadorDeDados gravador = new GravadorDeDados();

    // Construtor que tenta carregar os dados ao inicializar
     public SistemaCadastroMap() {
         this.gravador = new GravadorDeDados();
         try {
             this.alunos = gravador.carregarDados();  // Carrega os dados do arquivo ao inicializar
         } catch (IOException e) {
             e.printStackTrace();
             this.alunos = new HashMap<>();  // Se houver um erro, inicializa um mapa vazio
         }
     }
    // Implementa  método e cadastro de alunos
    @Override
    public void cadastrarAluno(Aluno aluno) {
        alunos.put(aluno.getMatricula(), aluno);
    }

    //Implementa o método de pesquisa de alunos
    @Override
    public Aluno pesquisarAluno(String matricula) {
        return alunos.get(matricula);
    }


    // Implementa o método para listar todos os alunos
    @Override
    public List<Aluno> listarAlunos() {
        return new ArrayList<>(alunos.values());
    }

    // Implementa o método de remoção de alunos
    @Override
    public void removerAluno(String matricula) {
        alunos.remove(matricula);
    }

}

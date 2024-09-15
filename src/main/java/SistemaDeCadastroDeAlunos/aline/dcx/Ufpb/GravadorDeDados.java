package SistemaDeCadastroDeAlunos.aline.dcx.Ufpb;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {

    private static final String ARQUIVO = "alunos.txt"; // Nome do arquivo onde os dados serão salvos

    // Método para salvar os dados dos alunos em um arquivo
    public void salvarDados(Map<String, Aluno> alunos) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Aluno aluno : alunos.values()) {
                writer.write(aluno.getNome() + "," + aluno.getMatricula() + ","
                        + aluno.getCurso().getNomeCurso() + "," + aluno.getCurso() + "\n");
            }
        }
    }

    //  Método para carregar os dados dos alunos do arquivo
    public Map<String, Aluno> carregarDados() throws IOException {
        Map<String, Aluno> alunos = new HashMap<>();
        File file = new File(ARQUIVO);

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    String[] partes = linha.split(",");
                    if (partes.length == 4) {  // Verifica se há 4 partes: nome, matrícula, nomeCurso, codigoCurso
                        String nome = partes[0];
                        String matricula = partes[1];
                        String nomeCurso = partes[2];
                        String codigoCurso = partes[3];

                        // Criando o objeto Curso
                        Curso curso = new Curso(nomeCurso);  // Cria o objeto Curso a partir do nome
                        Aluno aluno = new Aluno(nome, matricula, curso);
                        alunos.put(matricula, aluno); // Adiciona o aluno ao mapa
                    }
                }
            }
        }

        return alunos;
    }
}
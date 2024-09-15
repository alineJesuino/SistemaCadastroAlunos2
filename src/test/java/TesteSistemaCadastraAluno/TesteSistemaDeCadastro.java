package TesteSistemaCadastraAluno;

import SistemaDeCadastroDeAlunos.aline.dcx.Ufpb.Aluno;
import SistemaDeCadastroDeAlunos.aline.dcx.Ufpb.CadastroAluno;
import SistemaDeCadastroDeAlunos.aline.dcx.Ufpb.Curso;

public class TesteSistemaDeCadastro {
    public static void main(String[] args) {
        // Instancia a classe de cadastro
        CadastroAluno cadastroAluno = new CadastroAluno();
        // Teste 1: Cadastrar um aluno
        System.out.println("Teste 1: Cadastrar Aluno");
        Curso curso1 = new Curso("Ciência da Computação");
        boolean cadastroSucesso = cadastroAluno.cadastraAluno("Maria", "12345", curso1);
        System.out.println("Cadastro bem-sucedido: " + cadastroSucesso);

        // Teste 2: Cadastrar um aluno com a mesma matrícula (espera-se que falhe)
        System.out.println("\nTeste 2: Cadastrar aluno com a mesma matrícula");
        Curso curso2 = new Curso("Engenharia de Software");
        boolean cadastroFalha = cadastroAluno.cadastraAluno("João", "12345", curso2);
        System.out.println("Cadastro bem-sucedido: " + cadastroFalha);  // Espera-se false

        // Teste 3: Pesquisar um aluno existente
        System.out.println("\nTeste 3: Pesquisar Aluno");
        Aluno alunoPesquisado = cadastroAluno.pesquisaAluno("12345");
        if (alunoPesquisado != null) {
            System.out.println("Aluno encontrado: " + alunoPesquisado.getNome() + ", Curso: " + alunoPesquisado.getCurso().getNomeCurso());
        } else {
            System.out.println("Aluno não encontrado.");
        }

        // Teste 4: Remover um aluno existente
        System.out.println("\nTeste 4: Remover Aluno");
        boolean alunoRemovido = cadastroAluno.removeAluno("12345");
        System.out.println("Aluno removido: " + alunoRemovido);

        // Teste 5: Tentar pesquisar aluno removido
        System.out.println("\nTeste 5: Pesquisar Aluno Removido");
        Aluno alunoRemovidoPesquisado = cadastroAluno.pesquisaAluno("12345");
        if (alunoRemovidoPesquisado == null) {
            System.out.println("Aluno não encontrado (como esperado).");
        } else {
            System.out.println("Erro: Aluno ainda está no sistema.");
        }

        // Teste 6: Listar alunos
        System.out.println("\nTeste 6: Listar todos os Alunos");
        Curso curso3 = new Curso("Matemática");
        cadastroAluno.cadastraAluno("Ana", "54321", curso3);  // Cadastra mais um aluno
        System.out.println("Alunos cadastrados: ");
        cadastroAluno.listarAlunos().forEach(aluno -> System.out.println(aluno.toString()));
    }
}


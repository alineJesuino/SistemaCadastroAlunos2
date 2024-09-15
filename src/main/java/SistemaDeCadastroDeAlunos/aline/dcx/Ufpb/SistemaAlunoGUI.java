package SistemaDeCadastroDeAlunos.aline.dcx.Ufpb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaAlunoGUI extends JFrame {
    JLabel titulo;// Titulo da janela

    CadastroAluno cadastroAlunos = new CadastroAluno();// Classe que gerencia os alunos
    // Carrega as imagens

    ImageIcon addImg = new ImageIcon(getClass().getResource("c:/Users/55839/IdeaProjects/SistemaCadastroAlunos/imgs/icons/add.png"));
    ImageIcon pesqImg = new ImageIcon(getClass().getResource("c:/Users/55839/IdeaProjects/SistemaCadastroAlunos/imgs/icons/pesqImg"));
    ImageIcon listImg = new ImageIcon("c:/Users/55839/IdeaProjects/SistemaCadastroAlunos/imgs/icons/list.png");
    ImageIcon delImg = new ImageIcon(getClass().getResource("c:/Users/55839/IdeaProjects/SistemaCadastroAlunos/imgs/icons/del.png"));
    JButton botaoAdicionar, botaoPesquisar,botaoListar, botaoRemover; // Botões para operações


    public SistemaAlunoGUI() {
        setTitle("Sistema de Cadastro de Alunos");
        setSize(800, 600); // Tamanho da janela
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setResizable(false);
        getContentPane().setBackground(Color.white);

        // Configuração para o título
        titulo = new JLabel("Cadastro de Alunos", JLabel.CENTER);
        titulo.setForeground(Color.blue);
        titulo.setFont(new Font("Serif", Font.BOLD, 24));




        // Botões com textos
        botaoAdicionar = new JButton("Adicionar Aluno",addImg);
        botaoAdicionar.setForeground(new Color(111, 76, 129));
        botaoAdicionar.addActionListener(e -> adicionarAluno());

        botaoPesquisar = new JButton("Pesquisar Aluno", pesqImg);
        botaoPesquisar.setForeground(new Color(24, 134, 29));
        botaoPesquisar.addActionListener(e -> pesquisarAluno());

        // Novo botão para listar alunos
        botaoListar = new JButton("Listar Alunos", listImg);
        botaoListar.setForeground(new Color(0, 102, 204));
        botaoListar.addActionListener(e -> listarAlunos());

        // Adiciona ação ao botão
        botaoRemover = new JButton("Remover Aluno", delImg);
        botaoRemover.setForeground(new Color(122, 3, 40));
        botaoRemover.addActionListener(e -> removerAluno());

        // Layout da interface
        getContentPane().setLayout(new GridLayout(5, 1)); // 5 linhas no grid para incluir o novo botão
        getContentPane().add(titulo); // Adiciona o título ao layout
        getContentPane().add(botaoAdicionar);// Adiciona o botão de adicionar aluno
        getContentPane().add(botaoPesquisar);// Adiciona o botão de pesquisar aluno
        getContentPane().add(botaoListar);  // Adiciona o botão de listar alunos
        getContentPane().add(botaoRemover);// Adiciona o botão de remover aluno
    }

    //Método de entrada de dados dos alunos
    public void adicionarAluno() {
        String nome = JOptionPane.showInputDialog("Nome do aluno:");
        String matricula = JOptionPane.showInputDialog("Matrícula do aluno:");
        String nomeCurso = JOptionPane.showInputDialog("Nome do curso:");

        // Cria o objeto Curso com o nome fornecido
        Curso curso = new Curso(nomeCurso);

        // Tenta cadastrar o aluno no sistema
        boolean cadastrou = cadastroAlunos.cadastraAluno(nome, matricula, curso);

        // Mostra uma mensagem de sucesso ou falha
        if (cadastrou) {
            JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Falha ao cadastrar aluno. Verifique se já existe um aluno com essa matrícula.");
        }
    }
    // Método para pesquisar um aluno cadastrado no sistema pela matricula
    public void pesquisarAluno() {
        String matricula = JOptionPane.showInputDialog("Matrícula do aluno a pesquisar:");
        Aluno aluno = cadastroAlunos.pesquisaAluno(matricula); // Pesquisa o aluno pelo número da matrícula

       // Exibe o resultado da pesquisa
        if (aluno != null) {
            JOptionPane.showMessageDialog(this, "Aluno encontrado: " + aluno.toString());
        } else {
            JOptionPane.showMessageDialog(this, "Aluno não encontrado.");
        }
    }
    // Método para listar todos os alunos
    public void listarAlunos() {
        // Obtém a lista de todos os alunos
        java.util.List<Aluno> listaAlunos = cadastroAlunos.listarAlunos();

        // Se houver alunos cadastrados, exibe a lista
        if (listaAlunos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum aluno cadastrado.");

            // Se não houver alunos cadastrados, exibe uma mensagem apropriada
        } else {
            StringBuilder resultado = new StringBuilder("Alunos cadastrados:\n\n");
            for (Aluno aluno : listaAlunos) {
                resultado.append(aluno.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(this, resultado.toString());
        }
    }

// Método para romover um aluno no sistema
    public void removerAluno() {
        String matricula = JOptionPane.showInputDialog("Matrícula do aluno a remover:");
        boolean removeu = cadastroAlunos.removeAluno(matricula);// Tenta remover o aluno
        // Exibe uma mensagem de sucesso ou falha
        if (removeu) {
            JOptionPane.showMessageDialog(this, "Aluno removido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Aluno não encontrado. Operação não realizada.");
        }
    }
    // Método main para iniciar o sistema com a interface gráfica
    public static void main(String[] args) {
        SistemaAlunoGUI gui = new SistemaAlunoGUI();// Cria a janela do sistema
        gui.setVisible(true); // Torna a janela visível
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Define a ação ao fechar a janela
    }
}


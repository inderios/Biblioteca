Isso é uma biblioteca, inspirada na atividade da professora Ayla, tem novos métodos, existe dois sistemas, principais, o da biblioteca, e o gui que implementa a biblioteca para interação com gui.

Este programa é um sistema simples de gerenciamento de biblioteca, implementado em Java, que permite gerenciar usuários e livros, incluindo empréstimos e devoluções. O sistema é composto por várias classes:
Livro: Representa um livro na biblioteca, com atributos como ISBN, título, autor e um indicador de se o livro está emprestado.
SistemaBiblioteca: Gerencia os usuários e livros, permitindo operações como empréstimo e devolução de livros, além de cadastro de usuários e livros. Utiliza mapas (HashMap) para armazenar usuários e livros, 
facilitando a busca rápida por matrícula ou ISBN.
TipoUsuario: Um enum que define os tipos de usuários que podem ser cadastrados no sistema, como PROFESSOR, ALUNO e FUNCIONARIO.
Usuario: Representa um usuário do sistema, com atributos como matrícula, nome, tipo de usuário e uma coleção de livros emprestados. Permite adicionar e remover empréstimos de livros.

O sistema permite:

Cadastrar usuários: Com base no tipo de usuário (professor, aluno, funcionário), permitindo a criação de novos usuários no sistema.
Cadastrar livros: Permite adicionar novos livros ao sistema, identificados por ISBN.
Empréstimo de livros: Permite que um usuário empreste um livro, marcando o livro como emprestado e adicionando-o à lista de livros emprestados do usuário.
Devolução de livros: Permite que um usuário devolva um livro, removendo-o da lista de livros emprestados do usuário e marcando o livro como não emprestado


gui é uma interface gráfica de usuário (GUI) para um sistema de gerenciamento de biblioteca, implementado em Java usando Swing. O sistema permite gerenciar usuários e livros,
incluindo operações como cadastro de usuários e livros, empréstimo e devolução de livros. O sistema é composto por várias classes de GUI, cada uma responsável por uma funcionalidade específica:

CadastroLivro: Permite cadastrar novos livros no sistema, coletando informações como ISBN, título e autor do usuário.
CadastroUsuario: Permite cadastrar novos usuários, coletando matrícula, nome e tipo de usuário (aluno, professor, funcionário).
EmprestimoLivro: Permite que um usuário empreste um livro, coletando a matrícula do usuário e o ID do livro.
TelaInicial: A interface principal que exibe botões para acessar as funcionalidades de cadastro de usuários e livros, e empréstimo de livros.

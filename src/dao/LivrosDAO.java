package dao;

import model.Livros;

import java.sql.SQLException;
import java.util.List;

public interface LivrosDAO {

    void salvar(Livros livro) throws SQLException;

    Livros buscarPorId(int id) throws SQLException;

    List<Livros> listarTodos() throws SQLException;

    void atualizar(Livros livro) throws SQLException;

    void deletar(int id) throws SQLException;
}
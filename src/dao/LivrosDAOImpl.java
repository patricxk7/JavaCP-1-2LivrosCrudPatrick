package dao;

import model.Livros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivrosDAOImpl implements LivrosDAO {

    private Connection connection;

    public LivrosDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void salvar(Livros livro) throws SQLException {
        String sql = "INSERT INTO LIVROS " +
                "(TITULO, ESCRITOR, ANO_LANCAMENTO, GENERO, NOTAS) " +
                "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, livro.getTitulo());
        stmt.setString(2, livro.getEscritor());
        stmt.setInt(3, livro.getAnoLancamento());
        stmt.setString(4, livro.getGenero());
        stmt.setDouble(5, livro.getNotas());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public Livros buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM LIVROS WHERE ID = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet result = stmt.executeQuery();

        Livros livro = null;

        if (result.next()) {
            livro = new Livros();

            livro.setId(result.getInt("ID"));
            livro.setTitulo(result.getString("TITULO"));
            livro.setEscritor(result.getString("ESCRITOR"));
            livro.setAnoLancamento(result.getInt("ANO_LANCAMENTO"));
            livro.setGenero(result.getString("GENERO"));
            livro.setNotas(result.getDouble("NOTAS"));
        }

        result.close();
        stmt.close();

        return livro;
    }

    @Override
    public List<Livros> listarTodos() throws SQLException {
        String sql = "SELECT * FROM LIVROS ORDER BY ID";

        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet result = stmt.executeQuery();

        List<Livros> livros = new ArrayList<>();

        while (result.next()) {
            Livros livro = new Livros();

            livro.setId(result.getInt("ID"));
            livro.setTitulo(result.getString("TITULO"));
            livro.setEscritor(result.getString("ESCRITOR"));
            livro.setAnoLancamento(result.getInt("ANO_LANCAMENTO"));
            livro.setGenero(result.getString("GENERO"));
            livro.setNotas(result.getDouble("NOTAS"));

            livros.add(livro);
        }

        result.close();
        stmt.close();

        return livros;
    }

    @Override
    public void atualizar(Livros livro) throws SQLException {
        String sql = "UPDATE LIVROS SET " +
                "TITULO = ?, " +
                "ESCRITOR = ?, " +
                "ANO_LANCAMENTO = ?, " +
                "GENERO = ?, " +
                "NOTAS = ? " +
                "WHERE ID = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, livro.getTitulo());
        stmt.setString(2, livro.getEscritor());
        stmt.setInt(3, livro.getAnoLancamento());
        stmt.setString(4, livro.getGenero());
        stmt.setDouble(5, livro.getNotas());
        stmt.setInt(6, livro.getId());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM LIVROS WHERE ID = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.executeUpdate();
        stmt.close();
    }
}
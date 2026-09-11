package factory;

import connection.ConnectionSingleton;
import dao.LivrosDAO;
import dao.LivrosDAOImpl;

public class DAOFactory {

    public static LivrosDAO getLivrosDAO() {

        return new LivrosDAOImpl(
                ConnectionSingleton.getConnection()
        );
    }
}

package br.com.bradesco.enge;

import javax.enterprise.context.ApplicationScoped;
import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;

@ApplicationScoped
public class PersonalizationService {

    public void updateOrder(Connection conn, int agencia, int conta, Array ordem) throws SQLException {
        try (var preparedStatement =
                     conn.prepareStatement("INSERT INTO personalizacao (agencia, conta, ordem) VALUES (?, ?, ?)" +
                             " ON CONFLICT (agencia, conta) DO UPDATE SET ordem = excluded.ordem")) {
            preparedStatement.setInt(1, agencia);
            preparedStatement.setInt(2, conta);
            preparedStatement.setArray(3, ordem);
            var rs = preparedStatement.executeUpdate();
        }
    }

}

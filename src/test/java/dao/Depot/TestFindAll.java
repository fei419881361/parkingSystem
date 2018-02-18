package dao.Depot;

import com.parking.system.dbc.DatabaseConnection;
import com.parking.system.factory.DAOFactory;
import com.parking.system.vo.Depot;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestFindAll {
    @Test
    public void test(){
        try {
            List<Depot> depots = DAOFactory.getIDepotDAOInstance(new DatabaseConnection().getConn()).finaAll();
            System.out.println(depots.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package dao.Depot;

import com.parking.system.dbc.DatabaseConnection;
import com.parking.system.factory.DAOFactory;
import com.parking.system.vo.Depot;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class TestDelete {
    @Test
    public void test(){
        Set<Integer> ids = new HashSet<Integer>();
        ids.add(7);
        boolean b = false;
        try {
            b = DAOFactory.getIDepotDAOInstance(new DatabaseConnection().getConn()).doRemove(ids);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(b);
    }
}

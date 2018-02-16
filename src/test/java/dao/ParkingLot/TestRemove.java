package dao.ParkingLot;

import com.parking.system.dbc.DatabaseConnection;
import com.parking.system.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class TestRemove {
    @Test
    public void test(){
        boolean b = false;
        Set<Integer> ids = new HashSet<Integer>();
        ids.add(2);
        try {
            b = DAOFactory.getIParkingLotInstance(new DatabaseConnection().getConn()).doRemove(ids);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(b);
    }
}

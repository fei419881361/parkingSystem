package dao.Depot;

import com.parking.system.dbc.DatabaseConnection;
import com.parking.system.factory.DAOFactory;
import com.parking.system.vo.Depot;
import org.junit.Test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUpdate {
    @Test
    public void test(){
        Date date = new Date();
        boolean b = false;
        Depot depot = new Depot(1,"日本","xx1","12",date,date);
        try {
            b = DAOFactory.getIDepotDAOInstance(new DatabaseConnection().getConn()).doUpdate(depot);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(b);
    }
}

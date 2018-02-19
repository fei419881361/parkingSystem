package dao.ParkingLot;

import com.parking.system.dbc.DatabaseConnection;
import com.parking.system.factory.DAOFactory;
import com.parking.system.vo.ParkingLot;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;

public class TestCreate {
    @Test
    public void test(){
        Date date = new Date();
        boolean b = false;
        ParkingLot parkingLot = new ParkingLot(1,123,"朝天门外30",date,date);
        try {
            for (int i = 0 ; i<10; i++) {
                DAOFactory.getIParkingLotDAOInstance(new DatabaseConnection().getConn()).doCreate(parkingLot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

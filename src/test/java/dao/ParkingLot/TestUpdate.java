package dao.ParkingLot;

import com.parking.system.dbc.DatabaseConnection;
import com.parking.system.factory.DAOFactory;
import com.parking.system.vo.ParkingLot;
import org.junit.Test;


import java.sql.SQLException;
import java.util.Date;

public class TestUpdate {
    @Test
    public void test(){
        Date date = new Date();
        boolean b = false;
        ParkingLot parkingLot = new ParkingLot(1,1,321,"资料发",date,date);
        try {
            b = DAOFactory.getIParkingLotDAOInstance(new DatabaseConnection().getConn()).doUpdate(parkingLot);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(b);
    }
}

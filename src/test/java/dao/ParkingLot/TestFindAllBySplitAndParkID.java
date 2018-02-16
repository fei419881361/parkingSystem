package dao.ParkingLot;

import com.parking.system.dbc.DatabaseConnection;
import com.parking.system.factory.DAOFactory;
import com.parking.system.vo.ParkingLot;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestFindAllBySplitAndParkID {
    @Test
    public void test(){
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        Integer curentPage = 2;
        Integer lineSize =2;
        Integer parkId = 1;
        try {
            parkingLots = DAOFactory.getIParkingLotInstance(new DatabaseConnection().getConn()).findAllBySplitAndParkID(parkId,curentPage,lineSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (ParkingLot parkingLot : parkingLots) {
            System.out.println(parkingLot.toString());
        }
    }
}

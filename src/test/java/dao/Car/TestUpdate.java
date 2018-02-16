package dao.Car;

import com.parking.system.dbc.DatabaseConnection;
import com.parking.system.factory.DAOFactory;
import com.parking.system.vo.Car;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;

public class TestUpdate {
    @Test
    public void test(){
        Date date = new Date();
        boolean b = false;
        Car car = new Car(3,1,"川A8888","资料发","12323",date,date);
        try {
            b = DAOFactory.getICarDAOInstance(new DatabaseConnection().getConn()).doUpdate(car);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(b);
    }
}

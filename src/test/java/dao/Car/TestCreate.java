package dao.Car;

import com.parking.system.dbc.DatabaseConnection;
import com.parking.system.factory.DAOFactory;
import com.parking.system.vo.Car;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;

public class TestCreate {
    @Test
    public void test(){
        Date date = new Date();
        boolean b = false;
        Car car = new Car(1,"川A66666","资料发","12323",date,date);
        try {
            //b = DAOFactory.getICarDAOInstance(new DatabaseConnection().getConn()).doCreate(car);
            for (int i = 0 ; i<10; i++) {
                DAOFactory.getICarDAOInstance(new DatabaseConnection().getConn()).doCreate(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(b);
    }
}

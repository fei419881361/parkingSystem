/*
package dao.Car;

import com.parking.system.dbc.DatabaseConnection;
import com.parking.system.factory.DAOFactory;
import com.parking.system.vo.Car;
import org.junit.Test;

import java.sql.SQLException;

public class TestFindByCarNumAndParkId {
    @Test
    public void test(){
        Car car = new Car();
        car.setCar_num("川A8888");
        car.setPark_id(1);

        try {
            car = DAOFactory.getICarDAOInstance(new DatabaseConnection().getConn()).findByCarNumAndParkID(car);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(car.toString());
    }
}
*/

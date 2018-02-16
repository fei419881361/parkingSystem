package dao.Car;

import com.parking.system.dbc.DatabaseConnection;
import com.parking.system.factory.DAOFactory;
import com.parking.system.vo.Car;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestFindByFuzzy {
    @Test
    public void test(){
        String key = "资料";
        Integer curentPage = 2;
        Integer lineSize =2;
        List<Car> cars = new ArrayList<Car>();
        try {
            cars =  DAOFactory.getICarDAOInstance(new DatabaseConnection().getConn()).findByFuzzy(key,curentPage,lineSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }
}

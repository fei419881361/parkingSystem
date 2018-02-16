package dao.Car;

import com.parking.system.dbc.DatabaseConnection;
import com.parking.system.factory.DAOFactory;
import com.parking.system.vo.Car;
import com.parking.system.vo.Depot;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestFindAllBySplit {
    String colum = "";
    String keyWord = "";
    Integer curentPage = 2;
    Integer lineSize =2;

    List<Car> cars = new ArrayList<Car>();

    @Test
    public void test(){
        try {
            cars = DAOFactory.getICarDAOInstance(new DatabaseConnection().getConn()).findAllBySplit(colum, keyWord, curentPage, lineSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(cars.size());
        for (Car a : cars){
            System.out.println(a.toString());
        }
    }
}

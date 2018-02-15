package dao.Depot;

import com.parking.system.dbc.DatabaseConnection;
import com.parking.system.factory.DAOFactory;
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

    List<Depot> depots = new ArrayList<Depot>();

   @Test
    public void test(){
       try {
           depots = DAOFactory.getIDepotDAOInstance(new DatabaseConnection().getConn()).findAllBySplit(colum, keyWord, curentPage, lineSize);
       } catch (SQLException e) {
           e.printStackTrace();
       }
       System.out.println(depots.size());
       for (Depot a : depots){
           System.out.println(a.toString());
       }
   }
}

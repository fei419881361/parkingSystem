package dao.Admin;

import com.parking.system.dao.Impl.AdminDAOImpl;
import com.parking.system.dbc.DatabaseConnection;
import com.parking.system.factory.DAOFactory;
import com.parking.system.vo.Admin;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestFindAllBySplit {
    @Test
    public void test(){
        List<Admin> admins = new ArrayList<Admin>();
        String colum = "";
        String keyWord = "";
        Integer curentPage = 5;
        Integer lineSize =2;
        try {
            admins = DAOFactory.getIAdminDAOInstance(new DatabaseConnection().getConn()).findAllBySplit(colum,keyWord,curentPage,lineSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(admins.size());
        for (Admin a : admins){
            System.out.println(a.toString());
        }
    }
}

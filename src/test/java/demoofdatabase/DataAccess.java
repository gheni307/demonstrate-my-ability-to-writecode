package demoofdatabase;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess {

    public boolean getCustomer(String customerEmail, Connection connection){

        boolean isCustomerExist = false;
        Statement statement = null;
        ResultSet resultSet = null;
        CachedRowSet cachedRowSet = null;

        try {
            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String sqlScrip = String.format("select customer_id,email from cc_CubeCart_customer where email='%s'", customerEmail);

        try {
            resultSet = statement.executeQuery(sqlScrip);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (resultSet==null){
            System.out.println("No record Fond");
            return isCustomerExist;
        }else {
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        int count = 0;
        while (true){
            try {
                if (!cachedRowSet.next())
                    break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                int customerId = cachedRowSet.getInt("customer_id");
                String email = cachedRowSet.getString("email");
                System.out.println(String.format("product_id=%d email=%s", customerId, email));
                count = cachedRowSet.getRow();
                System.out.println("total Row" + count);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        if (count >=1){
            isCustomerExist = true;
        }
        return isCustomerExist;
    }
}

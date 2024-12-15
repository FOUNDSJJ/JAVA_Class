import java.sql.*;

public class JavaProgram17_1 {

    static String code = "sjj20051206";

    public static void main(String[] args)throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cne) {
            cne.printStackTrace();
        }
        var dburl = "jdbc:mysql://127.0.0.1:3306/webstore?serverTimezone=UTC";
        var sql = "SELECT * FROM books WHERE id < 104";
        var conn = DriverManager.getConnection(dburl, "root", code);
        try(    conn;
                var stmt = conn.prepareStatement(sql);
                var rst = stmt.executeQuery()
        ) {
            while(rst.next()){
                System.out.println(rst.getInt(1)+"\t"+
                        rst.getString(2) +"\t"+rst.getString(3)+
                        "\t"+rst.getDouble(4) +"\t"+rst.getString(5));
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
    }

}

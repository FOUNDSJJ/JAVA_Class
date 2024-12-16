
import java.awt.*;
import java.io.*;
import java.sql.*;

public class JavaAndMySQLDemo {

    //query table with conn and command
    public static void queryTable(Connection conn, String command) {
        System.out.println("--查看表格books");
        try (
                var stmt = conn.prepareStatement(command);
                var rst = stmt.executeQuery()
        ) {
            while (rst.next()) {
                System.out.printf("%3d%15s%10s%15f%20s", rst.getInt(1), rst.getString(2)
                        , rst.getString(3), rst.getDouble(4), rst.getString(5));
                System.out.println();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    //insert photo by binarystream
    public static int insertPhoto(Connection conn, String tableName, String path, int id, String name) throws SQLException, IOException {
        var insertPhoto = "INSERT INTO " + tableName + " VALUES(?,?,?)";
        var pstmt = conn.prepareStatement(insertPhoto);
        var fis = new FileInputStream(path);
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.setBinaryStream(3, fis, (int) (fis.available()));
        return pstmt.executeUpdate();
    }

    //get photo from table
    public static void getPhotoById(Connection conn, String tableName, int id, String storePath) {
        var getPhoto = "SELECT id,name,photo FROM " + tableName + " WHERE id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(getPhoto);
            //将getPhoto中的？设置为id
            pstmt.setInt(1, id);
            ResultSet rst = pstmt.executeQuery();
            if (rst.next()) {
                //创建存放地址的输出流
                FileOutputStream fos = new FileOutputStream(new File(storePath));
                //读取数据库图片存放的二进制流
                InputStream is = rst.getBinaryStream(3);
                byte[] buffer = new byte[4 * 1024];
                int length = 0;
                while ((length = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, length);
                }
                fos.flush();
                fos.close();
                is.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cne) {
            cne.printStackTrace();
        }
        var dburl = "jdbc:mysql://127.0.0.1:3306/webstore?serverTimezone=UTC";
        //command_query_table
        var query = "SELECT * FROM books";//查看表格
        //conmand_insert_data
        var insert = "INSERT INTO books (id,name,author,price,press) VALUES(?,?,?,?,?)";
        //command_delete_data
        var delete = "DELETE FROM books WHERE id = 101";
        //set connection with myaql
        var conn = DriverManager.getConnection(dburl, "root", "code of MySQL");

        //query table
        queryTable(conn,query);

        //insert data into table
        System.out.println("--插入数据(106,\"面向对象程序设计（java）\",\"name\",0,\"武汉大学\")");
        try(PreparedStatement create=conn.prepareStatement(insert)){
            //指定参数
            create.setInt(1,106);
            create.setString(2,"面向对象程序设计（java）");
            create.setString(3,"name");
            create.setDouble(4,0);
            create.setString(5,"武汉大学");
            //更新
            create.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        //query table
        queryTable(conn,query);

        //delete data from table
        System.out.println("--删除id为101的数据（即第一条数据）");
        try{
            int index=conn.createStatement().executeUpdate(delete);
        }catch(SQLException e){
            e.printStackTrace();
        }

        //query table
        queryTable(conn, query);

        //insert photo
        String inputPath = ("C:\\Users\\12198\\Pictures\\武大\\图片1.png");
        int index = insertPhoto(conn, "students", inputPath, 101, "武汉大学");

        //get photo from table(path must endwith ".bmp")
        String storePath = "C:\\Users\\12198\\Pictures\\武大\\武汉大学.bmp";
        getPhotoById(conn, "students", 101, storePath);

    }
}

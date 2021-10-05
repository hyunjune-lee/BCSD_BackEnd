package jdbcExample;

import java.sql.*;

public class Main {
    private static String className = "com.mysql.jdbc.Driver";
    private static String dbUrl = "jdbc:mysql://localhost:3306/dreamhome?serverTimezone=Asia/Seoul&useSSL=false";
    private static String dbUser = "root";
    private static String dbPassword = "";


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // DB 접속
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);


        // [전체 SELECT]----------------------------------------------
        System.out.println("=========================================================");
        System.out.println("SELECT * from branch");
        System.out.println("=========================================================");
        String querySelectAll = "SELECT * from branch";
        PreparedStatement psSelectAll = conn.prepareStatement(querySelectAll);

        // 쿼리 실행 및 결과 얻기
        ResultSet rs = psSelectAll.executeQuery();

        while(rs.next()){
            String branchNo = rs.getString("branchNo");
            String street = rs.getString("street");
            String city = rs.getString("city");
            String postcode = rs.getString("postcode");
            System.out.println("branchNo: " + branchNo + "\nstreet: " + street + "\ncity: " + city + "\npostcode: " + postcode);
            System.out.println("-------------------------");
        }
        //-------------------------------------------------------

        // [INSERT]
        System.out.println("=========================================================");
        System.out.println("INSERT INTO branch (branchNo, street, city, postcode) VALUES ('B004', '199 Doyak St', 'Seoul', 'AWE 3US')");
        System.out.println("=========================================================");

        String query = "INSERT INTO branch (branchNo, street, city, postcode) VALUES ('B004', '199 Doyak St', 'Seoul', 'AWE 3US')";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.executeUpdate();


        // [전체 SELECT]----------------------------------------------
        System.out.println("=========================================================");
        System.out.println("SELECT * from branch");
        System.out.println("=========================================================");

        // 쿼리 실행 및 결과 얻기
        rs = psSelectAll.executeQuery();

        while(rs.next()){
            String branchNo = rs.getString("branchNo");
            String street = rs.getString("street");
            String city = rs.getString("city");
            String postcode = rs.getString("postcode");
            System.out.println("branchNo: " + branchNo + "\nstreet: " + street + "\ncity: " + city + "\npostcode: " + postcode);
            System.out.println("-------------------------");
        }
        //-------------------------------------------------------


        // [서울만 SELECT]----------------------------------------------
        System.out.println("=========================================================");
        System.out.println("SELECT * from branch WHERE city = ?");
        System.out.println("=========================================================");
        String querySelect = "SELECT * from branch WHERE city = ?";
        PreparedStatement psSelect = conn.prepareStatement(querySelect);
        psSelect.setString(1, "Seoul");

        // 쿼리 실행 및 결과 얻기
        rs = psSelect.executeQuery();

        while(rs.next()){
            String branchNo = rs.getString("branchNo");
            String street = rs.getString("street");
            String city = rs.getString("city");
            String postcode = rs.getString("postcode");
            System.out.println("branchNo: " + branchNo + "\nstreet: " + street + "\ncity: " + city + "\npostcode: " + postcode);
            System.out.println("-------------------------");
        }
        //-------------------------------------------------------


        // [UPDATE]
        String query3 = "UPDATE branch SET city = 'Busan' where branchNo = 'B004'";
        PreparedStatement ps3 = conn.prepareStatement(query3);
        ps3.executeUpdate();

        // [SELECT]----------------------------------------------
        System.out.println("=========================================================");
        System.out.println("UPDATE branch SET city = 'Busan' where branchNo = 'B004'");
        System.out.println("=========================================================");

        // 쿼리 실행 및 결과 얻기
        rs = psSelectAll.executeQuery();
        while(rs.next()){
            String branchNo = rs.getString("branchNo");
            String street = rs.getString("street");
            String city = rs.getString("city");
            String postcode = rs.getString("postcode");
            System.out.println("branchNo: " + branchNo + "\nstreet: " + street + "\ncity: " + city + "\npostcode: " + postcode);
            System.out.println("-------------------------");
        }
        //-------------------------------------------------------

        //DELETE 쿼리
        String query4 = "DELETE from branch where city = 'Busan'";
        PreparedStatement ps4 = conn.prepareStatement(query4);
        ps4.executeUpdate();


        // [SELECT]----------------------------------------------
        System.out.println("=========================================================");
        System.out.println("DELETE from branch where name = 'Busan'");
        System.out.println("=========================================================");

        // 쿼리 실행 및 결과 얻기
        rs = psSelectAll.executeQuery();
        while(rs.next()){
            String branchNo = rs.getString("branchNo");
            String street = rs.getString("street");
            String city = rs.getString("city");
            String postcode = rs.getString("postcode");
            System.out.println("branchNo: " + branchNo + "\nstreet: " + street + "\ncity: " + city + "\npostcode: " + postcode);
            System.out.println("-------------------------");
        }
        //-------------------------------------------------------

        conn.close();
    }




}

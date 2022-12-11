package dbClasses;
import models.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends Configs{
    Connection dbConnection;
    public static int loggedUserId = 0;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":" +
                dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }

    public void addNecklece(String name){
        List<Necklace> list = this.getNecklace();
        for(int i = 0;i<list.size();i++) {
            if(list.get(i).equals(name))
                return;
        }
        String insert = "INSERT INTO " + Const.NECKLACE_TABLE + "(" +
                    Const.NECKLACE_NAME + ")" +
                    "VALUES(?)";
            try {

                PreparedStatement statement = getDbConnection().prepareStatement(insert);
                statement.setString(1, name);
                statement.executeUpdate();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        addUserNecklace(loggedUserId,name);
    }

    public void addUserNecklace(int userId,String name){
        int necklaceId = 0;
        System.out.println("??????????????????????????????????");
        List<Necklace> list = this.getNecklace();
        for(int i = 0;i<list.size();i++) {
            if(list.get(i).getName().equals(name))
                necklaceId = list.get(i).getId();
        }
        if(necklaceId == 0)
            return;

        System.out.println("??????????????????????????????????");
        String insert = "INSERT INTO " + Const.USERNECKLACE_TABLE + "("+
                Const.USERNECKLACE_USERID + "," + Const.USERNECKLACE_NECKLACEID + ")"+
                "VALUES(?,?)";
        try {

            PreparedStatement statement = getDbConnection().prepareStatement(insert);
            statement.setInt(1, userId);
            statement.setInt(2, necklaceId);
            statement.executeUpdate();

        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteNecklace(int id){
        String insert ="DELETE from necklace where id = ?";
        try {

            PreparedStatement statement = getDbConnection().prepareStatement(insert);
            statement.setInt(1, id);
            statement.execute();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void deleteNecklaceStone(int necklaceId,int stoneId){
//        String insert = "DELETE FROM "+ Const.NECKLACESTONE_TABLE +
//                "WHERE "+ Const.NECKLACESTONE_NECKLACEID+ " IN (" +
//                "   SELECT "+ Const.NECKLACESTONE_NECKLACEID+" FROM " +
//                Const.NECKLACESTONE_TABLE+" WHERE "+ Const.NECKLACESTONE_NECKLACEID +"=? LIMIT 1" +
//                ")" +"AND IN (" +
//                "   SELECT "+ Const.NECKLACESTONE_STONEID+" FROM " +
//                        Const.NECKLACESTONE_TABLE+" WHERE "+ Const.NECKLACESTONE_STONEID +"=? LIMIT 1" +
//                        ")";
//        try {
//
//            PreparedStatement statement = getDbConnection().prepareStatement(insert);
//            statement.setInt(1, necklaceId);
//            statement.setInt(2, stoneId);
//            statement.executeUpdate();
//        }
//        catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    public void registerUser(String username,String password){
        String insert = "INSERT INTO " + Const.USER_TABLE + "("+
                Const.USER_USERNAME + "," + Const.USER_PASSWORD + ")"+
                "VALUES(?,?)";
        try {

            PreparedStatement statement = getDbConnection().prepareStatement(insert);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void addNecklaceStone(int necklaceId,int stoneId){
        String insert = "INSERT INTO " + Const.NECKLACESTONE_TABLE + "("+
                Const.NECKLACESTONE_NECKLACEID + "," + Const.NECKLACESTONE_STONEID + ")"+
                "VALUES(?,?)";
        try {

            PreparedStatement statement = getDbConnection().prepareStatement(insert);
            statement.setInt(1, necklaceId);
            statement.setInt(2, stoneId);
            statement.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public  int getUser(User user) {
        ResultSet result = null;

        String select = "SELECT * FROM " + Const.USER_TABLE;//+ " WHERE "+
               // Const.USER_USERNAME + "=? AND " + Const.USER_PASSWORD +"=?";
        try {

            PreparedStatement statement = getDbConnection().prepareStatement(select);
            result = statement.executeQuery();
            while(result.next()){
                System.out.println(result.getString(2));
                System.out.println(result.getString(3));
                System.out.println(user.getUsername());
                System.out.println(user.getPassword());

                if(user.getUsername().equals(result.getString(2))
                        && user.getPassword().equals(result.getString(3))){

                    loggedUserId = result.getInt(1);
                    break;
                }
            }
            System.out.println(loggedUserId);
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return loggedUserId;
    }
    public int getLoggedUserId(){
        System.out.println("ID: "+loggedUserId);
        return loggedUserId;
    }

    public  User getUser() {
        ResultSet result = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE "+
                Const.USER_ID + "=?";
        try {

            PreparedStatement statement = getDbConnection().prepareStatement(select);
            statement.setInt(1, loggedUserId);
            result = statement.executeQuery();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return ParseUser(result);
    }
    public  List<Stone> getStones() {
        ResultSet result = null;

        String select = "SELECT * FROM " + Const.STONE_TABLE;
        try {

            PreparedStatement statement = getDbConnection().prepareStatement(select);
            result = statement.executeQuery();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ParseStones(result);
    }

    public  List<NecklaceStone> getNecklaceStones() {
        ResultSet result = null;

        String select = "SELECT * FROM " + Const.NECKLACESTONE_TABLE;
        try {

            PreparedStatement statement = getDbConnection().prepareStatement(select);
            result = statement.executeQuery();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return ParseNecklaceStones(result);
    }

    public  List<UserNecklace> getUserNecklace() {
        ResultSet result = null;

        String select = "SELECT * FROM " + Const.USERNECKLACE_TABLE;//+" WHERE "+Const.USERNECKLACE_USERID+ "=?";
        try {

            PreparedStatement statement = getDbConnection().prepareStatement(select);
            result = statement.executeQuery();

        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return ParseUserNecklaces(result);
    }

    public  List<Necklace> getNecklace() {
        ResultSet result = null;

        String select = "SELECT * FROM " + Const.NECKLACE_TABLE;
        try {

            PreparedStatement statement = getDbConnection().prepareStatement(select);
            result = statement.executeQuery();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return ParseNecklaces(result);
    }

    public List<Stone> ParseStones(ResultSet result){
        List<Stone> stones = new ArrayList<>();
        Stone stone = null;
        try {
            while (result.next()) {
                stone = new Stone(result.getInt(1),result.getString(2),result.getDouble(3),
                        result.getDouble(4),result.getDouble(5),result.getString(6));
                stones.add(stone);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return stones;
    }
    public List<Necklace> ParseNecklaces(ResultSet result){
        List<Necklace> necklaces = new ArrayList<>();
        Necklace necklace = null;
        try {
            while (result.next()) {
                necklace = new Necklace(result.getInt(1),result.getString(2));
                necklaces.add(necklace);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return necklaces;
    }

    public User ParseUser(ResultSet result){
        User user = null;
        try {
            while (result.next()) {
                user = new User(result.getString(2),result.getString(3));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    public List<UserNecklace> ParseUserNecklaces(ResultSet result){
        List<UserNecklace> necklaces = new ArrayList<>();
        UserNecklace necklace = null;
        try {
            while (result.next()) {
                necklace = new UserNecklace(result.getInt(1),result.getInt(2));
                necklaces.add(necklace);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return necklaces;
    }
    public List<NecklaceStone> ParseNecklaceStones(ResultSet result){
        List<NecklaceStone> necklaces = new ArrayList<>();
        NecklaceStone necklace = null;
        try {
            while (result.next()) {
                necklace = new NecklaceStone(result.getInt(1),result.getInt(2));
                necklaces.add(necklace);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return necklaces;
    }

}

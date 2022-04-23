package com.LibraryCT.utilities;


import java.sql.*;
import java.util.*;

public class DB_Utility {

    private static Connection connection;
    private static ResultSet rs;
    private static Statement statement;
    private static ResultSetMetaData rsmd;


    public static void main(String[] args) {



    }


    public static List<Map<String, String>> getAllDataAsListOfMap() {

        List<Map<String, String>> everything = new ArrayList<>();

        for (int i = 1; i <= getRowCount(); i++) {
            everything.add(getRowMap(i));
        }


        return everything;

    }

    public static String getFirstData() {

        return getColumnDataAtRow(1, 1);
    }


    public static Map<String, String> getRowMap(int rowMum) {

        Map<String, String> rowMap = new LinkedHashMap<>();

        try {
            rs.absolute(rowMum);
            ResultSetMetaData rsmd = rs.getMetaData();

            for (int i = 1; i <= getColumnCount(); i++) {

                rowMap.put(rsmd.getColumnName(i), rs.getString(i));

            }
            rs.beforeFirst();
        } catch (SQLException e) {
            System.out.println(("Error while getting getRowMap " + e.getMessage()));
        }

        return rowMap;

    }

    public static void createConnection(String url, String username, String password) {
//        String url = "jdbc:oracle:thin:@54.225.165.105:1521:XE";
//        String username = "hr";
//        String password = "hr";

        try {
            connection = DriverManager.getConnection(url, username, password);
//            System.out.println("CONNECTION SUCCESSFUL");
        } catch (SQLException e) {
            System.out.println("Connection has failed " + e.getMessage());
        }
    }

    public static void runQuery(String query) {

        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery(query);

        } catch (SQLException e) {
            System.out.println(("Error while getting ResultSET " + e.getMessage()));
        }

    }



    public static ResultSet runQuery2(String query) {

        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery(query);

        } catch (SQLException e) {
            System.out.println(("Error while getting ResultSET " + e.getMessage()));
        }
        return rs;
    }


    public static void destroy() {

        try {
            if (rs != null) rs.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static int getRowCount() {
        int rowCount = 0;

        try {
            rs.last();
            rowCount = rs.getRow();
            rs.beforeFirst();
        } catch (SQLException e) {
            System.out.println("Error while getting row count " + e.getMessage());
        }

        return rowCount;
    }

    public static int getColumnCount() {

        int columnCount = 0;

        try {
            rsmd = rs.getMetaData();
            columnCount = rsmd.getColumnCount();
        } catch (SQLException e) {
            System.out.println("Error while getting column count " + e.getMessage());
        }

        return columnCount;
    }


    public static List<String> getColumnNames() {
        List<String> list = new ArrayList<>();

        try {
            rsmd = rs.getMetaData();
            for (int i = 1; i <= getColumnCount(); i++) {
                list.add(rsmd.getColumnName(i));
            }

        } catch (SQLException e) {
            System.out.println("Error while getting column name " + e.getMessage());
        }

        return list;

    }


    public static List<String> getRowDataAsList(int rowNum) {


        List<String> list = new ArrayList<>();

        try {

            rs.absolute(rowNum);

            for (int i = 1; i <= getColumnCount(); i++) {
                list.add(rs.getString(i));
            }
            rs.beforeFirst();

        } catch (SQLException e) {
            System.out.println("Error while getRowDataAsList " + e.getMessage());
        }

        return list;


    }


    public static String getColumnDataAtRow(int rowNum, int columnIndex) {

        String result = "";

        try {
            rs.absolute(rowNum);
            result = rs.getString(columnIndex);
            rs.beforeFirst();
        } catch (SQLException e) {
            System.out.println("Error while getColumnDataAtRow " + e.getMessage());
        }
        return result;

    }

    public static String getColumnDataAtRow(int rowNum, String columnName) {
        String result = "";

        try {
            rs.absolute(rowNum);
            result = rs.getString(columnName);
            rs.beforeFirst();
        } catch (SQLException e) {
            System.out.println("Error while getColumnDataAtRow " + e.getMessage());
        }
        return result;


    }


    public static List<String> getColumnDataAsList(int columnIndex) {
        List<String> list = new ArrayList<>();

        try {
            rs.beforeFirst();
            while (rs.next()) {
                String cellValue = rs.getString(columnIndex);
                list.add(cellValue);
            }
            rs.beforeFirst();
        } catch (SQLException e) {

            System.out.println("Error while getColumnDataAsList " + e.getMessage());
        }
        return list;

    }

    public static List<String> getColumnDataAsList(String columnName) {
        List<String> list = new ArrayList<>();

        try {
            rs.beforeFirst();
            while (rs.next()) {
                String cellValue = rs.getString(columnName);
                list.add(cellValue);
            }
            rs.beforeFirst();
        } catch (SQLException e) {

            System.out.println("Error while getColumnDataAsList " + e.getMessage());
        }
        return list;

    }


    public static void displayAllData() {
        try {
            rs.beforeFirst();


            while (rs.next()) {

                for (int i = 1; i <= getColumnCount(); i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Error while displayAllData " + e.getMessage());
        }
    }


}

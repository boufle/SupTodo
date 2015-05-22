package utils;

import java.sql.*;
import java.sql.Connection;

/**
 * Created by lalfechee on 19/05/2015.
 */


public class Connect
{
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public Connect ()
    {


        try
        {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/SupTodo";
            Class.forName ("com.mysql.jdbc.Driver").newInstance ();
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println ("Database connection established");
        }
        catch (Exception e)
        {
            System.err.println (e);
        }
       /* finally
        {
            if (conn != null)
            {
                try
                {
                    conn.close ();
                    System.out.println ("Database connection terminated");
                }
                catch (Exception e) { }
            }
        }*/
    }

    public boolean testConnectionUser(String login, String password){

        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs = stmt.executeQuery("SELECT * FROM user");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {
                String id = rs.getString("id");
                String log = rs.getString("login");
                String pass = rs.getString("password");
                System.out.println("id: " + id + ", login: " + log
                        + ", password " + pass);

                if (log.equals(login) && pass.equals(password))return true;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public int typeofuser(String log){
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs = stmt.executeQuery("SELECT role FROM user WHERE login = '"+log+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {
                String role = rs.getString("role");
               return Integer.parseInt(role);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 200;
    }

    public String getDescriptionTicket(String nom){

        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs = stmt.executeQuery("SELECT description FROM todo WHERE nom = '"+nom+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {
                String desxription = rs.getString("description");
                return desxription;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String[] getAllTicket() {

    String[] listTicket = new String[255];
        int compteur = 0;

    try {
        stmt = conn.createStatement();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        rs = stmt.executeQuery("SELECT * FROM todo");
    } catch (SQLException e) {
        e.printStackTrace();
    }

    try {
        while (rs.next()) {
            String nom = rs.getString("nom");
            System.out.println("id: " + nom);
            listTicket[compteur] = nom;
            compteur++;

        }

        return listTicket;

    } catch (SQLException e) {
        e.printStackTrace();
    }
        return null;
    }


    public void setToDo (String ToDo, String nom){

        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt.executeUpdate("INSERT INTO todo (nom, description)"+"VALUES ('"+nom+"', '"+ToDo+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void setCheck (boolean check, String nom){

        int i = 0;

        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (check){
                i = 1;
            }
            else i=0;
            stmt.executeUpdate("UPDATE todo "+"SET checkasdone = ('"+i+"')"+"WHERE nom = '"+nom+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public int getCheckTicket(String nom){

        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs = stmt.executeQuery("SELECT checkasdone FROM todo WHERE nom = '" + nom + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {
                String done = rs.getString("checkasdone");
                return Integer.parseInt(done);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void setComment (String nomToDo, String com, int iduser){

        int id = 0;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs = stmt.executeQuery("SELECT id FROM todo WHERE nom = '" + nomToDo + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {
                 id = Integer.parseInt(rs.getString("id"));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            stmt.executeUpdate("INSERT INTO commentaire (todo, body, user)"+"VALUES ('"+id+"', '"+com+"', '"+iduser+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String[] getComment(int id){

        String[] listcomment = new String[255];
        int compteur = 0;

        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs = stmt.executeQuery("SELECT body FROM commentaire WHERE todo = '" + id + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {
                String comment = rs.getString("body");
                listcomment[compteur] = comment;
                compteur++;
            }
            return listcomment;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getIdToDoByName(String nom){
        int id = 0;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs = stmt.executeQuery("SELECT id FROM todo WHERE nom = '" + nom + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {
                id = Integer.parseInt(rs.getString("id"));

            }
            return id;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

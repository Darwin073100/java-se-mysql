package com.jsf.javaandmysql.service;

import com.jsf.javaandmysql.implemet.MessageImplement;
import com.jsf.javaandmysql.model.Message;
import com.jsf.javaandmysql.persistence.Persistence;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edwin
 */
public class MessageService implements MessageImplement {

    Persistence persistence = new Persistence();
    Connection connection = persistence.getConnection();

    @Override
    public Boolean save(Message message) {
        java.sql.Date dateSql = new java.sql.Date(message.getActuallyDate().getTime());
        String query = "INSERT INTO messages VALUES(default,'" + message.getMessage() + "','" + message.getAuthor() + "','" + dateSql + "');";
        try {
            connection.prepareStatement(query).execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    @Override
    public List<Message> findAll() {
        ResultSet result = null;
        String query = "SELECT * FROM messages;";
        List<Message> messages = new ArrayList<>();
        try {
            result = connection.prepareStatement(query).executeQuery();
                while (result.next()) {
                    Message message = new Message(
                            result.getInt("id"),
                            result.getString("message"),
                            result.getString("author"),
                            result.getDate("date"));
                    messages.add(message);
                }
                return messages;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return messages;
    }

    @Override
    public Boolean deleteById(int id) {
        String query = "DELETE FROM messages WHERE(id = " + id + ");";
        try {
            return connection.prepareStatement(query).execute();
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    @Override
    public Boolean update(Message message) {
        String query = "UPDATE messages SET message = '" + message.getMessage() + "', "
                + "author = '" + message.getAuthor() + "', "
                + "date = '" + message.getDate() + "'"
                + "WHERE(id = " + message.getId() + ");";
        try {
            return connection.prepareStatement(query).execute();
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }

    }

    @Override
    public Message findById(int id) {
        ResultSet result;
        Message message = new Message();
        String query = "SELECT * FROM messages WHERE(id = "+id+");";
        try {
            result = connection.prepareStatement(query).executeQuery();
            while (result.next()) {
                message = new Message(
                    result.getInt("id"),
                    result.getString("message"),
                    result.getString("author"),
                    result.getDate("date"));                
            }
            return message;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return message;
    }
    
    
}

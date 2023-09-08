package com.jsf.javaandmysql.implemet;

import com.jsf.javaandmysql.model.Message;
import java.util.List;

/**
 *
 * @author edwin
 */
public interface MessageImplement {
    Boolean save(Message message); 
    List<Message> findAll();
    Boolean deleteById(int id);
    Boolean update(Message message);
    Message findById(int id);
}

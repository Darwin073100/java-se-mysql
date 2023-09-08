package com.jsf.javaandmysql.ui;

import com.jsf.javaandmysql.model.Message;
import com.jsf.javaandmysql.service.MessageService;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author edwin
 */
public class MessageUI {

    MessageService service = new MessageService();

    public void menu() {
        int response = 0;
        do {
            System.out.println("Option Selected");
            System.out.println("1. Read all");
            System.out.println("2. Write");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("0. Exit");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            switch (response) {
                case 1:
                    findAll();
                    break;
                case 2:
                    save();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 0:
                    System.out.println("Good Bye!");
                    break;
            }
        } while (response != 0);
    }

    private void findAll() {
        List<Message> messages = service.findAll();
        for (Message m : messages) {
            System.out.println("========================Row=============================");
            System.out.println("Id: " + m.getId());
            System.out.println("Messages: " + m.getMessage());
            System.out.println("Author: " + m.getAuthor());
            System.out.println("Date: " + m.getDate());
            System.out.println();
        }
        System.out.println("========================End=============================");
    }

    private void save() {
        Message message = new Message();
        Scanner sc = new Scanner(System.in);
        System.out.println("::Public Message");
        System.out.println("Enter your information: ");
        System.out.println("Message: ");
        message.setMessage(sc.nextLine());
        System.out.println("Author: ");
        message.setAuthor(sc.nextLine());

        System.out.println(service.save(message));
        System.out.println("Saved finish...");
    }

    private void delete() {
        System.out.println("::Delete Message");
        System.out.println("Enter Id: ");
        Scanner sc = new Scanner(System.in);
        int id = Integer.valueOf(sc.nextLine());
        service.deleteById(id);
        System.out.println("Delete susses...");
    }

    private void update() {
        Message message;
        int idSearch;
        int option = 0;
        System.out.println("::Update Message");
        do {
            System.out.println("Search Message by ID: ");
            Scanner sc = new Scanner(System.in);
            idSearch = Integer.valueOf(sc.nextLine());
            message = service.findById(idSearch);
            if (message != null) {
                System.out.println("========================Row=============================");
                System.out.println("Id: " + message.getId());
                System.out.println("Messages: " + message.getMessage());
                System.out.println("Author: " + message.getAuthor());
                System.out.println("Date: " + message.getDate());
                System.out.println("=====================================================");
                System.out.println("Enter new Message: ");
                message.setMessage(sc.nextLine());
                System.out.println("Enter new Author: ");
                message.setAuthor(sc.nextLine());
                service.update(message);
                System.out.println("Update susses...");
                option = 0;
            } else {
                System.out.println("Messages don't exist...");
            }
        } while (option != 0);
        
    }
}

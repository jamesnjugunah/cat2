import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class RegistrationForm {

    private JFrame Title;
    private JPanel panel;
    private JLabel nameLabel, usernameLabel, passwordLabel, confirmPasswordLabel, emailLabel, phoneLabel, addressLabel;
    private JTextField nameField, usernameField, passwordField, confirmPasswordField, emailField, phoneField, addressField;
    private JButton  submitButton, resetButton, closeButton;


    public RegistrationForm() {
        JFrame  Title= new JFrame("Registration Form");
        Title.setSize(400, 500);
        Title.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        panel.add(nameLabel);
        panel.add(nameField);

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        panel.add(usernameLabel);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        panel.add(passwordLabel);
        panel.add(passwordField);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        JPasswordField confirmPasswordField = new JPasswordField();
        panel.add(confirmPasswordLabel);
        panel.add(confirmPasswordField);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        panel.add(emailLabel);
        panel.add(emailField);

        JLabel phoneLabel = new JLabel("Phone:");
        JTextField phoneField = new JTextField();
        panel.add(phoneLabel);
        panel.add(phoneField);

        JLabel addressLabel = new JLabel("Address:");
        JTextField addressField = new JTextField();
        panel.add(addressLabel);
        panel.add(addressField);

        JButton submitButton = new JButton("Submit");
        JButton resetButton = new JButton("Reset");
        JButton closeButton = new JButton("Close");


        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear the form fields
                nameField.setText("");
                usernameField.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
                emailField.setText("");
                phoneField.setText("");
                addressField.setText("");
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Exit the program
                System.exit(0);
            }
        });

        panel.add(submitButton);
        panel.add(resetButton);
        panel.add(closeButton);

        Title.getContentPane().add(panel);
        Title.setVisible(true);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    String url = "jdbc:mysql://localhost:3306/registration";
                    Connection connection = DriverManager.getConnection(url);
                    String insertSQL = "INSERT INTO registration (Name,Username,Password,Email,Phone,Address) VALUES (?,?,?,?,?,?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)){
                    String name = nameField.getText();
                    String username = usernameField.getText();
                    String password = passwordField.getText();
                    String confirmPassword = confirmPasswordField.getText();
                    String email = emailField.getText();
                    String phone = phoneField.getText();
                    String address = addressField.getText();
                    if(name.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please fill all the fields");
                    }
                    else if(!password.equals(confirmPassword)){
                        JOptionPane.showMessageDialog(null, "Password and Confirm Password must be same");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Registration Successful");
                    }
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
                // Register the user

            }
        });

    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}


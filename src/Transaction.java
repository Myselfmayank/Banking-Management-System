import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class Transaction extends JFrame implements ActionListener {

    JLabel l1,nameLabel;
    JButton button1,button2,button3,button4,button5,button6;
    private final String pin;

    Transaction(String pin){

        this.pin=pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 900);
        add(l2);

        Conn conn = new Conn();
        String custName="";
        try {
            // retrieving customer's name
            ResultSet res = conn.statement.executeQuery("SELECT NAME FROM signup WHERE custid=(SELECT custid FROM signup3 WHERE pin='"+pin+"')");
            if(res.next()) {
                custName = res.getString("name");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        nameLabel = new JLabel("HI! "+custName);
        nameLabel.setForeground(Color.black);
        nameLabel.setFont(new Font("System",Font.BOLD,40));

        button1 = new JButton("DEPOSIT");
        button2 = new JButton("CASH WITHDRAWAL");
        //button3 = new JButton("FAST CASH");
        button3 = new JButton("MINI STATEMENT");
        button4 = new JButton("PIN CHANGE");
        button5 = new JButton("BALANCE ENQUIRY");
        button6 = new JButton("EXIT");

        /*button1 = new JButton("DEPOSIT");
        button1.setFont(new Font("System", Font.BOLD, 18));
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);*/

        /*button2 = new JButton("CASH WITHDRAWL");
        button2.setFont(new Font("System", Font.BOLD, 18));
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);*/

       /* button3 = new JButton("FAST CASH");
        button3.setFont(new Font("System", Font.BOLD, 18));
        button3.setBackground(Color.BLACK);
        button3.setForeground(Color.WHITE); */

        /*button4 = new JButton("MINI STATEMENT");
        button4.setFont(new Font("System", Font.BOLD, 18));
        button4.setBackground(Color.BLACK);
        button4.setForeground(Color.WHITE);*/

        /*button5 = new JButton("PIN CHANGE");
        button5.setFont(new Font("System", Font.BOLD, 18));
        button5.setBackground(Color.BLACK);
        button5.setForeground(Color.WHITE);*/

        /*button6 = new JButton("BALANCE ENQUIRY");
        button6.setFont(new Font("System", Font.BOLD, 18));
        button6.setBackground(Color.BLACK);
        button6.setForeground(Color.WHITE);*/

        /*b7 = new JButton("EXIT");
        b7.setFont(new Font("System", Font.BOLD, 18));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);*/


        setLayout(null);

        l1.setBounds(235,320,700,35);
        l2.add(l1);

        nameLabel.setBounds(230,150,700,50);
        l2.add(nameLabel);

        button1.setBounds(170,410,150,30);
        l2.add(button1);

        button2.setBounds(390,410,150,30);
        l2.add(button2);

        /*button3.setBounds(170,543,150,35);
        bankName.add(button3);*/

        button3.setBounds(170,450,150,30);
        l2.add(button3);

        button4.setBounds(390,450,150,30);
        l2.add(button4);

        button5.setBounds(170,490,150,30);
        l2.add(button5);

        button6.setBounds(390,490,150,30);
        l2.add(button6);


        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        //b7.addActionListener(this);


        setSize(960,1080);
        setLocation(360,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()== button1){

            setVisible(false);
            new Deposit(pin).setVisible(true);

        }
        else if(ae.getSource()== button2){

            new Withdrawal(pin).setVisible(true);
            setVisible(false);

        }
       /* else if(ae.getSource()==button3){

            new FastCash().setVisible(true);
            setVisible(false);

        }*/
        else if(ae.getSource()== button3){

            new MiniStatement(pin).setVisible(true);

        }else if(ae.getSource()== button4){

            setVisible(false);
            new Pin(pin).setVisible(true);

        }else if(ae.getSource()== button5) {
            setVisible(false);
            new Balance(pin).setVisible(true);
        }
        else if(ae.getSource()== button6){

            System.exit(0);

        }




    }

    public static void main(String[] args){
        new Transaction("").setVisible(true);
    }
}

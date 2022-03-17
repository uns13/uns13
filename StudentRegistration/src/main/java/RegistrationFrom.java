import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class RegistrationFrom extends JDialog
{
    private JTextField txtname;
    private JTextField txterollno;
    private JTextField txtstd;
    private JTextField txtsec;
    private JTextField txtemail;
    private JTextField txtcnt;
    private JButton SubmitB;
    private JButton cancelB;
    private JPanel Registerpanel;

    public RegistrationFrom(JFrame parent) {
        super(parent);
        setTitle("Student Registration");
        setContentPane(Registerpanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        SubmitB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        cancelB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });
        setVisible(true);
    }


    private void registerUser() {
        String StudentName = txtname.getText();
        String ERollNo = txterollno.getText();
        String Std = txtstd.getText();
        String sec = txtsec.getText();
        String mail = txtemail.getText();
        String cnt = txtcnt.getText();

        if (StudentName.isEmpty() || ERollNo.isEmpty() || Std.isEmpty() ||
                sec.isEmpty() || mail.isEmpty() || cnt.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please Enter All Fields", "Try Again", JOptionPane.ERROR_MESSAGE);
            return;
        }
        user = addUserToDatabase(StudentName, ERollNo, Std, sec, mail, cnt);
        if (user != null) {
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to Register new user",
                    "Try Again", JOptionPane.ERROR_MESSAGE);
        }
    }
    public User user;
    private User addUserToDatabase(String StudentName, String ERollNo, String Standerd,
                                   String Section, String EMail, String ContactNo) {

        User user = null;
        final String DB_URL = "jdbc:mysql://localhost:3306/studentregiste";
        final String USERNAME = "";
        final String PASSWORD = "";
        try {
            Connection con = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement st = con.createStatement();
            String sql = "INSERT INTO newregister (StudentName, ERollNo, Standerd, Section, EMail, ContactNo)" +
                    "VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, StudentName);
            preparedStatement.setString(2, ERollNo);
            preparedStatement.setString(3, Standerd);
            preparedStatement.setString(4, Section);
            preparedStatement.setString(5, EMail);
            preparedStatement.setString(6, ContactNo);

            int addedRows = preparedStatement.executeUpdate();
            if (addedRows > 0 ) {
                user = new User();
                user.StudentName = StudentName;
                user.ERollNo = ERollNo;
                user.Standerd = Standerd;
                user.Section = Section;
                user.EMail = EMail;
                user.ContactNo = ContactNo;

                st.close();
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void main(String[] args) {
        RegistrationFrom myfrom = new RegistrationFrom(null);
        User user = myfrom.user;
        if (user != null) {
            System.out.println("successfully Registered : " + user.StudentName);
        } else {
            System.out.println("Registration Canceled...");
        }
    }
}

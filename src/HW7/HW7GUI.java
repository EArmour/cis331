/** Author Name: Evan Armour
 * CIS331, Section 2, Fall 2013
 * Homework 7
 * Purpose: The purpose of this assignment is to bring together all the concepts
 * covered throughout the course, as well as introducing database interaction
 * using ODBC. It also covers GUI, polymorphism, and inheritance in some detail.
 */
package HW7;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.event.*;

public class HW7GUI extends JFrame 
{
  public static HW7GUI firstFrame = new HW7GUI();
  
  public static void main(String[] args)
  {
    firstFrame.setLocationRelativeTo(null);
    firstFrame.setVisible(true);
  }
  
  JButton btnRead = new JButton("Read File");
  JButton btnClear = new JButton("Clear DB");
  JButton btnLoad = new JButton("Load DB");
  JButton btnCRUD = new JButton("Edit DB");
  
  public HW7GUI()
  {
    setTitle("Person Database GUI");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(750, 250);
 
    JPanel buttonPanel = new JPanel(new GridLayout());
    buttonPanel.add(btnRead);
    buttonPanel.add(btnClear);
    buttonPanel.add(btnLoad);
    buttonPanel.add(btnCRUD);
    add(buttonPanel, BorderLayout.SOUTH);
    
    btnRead.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(Person.readPeople())
          JOptionPane.showMessageDialog(rootPane, "People loaded from file!");
      }
    });
    
    btnClear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(Person.clearDB())
          JOptionPane.showMessageDialog(rootPane, "Database Cleared!");
      }
    });
    
    btnLoad.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(Person.loadDB())
          JOptionPane.showMessageDialog(rootPane, "Database Loaded!");
      }
    });
    
    //Hide menu frame and open CRUD frame for editing
    btnCRUD.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(Faculty.totFaculty == 0)
          JOptionPane.showMessageDialog(rootPane, "There are no faculty to modify!");
        else
        {
          firstFrame.setVisible(false);
          CRUDGUI CRUDFrame = new CRUDGUI();
          CRUDFrame.setLocationRelativeTo(firstFrame);
          CRUDFrame.setVisible(true);
        }
      }
    });
  }
  
  class CRUDGUI extends JFrame
  {
    int display = -1;
    JButton btnAdd = new JButton("Add Faculty");
    JButton btnMod = new JButton("Mod Faculty");
    JButton btnClear = new JButton("Clear");
    JButton btnPrev = new JButton("<--");
    JButton btnNext = new JButton("-->");
    JButton btnReturn = new JButton("Exit");
    JTextField txtFName = new JTextField();
    JTextField txtLName = new JTextField();
    JTextField txtAge = new JTextField();
    JComboBox boxMarital = new JComboBox(new String[] {"Unknown",
      "Married","Divorced","Widowed","Single"});
    JComboBox boxGender = new JComboBox(new String[] {"Unknown",
      "Male","Female"});
    JComboBox boxRank = new JComboBox(new String[] {"Assistant Professor",
      "Full Professor","Instructor"});
    
    public CRUDGUI()
    {
      setTitle("Faculty Management");
      setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      setSize(600, 250);
    
      //Field labels will be on the left
      JPanel labelsPanel = new JPanel(new GridLayout(6,1));
      labelsPanel.add(new JLabel("First Name: ", JLabel.RIGHT));
      labelsPanel.add(new JLabel("Last Name: ", JLabel.RIGHT));
      labelsPanel.add(new JLabel("Age: ", JLabel.RIGHT));
      labelsPanel.add(new JLabel("Marital Status: ", JLabel.RIGHT));
      labelsPanel.add(new JLabel("Gender: ", JLabel.RIGHT));
      labelsPanel.add(new JLabel("Rank: ", JLabel.RIGHT));

      //Text fields/boxes on the right
      JPanel fieldsPanel = new JPanel(new GridLayout(6, 1));
      fieldsPanel.add(txtFName);
      fieldsPanel.add(txtLName);
      fieldsPanel.add(txtAge);
      fieldsPanel.add(boxMarital);
      fieldsPanel.add(boxGender);
      fieldsPanel.add(boxRank);

      JPanel buttonPanel = new JPanel(new GridLayout());
      buttonPanel.add(btnAdd);
      buttonPanel.add(btnMod);
      buttonPanel.add(btnClear);
      buttonPanel.add(btnPrev);
      btnPrev.setVisible(false);
      buttonPanel.add(btnNext);
      buttonPanel.add(btnReturn);

      //Assemble panels into the frame
      add(labelsPanel, BorderLayout.WEST);
      add(fieldsPanel, BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.SOUTH);
      
      btnPrev.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          display--;
          btnNext.setVisible(true);
          
          String[] results = Person.query(Faculty.faculty[display]);
          txtFName.setText(results[0]);
          txtLName.setText(results[1]);
          txtAge.setText(results[2]);
          boxMarital.setSelectedItem(results[3]);
          boxGender.setSelectedItem(results[4]);
          boxRank.setSelectedItem(results[5]);
          
          if(display == 0)
            btnPrev.setVisible(false);
        }
      });
            
      btnNext.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          display++;
          if(display > 0)
            btnPrev.setVisible(true);
          
          String[] results = Person.query(Faculty.faculty[display]);
          txtFName.setText(results[0]);
          txtLName.setText(results[1]);
          txtAge.setText(results[2]);
          boxMarital.setSelectedItem(results[3]);
          boxGender.setSelectedItem(results[4]);
          boxRank.setSelectedItem(results[5]);
          
          if(display + 2 > Faculty.totFaculty)
            btnNext.setVisible(false);
        }
      });
      
      btnClear.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          txtAge.setText("");
          txtFName.setText("");
          txtLName.setText("");
        }
      });
      
      btnMod.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {          
          if(txtFName.getText().equals("") || txtLName.getText().equals("") || 
                  txtAge.getText().equals(""))
          {
            JOptionPane.showMessageDialog(rootPane, "All fields must be filled "
                    + "out!", "ERROR", 0);
            return;
          }
          if(txtFName.getText().length() > 10 || txtLName.getText().length() > 10 
                  || txtAge.getText().length() > 3)
          {
            JOptionPane.showMessageDialog(rootPane, "Names must be 10 letters or"
                    + " less, age 3 digits or less", "ERROR", 0);
            return;
          }

          int age;
          try {
            age = Integer.parseInt(txtAge.getText());
          } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Age must be an integer!", 
                    "ERROR", 0);
            return;
          }

          Faculty fac = (Faculty) Person.people[Faculty.faculty[display]];
          fac.setfirstName(txtFName.getText());
          fac.setlastName(txtLName.getText());
          fac.setAge(age); 
          fac.setMaritalStatus(boxMarital.getSelectedItem().toString());
          fac.setGender(boxGender.getSelectedItem().toString());
          fac.setRank(Faculty.getSymbol(boxRank.getSelectedItem().toString()));
          
          Person.updateDB(Faculty.faculty[display]);
          Person.clearDB();
          Person.loadDB();
          
          JOptionPane.showMessageDialog(rootPane, "Faculty member modified!");
        }
      });
      
      btnAdd.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          if(txtFName.getText().equals("") || txtLName.getText().equals("") || 
                  txtAge.getText().equals(""))
          {
            JOptionPane.showMessageDialog(rootPane, "All fields must be filled "
                    + "out!", "ERROR", 0);
            return;
          }
          if(txtFName.getText().length() > 10 || txtLName.getText().length() > 10 
                  || txtAge.getText().length() > 3)
          {
            JOptionPane.showMessageDialog(rootPane, "Names must be 10 letters or"
                    + " less, age 3 digits or less", "ERROR", 0);
            return;
          }

          int age;
          try {
            age = Integer.parseInt(txtAge.getText());
          } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Age must be an integer!", 
                    "ERROR", 0);
            return;
          }

          Faculty.addFaculty(txtFName.getText(), txtLName.getText(), 
                  age, boxMarital.getSelectedItem().toString(), boxGender.getSelectedItem().toString(), 
                  Faculty.getSymbol(boxRank.getSelectedItem().toString()));
          Person.clearDB();
          Person.loadDB();
          JOptionPane.showMessageDialog(rootPane, "Faculty member added!");
        }
      });
      
      btnReturn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          try{
            Person.connection.close();
          }
          catch(SQLException s) {
            JOptionPane.showMessageDialog(rootPane, "DB not closed, may still be locked!");
          }
          firstFrame.setVisible(true);
          dispose();
        }
      });
    }
  }
}
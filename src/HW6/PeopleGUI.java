/* Author Name: Evan Armour
 * CIS331, Section 2, Fall 2013
 * Homework 6
 * Purpose: This assignment introduced GUI development in Java, using AWT and 
 * Swing. Therefore, it also introduces interfaces, listeners, and event 
 * handlers in order to deal with user interaction through GUI elements.
*/
package HW6;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class PeopleGUI extends JFrame 
{
  public static void main (String args[]) 
  {    
    PeopleGUI frame = new PeopleGUI();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
  
  public PeopleGUI()
  {
    setTitle("Person Management GUI");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(750, 250);
    
    /* ====================INPUTS IN FLOW LAYOUT==================== */
    final JList lstPeople = new JList(Person.people);
    final JTextField txtFName = new JTextField(12);
    final JTextField txtLName = new JTextField(12);
    final JTextField txtAge = new JTextField(2);
    final JComboBox boxMarital = new JComboBox(new String[] {"Unknown",
      "Married","Divorced","Widowed","Single"});
    
    final JRadioButton rdioGenderMale = new JRadioButton("Male");
    final JRadioButton rdioGenderFemale = new JRadioButton("Female");
    final JRadioButton rdioGenderUnknown = new JRadioButton("Unknown");
    final ButtonGroup genderButtonGroup = new ButtonGroup();
    genderButtonGroup.add(rdioGenderMale);
    genderButtonGroup.add(rdioGenderFemale);
    genderButtonGroup.add(rdioGenderUnknown);
    
    JPanel inputPanel = new JPanel(new FlowLayout());
    inputPanel.add(new LabelComponent("First Name", txtFName));
    inputPanel.add(new LabelComponent("Last Name", txtLName));
    inputPanel.add(new LabelComponent("Age", txtAge));
    inputPanel.add(new LabelComponent("Marital Status", boxMarital));
    
    //Radio buttons in a panel of their own to center label
    JPanel radioBtnPanel = new JPanel(new FlowLayout());
    radioBtnPanel.add(rdioGenderMale);
    radioBtnPanel.add(rdioGenderFemale);
    radioBtnPanel.add(rdioGenderUnknown);
    JPanel radioPanel = new JPanel(new BorderLayout());
    radioPanel.add(new JLabel("Gender", SwingConstants.CENTER), 
            BorderLayout.NORTH);
    radioPanel.add(radioBtnPanel, BorderLayout.SOUTH);
    inputPanel.add(radioPanel);
    rdioGenderUnknown.setSelected(true);
    
    /* ====================BUTTONS IN GRID LAYOUT==================== */
    JButton btnAdd = new JButton("Add Person");
    JButton btnMod = new JButton("Mod Person");
    JButton btnClear = new JButton("Clear");
    JButton btnRead = new JButton("Read File");
    JButton btnWrite = new JButton("Write File");
    JPanel buttonPanel = new JPanel(new GridLayout());
    buttonPanel.add(btnAdd);
    buttonPanel.add(btnMod);
    buttonPanel.add(btnClear);
    buttonPanel.add(btnRead);
    buttonPanel.add(btnWrite);
    
    /* ====================ASSEMBLE ALL PANELS INTO FRAME==================== */
    add(new LabelComponent("People List", lstPeople), BorderLayout.WEST);
    add(inputPanel, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);
    
    /* ====================EVENT LISTENERS==================== */
    //Add Person
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
        
        String gender = "Unknown";
        if(rdioGenderMale.isSelected())
          gender = "Male";
        else if(rdioGenderFemale.isSelected())
          gender = "Female";
        
        Person.addPerson(txtFName.getText(), txtLName.getText(), 
                age, boxMarital.getSelectedItem().toString(), gender);
        JOptionPane.showMessageDialog(rootPane, Person.getPerson(Person.
                totPeople - 1).toString() + " has been added successfully!");
        lstPeople.updateUI();
        lstPeople.setSelectedIndex(Person.totPeople - 1);
      }
    });
    //Modify Person
    btnMod.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        if(lstPeople.getSelectedIndex() >= Person.totPeople)
          return;

        Person selected = Person.getPerson(lstPeople.getSelectedIndex());
        selected.setfirstName(txtFName.getText());
        selected.setlastName(txtLName.getText());
        selected.setAge(Integer.parseInt(txtAge.getText()));
        
        selected.setMaritalStatus(boxMarital.getSelectedItem().toString());
        String gender = "Unknown";
        if(rdioGenderMale.isSelected())
          gender = "Male";
        else if(rdioGenderFemale.isSelected())
          gender = "Female";
        selected.setGender(gender);
        
        JOptionPane.showMessageDialog(rootPane, selected.toString() + 
                " has been modified successfully!");
        lstPeople.updateUI();
      }
    });
    //Clear Fields
    btnClear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        txtFName.setText(null);
        txtLName.setText(null);
        txtAge.setText(null);
        genderButtonGroup.clearSelection();
        boxMarital.setSelectedIndex(0);
      }
    });
    //Read from C:/Temp/people.txt
    btnRead.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        Person.readPeople();
        lstPeople.updateUI();
      }
    });
    //Write to C:/Temp/peopleOutput.txt
    btnWrite.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        Person.writePeople();
        JOptionPane.showMessageDialog(null, "Data successfully saved to "
                + "C:/Temp/peopleOutput.txt", "Saved", 1);
      }
    });
    //Listen for selecting any person from the list
    lstPeople.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent lse) {
        //When person selected, display info in components
        //TODO:Implement counter so user can't just keep clicking add with a single person selected
        if(lstPeople.getSelectedIndex() == -1 || lstPeople.getSelectedIndex() >= Person.totPeople)
          return;

        Person selected = Person.getPerson(lstPeople.getSelectedIndex());
        txtFName.setText(selected.getfirstName());
        txtLName.setText(selected.getlastName());
        txtAge.setText(Integer.toString(selected.getAge()));
        boxMarital.setSelectedItem(selected.getMaritalStatus());
        if(selected.getGender().equals("Male"))
          rdioGenderMale.setSelected(true);
        else if(selected.getGender().equals("Female"))
          rdioGenderFemale.setSelected(true);
        else
          rdioGenderUnknown.setSelected(true);
      }
    });
  }
  
  // Class for a labeled component, courtesy of Dr. May
  class LabelComponent extends JPanel
  {
    JLabel l;

    public LabelComponent(String s, Component c)
    {
      setLayout(new BorderLayout());
      l = new JLabel(s);
      l.setHorizontalAlignment(SwingConstants.CENTER);               
      add(l,BorderLayout.NORTH);
      add(c,BorderLayout.CENTER);
    }
  }
}
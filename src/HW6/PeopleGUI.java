/* Author Name: Evan Armour
 * CIS331, Section 2, Fall 2013
 * Homework 6
 * Purpose:
*/
package HW6;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PeopleGUI extends JFrame {

  public static void main (String args[]) 
  {
    Person.addPerson("Evan", "Armour", 21, "Single", "male");
    Person.addPerson("Jeff", "may", 55, "marrIED", "MALe");
    
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
    final JComboBox boxMarital = new JComboBox(Person.maritalChoices);
    
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
    
    //This can't possibly be the best way to do this
    JPanel radioBtnPanel = new JPanel(new FlowLayout());
    radioBtnPanel.add(rdioGenderMale);
    radioBtnPanel.add(rdioGenderFemale);
    radioBtnPanel.add(rdioGenderUnknown);
    
    JPanel radioPanel = new JPanel(new BorderLayout());
    radioPanel.add(new JLabel("Gender", SwingConstants.CENTER), 
            BorderLayout.NORTH);
    radioPanel.add(radioBtnPanel, BorderLayout.SOUTH);
    inputPanel.add(radioPanel);
    
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
    btnAdd.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        //Add new person
      }
    });
    btnMod.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        //Modify selected person's info
      }
    });
    btnClear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        txtFName.setText(null);
        txtLName.setText(null);
        txtAge.setText(null);
        genderButtonGroup.clearSelection();
        boxMarital.setSelectedIndex(0);
      }
    });
    btnRead.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        //Read all people from people.txt
      }
    });
    btnWrite.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        //Write all people to people.txt
      }
    });
    lstPeople.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent lse) {
        //When person selected, display info in components
        Person selected = Person.getPerson(lstPeople.getSelectedIndex());
        txtFName.setText(selected.getGender());
        txtLName.setText(selected.getlastName());
        txtAge.setText(Integer.toString(selected.getAge()));
        boxMarital.setSelectedItem(selected.getMaritalStatus());
        if(selected.getGender().equals("male"))
          rdioGenderMale.setSelected(true);
        else if(selected.getGender().equals("female"))
          rdioGenderFemale.setSelected(true);
        else
          rdioGenderUnknown.setSelected(true);
      }
    });
    
  }
  
  // Class for a labeled component
  // Courtesy of Dr. May
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


package Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class WeeklyPlannerDesign extends JFrame {

    public WeeklyPlannerDesign() {
        setTitle("Weekly Planner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600); // Increased width to accommodate Saturday
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Top Panel for Room#, Week Of, Month
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel roomLabel = new JLabel("Room#:");
        JTextField roomField = new JTextField(5);
        JLabel weekLabel = new JLabel("Week of:");
        JTextField weekField = new JTextField(10);
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        JComboBox<String> monthComboBox = new JComboBox<>(months);

        topPanel.add(roomLabel);
        topPanel.add(roomField);
        topPanel.add(weekLabel);
        topPanel.add(weekField);
        topPanel.add(monthComboBox);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        // Table for the schedule (Added Saturday)
        String[] columnNames = {"Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}; // Added Saturday
        String[][] data = new String[18][7]; // Increased column count to 7
        String[] timeSlots = {"8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "1:00", "1:30", "2:00", "2:30", "3:00", "3:30", "4:00", "4:30"};
        for (int i = 0; i < timeSlots.length; i++) {
            data[i][0] = timeSlots[i];
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel for Buttons
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton addButton = new JButton("Add Book");
        JButton updateButton = new JButton("Update");
        JButton cancelButton = new JButton("Cancel");
        JButton logoutButton = new JButton("Logout");

        bottomPanel.add(addButton);
        bottomPanel.add(updateButton);
        bottomPanel.add(cancelButton);
        bottomPanel.add(logoutButton);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WeeklyPlannerDesign::new);
    }
}
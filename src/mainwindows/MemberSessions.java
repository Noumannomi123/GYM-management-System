package mainwindows;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import database.Database;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MemberSessions extends JFrame {

	private JPanel contentPane;
	private Database database = new Database();
	/**
	 * Launch the application.
	 */
	 private Color backgroundColor = new Color(32, 57, 122);
	 private Color foregroundColor = new Color(62, 85, 145);
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberSessions frame = new MemberSessions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//write code to compute 2 + 2
	/**
	 * Create the frame.
	 */
	public MemberSessions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(203, 73, 968, 670);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setResizable(false);
        contentPane.setLayout(null);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(0, 0, 968, 670);
        panel_3.setBackground(backgroundColor);
        contentPane.add(panel_3);
        panel_3.setLayout(null);
		
		JPanel reviewGPanel = new JPanel();
        reviewGPanel.setBounds(36,44,877,504);
        reviewGPanel.setBackground(foregroundColor);
        panel_3.add(reviewGPanel);
        reviewGPanel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Session Name");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 24));
        lblNewLabel.setBounds(10, 100, 173, 46);
        reviewGPanel.add(lblNewLabel);
        
        JLabel lblDate = new JLabel("Date");
        lblDate.setForeground(Color.WHITE);
        lblDate.setFont(new Font("Open Sans", Font.BOLD, 24));
        lblDate.setBounds(297, 100, 91, 46);
        reviewGPanel.add(lblDate);
        
        JLabel lblTime = new JLabel("Time");
        lblTime.setForeground(Color.WHITE);
        lblTime.setFont(new Font("Open Sans", Font.BOLD, 24));
        lblTime.setBounds(559, 100, 91, 46);
        reviewGPanel.add(lblTime);
        
        JLabel lblAppointmentsList = new JLabel("List of Training Sessions");
        lblAppointmentsList.setForeground(Color.WHITE);
        lblAppointmentsList.setFont(new Font("Open Sans", Font.BOLD, 34));
        lblAppointmentsList.setBounds(225, 10, 425, 46);
        reviewGPanel.add(lblAppointmentsList);
		
	

	}
}
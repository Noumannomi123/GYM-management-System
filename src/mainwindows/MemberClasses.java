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

public class MemberClasses extends JFrame {

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
					MemberClasses frame = new MemberClasses();
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
	public MemberClasses() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(203, 73, 968, 670);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setResizable(false);
        contentPane.setLayout(null);
        
        JPanel panelTS = new JPanel();
        panelTS.setBounds(0, 0, 968, 670);
        panelTS.setBackground(backgroundColor);
        contentPane.add(panelTS);
        panelTS.setLayout(null);
		
		JPanel reviewGPanelT = new JPanel();
        reviewGPanelT.setBounds(36,44,877,504);
        reviewGPanelT.setBackground(foregroundColor);
        panelTS.add(reviewGPanelT);
        reviewGPanelT.setLayout(null);
        
        JLabel lblNewLabelT = new JLabel("Class Name");
        lblNewLabelT.setForeground(new Color(255, 255, 255));
        lblNewLabelT.setFont(new Font("Open Sans", Font.BOLD, 24));
        lblNewLabelT.setBounds(10, 100, 173, 46);
        reviewGPanelT.add(lblNewLabelT);
        
        JLabel lblDateT = new JLabel("Date");
        lblDateT.setForeground(Color.WHITE);
        lblDateT.setFont(new Font("Open Sans", Font.BOLD, 24));
        lblDateT.setBounds(297, 100, 91, 46);
        reviewGPanelT.add(lblDateT);
        
        JLabel lblTimeT = new JLabel("Time");
        lblTimeT.setForeground(Color.WHITE);
        lblTimeT.setFont(new Font("Open Sans", Font.BOLD, 24));
        lblTimeT.setBounds(559, 100, 91, 46);
        reviewGPanelT.add(lblTimeT);
        
        JLabel lblAppointmentsListT = new JLabel("List of Fitness Classes");
        lblAppointmentsListT.setForeground(Color.WHITE);
        lblAppointmentsListT.setFont(new Font("Open Sans", Font.BOLD, 34));
        lblAppointmentsListT.setBounds(225, 10, 425, 46);
        reviewGPanelT.add(lblAppointmentsListT);
		
	

	}
}
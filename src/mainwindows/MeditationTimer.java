package mainwindows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javax.sound.sampled.*;

public class MeditationTimer extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4981718351791290551L;
	private static final String PREF_DURATION = "MeditationDuration";
    private static final String PREF_SOUND = "AmbientSound";
    private Clip currentClip;
    public MeditationTimer() {
        getContentPane().setBackground(new Color(0, 128, 192));
        setTitle("Meditation Timer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(980, 670);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.addItem("5");
        comboBox.addItem("10");
        comboBox.addItem("15");
        comboBox.addItem("20");
        comboBox.addItem("25");
        comboBox.addItem("30");
        comboBox.setBounds(430, 105, 195, 60);
        getContentPane().add(comboBox);

        JComboBox<String> comboBox_1 = new JComboBox<String>();
        comboBox_1.addItem("Rain");
        comboBox_1.addItem("ocean waves");
        comboBox_1.addItem("Birds Chipring");
        comboBox_1.setBounds(430, 215, 196, 55);
        getContentPane().add(comboBox_1);

        JLabel lblNewLabel = new JLabel(" Meditation Duration(min)");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Serif", Font.BOLD, 19));
        lblNewLabel.setBounds(127, 101, 249, 60);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("  Meditation Timer");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 28));
        lblNewLabel_1.setBounds(275, 24, 242, 46);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("  Ambient Sound");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 19));
        lblNewLabel_2.setBounds(164, 219, 150, 38);
        getContentPane().add(lblNewLabel_2);

        JButton btnNewButton = new JButton("  Start Meditation");
        btnNewButton.setFont(new Font("Serif", Font.BOLD, 24));
        btnNewButton.setBounds(288, 361, 242, 81);
        getContentPane().add(btnNewButton);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDuration = (String) comboBox.getSelectedItem();
                int duration = Integer.parseInt(selectedDuration);
                savePreferences(duration, comboBox_1.getSelectedItem().toString());
            }
        });

        comboBox_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSound = (String) comboBox_1.getSelectedItem();
                savePreferences(Integer.parseInt(comboBox.getSelectedItem().toString()), selectedSound);
            }
        });

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int duration = Integer.parseInt(comboBox.getSelectedItem().toString());
                String selectedSound = comboBox_1.getSelectedItem().toString();
                startMeditation(duration, selectedSound);
            }
        });

        loadPreferences();
        setVisible(true);
    }

    private void startMeditation(int duration, String soundFileName) {
    	stopCurrentClip();
        // Display a message that meditation is started
        JOptionPane.showMessageDialog(this, "Meditation is started!");

        // Play the selected sound from the file
        playSoundFromFile(soundFileName);

        // You can add any additional logic related to meditation duration here
        // For example, you might want to use a Timer to handle the meditation duration
    }

    private void playSoundFromFile(String soundFileName) {
        try {
            // Specify the folder path where the sound files are located
        	String folderPath = "D:\\Downloads\\";

        	// Create a File object for the sound file
        	System.out.println(soundFileName.toLowerCase());
        	File soundFile = new File(folderPath + soundFileName.toLowerCase() + ".wav");
            // Check if the file exists
            if (!soundFile.exists()) {
                System.out.println("Sound file not found: " + soundFile.getAbsolutePath());
                JOptionPane.showMessageDialog(this, "Error: Sound file not found. See console for details.");
                return;
            }

            // Create an AudioInputStream from the sound file
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

         // Get a Clip resource
            currentClip = AudioSystem.getClip();

            // Open the audioInputStream to the clip
            currentClip.open(audioInputStream);

            // Start playing the clip
            currentClip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error playing the selected sound. See console for details.");
        }
    }

    private void savePreferences(int duration, String sound) {
        Preferences prefs = Preferences.userNodeForPackage(MeditationTimer.class);
        prefs.putInt(PREF_DURATION, duration);
        prefs.put(PREF_SOUND, sound);
    }
    private void stopCurrentClip() {
        if (currentClip != null && currentClip.isOpen()) {
            currentClip.stop();
            currentClip.close();
        }
    }

    private void loadPreferences() {
        Preferences prefs = Preferences.userNodeForPackage(MeditationTimer.class);
        prefs.getInt(PREF_DURATION, 10);
    }

    
}

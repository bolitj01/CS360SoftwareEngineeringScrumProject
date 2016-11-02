package src;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;

/*
 * Created 10-26-16 by Thomas Bolinger
 */
public class PaceCalculatorGUI extends JFrame {

	private JComboBox eventSelect;

	private JTextField timeHoursTextField;
	private JTextField timeMinutesTextField;
	private JTextField timeSecondsTextField;

	private JTextField paceHoursTextField;
	private JTextField paceMinutesTextField;
	private JTextField paceSecondsTextField;

	public PaceCalculatorGUI() {
		setMinimumSize(new Dimension(600, 400));
		setBackground(Color.white);
		setForeground(Color.white);

		//Title
		JLabel titleLabel = new JLabel("Pace Calculator");
		titleLabel.setBackground(Color.white);
		titleLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
		titleLabel.setFont(new Font("arial", Font.BOLD, 22));
		add(titleLabel, BorderLayout.NORTH);

		//Main content grid
		JPanel contentPanel = new JPanel(new GridLayout(1,3));
		contentPanel.setBackground(Color.white);
		add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBorder(new EmptyBorder(10,5,10,10));

		//Left side header labels
		JPanel headerPanel = new JPanel(new GridLayout(3,1));
		headerPanel.setBorder(new EmptyBorder(0,10,0,0));
		headerPanel.setBackground(Color.white);
		JLabel timeHeader = new JLabel("Time");
		timeHeader.setFont(new Font("arial", Font.BOLD, 16));
		timeHeader.setHorizontalAlignment(SwingConstants.RIGHT);
		headerPanel.add(timeHeader);
		JLabel distanceHeader = new JLabel("Distance");
		distanceHeader.setFont(new Font("arial", Font.BOLD, 16));
		distanceHeader.setHorizontalAlignment(SwingConstants.RIGHT);
		headerPanel.add(distanceHeader);
		JLabel paceHeader = new JLabel("Pace");
		paceHeader.setFont(new Font("arial", Font.BOLD, 16));
		paceHeader.setHorizontalAlignment(SwingConstants.RIGHT);
		headerPanel.add(paceHeader);
		add(headerPanel, BorderLayout.WEST);

		//Middle data entry section
		JPanel dataPanel = new JPanel(new GridLayout(3, 1));

		//Time
		JPanel timeDataPanel = new JPanel(new GridLayout(3, 3));
		timeDataPanel.setBorder(new LineBorder(Color.black, 1));
		timeDataPanel.setBackground(Color.white);
		JLabel hoursLabel = new JLabel("Hours");
		hoursLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeDataPanel.add(hoursLabel);
		JLabel minutesLabel = new JLabel("Mins");
		minutesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeDataPanel.add(minutesLabel);
		JLabel secondsLabel = new JLabel("Secs");
		secondsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeDataPanel.add(secondsLabel);

		timeHoursTextField = new JTextField();
		timeDataPanel.add(timeHoursTextField);
		timeMinutesTextField = new JTextField();
		timeDataPanel.add(timeMinutesTextField);
		timeSecondsTextField = new JTextField();
		timeDataPanel.add(timeSecondsTextField);

		JLabel filler1 = new JLabel();
		JLabel filler2 = new JLabel();
		JLabel filler3 = new JLabel();

		timeDataPanel.add(filler1);
		timeDataPanel.add(filler2);
		timeDataPanel.add(filler3);

		dataPanel.add(timeDataPanel);

		//Distance
		JPanel distanceDataPanel = new JPanel(new GridLayout(1,1));
		distanceDataPanel.setBorder(new LineBorder(Color.black, 1));
		distanceDataPanel.setBackground(Color.white);

		String events[] = {"5K", "5-Mile", "10K", "Half-Marathon"};
		eventSelect = new JComboBox(events);
		distanceDataPanel.add(eventSelect);

		dataPanel.add(distanceDataPanel);

		//Pace
		JPanel paceDataPanel = new JPanel(new GridLayout(2,1));
		paceDataPanel.setBorder(new LineBorder(Color.black,1));
		paceDataPanel.setBackground(Color.white);
		JPanel paceUpperPanel = new JPanel(new GridLayout(2,2));
		paceUpperPanel.setBackground(Color.white);
		paceDataPanel.add(paceUpperPanel);

		JLabel minutesLabel2 = new JLabel("Mins");
		minutesLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		paceUpperPanel.add(minutesLabel2);

		JLabel secondsLabel2 = new JLabel("Secs");
		secondsLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		paceUpperPanel.add(secondsLabel2);

		paceMinutesTextField = new JTextField();
		paceUpperPanel.add(paceMinutesTextField);

		paceSecondsTextField = new JTextField();
		paceUpperPanel.add(paceSecondsTextField);

		JLabel perLabel = new JLabel("Per Mile");
		perLabel.setHorizontalAlignment(SwingConstants.CENTER);
		paceDataPanel.add(perLabel);


		dataPanel.add(paceDataPanel);

		contentPanel.add(dataPanel);

		//Instructions and buttons section
		JPanel controlPanel = new JPanel(new GridLayout(6, 1));
		controlPanel.setBackground(Color.white);
		controlPanel.setBorder(new EmptyBorder(3,3,3,3));
		JLabel timeInstructions = new JLabel("<html><p style='text-align:center'>Enter distance and pace to calculate time:</p></html>");
		controlPanel.add(timeInstructions);

		JButton timeButton = new JButton("Calculate Time");
		timeButton.setEnabled(false);
		controlPanel.add(timeButton);

		JLabel distanceInstructions = new JLabel("<html><p style='text-align:center'>Enter time and pace to calculate distance:</p></html>");
		controlPanel.add(distanceInstructions);

		JButton distanceButton = new JButton("Calculate Distance");
		controlPanel.add(distanceButton);

		JLabel paceInstructions = new JLabel("<html><p style='text-align:center'>Enter time and distance to calculate pace:</p></html>");
		controlPanel.add(paceInstructions);

		JButton paceButton = new JButton("Calculate Pace");
		paceButton.setEnabled(false);
		controlPanel.add(paceButton);

		contentPanel.add(controlPanel);


		//Answer section
		JPanel answerPanel = new JPanel(new GridLayout(6, 1));
		answerPanel.setBorder(new EmptyBorder(3,3,3,3));
		answerPanel.setBackground(Color.white);

		JLabel answerTimeHeader = new JLabel("<html><u>Time</u></html>");
		answerTimeHeader.setHorizontalAlignment(SwingConstants.CENTER);
		answerPanel.add(answerTimeHeader);
		JLabel answerTime = new JLabel();
		answerTime.setHorizontalAlignment(SwingConstants.CENTER);
		answerPanel.add(answerTime);

		JLabel answerDistanceHeader = new JLabel("<html><u>Distance</u></html>");
		answerDistanceHeader.setHorizontalAlignment(SwingConstants.CENTER);
		answerPanel.add(answerDistanceHeader);
		JLabel answerDistance = new JLabel();
		answerDistance.setHorizontalAlignment(SwingConstants.CENTER);
		answerPanel.add(answerDistance);

		JLabel answerPaceHeader = new JLabel("<html><u>Pace</u></html>");
		answerPaceHeader.setHorizontalAlignment(SwingConstants.CENTER);
		answerPanel.add(answerPaceHeader);
		JLabel answerPace = new JLabel();
		answerPace.setHorizontalAlignment(SwingConstants.CENTER);
		answerPanel.add(answerPace);

		contentPanel.add(answerPanel);

		//Add time button functionality
		timeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] paceStrings = {"", paceMinutesTextField.getText(), paceSecondsTextField.getText()};
				double[] pace = TimeUtility.parseAndValidateEntries(paceStrings);
				
				if (pace == null){
					JOptionPane.showMessageDialog(null,  "Enter valid pace", "Pace Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				double distanceInMiles = -1;
				
				switch ((String)eventSelect.getSelectedItem()){
					case "5K":
						distanceInMiles = PaceCalculatorUtility.kilometersToMiles(5);
						break;
					case "5-Mile":
						distanceInMiles = 5;
						break;
					case "10K":
						distanceInMiles = PaceCalculatorUtility.kilometersToMiles(10);
						break;
					case "Half-Marathon":
						distanceInMiles = 13.1094;
						
				}
				
				answerDistance.setText(distanceInMiles + " miles");
			}
		});

		//Add distance button functionality
		distanceButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] timeStrings = {timeHoursTextField.getText(), timeMinutesTextField.getText(), timeSecondsTextField.getText()};
				String[] paceStrings = {"", paceMinutesTextField.getText(), paceSecondsTextField.getText()};

				double[] time = TimeUtility.parseAndValidateEntries(timeStrings);
				double[] pace = TimeUtility.parseAndValidateEntries(paceStrings);

				if (time == null){
					JOptionPane.showMessageDialog(null, "Enter valid time", "Time Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (pace == null){
					JOptionPane.showMessageDialog(null,  "Enter valid pace", "Pace Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				double timeSeconds = TimeUtility.hMsToSeconds(time);
				double paceSeconds = TimeUtility.hMsToSeconds(pace);

				//Time upper bound of 4 hours
				if (timeSeconds > 60*60*4){
					JOptionPane.showMessageDialog(null, "Time must be less than 4 hours", "Time Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				//Pace upper bound of 
				if (paceSeconds > 60*20){
					JOptionPane.showMessageDialog(null,  "Pace must be less than 20 minutes per mile", "Pace Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				double distance = PaceCalculatorUtility.calculateDistance(paceSeconds, timeSeconds);

				//Set answer label
				answerDistance.setText(String.format("%.01f miles", distance));
			}
		});

		//Add pace button functionality
		paceButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		setVisible(true);


	}

	/**
	 * Main method to create and run PaceCalculatorGUI
	 */
	public static void main(String[] args) {
		new PaceCalculatorGUI();
	}
}

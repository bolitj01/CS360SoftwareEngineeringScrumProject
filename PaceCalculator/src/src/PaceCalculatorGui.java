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

	private final Color timeColor = new Color(150,200,255);
	private final Color distanceColor = new Color(255, 200, 150);
	private final Color paceColor = new Color(175, 255, 175);
	private final Font font = new Font("arial", Font.BOLD, 16);

	public PaceCalculatorGUI() {
		setMinimumSize(new Dimension(500, 400));
		setBackground(Color.white);
		setLocationRelativeTo(null);

		//Title
		JPanel titlePanel = new JPanel(new GridLayout(1,1));
		titlePanel.setBackground(Color.white);
		JLabel titleLabel = new JLabel("Pace Calculator");
		titleLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
		titleLabel.setFont(new Font("arial", Font.BOLD, 22));
		titlePanel.add(titleLabel);
		add(titlePanel, BorderLayout.NORTH);

		//Main content grid
		JPanel contentPanel = new JPanel(new GridLayout(1,3));
		contentPanel.setBackground(Color.white);
		add(contentPanel, BorderLayout.CENTER);

		//Left side header labels
		JPanel headerPanel = new JPanel(new GridLayout(3,1));
		headerPanel.setBackground(Color.white);

		JPanel timeHeaderPanel = new JPanel(new GridLayout(1,1));
		timeHeaderPanel.setBackground(timeColor);
		JLabel timeHeader = new JLabel("Time");
		timeHeader.setFont(font);
		timeHeader.setHorizontalAlignment(SwingConstants.RIGHT);
		timeHeaderPanel.add(timeHeader);
		headerPanel.add(timeHeaderPanel);

		JPanel distanceHeaderPanel = new JPanel(new GridLayout(1,1));
		distanceHeaderPanel.setBackground(distanceColor);
		JLabel distanceHeader = new JLabel("Distance");
		distanceHeader.setFont(font);
		distanceHeader.setHorizontalAlignment(SwingConstants.RIGHT);
		distanceHeaderPanel.add(distanceHeader);
		headerPanel.add(distanceHeaderPanel);

		JPanel paceHeaderPanel = new JPanel(new GridLayout(1,1));
		paceHeaderPanel.setBackground(paceColor);
		JLabel paceHeader = new JLabel("Pace");
		paceHeader.setFont(font);
		paceHeader.setHorizontalAlignment(SwingConstants.RIGHT);
		paceHeaderPanel.add(paceHeader);
		headerPanel.add(paceHeaderPanel);

		add(headerPanel, BorderLayout.WEST);

		//Middle data entry section
		JPanel dataPanel = new JPanel(new GridLayout(3, 1));

		//Time
		JPanel timeDataPanel = new JPanel(new GridLayout(3, 3));
		timeDataPanel.setBackground(timeColor);
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
		JPanel distanceDataPanel = new JPanel(new GridLayout(2,1));
		distanceDataPanel.setBackground(distanceColor);

		String events[] = {"5K", "5-Mile", "10K", "Half-Marathon"};
		eventSelect = new JComboBox(events);
		distanceDataPanel.add(eventSelect);

		JLabel answerDistance = new JLabel();
		answerDistance.setHorizontalAlignment(SwingConstants.CENTER);
		distanceDataPanel.add(answerDistance);

		dataPanel.add(distanceDataPanel);

		//Pace
		JPanel paceDataPanel = new JPanel(new GridLayout(2,1));
		paceDataPanel.setBackground(paceColor);
		JPanel paceUpperPanel = new JPanel(new GridLayout(2,2));
		paceUpperPanel.setBackground(paceColor);
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
		JPanel controlPanel = new JPanel(new GridLayout(3, 1));
		controlPanel.setBackground(Color.white);

		JPanel timeControlPanel = new JPanel(new GridLayout(2,1));
		timeControlPanel.setBackground(timeColor);

		JLabel timeInstructions = new JLabel("<html><p style='text-align:center'>Enter distance and pace to calculate time:</p></html>");
		timeControlPanel.add(timeInstructions);

		JButton timeButton = new JButton("Calculate Time");
//		timeButton.setEnabled(false);
		timeControlPanel.add(timeButton);

		controlPanel.add(timeControlPanel);

		JPanel distanceControlPanel = new JPanel(new GridLayout(2, 1));
		distanceControlPanel.setBackground(distanceColor);

		JLabel distanceInstructions = new JLabel("<html><p style='text-align:center'>Enter time and pace to calculate distance:</p></html>");
		distanceControlPanel.add(distanceInstructions);

		JButton distanceButton = new JButton("Calculate Distance");
		distanceControlPanel.add(distanceButton);

		controlPanel.add(distanceControlPanel);

		JPanel paceControlPanel = new JPanel(new GridLayout(2,1));
		paceControlPanel.setBackground(paceColor);

		JLabel paceInstructions = new JLabel("<html><p style='text-align:center'>Enter time and distance to calculate pace:</p></html>");
		paceControlPanel.add(paceInstructions);

		JButton paceButton = new JButton("Calculate Pace");
//		paceButton.setEnabled(false);
		paceControlPanel.add(paceButton);

		controlPanel.add(paceControlPanel);

		contentPanel.add(controlPanel);

		//Add time button functionality
		timeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] paceStrings = {"", paceMinutesTextField.getText(), paceSecondsTextField.getText()};
				double[] pace = TimeUtility.parseAndValidateEntries(paceStrings);

				double paceSeconds = TimeUtility.hMsToSeconds(pace);
				
				if (!paceInBounds(paceSeconds)){
					return;
				}
				
				double distanceInMiles = getSelectedDistanceInMiles();
				
				double time = PaceCalculatorUtility.calculateTime(paceSeconds, distanceInMiles);
				
				double timeHours = TimeUtility.hours(time);
				double timeMinutes = TimeUtility.minutes(time);
				double timeSeconds = TimeUtility.seconds(time);
				
				timeHoursTextField.setText((int)timeHours + "");
				timeMinutesTextField.setText((int)timeMinutes + "");
				timeSecondsTextField.setText(String.format("%.01f", timeSeconds) + "");
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

				double timeSeconds = TimeUtility.hMsToSeconds(time);
				double paceSeconds = TimeUtility.hMsToSeconds(pace);

				if (!timeInBounds(timeSeconds) || !paceInBounds(paceSeconds)){
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
				String[] timeStrings = {timeHoursTextField.getText(), timeMinutesTextField.getText(), timeSecondsTextField.getText()};
				double[] time = TimeUtility.parseAndValidateEntries(timeStrings);
				
				double timeSeconds = TimeUtility.hMsToSeconds(time);
				
				if (!timeInBounds(timeSeconds)){
					return;
				}
				
				double distanceInMiles = getSelectedDistanceInMiles();
				
				double pace = PaceCalculatorUtility.calculatePace(timeSeconds, distanceInMiles);
				
				double paceMinutes = TimeUtility.minutes(pace);
				double paceSeconds = TimeUtility.seconds(pace);
				
				paceMinutesTextField.setText((int)paceMinutes + "");
				paceSecondsTextField.setText(String.format("%.01f",  paceSeconds));
			}
		});

		setVisible(true);


	}

	private boolean timeInBounds(double time){
		if (time <= 0 || time > 60*60*4){
			JOptionPane.showMessageDialog(null, "Please enter a time greater than 0 up to 4 hours. "
					+ "Hours and minutes must be integers, seconds may be a decimal.", 
					"Time Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	private boolean paceInBounds(double pace){
		if (pace <= 0 || pace > 60*20){
			JOptionPane.showMessageDialog(null, "Please enter a pace greater than 0 seconds and less than 20 minutes per mile. "
					+ "Minutes must be an integer, but seconds may be a decimal.", "Pace Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private double getSelectedDistanceInMiles(){
		double distanceInMiles;
		
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
			break;
		default:
			distanceInMiles = -1;
		}
		
		return distanceInMiles;
	}

	/**
	 * Main method to create and run PaceCalculatorGUI
	 */
	public static void main(String[] args) {
		new PaceCalculatorGUI();
	}
}

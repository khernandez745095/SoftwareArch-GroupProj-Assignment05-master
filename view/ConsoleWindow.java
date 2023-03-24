package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import model.Cycler;
import model.Sorter;

public class ConsoleWindow extends JFrame {
	Cycler cycler = new Cycler();
	Sorter sorter = new Sorter();


	private JFrame window;

	public ConsoleWindow(JFrame window) {
		this.window = window;
	}

	public void init() {
		window.setPreferredSize(new Dimension(750, 800));
		Container cp = window.getContentPane();
		GridBagLayout gridBagLayout = new GridBagLayout();
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		
		JPanel formPanel = new JPanel();

		JTextArea textArea = new JTextArea(20, 40);
		JTextArea outputField = new JTextArea(20, 40);
		JButton submitButton = new JButton("Submit");
		JButton clearButton = new JButton("Clear");
		submitButton.setPreferredSize(new Dimension(100, 50));
		clearButton.setPreferredSize(new Dimension(100, 50));

		JScrollPane inputPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JScrollPane outputPane = new JScrollPane(outputField, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		JPanel panel = new JPanel();

		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		gridBagConstraints.weightx = 1;
		gridBagConstraints.weighty = 1;
		
		panel.setLayout(gridBagLayout);
		panel.add(new JLabel("Input: ",SwingConstants.CENTER), gridBagConstraints);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridwidth = 6;
		gridBagConstraints.gridheight = 6;
		gridBagConstraints.weightx = 2;
		gridBagConstraints.weighty = 2;
		panel.add(inputPane, gridBagConstraints);

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		panel.add(new JLabel("Output: ", SwingConstants.CENTER), gridBagConstraints);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridwidth = 6;
		gridBagConstraints.gridheight = 6;
		panel.add(outputPane, gridBagConstraints);

		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 13;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		panel.add(submitButton, gridBagConstraints);

		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 13;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		panel.add(clearButton, gridBagConstraints);
		submitButton.setSize(new Dimension(100, 50));

		submitButton.setHorizontalAlignment((JButton.CENTER));
		submitButton.setVerticalAlignment((JButton.CENTER));
		clearButton.setSize(new Dimension(100, 50));
		clearButton.setHorizontalAlignment((JButton.CENTER));
		clearButton.setVerticalAlignment((JButton.CENTER));


		clearButton.addActionListener(e -> {
			textArea.setText("");
			outputField.setText("");
		});

		submitButton.addActionListener(e -> {
			//System.out.println("Submit button pressed" + " " + textArea.getText() + " " + outputField.getText());
			String input = textArea.getText();
			String output = cycleAndSort(input);
			outputField.setText(output);
		});

		outputField.setEditable(false);
		formPanel.add(panel, BorderLayout.CENTER);

		cp.add(formPanel, BorderLayout.CENTER);
		setVisible(true);
	}

	String cycleAndSort(String input) {
		String tempString = input;
		int nl = 0;
		String output = "";
		String temp = "";
		ArrayList<String> lines = new ArrayList<>();
		// Split input into lines
		// multiple lines
		System.out.println(input);

		while (tempString.indexOf('\n') != -1) {
			nl = tempString.indexOf('\n');
			temp = tempString.substring(0, nl);
			lines.add(temp);
			tempString = tempString.substring(nl + 1);
		}
			lines.add(tempString);
			System.out.println(tempString);
		
		// else for one line just add it to the arraylist

		ArrayList<String> cycledLines = new ArrayList<>();

		////////////////////////////////////////////
		//////////////// FILTERS////////////////////
		////////////////////////////////////////////
		//CYCLER//
		//cycledLines = cycler.cycle(lines);

		//SORTER//
		cycledLines = sorter.sortOutput(cycledLines);


		//CYCLER//
		cycledLines = cycler.cycle(lines);


		// split lines into words in ArrayList
		// need to sort the cycledLines arraylist
		
		//cycledLines = sorter.sortOutput(cycledLines);
		
		//format output to string

		
		for(var l : cycledLines) {
			output += l + "\n";
		}

		cycledLines.clear();
		lines.clear();
		return output;
		
	}

}

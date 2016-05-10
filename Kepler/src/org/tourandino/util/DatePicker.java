package org.tourandino.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class DatePicker{
	int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
	int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);;
	JLabel l = new JLabel("", JLabel.CENTER);
	String day = "";
	JDialog d;
	JButton[] button = new JButton[49];

	public DatePicker(JDialog parent) {
		d = new JDialog();
		d.setIconImage(Toolkit.getDefaultToolkit().getImage(DatePicker.class.getResource("/ar/com/tourandino/resources/calendar_big.png")));
		d.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		d.setModal(true);
		d.setResizable(false);
		String[] header = { "Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa" };
		JPanel p1 = new JPanel(new GridLayout(7, 7));
		p1.setPreferredSize(new Dimension(500, 120));

		for (int x = 0; x < button.length; x++) {
			final int selection = x;
			button[x] = new JButton();
			button[x].setFocusPainted(false);
			button[x].setBackground(Color.white);
			if (x > 6)
				button[x].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						day = button[selection].getActionCommand();
						d.dispose();
					}
				});
			if (x < 7) {
				button[x].setText(header[x]);
				button[x].setForeground(Color.red);
			}
			p1.add(button[x]);
		}
		JPanel p2 = new JPanel(new GridLayout(1, 3));
		
		JButton previousYear = new JButton("");
		previousYear.setIcon(new ImageIcon(DatePicker.class.getResource("/ar/com/tourandino/resources/resultset_first.png")));
		previousYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				year--;
				displayDate();
			}
		});
		previousYear.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		p2.add(previousYear);
		
		JButton previous = new JButton("");
		previous.setIcon(new ImageIcon(DatePicker.class.getResource("/ar/com/tourandino/resources/resultset_previous.png")));
		previous.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				month--;
				displayDate();
			}
		});
		p2.add(previous);
		l.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		p2.add(l);
		
		JButton next = new JButton("");
		next.setIcon(new ImageIcon(DatePicker.class.getResource("/ar/com/tourandino/resources/resultset_next.png")));
		next.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				month++;
				displayDate();
			}
		});
		p2.add(next);
		
		JButton nextYear = new JButton("");
		nextYear.setIcon(new ImageIcon(DatePicker.class.getResource("/ar/com/tourandino/resources/resultset_last.png")));
		nextYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				year++;
				displayDate();
			}
		});
		nextYear.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		p2.add(nextYear);
		
		d.getContentPane().add(p1, BorderLayout.CENTER);
		d.getContentPane().add(p2, BorderLayout.SOUTH);
		d.pack();
		d.setLocationRelativeTo(parent);
		displayDate();
		d.setVisible(true);
	}

	public void displayDate() {
		for (int x = 7; x < button.length; x++)
			button[x].setText("");
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"MM yyyy");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, 1);
		int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
		int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
		for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++)
			button[x].setText("" + day);
		l.setText(sdf.format(cal.getTime()));
		d.setTitle("Calendario");
	}

	public String getPickedDate() {
		if (day.equals(""))
			return day;
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"dd-MM-yyyy");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, Integer.parseInt(day));
		return sdf.format(cal.getTime());
	}
}
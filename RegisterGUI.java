package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.Helper;
import Model.Hasta;
import Model.User;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RegisterGUI extends JFrame {

	private JPanel w_pane;
	private JTextField fld_name;
	private JTextField fld_tcno;
	private JPasswordField fld_pass;
	private JButton btn_backto;
	private Hasta hasta = new Hasta();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGUI frame = new RegisterGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterGUI() {
		setResizable(false);
		setTitle("Hastane Y\u00F6netim Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 330);
		w_pane = new JPanel();
		w_pane.setBackground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);
		
		JLabel label = new JLabel("Ad soyad");
		label.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		label.setBounds(10, 10, 72, 18);
		w_pane.add(label);
		
		fld_name = new JTextField();
		fld_name.setColumns(10);
		fld_name.setBounds(10, 32, 264, 28);
		w_pane.add(fld_name);
		
		JLabel lblTcNo = new JLabel("T.C. Numaras\u0131");
		lblTcNo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblTcNo.setBounds(10, 70, 100, 18);
		w_pane.add(lblTcNo);
		
		fld_tcno = new JTextField();
		fld_tcno.setColumns(10);
		fld_tcno.setBounds(10, 92, 264, 28);
		w_pane.add(fld_tcno);
		
		JLabel lblifre = new JLabel("\u015Eifre");
		lblifre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblifre.setBounds(9, 131, 100, 18);
		w_pane.add(lblifre);
		
		fld_pass = new JPasswordField();
		fld_pass.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		fld_pass.setBounds(12, 152, 264, 28);
		w_pane.add(fld_pass);
		
		JButton btn_register = new JButton("Kay\u0131t Ol");
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_tcno.getText().length() == 0 || fld_pass.getText().length() == 0 || fld_name.getText().length() == 0) {
					Helper.showMsg("fill");
				}else {
					try {
						boolean control = hasta.register(fld_tcno.getText(), fld_pass.getText(), fld_name.getText());
						if(control) {
							Helper.showMsg("success");
							LoginGUI login = new LoginGUI();
							login.setVisible(true);
							dispose();
						}else {
							Helper.showMsg("error");						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btn_register.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btn_register.setBounds(10, 192, 266, 35);
		w_pane.add(btn_register);
		
		btn_backto = new JButton("Geri D\u00F6n");
		btn_backto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI login = new LoginGUI();
				login.setVisible(true);
				dispose();
			}
		});
		btn_backto.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btn_backto.setBounds(10, 236, 266, 35);
		w_pane.add(btn_backto);
	}
}

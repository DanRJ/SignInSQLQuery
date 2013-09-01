package myfirstjdbc;

import javax.swing.*;
import javax.swing.border.Border;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;
import java.awt.event.*;

public class GUISQL extends JFrame {
	public enum LoginState {
		LOGIN, BAD_LOGIN, LOGIN_CHECK, GOOD_LOGIN, SQL_VIEW
	}
	
	private static final long serialVersionUID = 1L;
	
	public LoginState stateLogin;
	private String query, server, username, password;
	private JPanel jpPanel, jpLogin;
	private JTextArea jtaText;
	private JButton jbLogin;
	private JTextField jtfServer, jtfUsername, jtfPassword;
	private JLabel jlServer, jlUsername, jlPassword;
	
	public GUISQL() {
		stateLogin = LoginState.LOGIN;
		createGUI();
	}
	
	public void createGUI() {
		switch (stateLogin) {
			case LOGIN:
				System.out.println(stateLogin);
				login();
				break;
			case BAD_LOGIN:
				System.err.println("BADLOGIN");
				break;
			case LOGIN_CHECK:
				setServer(jtfServer.getText());
				setUsername(jtfUsername.getText());
				setPassword(jtfPassword.getText());
				break;
			case GOOD_LOGIN:
				break;
			case SQL_VIEW:
				textArea();
				System.out.println("SQL");
				break;
		}
	}
	
	public void textArea() {
		jtaText = new JTextArea();
		
		jtaText.addKeyListener(new KeyListener() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F5) {
					query = jtaText.getText();
					System.out.println(query);
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyTyped(KeyEvent e) {}
		});
	}
	
	public void login() {
		jbLogin = new JButton("Sign in");
		
		jtfServer = new JTextField(15);	
		jlServer = new JLabel("Server:");
		
		jtfUsername = new JTextField(15);
		jlUsername = new JLabel("Username:");
		
		jtfPassword = new JPasswordField(15);
		jlPassword = new JLabel("Password:");
		
		jpLogin = new JPanel(new GridLayout(0, 2));
		
		jpLogin.add(jlServer);
		jpLogin.add(jtfServer);
		
		jpLogin.add(jlUsername);
		jpLogin.add(jtfUsername);
		
		jpLogin.add(jlPassword);
		jpLogin.add(jtfPassword);
		
		setSize(400, 130);
		setLocationRelativeTo(null);
		
		jbLogin = new JButton("Sign in");
		jbLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				stateLogin = LoginState.LOGIN_CHECK;
				System.out.println(stateLogin);
				createGUI();
			}
		});
		
		add(jbLogin, BorderLayout.SOUTH);
		add(jpLogin, BorderLayout.CENTER);
		setVisible(true);
		setTitle("Login Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//QUERY GET/SET
	public void setQuery(String in) {
		query = in;
	}
	public String getQuery() {
		return query;
	}
	
	//SERVER GET/SET
	public void setServer(String in) {
		server = in;
	}
	public String getServer() {
		return server;
	}
	
	//USERNAME GET/SET
	public void setUsername(String in) {
		username = in;
	}
	public String getUsername() {
		return username;
	}
	
	//PASSWORD GET/SET
	public void setPassword(String in) {
		password = in;
	}
	public String getPassword() {
		return password;
	}
}
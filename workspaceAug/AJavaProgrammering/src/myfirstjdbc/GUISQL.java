package myfirstjdbc;

import javax.swing.*;

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
	private JTextArea jtaText, jtaConsole;
	private JButton jbSubmit;
	private JTextField jtfServer, jtfUsername, jtfPassword;
	private JLabel jlServer, jlUsername, jlPassword;
	private JFrame jfWindowSignIn, jfSQL;

	public GUISQL() {
		stateLogin = LoginState.LOGIN;
		checkStatus();
	}

	public void checkStatus() {
		switch (stateLogin) {
		case LOGIN:
			System.out.println(stateLogin);
			login();
			break;
		case BAD_LOGIN:
			System.err.println("BADLOGIN");
			break;
		case LOGIN_CHECK:
			System.out.println("hello");
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
		
		jfSQL = new JFrame();
		jtaText = new JTextArea();
		
		jtaConsole = new JTextArea();
		jtaConsole.setEditable(false);
		
		jfSQL.add(jtaConsole, BorderLayout.SOUTH);
		jfSQL.add(jtaText, BorderLayout.CENTER);
		
		jfSQL.setSize(800, 400);
		jfSQL.setLocationRelativeTo(null);
		jfSQL.setVisible(true);
		jfSQL.setTitle("SQL QUERY");
		jfSQL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfSQL.setResizable(false);

		jtaText.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F5) {
					setQuery(jtaText.getText());
					System.out.println("asdasd");
				}
				if (e.getKeyCode() == KeyEvent.VK_F4) {
					stateLogin = LoginState.LOGIN;
					jfSQL.dispose();
					checkStatus();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
	}

	public void login() {
		jfWindowSignIn = new JFrame();
		jbSubmit = new JButton("Sign in");

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

		jfWindowSignIn.add(jbSubmit, BorderLayout.SOUTH);
		jfWindowSignIn.add(jpLogin, BorderLayout.CENTER);
		jfWindowSignIn.setSize(400, 110);
		jfWindowSignIn.setLocationRelativeTo(null);
		jfWindowSignIn.setVisible(true);
		jfWindowSignIn.setTitle("Login Form");
		jfWindowSignIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfWindowSignIn.setResizable(false);

		jbSubmit = new JButton("Sign in");
		jbSubmit.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				stateLogin = LoginState.LOGIN_CHECK;
				checkStatus();
			}
		});
		
	}

	// QUERY GET/SET
	public void setQuery(String in) {
		query = in;
	}

	public String getQuery() {
		return query;
	}

	// SERVER GET/SET
	public void setServer(String in) {
		server = in;
	}

	public String getServer() {
		return server;
	}

	// USERNAME GET/SET
	public void setUsername(String in) {
		username = in;
	}

	public String getUsername() {
		return username;
	}

	// PASSWORD GET/SET
	public void setPassword(String in) {
		password = in;
	}

	public String getPassword() {
		return password;
	}
//	 public static void main(String[]args) {
//	        SwingUtilities.invokeLater(new Runnable() {
//	            public void run() {
//	                new GUISQL();
//	            }
//	        });
//	 }
}

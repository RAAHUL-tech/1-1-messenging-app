package client;

/**
 * Client class creates a client connection and waits for the server to connect
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class clientmsg {

	private JFrame frmClient;
	private JTextField textField;
	private static JTextArea textArea;
    static Socket s;
    static DataInputStream din;
	static DataOutputStream dout;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clientmsg window = new clientmsg();
					window.frmClient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		try
		{
			s=new Socket("localhost",3333);  //local host is ip address name and 3333 is port number
			
			din=new DataInputStream(s.getInputStream());
			dout=new DataOutputStream(s.getOutputStream());
			String data="";
			while(!data.equalsIgnoreCase("bye"))
			{
				data=din.readUTF();
				textArea.setText(textArea.getText().trim()+"\n Server :"+data+"\n");
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}	

	/**
	 * Create the application.
	 */
	public clientmsg() {
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClient = new JFrame();
		frmClient.setTitle("client");
		frmClient.setBounds(100, 100, 750, 500);
		frmClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClient.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 716, 337);
		frmClient.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setFont(new Font("Vivaldi", Font.PLAIN, 16));
		textField.setBounds(10, 384, 527, 41);
		frmClient.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.setBounds(557, 375, 140, 50);
		frmClient.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener((ActionListener) new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
			    
			    try {
			    	String data1="";
				    data1=textField.getText().trim();
				    textArea.append(data1+"\n");
					dout.writeUTF(data1);
					textField.setText("");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
				});
		
	}

}

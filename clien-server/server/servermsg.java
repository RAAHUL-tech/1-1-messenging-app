package server;

/**
 * @author Raahul krishna
 * 
 * Tecnologies used: core java,swing,networking concepts
 *
 * Server class create the server and also allows clients to connect with it for sharing information.
 * Here once the connection is established server sends a response signal to client.
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;


public class servermsg {

	private JFrame frmMesseger;
	private JTextField textField;
	private static JTextArea textArea;
	static ServerSocket ss;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
     
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					servermsg window = new servermsg();
					window.frmMesseger.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		String data="";
		try
		{
			ss=new ServerSocket(3333);  //3333 is port number
			s=ss.accept();  //establishing connection with client
			
			din=new DataInputStream(s.getInputStream());
			dout=new DataOutputStream(s.getOutputStream());
			
			while(!data.equalsIgnoreCase("bye"))
			{
				data=din.readUTF();
				textArea.setText(textArea.getText().trim()+"\n Client :"+data+"\n");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public servermsg() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frmMesseger = new JFrame();
		frmMesseger.setTitle("server");
		frmMesseger.setBounds(100, 100, 750, 500);
		frmMesseger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMesseger.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 716, 337);
		frmMesseger.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setFont(new Font("Vivaldi", Font.PLAIN, 16));
		textField.setBounds(10, 384, 527, 41);
		frmMesseger.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.setBounds(557, 375, 140, 50);
		frmMesseger.getContentPane().add(btnNewButton);
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

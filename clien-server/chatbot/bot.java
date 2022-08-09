package chatbot;

/**
 * @author Raahul krishna
 * 
 *Tecnologies used: core java,swing,networking concepts
 *
 * A simple bot messenger to chat with the bot.
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bot extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtEnterAMessege;
	private JScrollPane scrollPane;
	private JTextArea textArea;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bot frame = new bot();
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
	public bot() {
		setBackground(Color.LIGHT_GRAY);
		setTitle("Chatbot");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEnterAMessege = new JTextField();
		txtEnterAMessege.setBounds(10, 397, 450, 43);
		contentPane.add(txtEnterAMessege);
		txtEnterAMessege.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.setBounds(499, 394, 108, 48);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String data=txtEnterAMessege.getText().toLowerCase();
				textArea.append("YOU --> "+ data +"\n");
				txtEnterAMessege.setText(" ");
			    if(data.contains("hi"))	
			    {
			    	bot("hello");
			    }
			    else if(data.contains("order"))
			    {
			    	 bot("Hurrah!! I ordered for you...");
			    }
			    else if(data.contains("thank"))
			    {
			        bot("Welcome");	
			    }
			    else if(data.contains("name"))
			    		{
			    	bot("Hi,my name is alexa");
			    		}
			    else if(data.contains("gender"))
			    {
			    	bot("I'm female");
			    }
			    else if(data.contains("whatsup"))
			    {
			    	bot("Holla");
			    }
			    else if(data.contains("how are you"))
			    {
			    	bot("I'm fine,what about you");
			    }
			    else if(data.contains("song"))
			    {
			    	bot("which song do you want?");
			    }
			    else if(data.contains("remenber"))
			    {
			    	bot("Yes i remember...");
			    }
			    else
			    	bot("Sorry!! I can't understand you");
			}
			void bot(String s)
			{
				textArea.append("BOT --> "+ s +"\n");
			}
		});
		
		JLabel lblNewLabel = new JLabel("    WHATSAPP BOT");
		lblNewLabel.setFont(new Font("Viner Hand ITC", Font.PLAIN, 14));
		lblNewLabel.setBounds(202, 0, 141, 33);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 37, 616, 324);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		
		
	}
	
	
}

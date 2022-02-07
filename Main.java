public class  mail2 extends JFrame
{
	Static String POPServer;
	Static String POPUser;
	Static String POPs Password;
               Public static void main(String args[])
               {
            	   	//POPServer=args [0];
           			//POP User=args [1];
           			//POPPassword=args [2];
                    JFrame frame = new mailframe ();
                    frame.setVisible (true);
               }
       }

@SuppressWarnings ("serial")
Class mail frame extends JFrame implements ActionListener
{
	JLabel lserver =new JLabel ("SMTP Server");
	Static JTextField tserver = new JTextField (15);
	JLabel luname =new JLabel ("UserName");
	Static JTextField tuname = new JTextField (15);
	JLabel lpass =new JLabel("Password");
	Static JPasswordField tpass = new JPasswordField(15);
	Static JTextArea message = new JTextArea(30,72);
	
	Public mailframe()
	{
		this.setSize(850,500);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		}
		);
		
		tpass.setEchoChar('*');
		this.add(lserver);
		this.add(tserver);
		this.add(luname);
		this.add(tuname);
		this.add(lpass);
		this.add(tpass);

		JButton b1 =new JButton("Fetch");
		b1.addActionListener(this);
		this.add(b1);
		
		message.setEditable(false);
		JScrollPane sp =  new JScrollPane();
		message.add(sp);
		this.add(message);
		

	}
	public void actionPerformed(ActionEvent e) 
	{
		System.out.println("debug button");
		fetchmail();		
	}
	@SuppressWarnings("deprecation")
	private void fetchmail() 
	{
		String POPServer;
		String POPUser;
		String POPPassword;
		
		POPServer = mailframe.tserver.getText();
		POPUser = mailframe.tuname.getText();
		POPPassword = mailframe.tpass.getText();
		
		System.out.println(POPServer);
		try
		{
			receive(POPServer, POPUser, POPPassword);
			//receive("mail.imparttechnologies.com","testproject@imparttechnologies.com", "password123");
		}
		catch (Exception ex)
		{
			System.out.println("Usage: java jmail"+" SMTPServer address password ");
		}
		//System.exit(0);
		}


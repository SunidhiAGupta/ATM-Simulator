import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Atm extends JFrame implements ActionListener, MouseListener {

	// JPanel
	// enquiry,options,fastpanel,withdrawal,withdrawal1,depositpanel,transferpanel,transferpanel1,ministatement,exit;
	JPanel enquiry, options, fastpanel, fastpanelloan, loanmessage, withdrawal, withdrawal1, depositpanel,
			transferpanel, transferpanel1, ministatement, exit;
	JLabel loanMessage = null;
	static int z = 1;
	String k = "", q = "";
	static int wd = 0;
	static int keystate = 0;
	static int cnt1 = 0, cnt2 = 0, cnt3 = 0, cnt4 = 0, cnt5 = 0, cnt6 = 0;

	static HashMap session = new HashMap();

	String user;
	int usr, pass, cnt = 2, accno, tacc, tamt, deposi;
	// JLabel msg1,fast,balance,cash,deposit,mini,transfer;
	JLabel msg1, fast, balance, cash, deposit, mini, transfer, loan;
	JPanel pan1, pan0, pantop, panmiddle, loginpanel, mainpanel, accountpanel, adpanel;
	// JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bclear,bcancel,bok,but1,but2,click1,
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bclear, bcancel, bok, but1, but2, click1,
			but3, but4, but5, but6, but7, but8, but9, butLoan, saveButton;
	JComboBox loanList;

	JTextField loginfield, textamt, textamt1, loanAmountTxt, tenureTxt;
	JTextArea textarea;

	private JPasswordField pwordfield;
	CardLayout cardlay, cardlay1;
	Container c;
	JLabel labb, label, label2, label3, label4, label4a, label5, label6, label6a, label7;
	BorderLayout blo;
	Color c1, c2, c3;
	OptionButtonHandler handler = new OptionButtonHandler();

	public void Atmmain() {
		Container c = getContentPane();

		c = getContentPane();
		c.setLayout(null);
		click1 = new JButton("click here to start");
		click1.setLocation(300, 100);
		// c.add(click1);

		but1 = new JButton(">>>");
		but1.setPreferredSize(new Dimension(100, 30));
		but1.setSize(but1.getPreferredSize());
		but1.setLocation(50, 50);
		// but1.addActionListener(this) ;
		c.add(but1);

		but2 = new JButton(">>>");
		but2.setPreferredSize(new Dimension(100, 30));
		but2.setSize(but2.getPreferredSize());
		but2.setLocation(50, 100);

		c.add(but2);

		but3 = new JButton(">>>");
		but3.setPreferredSize(new Dimension(100, 30));
		but3.setSize(but3.getPreferredSize());

		but3.setLocation(50, 150);
		c.add(but3);

		butLoan = new JButton(">>>");
		butLoan.setPreferredSize(new Dimension(100, 30));
		butLoan.setSize(butLoan.getPreferredSize());
		butLoan.setLocation(50, 200);
		// but1.addActionListener(this) ;
		c.add(butLoan);

		but4 = new JButton("<<<");
		but4.setPreferredSize(new Dimension(100, 30));
		but4.setSize(but4.getPreferredSize());
		// but4.addActionListener(this);
		but4.setLocation(575, 50);
		c.add(but4);

		but5 = new JButton("<<<");
		but5.setPreferredSize(new Dimension(100, 30));
		but5.setSize(but5.getPreferredSize());
		but5.setLocation(575, 100);
		// but5.addActionListener(this);
		c.add(but5);

		but6 = new JButton("<<<");
		but6.setPreferredSize(new Dimension(100, 30));
		but6.setSize(but6.getPreferredSize());
		but6.setLocation(575, 150);
		// but6.addActionListener(this);
		c.add(but6);

		b1 = new JButton("1");// b1.setSize(300,300);
		b2 = new JButton("2");// b1.setSize(300,300);
		b3 = new JButton("3");// b1.setSize(300,300);
		b4 = new JButton("4");// b1.setSize(300,300);
		b5 = new JButton("5");// b1.setSize(300,300);
		b6 = new JButton("6");// b1.setSize(300,300);
		b7 = new JButton("7");// b1.setSize(300,300);
		b8 = new JButton("8");// b1.setSize(300,300);
		b9 = new JButton("9");// b1.setSize(300,300);
		b0 = new JButton("0");// b1.setSize(300,300);

		bclear = new JButton("CLEAR");
		bcancel = new JButton("CANCEL");
		bok = new JButton("OK");

		pan1 = new JPanel();
		pan1.setLayout(new GridLayout(4, 2, 10, 10));
		pan1.setSize(260, 150);

		pan1.add(b1);
		pan1.add(b2);
		pan1.add(b3);
		pan1.add(b4);
		pan1.add(b5);
		pan1.add(b6);
		pan1.add(b7);
		pan1.add(b8);
		pan1.add(b9);
		pan1.add(b0);
		pan1.add(bclear);
		pan1.add(bcancel);
		pan1.setLocation(225, 300);
		// pan1.setBackground(Color.ORANGE);
		pan1.setBackground(Color.ORANGE);
		c.add(pan1);

		cardlay = new CardLayout();
		blo = new BorderLayout();
		panmiddle = new JPanel();
		panmiddle.setSize(402, 250);
		panmiddle.setLocation(160, 30);
		panmiddle.setLayout(cardlay);

		panmiddle.setBackground(Color.WHITE);

		adpanel = new JPanel();
		loginpanel = new JPanel();
		mainpanel = new JPanel();
		accountpanel = new JPanel();

		mainpanel.setBackground(Color.WHITE);
		panmiddle.add(adpanel, "ad");
		panmiddle.add(loginpanel, "login");
		panmiddle.add(mainpanel, "main");
		panmiddle.add(accountpanel, "account");
		// adpanel.setBackground(Color.PINK);
		adpanel.setBackground(Color.BLUE);

		start();
		c.add(panmiddle);
		setTitle("Main Atm");
		setSize(730, 520);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void Password() {
		loginpanel.setSize(200, 200);
		c1 = new Color(255, 100, 100);
		c2 = new Color(255, 50, 50);
		loginpanel.setBackground(c1);
		loginpanel.setLayout(blo);

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(3, 2, 10, 10));
		p1.setSize(100, 50);
		p1.setBackground(c2);

		String wel1 = "                     	W E L C O M E!   \n " +
				"             	Please write your login and password:\n" +
				"         	 -------------------------------------------\n";

		JTextArea welcome1 = new JTextArea(wel1);
		welcome1.setBackground(c1);
		welcome1.setEditable(false);

		loginpanel.add(welcome1, blo.NORTH);

		// inside panel p1 (grid)

		JLabel login = new JLabel("CUSTOMER ID");
		JLabel pass = new JLabel("PIN CODE");
		loginfield = new JTextField(4);
		p1.add(login);
		p1.add(loginfield);
		p1.add(pass);
		pwordfield = new JPasswordField(4);
		p1.add(pwordfield);
		but8 = new JButton("OK");
		but8.setPreferredSize(new Dimension(90, 25));
		but8.setSize(but8.getPreferredSize());
		p1.add(but8);
		but9 = new JButton("CANCEL");
		but9.setPreferredSize(new Dimension(90, 25));
		but9.setSize(but9.getPreferredSize());
		p1.add(but9);
		// -----Informations about the program-----
		String sttr = "\t\t---------------------------------------------\n";
		// -----set up textarea----------------
		textarea = new JTextArea(sttr);
		loginpanel.add(textarea, blo.SOUTH);
		textarea.setBackground(c1);
		textarea.setEditable(false);
		loginpanel.add(p1, blo.EAST);
		loginfield.requestFocus();
		but8.addActionListener(this);
		but9.addActionListener(this);

	}

	public void start() {
		// LogoAnimatorJPanel animation = new LogoAnimatorJPanel();
		adpanel.add(click1); // add panel to frame
		// panmiddle.pack(); // make window just large enough for its GUI
		adpanel.setVisible(true); // display window
		// animation.startAnimation(); // begin animation
		click1.addMouseListener(this);

	}

	public void getchoice() {
		JPanel choice = new JPanel();
		choice.setLayout(blo);
		String wel2 = "                     W E L C O M E   " + user + " \n " +
				"             	Please select your account \n" +
				"         	 -------------------------------------------\n";

		JTextArea welcome2 = new JTextArea(wel2);
		welcome2.setBackground(c1);
		welcome2.setEditable(false);
		choice.add(welcome2, blo.NORTH);
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(2, 1, 30, 40));
		JLabel saving = new JLabel("SAVING");
		JLabel current = new JLabel("CURRENT");
		p2.add(saving);
		p2.add(current);
		choice.add(p2, blo.EAST);
		mainpanel.add(choice);
		but5.addActionListener(this);
		but6.addActionListener(this);

	}

	public void getaccountscreen() {

		cardlay1 = new CardLayout();
		accountpanel.setBackground(c1);
		accountpanel.setLayout(cardlay1);
		options = new JPanel();
		enquiry = new JPanel();
		fastpanel = new JPanel();
		fastpanelloan = new JPanel();
		loanmessage = new JPanel();
		// loanmessage.setBackground(new Color(255,76,89));
		String show = "Your Loan Request Has Been Saved Successfully.";
		loanMessage = new JLabel(show);
		loanmessage.add(loanMessage);
		withdrawal = new JPanel();
		withdrawal1 = new JPanel();
		ministatement = new JPanel();
		depositpanel = new JPanel();
		transferpanel = new JPanel();
		transferpanel1 = new JPanel();
		exit = new JPanel();
		String acc = "  \n \n" +
				"FAST CASH			BALANCE ENQUIRY \n" +
				"                                 \n  \n" +
				"CASH WITHDRAWAL		DEPOSIT \n " +
				"						\n	\n " +
				"MINI STATEMENT		TRANSFER \n \n\n" +
				"APPLY FOR LOAN";

		JTextArea account = new JTextArea(acc);
		account.setBackground(c1);
		account.setEditable(false);
		options.add(account);
		String dispbal = "\n\n\n  Dear " + user + "\n Select your choice " + "\n   on your Account NO " + accno;
		JTextArea bal = new JTextArea(dispbal);
		bal.setBackground(c1);
		bal.setEditable(false);
		options.add(bal);
		accountpanel.add(options, "options");
		accountpanel.add(enquiry, "enquiry");
		accountpanel.add(fastpanel, "fast");
		// added by ankit bajaj
		accountpanel.add(fastpanelloan, "loan");
		accountpanel.add(loanmessage, "loanmessage");
		accountpanel.add(withdrawal, "withdrawal");
		accountpanel.add(withdrawal1, "withdrawal1");
		accountpanel.add(ministatement, "ministatement");
		accountpanel.add(depositpanel, "deposit");
		accountpanel.add(transferpanel, "transfer");
		accountpanel.add(transferpanel1, "transfer1");
		accountpanel.add(exit, "exit");
		options.setBackground(c1);
		cardlay1.show(accountpanel, "options");
		System.out.println("start ");
		System.out.println(cnt6);
		but1.addActionListener(handler);
		but2.addActionListener(handler);
		but3.addActionListener(handler);
		but4.addActionListener(handler);
		but5.addActionListener(handler);
		but6.addActionListener(handler);
		// added by Ankit Bajaj1
		butLoan.addActionListener(handler);
		// saveButton.addActionListener(handler);
	}

	private class OptionButtonHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			boolean a = false;
			System.out.println("-------------------->>>amit>>>----------");
			if (event.getSource() == but1 && cnt1 == 0 && a == false) {
				cnt1 = 1;
				a = true;
				cnt4 = -1;
				cnt2 = -1;
				cnt3 = -1;
				cnt5 = -1;
				cnt6 = -1;
				a = true;
				cardlay1.show(accountpanel, "fast");
				getfastpanel();

			} else if (event.getSource() == but1 && cnt1 == 1 && a == false) {
				cnt1 = 2;
				a = true;
				wd = 100;
				Withdrawal w = new Withdrawal(accno, wd);
				cardlay1.show(accountpanel, "enquiry");
				showprintoptions();

			} else if (event.getSource() == but2 && cnt == 1 && a == false) {
				cnt1 = 2;
				a = true;
				wd = 1000;
				Withdrawal w = new Withdrawal(accno, wd);
				cardlay1.show(accountpanel, "enquiry");
				showprintoptions();

			} else if (event.getSource() == but3 && cnt1 == 1 && a == false) {
				cnt1 = 2;
				a = true;
				wd = 10000;
				Withdrawal w = new Withdrawal(accno, wd);
				cardlay1.show(accountpanel, "enquiry");
				showprintoptions();

			} else if (event.getSource() == but4 && cnt1 == 1 && a == false) {
				cnt1 = 2;
				a = true;
				wd = 500;
				Withdrawal w = new Withdrawal(accno, wd);
				cardlay1.show(accountpanel, "enquiry");
				showprintoptions();

			} else if (event.getSource() == but5 && cnt1 == 1 && a == false) {
				cnt1 = 2;
				a = true;
				wd = 5000;
				Withdrawal w = new Withdrawal(accno, wd);
				cardlay1.show(accountpanel, "enquiry");
				showprintoptions();

			} else if (event.getSource() == but6 && cnt1 == 1 && a == false) {
				cnt1 = 2;
				a = true;
				wd = 15000;
				Withdrawal w = new Withdrawal(accno, wd);
				cardlay1.show(accountpanel, "enquiry");
				showprintoptions();

			}

			else if (event.getSource() == but4 && cnt1 == 2 && a == false) {
				cnt1 = 3;
				a = true;
				printslip();
				cardlay1.show(accountpanel, "exit");
				exitpanel();
			} else if (event.getSource() == but5 && cnt1 == 2 && a == false) {
				cnt1 = 3;
				a = true;
				// do not print slip and go to exit panel
				cardlay1.show(accountpanel, "exit");
				exitpanel();
			}

			else if (event.getSource() == but5 && cnt1 == 3 && a == false) // next 2 options for exit screen
			{
				a = true;
				cnt1 = 0;
				cnt2 = 0;
				cnt3 = 0;
				cnt4 = 0;
				cnt5 = 0;
				cnt6 = 0;
				cardlay1.show(accountpanel, "options");

			} else if (event.getSource() == but4 && cnt1 == 3 && a == false) {
				a = true;
				System.exit(0);
			}

			// Cash withdrawal

			else if (event.getSource() == but2 && cnt2 == 0 && a == false) {
				cnt2 = 1;
				a = true;
				cnt4 = -1;
				cnt1 = -1;
				cnt3 = -1;
				cnt5 = -1;
				cnt6 = -1;

				withdrawal.setBackground(c1);
				withdrawal.setLayout(blo);
				cardlay1.show(accountpanel, "withdrawal");

				showWithrawalOptions();
			} else if (event.getSource() == but5 && cnt2 == 1 && a == false) {
				cnt2 = 2;
				a = true;
				k = "";
				wd = Integer.parseInt(textamt.getText());
				Withdrawal w = new Withdrawal(accno, wd);

				cardlay1.show(accountpanel, "enquiry");
				System.out.println(w.current_abal);

				showprintoptions();
			} else if (event.getSource() == but4 && cnt2 == 2 && a == false) {
				cnt2 = 3;
				a = true;
				printslip();
				wd = 0;
				cardlay1.show(accountpanel, "exit");
				exitpanel();
			} else if (event.getSource() == but5 && cnt2 == 2 && a == false) {
				cnt2 = 3;
				a = true;
				wd = 0;
				// do not print slip and go to exit panel
				cardlay1.show(accountpanel, "exit");
				exitpanel();
			}

			else if (event.getSource() == but5 && cnt2 == 3 && a == false) // next 2 options for exit screen
			{
				a = true;
				cardlay1.show(accountpanel, "options");
				cnt1 = 0;
				cnt2 = 0;
				cnt3 = 0;
				cnt4 = 0;
				cnt5 = 0;
				cnt6 = 0;
			} else if (event.getSource() == but4 && cnt2 == 3 && a == false) {
				a = true;
				System.exit(0);
			}

			// mini statement

			else if (event.getSource() == but3 && cnt3 == 0 && a == false) {
				cnt3 = 1;
				a = true;
				cnt1 = -1;
				cnt2 = -1;
				cnt4 = -1;
				cnt5 = -1;
				cnt6 = -1;
				a = true;
				// ministatement.setBackground(c1);
				// cardlay1.show(accountpanel,"ministatement");

				printmini();

				// do not print slip and go to exit panel
				cardlay1.show(accountpanel, "exit");
				exitpanel();

			} else if (event.getSource() == but5 && cnt3 == 1 && a == false) // next 2 options for exit screen
			{
				a = true;
				cnt1 = 0;
				cnt2 = 0;
				cnt3 = 0;
				cnt4 = 0;
				cnt5 = 0;
				cnt6 = 0;
				cardlay1.show(accountpanel, "options");
				cnt1 = 0;
				cnt2 = 0;
				cnt3 = 0;
				cnt4 = 0;
				cnt5 = 0;
				cnt6 = 0;
			} else if (event.getSource() == but4 && cnt3 == 1 && a == false) {
				a = true;
				System.exit(0);
			}

			// Balance Enquiry

			else if (event.getSource() == but4 && cnt4 == 0 && a == false) {
				cnt4 = 1;
				cnt1 = -1;
				cnt2 = -1;
				cnt3 = -1;
				cnt5 = -1;
				cnt6 = -1;
				a = true;

				BalanceEnquiry be = new BalanceEnquiry(accno);
				enquiry.setBackground(c1);
				cardlay1.show(accountpanel, "enquiry");

				System.out.println(be.abal);

				showprintoptions();

			}

			else if (event.getSource() == but4 && cnt4 == 1 && a == false) {
				cnt4 = 2;
				a = true;
				printslip();
				cardlay1.show(accountpanel, "exit");
				exitpanel();
			} else if (event.getSource() == but5 && cnt4 == 1 && a == false) {
				cnt4 = 2;
				a = true;
				// do not print slip and go to exit panel
				cardlay1.show(accountpanel, "exit");
				exitpanel();
			}

			else if (event.getSource() == but5 && cnt4 == 2 && a == false) // next 2 options for exit screen
			{
				a = true;
				cardlay1.show(accountpanel, "options");
				cnt1 = 0;
				cnt2 = 0;
				cnt3 = 0;
				cnt4 = 0;
				cnt5 = 0;
				cnt6 = 0;
			} else if (event.getSource() == but4 && cnt4 == 2 && a == false) {
				a = true;
				System.exit(0);
			}

			// Deposit
			else if (event.getSource() == but5 && cnt5 == 0 && a == false) {
				cnt5 = 1;
				a = true;
				cnt1 = -1;
				cnt2 = -1;
				cnt3 = -1;
				cnt4 = -1;
				cnt6 = -1;
				a = true;

				withdrawal.setBackground(c1);
				withdrawal.setLayout(blo);
				cardlay1.show(accountpanel, "withdrawal");

				showWithrawalOptions();
			} else if (event.getSource() == but5 && cnt5 == 1 && a == false) {

				cnt5 = 2;
				a = true;
				deposi = Integer.parseInt(textamt.getText());
				Deposit d = new Deposit(accno, deposi);
				k = "";
				cardlay1.show(accountpanel, "enquiry");
				// System.out.println(w.current_abal);

				showprintoptions();
			} else if (event.getSource() == but4 && cnt5 == 2 && a == false) {
				cnt5 = 3;
				a = true;
				printslipdeposit();
				cardlay1.show(accountpanel, "exit");
				exitpanel();
			} else if (event.getSource() == but5 && cnt5 == 2 && a == false) {
				cnt5 = 3;
				a = true;
				// do not print slip and go to exit panel
				cardlay1.show(accountpanel, "exit");
				exitpanel();
			}

			else if (event.getSource() == but5 && cnt5 == 3 && a == false) // next 2 options for exit screen
			{
				a = true;
				cnt1 = 0;
				cnt2 = 0;
				cnt3 = 0;
				cnt4 = 0;
				cnt5 = 0;
				cnt6 = 0;
				cardlay1.show(accountpanel, "options");
				cnt1 = 0;
				cnt2 = 0;
				cnt3 = 0;
				cnt4 = 0;
				cnt5 = 0;
				cnt6 = 0;

			} else if (event.getSource() == but4 && cnt5 == 3 && a == false) {
				a = true;
				printslipdeposit();
				System.exit(0);
			}

			// Transfer

			else if (event.getSource() == but6 && cnt6 == 0 && a == false) {
				cnt6 = 1;
				a = true;
				cnt1 = -1;
				cnt2 = -1;
				cnt3 = -1;
				cnt4 = -1;
				cnt5 = -1;
				a = true;
				transferpanel.setBackground(c1);
				transferpanel.setLayout(blo);

				cardlay1.show(accountpanel, "transfer");
				gettransfer();
				System.out.println("transfer");

			} else if (event.getSource() == but5 && cnt6 == 1 && a == false) {
				cnt6 = 2;
				a = true;
				keystate = 2;

				tacc = Integer.parseInt(textamt.getText());
				textamt1.requestFocus();
				k = "";

				System.out.println(tacc);

			} else if (event.getSource() == but5 && keystate == 2 && cnt6 == 2 && a == false) {
				cnt6 = 3;
				a = true;
				keystate = -1;

				tamt = Integer.parseInt(textamt1.getText());

				System.out.println(" cnt is three obj created ");
				Withdrawal w = new Withdrawal(accno, tamt);
				Deposit d = new Deposit(tacc, tamt);
				cardlay1.show(accountpanel, "enquiry");

				showprintoptions();

			}
			// added by ankit bajaj1

			else if (event.getSource() == butLoan && cnt5 == 0 && a == false) {
				c3 = new Color(255, 70, 56);
				fastpanelloan.setBackground(c3);

				/// Added By AMit
				fastpanelloan.setLayout(new GridBagLayout());

				GridBagConstraints c = new GridBagConstraints();
				c.fill = GridBagConstraints.HORIZONTAL;
				c.insets = new Insets(10, 0, 0, 0);
				c.ipady = 5; // make this component tall
				c.weightx = 0.0;
				c.gridwidth = 3;
				c.gridx = 3;
				c.gridy = 0;
				JLabel loanLableHeader = new JLabel(" Loan Initiation ");
				loanLableHeader.setForeground(new Color(255, 255, 255));
				fastpanelloan.add(loanLableHeader, c);
				c.fill = GridBagConstraints.HORIZONTAL;
				c.insets = new Insets(10, 0, 0, 0);
				c.gridx = 0;
				c.gridy = 1;
				JLabel productLabel = null;
				productLabel = new JLabel("Product : ");
				fastpanelloan.add(productLabel, c);

				c.fill = GridBagConstraints.HORIZONTAL;
				c.insets = new Insets(10, 0, 0, 0);
				c.gridx = 3;
				c.gridy = 1;
				String[] loanStrings = { "home", "auto", "personal" };
				loanList = new JComboBox(loanStrings);
				loanList.setSize(2, 1);
				loanList.setSelectedIndex(2);
				fastpanelloan.add(loanList, c);

				c.fill = GridBagConstraints.HORIZONTAL;
				c.insets = new Insets(10, 0, 0, 0);
				c.gridx = 0;
				c.gridy = 2;
				JLabel loanAmountLabel = null;
				loanAmountLabel = new JLabel("Requested Amount: ");
				fastpanelloan.add(loanAmountLabel, c);

				c.fill = GridBagConstraints.HORIZONTAL;
				c.insets = new Insets(10, 0, 0, 0);
				c.gridx = 3;
				c.gridy = 2;
				loanAmountTxt = new JTextField(20);
				fastpanelloan.add(loanAmountTxt, c);

				c.fill = GridBagConstraints.HORIZONTAL;
				c.insets = new Insets(10, 0, 0, 0);
				c.gridx = 0;
				c.gridy = 3;
				JLabel tenureLable = new JLabel("Tenure :");
				fastpanelloan.add(tenureLable, c);

				c.fill = GridBagConstraints.HORIZONTAL;
				c.insets = new Insets(10, 0, 0, 0);
				c.gridx = 3;
				c.gridy = 3;
				tenureTxt = new JTextField(6);
				fastpanelloan.add(tenureTxt, c);

				c.fill = GridBagConstraints.HORIZONTAL;
				c.ipady = 5; // make this component tall
				c.insets = new Insets(10, 50, 0, 0);
				c.weightx = 0.0;
				c.gridwidth = 2;
				c.gridx = 3;
				c.gridy = 5;

				saveButton = new JButton("Save");
				fastpanelloan.add(saveButton, c);
				saveButton.addActionListener(handler);
				cardlay1.show(accountpanel, "loan");

			}

			// 123
			else if (event.getSource() == saveButton) {

				Query q = new Query();
				int usr = (Integer) session.get("user");
				int accno = q.getacc(usr, "s");

				System.out.println("SESSION USER: " + usr);
				System.out.println("SESSION ACCOUNTNO: " + accno);
				int reqId = (int) Math.random() * 100;
				q.getLoan(loanList.getSelectedItem().toString(), loanAmountTxt.getText(), tenureTxt.getText(),
						reqId + "".trim(), usr + "".trim(), accno + "".trim());

				System.out.println("AMIT IS HERE 2");
				showloanmessage();

			}
			// ended by ankit

			/*
			 * else if(event.getSource()==but4 && cnt6==3 && a==false)
			 * {
			 * cnt6=4;a=true;
			 * printslip();
			 * cardlay1.show(accountpanel,"exit");
			 * exitpanel();
			 * }
			 * /*else if(event.getSource()==but5 && cnt6==3 && a==false )
			 * {
			 * cnt6=4;a=true;
			 * //do not print slip and go to exit panel
			 * cardlay1.show(accountpanel,"exit");
			 * exitpanel();
			 * }
			 * 
			 * else if(event.getSource()==but5 && cnt6==4 && a==false ) //next 2 options for
			 * exit screen
			 * {
			 * a=true;cnt1=0;cnt2=0;cnt3=0;cnt4=0;cnt5=0;cnt6=0;
			 * cardlay1.show(accountpanel,"options");
			 * cnt1=0;cnt2=0;cnt3=0;cnt4=0;cnt5=0;cnt6=0;
			 * 
			 * }
			 * else if (event.getSource()==but4 && cnt6==4 && a==false)
			 * { a=true;
			 * System.exit(0);
			 * }
			 */

		}

	}

	public void gettransfer() {
		JLabel ook = new JLabel("		OK	");

		JLabel withamt1 = new JLabel(" 	Enter the account no   ");
		JLabel withamt2 = new JLabel(" 	Enter the amount     ");

		textamt = new JTextField(4);
		textamt1 = new JTextField(4);

		JPanel pp = new JPanel();
		pp.setLayout(new FlowLayout(50));
		pp.setBackground(c2);

		pp.add(withamt1);
		pp.add(textamt);

		pp.add(withamt2);
		pp.add(textamt1);
		pp.add(ook);

		transferpanel.add(pp, blo.EAST);

		textamt.requestFocus();
		keystate = 1;

		initkeypad();

	}

	public void printmini() {
		Query mini = new Query();
		String sta[] = new String[10];

		sta = mini.ministatement(accno);

		JOptionPane.showMessageDialog(null, sta);

	}
	// 123

	public void getfastpanel() {
		fastpanel.setBackground(c1);

		String acc = "  \n \n" +
				"INR 100		    	INR 500 \n" +
				"                                 \n  \n" +
				"INR 1000		    	INR 5000 \n " +
				"						\n	\n " +
				"INR 10000	     		INR 15000 ";

		JTextArea account = new JTextArea(acc);
		account.setBackground(c1);
		account.setEditable(false);

		fastpanel.add(account);

		String dispbal = "\n\n\n  Dear " + user + "\n Select your option ";

		JTextArea bal = new JTextArea(dispbal);
		bal.setBackground(c1);
		bal.setEditable(false);
		fastpanel.add(bal);
	}

	public void showWithrawalOptions() {

		JLabel ook = new JLabel("		OK	");
		JLabel withamt = new JLabel(" 	Enter the amount     ");
		textamt = new JTextField(4);

		JPanel pp = new JPanel();
		pp.setLayout(new FlowLayout(50));
		pp.setBackground(c2);

		pp.add(withamt);
		pp.add(textamt);
		pp.add(ook);

		withdrawal.add(pp, blo.EAST);
		textamt.requestFocus();

		initkeypad();

	}

	public void initkeypad() {
		KeyActionHandler key = new KeyActionHandler();

		b1.addActionListener(key);
		b2.addActionListener(key);
		b3.addActionListener(key);
		b4.addActionListener(key);
		b5.addActionListener(key);
		b6.addActionListener(key);
		b7.addActionListener(key);
		b8.addActionListener(key);
		b9.addActionListener(key);
		b0.addActionListener(key);
		bclear.addActionListener(key);
		bcancel.addActionListener(key);

	}

	private class KeyActionHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			if (((JButton) event.getSource()).getText() == "CLEAR") {
				textamt.setText("");
				k = "";
			} else if (((JButton) event.getSource()).getText() == "CANCEL") {
				cnt1 = 0;
				cnt2 = 0;
				cnt3 = 0;
				cnt4 = 0;
				cnt5 = 0;
				cnt6 = 0;
				k = "";
				q = "";
				cardlay1.show(accountpanel, "options");

			} else {

				String btntext = ((JButton) event.getSource()).getText();

				if (textamt.isFocusable()) {
					k = k + btntext;
					textamt.setText(k);
					textamt.setFocusable(true);
				}
				System.out.println("the value of textamt1 is----------------------->" + textamt1);
				if (textamt1.isFocusable()) {
					q = q + btntext;
					textamt1.setText(q);
					textamt1.setFocusable(true);
					System.out.println(" else ");
				}

			}
		}

	}

	public void showprintoptions() {
		BalanceEnquiry be = new BalanceEnquiry(accno);
		BorderLayout blo1 = new BorderLayout();
		enquiry.setLayout(blo1);

		String show = "\n\n\n\n\n  	    ACCOUNT BALANCE  " +
				"\n	    Available balance :" + be.abal +
				"\n\n 	   Want  Print statement ?";
		JTextArea bal1 = new JTextArea(show);
		bal1.setBackground(c1);
		bal1.setEditable(false);
		enquiry.add(bal1, blo1.CENTER);

		JPanel print = new JPanel();
		print.setLayout(new GridLayout(4, 1, 10, 14));
		print.setBackground(c1);
		JLabel yes = new JLabel("\nYES      ");
		JLabel no = new JLabel("NO        ");
		print.add(yes);
		print.add(no);

		enquiry.add(print, blo1.EAST);

	}

	// added By Amit
	public void showloanmessage() {

		// String show= "Your Loan Request Has Been Saved.\n\n You Further Status will
		// be informed to you Soon.";
		loanmessage.setBackground(new Color(255, 76, 89));
		cardlay1.show(accountpanel, "loanmessage");
	}

	public void exitpanel() {
		// BalanceEnquiry be=new BalanceEnquiry(accno);
		BorderLayout blo1 = new BorderLayout();
		exit.setLayout(blo1);

		String show11 = "\n\n\n\n\n 	Dear User  " +
				"\n	    Thank You!! ";
		JTextArea bal11 = new JTextArea(show11);
		bal11.setBackground(c1);
		bal11.setEditable(false);
		exit.add(bal11, blo1.CENTER);

		JPanel print = new JPanel();
		print.setLayout(new GridLayout(4, 1, 10, 14));
		print.setBackground(c1);
		JLabel yes = new JLabel("\nEXIT      ");
		JLabel no = new JLabel("   ");
		print.add(yes);
		print.add(no);

		exit.add(print, blo1.EAST);

	}

	public void printslip() {
		BalanceEnquiry be = new BalanceEnquiry(accno);
		// be.printbal(usr,be.accno,be.abal,be.lbal);

		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aaa ");
		String date = formatter.format(today);

		String slip1 = "		  A/C NO : " + be.accno +
				"\n    Card no: " + usr +
				"\n\n     " + date +
				"\n\n  Withdrawal :" + wd +
				"\n\n  Available Balance: " + be.abal +
				"\n\n  Thank you \n" +
				"-------------------------------\n";

		JOptionPane.showMessageDialog(null, slip1);

	}

	public void printslipdeposit() {
		BalanceEnquiry be = new BalanceEnquiry(accno);
		// be.printbal(usr,be.accno,be.abal,be.lbal);

		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aaa ");
		String date = formatter.format(today);

		String slip1 = "		  A/C NO : " + be.accno +
				"\n    Card no: " + usr +
				"\n\n     " + date +
				"\n\n  Deposit :" + deposi +
				"\n\n  Available Balance: " + be.abal +
				"\n\n  Thank you \n" +
				"-------------------------------\n";

		JOptionPane.showMessageDialog(null, slip1);

	}

	public void mouseClicked(MouseEvent me) {
		cardlay.show(panmiddle, "login");
		Password();
	}

	public void mouseExited(MouseEvent me) {
	}

	public void mousePressed(MouseEvent me) {
	}

	public void mouseEntered(MouseEvent me) {
	}

	public void mouseReleased(MouseEvent me) {
	}

	public void actionPerformed(ActionEvent ae) {

		System.out.println("ae.getSource()----->" + ae.getSource());
		System.out.println("I am here-----");

		if (ae.getSource() == but8) {
			Query q = new Query();
			// added BY Amit Kumar Sharma
			try {
				usr = Integer.parseInt(loginfield.getText());
				pass = Integer.parseInt(pwordfield.getText());
				// added BY Ankit
				session.put("user", usr);

			} catch (NumberFormatException e) {

				JOptionPane.showMessageDialog(null, "Warning! User Id Or Pin Should be Numeric!");

			}

			user = q.val_password(usr, pass);

			if (user == null) {
				cnt--;
				if (cnt >= 0) {
					int opi = cnt + 1;
					JOptionPane.showMessageDialog(null, "LOGIN ERROR!!\n You hav " + opi + " chances left");
					cardlay.show(panmiddle, "login");
				} else
					System.exit(0);
			} else {
				System.out.println(user);
				cardlay.show(panmiddle, "main");
				getchoice();

			}

		}
		if (ae.getSource() == but9) {
			cardlay.show(panmiddle, "ad");
			getchoice();
		}
		if (ae.getSource() == but5) {
			cardlay.show(panmiddle, "account");

			Query q = new Query();
			System.out.println("AMIT IS HERE 1");
			accno = q.getacc(usr, "s");
			System.out.println("AMIT IS HERE 2");
			getaccountscreen();
		}
		if (ae.getSource() == but6) {
			cardlay.show(panmiddle, "account");
			Query q = new Query();
			accno = q.getacc(usr, "c");

			getaccountscreen();

		}

	}

	public static void main(String[] args) {
		Atm a = new Atm();
		a.Atmmain();

	}

}// end class Atm
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorFactor extends JFrame
{
	private JPanel panel;
	private JPanel labelPanel;
	private JPanel buttonPanel;
	
    private JLabel messageLabel;
    private JTextField questionTextField;
    private JLabel responseLabel;
    private JLabel longLabel;
    
	private JButton getLongestWordsButton;
	private JButton submitButton;
	private JButton resetButton;
	
	
	
	
	private final int WINDOW_WIDTH = 580;
	private final int WINDOW_HEIGHT =150;
	// Constructor
	
	public ColorFactor()
	{
		setTitle("Getting the Loggesr word");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	   
		setLayout(new BorderLayout());
		
	    buildPanel();
	    buildLabelPanel();
		buildButtonPanel();
	
		
		
		add(panel, BorderLayout.NORTH);
		add(labelPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	    setVisible(true);
	     
	  }  
		
		/** Build the panel and add it to rhe frame.
	     */
		
		private void buildPanel()
		{
		
	
			panel = new JPanel();
		    messageLabel = new JLabel("In 1 sentence tell me what is in your mind today");
		    questionTextField = new JTextField(25);
		
		    panel.add(messageLabel);
		    panel.add(questionTextField);
	        add(panel);
	       
		
		
		
		
		}
		

  private void buildButtonPanel()
  {
	 
	 buttonPanel = new JPanel();   	
	 getLongestWordsButton = new JButton("Get the longest words");
	 submitButton = new JButton("Submit");
	 resetButton = new JButton("Reset");
	    	
	 // Register an event listener with buttons.
     getLongestWordsButton.addActionListener(new GetLongestWordsButtonListener());
     submitButton.addActionListener(new SubmitButtonListener());
	 resetButton.addActionListener(new ResetButtonListener());	
	    
	 buttonPanel.add(getLongestWordsButton);
	 buttonPanel.add(submitButton);
	 buttonPanel.add(resetButton);
		   
     add(buttonPanel);
	 

	    	
   }
   private class GetLongestWordsButtonListener implements ActionListener
	 {
	   public void actionPerformed(ActionEvent e)
	   {
	   	responseLabel.setText("");
	   	//Scanner kw = new Scanner(System.in);
	   	String str = questionTextField.getText();
	   	//String[] results = str.split(","));
	   	String longestWord = "null";
	   	
	    str = str.trim();
		if (str.equals( "" ))
		{
			longLabel.setText("You have not entered any word yet. Please tell me what is in your mind today");
			return;
		}
	   
	   		longLabel.setText("The longest word is: "+str); 
	   	}
	 }
    private class SubmitButtonListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    	   longLabel.setText("");
	   	   //Scanner kw = new Scanner(System.in);
	   	   String str = questionTextField.getText();
	   	   str = str.trim();
		   if (str.equals( "" ))
		   {
			  longLabel.setText("You have not entered any word yet. Please tell me what is in your mind today");
			  return;
		   }
	   	
	   	//String[] results = str.split(","));
	   	String longestWord = "null";
	   	str = str+' ';
	   	String words = "";
	   	int maxlength = 0;
		
	   	for(int i=0; i<str.length(); i++)
	   	{
	   		words = words+str.charAt(i);
	   		if(str.charAt(i+1)==' ')
	   		{
	   			if(words.length()>maxlength)
	   			{
	   				longestWord = new String(words);
	   				maxlength = words.length();
	   				
	   			}
	   			words = "";
	   			i++;
	   		} 
	   		
	   		if(longestWord.length()<3)
	      	{
	   	    	responseLabel.setText("Is there something else you would like to discuss?");
	     	}
	     	else if(longestWord.length()==3)
	      	{
	   	    	responseLabel.setText("Hmmm tell me more about longestword please");
	     	}
	     	else if(longestWord.length()==4)
	      	{
	   	    	responseLabel.setText("Why do you feel longestword is important?");
	     	}
	     	else if(longestWord.length()==5)
	      	{
	   	    	responseLabel.setText("How does longestword affect you?");
	     	} 
	     	else {
	     		responseLabel.setText("We seem to be making great progress with longestword?");
	     	}
	     	
	   		
	   	}
    	}
    }
    private class ResetButtonListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		questionTextField.setText("");
	 	   	longLabel.setText("");
	 	   	responseLabel.setText("");
    	}
    }
    
 
	
	
	    private void buildLabelPanel()
		{
	      
	        labelPanel = new JPanel();
	        longLabel = new JLabel("");
	        responseLabel = new JLabel("");
		    
	
		    labelPanel.add(longLabel);
		    labelPanel.add(responseLabel);
	        add(labelPanel);
	       
	     }
	    
       
    public static void main(String[] args)
	{
		ColorFactor cf = new ColorFactor();
	}

	


 

	
	
	
	
}


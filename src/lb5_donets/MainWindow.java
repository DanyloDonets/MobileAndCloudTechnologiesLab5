package lb5_donets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MainWindow {
	private Text wordText;

	/**
	 * Launch the application.
	 * @param args
	 */
	
	private static String word;
	
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label wordLbl = new Label(shell, SWT.NONE);
		wordLbl.setBounds(10, 10, 55, 15);
		wordLbl.setText("Word:");
		
		Label newWordLabelLbl = new Label(shell, SWT.NONE);
		newWordLabelLbl.setBounds(10, 37, 55, 15);
		newWordLabelLbl.setText("New word:");
		
		Label newWordLbl = new Label(shell, SWT.NONE);
		newWordLbl.setBounds(83, 37, 341, 15);
		newWordLbl.setText("");
		
		wordText = new Text(shell, SWT.BORDER);
		wordText.setBounds(83, 10, 76, 21);
		
		Button countBtn = new Button(shell, SWT.NONE);
		countBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
				word = wordText.getText();
				if (word.contains(" ")) {
					MessageBox box = new MessageBox(shell, SWT.ICON_WARNING);
					box.setText("Error");
					box.setMessage("This is sentence? not word!");
					box.open();
				}
				else {
				StringBuffer wordBuffer = new StringBuffer();
		        
		        for (int i = 0; i < word.length(); i+=2) {
		            
		            	wordBuffer.append(word.charAt(i));
		            
		        
		        
		        }
		        newWordLbl.setText(wordBuffer.toString());
				}    
			}catch(Exception el) {
				MessageBox box = new MessageBox(shell, SWT.ICON_WARNING);
				box.setText("Error");
				box.setMessage("Write correct word");
				box.open();
			}
				}
		});
		countBtn.setBounds(199, 5, 75, 25);
		countBtn.setText("Count");

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}

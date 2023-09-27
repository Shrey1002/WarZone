package view;

import javax.swing.JTextField;

public class CommandPrompt {
    	private JTextField d_CommandInput;

    
    public void setCommandAcknowledgement(String p_Str) {
        this.d_CommandAcknowledgeArea.append(p_Str);
    }

    public String getCommandInput() {
		return this.d_CommandInput.getText();
	}

}

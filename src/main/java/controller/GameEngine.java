package controller;
import java.awt.event.ActionListener;

/**
 * This is the main controller class of MVC model. 
 * This class has a references of View, Models and various child controllers. 
 * This class acts as an intermediary between models/controllers and view.
 */
public class GameEngine {
	

	/**
	 * This is a child class of the GameEngine which listens to the actions performed by button in view. 
	 * This class implements the ActionListener and override the actionPerformed method.
	 * This class is responsible for passing data from view to models/child controllers.
	 */
	public class CommandListener implements ActionListener{


		/**
		 * {@inheritDoc}
		 * On click of the button in view, this method gets the string which user entered. 
		 * Based on the type of the command, it will call the method of specific controllers.
		 * <ul>
		 * <li>editcontinent, editcountry, editneighbor commands are handled by the map controller's editmap method.</li>
		 * <li>savemap, loadmap, editmap, validatemap commands are also handled by the map controller's respective methods.</li>
		 * <li>gameplayer, showmap commands are handled by the GameEngine's respective methods.</li>
		 * <li>For all the methods called from the various cases here, feedback is shown on the view.</li>
		 * </ul>  
		 */
		@Override
		public void actionPerformed(ActionEvent l_E) {
			try {
				String l_CommandStringFromInput = d_CpView.getCommandInput().trim();
				switch(l_CommandStringFromInput.split(" ")[0]){
				case "editcontinent" : 
                    {
                    }
                    break; 

				case "editcountry" :
                    {
                    }
                    break;

				case "editneighbor" :
                    {
                    }
                    break;

				case "showmap": 
					{
                    }
                    break;

				case "savemap":
					{
                    }
                    break;

				case "editmap":
					{
                    }
                    break;

				case "validatemap":
					{
                    }
                    break;

				case "loadmap": 
				    {

					}
					break;

				case "gameplayer":
					{
                    }
                    break;

				case "assigncountries":
					{
					}
					break;

				
				default:
					d_CpView.setCommandAcknowledgement("Invalid Command. Please try again.\n");
					break;
				}
				d_CpView.setCommandInput("");
			}catch(Exception p_Exception) {
				System.out.println("Exception in ActionPerformed Method in ActionListener : " + p_Exception.getMessage());
			}
		}
	}

/*
 * Filename: SubdivisionMain.java
 * Programmer: Alex Lopez Torres Riega
 * Date: December 02, 2018
 * 
 * Description:
 * 		Project Real Estate Application. WidgetViewer program that will allow Sophie, Sally, and Jack
 * 		to maintain the inventory of houses in their subdivision. They can add houses, sort them by acreage,
 * 		sort them by area, and reset the display to show houses in the original order they were added to the
 * 		subdivision.
 */

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.util.ArrayList;

public class SubdivisionGui
{
	private JTextField inputNewHouseStyle;
	private JTextField inputNewAreaFamilyRoom;
	private JTextField inputNewAreaLivingRoom;
	private JTextField inputNewNumBedrooms;
	private JTextField inputNewPlotSize;
	
	private JTextArea inventory;
	private JTextArea displayMessage;
	private JTextArea projectTitle;
	
	public SubdivisionGui()
	{
		WidgetViewer wv = new WidgetViewer(1050, 400);
		EventHandler action = new EventHandler();
		
		JLabel newHouseStyle = new JLabel("House Style");
		JLabel newAreaFamilyRoom = new JLabel("Family Room Area");
		JLabel newAreaLivingRoom = new JLabel("Living Room Area");
		JLabel newNumBedrooms = new JLabel("Bedrooms");
		JLabel newPlotSize = new JLabel("Land Acres");
		
		inputNewHouseStyle = new JTextField();
		inputNewHouseStyle.setBounds(90, 30, 150, 20);
		
		inputNewAreaFamilyRoom = new JTextField();
		inputNewAreaFamilyRoom.setBounds(90, 50, 130, 20);
		
		inputNewAreaLivingRoom = new JTextField();
		inputNewAreaLivingRoom.setBounds(90, 70, 110, 20);
		
		inputNewNumBedrooms = new JTextField();
		inputNewNumBedrooms.setBounds(90, 90, 90, 20);
		
		inputNewPlotSize = new JTextField();
		inputNewPlotSize.setBounds(90, 110, 70, 20);
		
		JButton makeHouse = new JButton("Make a New House");
		makeHouse.setActionCommand("Make a New House");
		makeHouse.addActionListener(action);
		
		JButton sortByAcreage = new JButton("Sort By Acreage");
		sortByAcreage.setActionCommand("Sort By Acreage");
		sortByAcreage.addActionListener(action);
		
		JButton sortByArea = new JButton("Sort By Area");
		sortByArea.setActionCommand("Sort By Area");
		sortByArea.addActionListener(action);
		
		JButton resetToOriginalOrder = new JButton("Reset to Original Order");
		resetToOriginalOrder.setActionCommand("Reset to Original Order");
		resetToOriginalOrder.addActionListener(action);
		
		inventory = new JTextArea("");
		displayMessage = new JTextArea("");
		projectTitle = new JTextArea("Real Estate Application: Subdivision GUI Project");
		
		wv.add(newHouseStyle, 20, 30, 150, 20);
		wv.add(newAreaFamilyRoom, 20, 50, 130, 20);
		wv.add(newAreaLivingRoom, 20, 70, 110, 20);
		wv.add(newNumBedrooms, 20, 90, 90, 20);
		wv.add(newPlotSize, 20, 110, 70, 20);
		
		wv.add(inputNewHouseStyle, 140, 30, 100, 20);
		wv.add(inputNewAreaFamilyRoom, 140, 50, 100, 20);
		wv.add(inputNewAreaLivingRoom, 140, 70, 100, 20);
		wv.add(inputNewNumBedrooms, 140, 90, 100, 20);
		wv.add(inputNewPlotSize, 140, 110, 100, 20);
		
		wv.add(makeHouse, 20, 130, 220, 20);
		wv.add(sortByAcreage, 20, 150, 220, 20);
		wv.add(sortByArea, 20, 170, 220, 20);
		wv.add(resetToOriginalOrder, 20, 190, 220, 20);
		
		wv.add(inventory, 270, 35, 750, 285);
		wv.add(displayMessage, 20, 220, 220, 30);
		wv.add(projectTitle, 375, 10, 290, 30);
	}
	
	class EventHandler extends WidgetViewerActionEvent
	{
		private Subdivision subdivision = new Subdivision();
		
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			
			// if makeHouse button was pressed:
			if (command.equals("Make a New House"))
			{
				String style = inputNewHouseStyle.getText();
				double areaFamilyRoom = Double.parseDouble(inputNewAreaFamilyRoom.getText());
				double areaLivingRoom = Double.parseDouble(inputNewAreaLivingRoom.getText());
				int numBedrooms = Integer.parseInt(inputNewNumBedrooms.getText());
				double plotSize = Double.parseDouble(inputNewPlotSize.getText());
				
				
				// use the data gathered from the text fields to create a new house object...
				House newHouse = new House(style, areaFamilyRoom, areaLivingRoom, numBedrooms, plotSize);
				subdivision.add(newHouse);  // ... and add the new house to the subdivision
				
				/* create a copy of the inventory and save it to list, which we'll use to display the houses to the user
					without altering the subdivision */ 
				ArrayList<House> list = subdivision.list();
				int index = 0;
				
				// clear the text area
				inventory.setText("");
				
				// display the inventory of houses to the user.
				while (index < list.size())
				{
					inventory.append((list.get(index).toString()) + "\n");
					index++;
				}
				
				// display a message that a new house was added to the subdivision.
				displayMessage.setText("New House Added");
				
				// clearing fields to prepare for future input
				inputNewHouseStyle.setText("");
				inputNewAreaFamilyRoom.setText("");
				inputNewAreaLivingRoom.setText("");
				inputNewNumBedrooms.setText("");
				inputNewPlotSize.setText("");
			}
			
			// if sortByAcreage button was pressed:
			else if (command.equals("Sort By Acreage"))
			{	
				// clear the text area
				inventory.setText("");
				
				/* call the function sortByPlot() to sort the inventory without affecting the original inventory order 
				 *	 and store the sorted ArrayList in sortedByPlot which will later be used to display the sorted inventory
				 * 	 to the user. 
				*/
				ArrayList<House> sortedByPlot = subdivision.sortByPlot();
				int index = 0;
				
				// display the inventory that was sorted by plot to the user
				while (index < sortedByPlot.size())
				{
					inventory.append((sortedByPlot.get(index).toString()) + "\n");
					index++;
				}
				
				// display a message to the user to notify that the inventory was sorted by acreage
				displayMessage.setText("Displaying Inventory Sorted By Acreage");
			}
			
			// if sortByArea button was pressed:
			else if (command.equals("Sort By Area"))
			{
				// clear the text area
				inventory.setText("");
				
				/* call the function sortByArea() to sort the inventory without affecting the original inventory order
				 *  and store the sorted ArrayList in sortedByArea which will later be used to display the sorted inventory
				 *  to the user.
				 */
				ArrayList<House> sortedByArea = subdivision.sortByArea();
				int index = 0;
				
				// display the inventory that was sorted by area to the user
				while (index < sortedByArea.size())
				{
					inventory.append((sortedByArea.get(index).toString()) + "\n");
					index++;
				}
				
				// display a message to the user notifying them that the inventory display was sorted by area
				displayMessage.setText("Displaying Inventory Sorted By Area");
			}
			
			// if the resetToOriginalOrder button was pressed:
			else if (command.equals("Reset to Original Order"))
			{
				// clear the text area
				inventory.setText("");
				
				// display the inventory of houses in the original order that houses were added to it.
				ArrayList<House> listToDisplay = subdivision.list();
				int index = 0;
				while (index < listToDisplay.size())
				{
					inventory.append((listToDisplay.get(index).toString()) + "\n");
					index++;
				}
				
				// display a message to the user that the displayed inventory was reset to its original order.
				displayMessage.setText("Displaying Inventory in its Original Order");
			}
		}
	}
}
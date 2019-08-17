/*
 * Filename: Subdivision.java
 * Programmer: Alex Lopez Torres Riega
 * Date: October 31, 2018
 * 
 * Description:
 * 		Class Subdivision that has only one instance variable, an ArrayList of House elements.
 * 
 * 		*Updated on November 7, 2018*
 * 		Contains new methods listByPlot, sortByArea, and sortByPlot.
 */

import java.util.ArrayList;

public class Subdivision
{
	private ArrayList<House> subdivision = new ArrayList<House> ();
	
	public Subdivision()
	{
	}
	
	public House get(int position)
	{
		if (position < subdivision.size())
		{
			return subdivision.get(position);
		}
		else
		{
			return null;
		}
	}
		
	public ArrayList<House> list()
	{
		ArrayList<House> list = new ArrayList<House>();
		for (int i = 0; i < subdivision.size(); i++)
		{
			list.add(subdivision.get(i));
		}
		return list;
	}
	
	public ArrayList<House> listByArea(double floor, double ceiling)
	{
		ArrayList<House> listByArea = new ArrayList<House>();
		for (int i = 0; i < subdivision.size(); i++)
		{
			if (subdivision.get(i).getTotalArea() >= floor && subdivision.get(i).getTotalArea() <= ceiling)
			{
				listByArea.add(subdivision.get(i));
			}
		}
		return listByArea;
	}
	
	public ArrayList<House> listByBedrooms(int floor, int ceiling)
	{
		ArrayList<House> listByBedrooms = new ArrayList<House>();
		for (int i = 0; i < subdivision.size(); i++)
		{
			if (subdivision.get(i).getBedrooms() >= floor && subdivision.get(i).getBedrooms() <= ceiling)
			{
				listByBedrooms.add(subdivision.get(i));
			}			
		}
		return listByBedrooms;
	}
	
	public ArrayList<House> listByPlot(double floor, double ceiling)
	{
		ArrayList<House> listByPlot = new ArrayList<House>();
		for (int i = 0; i < subdivision.size(); i++)
		{
			if (subdivision.get(i).getPlot() >= floor && subdivision.get(i).getPlot() <= ceiling)
			{
				listByPlot.add(subdivision.get(i));
			}
		}
		return listByPlot;
	}
	
	public ArrayList<House> sortByArea()
	{
		ArrayList<House> sortedByArea = new ArrayList<House>();
		
		// copying Subvidision's inventory to sort without modifying the original inventory
		for (int i = 0; i < subdivision.size(); i++)
		{
			sortedByArea.add(subdivision.get(i));
		}
		
		// Selection Sort adapted for the use with ArrayList<House> objects
		for (int i = 0; i < sortedByArea.size() - 1; i++)
		{
			House currentMin = sortedByArea.get(i);
			int currentMinIndex = i;
			
			for (int j = i + 1; j < sortedByArea.size(); j++)
			{
				if (currentMin.compareArea(sortedByArea.get(j)) > 0)
				{
					currentMin = sortedByArea.get(j);
					currentMinIndex = j;
				}
			}
			
			// copiedInventory.get(i) with copiedInventory.get(currentMinIndex) if necessary;
			if (currentMinIndex != i)
			{
				sortedByArea.set(currentMinIndex, sortedByArea.get(i));
				sortedByArea.set(i, currentMin);
			}
		}
		return sortedByArea;
	}
	
	public ArrayList<House> sortByPlot()
	{
		ArrayList<House> sortedByPlot = new ArrayList<House>();
		
		// copying Subvidision's inventory to sort it without modifying the original inventory
		for (int i = 0; i < subdivision.size(); i++)
		{
			sortedByPlot.add(subdivision.get(i));
		}
		
		// Selection Sort adapted for the use with ArrayList<House> objects
		for (int i = 0; i < sortedByPlot.size() - 1; i++)
		{
			House currentMin = sortedByPlot.get(i);
			int currentMinIndex = i;
			
			for (int j = i + 1; j < sortedByPlot.size(); j++)
			{
				if (currentMin.getPlot() > sortedByPlot.get(j).getPlot())
				{
					currentMin = sortedByPlot.get(j);
					currentMinIndex = j;
				}
			}
			
			// copiedInventory.get(i) with copiedInventory.get(currentMinIndex) if necessary;
			if (currentMinIndex != i)
			{
				sortedByPlot.set(currentMinIndex, sortedByPlot.get(i));
				sortedByPlot.set(i, currentMin);
			}
		}
		return sortedByPlot;
	}
	
	public int size()
	{
		return subdivision.size();
	}
	
	public String toString()
	{
		String subdivisionStr = "";
		for (int i = 0; i < subdivision.size(); i++)
		{
			subdivisionStr += subdivision.get(i) + "\n";
		}
		return subdivisionStr;
	}
	
	public boolean add(House houseToAdd)
	{
		return subdivision.add(houseToAdd);
	}
}
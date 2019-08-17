/*
 *  Filename: House.java
 *  Programmer: Alex Lopez Torres Riega
 *  Date: October 24, 2018
 *  
 *  Description:
 *  	House class. A house object represents a single house with its plot of land in a subdivision.
 */

public class House
{
	int numberBedrooms = 0;
	double sizeFamilyRoom = 0;
	double sizeLivingRoom = 0;
	String houseStyle = "";
	double sizePlot = 0;
	
	public House()
	{
		this.numberBedrooms = 0;
		this.sizeFamilyRoom = 0;
		this.sizeLivingRoom = 0;
		this.houseStyle = "";
		this.sizePlot = 0;
	}
	
	public House(String style, double areaFamilyRoom, double areaLivingRoom, int numBedrooms, double plotSize)
	{
		this.houseStyle = style;
		this.sizeFamilyRoom = areaFamilyRoom;
		this.sizeLivingRoom = areaLivingRoom;
		this.numberBedrooms = numBedrooms;
		this.sizePlot = plotSize;
	}
	
	public int getBedrooms()
	{
		return numberBedrooms;
	}
	
	public double getFamilyRoomArea()
	{
		return sizeFamilyRoom;
	}
	
	public double getLivingRoomArea()
	{
		return sizeLivingRoom;
	}
	
	public double getPlot()
	{
		return sizePlot;
	}
	
	public String getStyle()
	{
		return houseStyle;
	}
	
	public double getTotalArea()
	{
		double totalArea;
		totalArea = numberBedrooms * 300 + sizeFamilyRoom + sizeLivingRoom;
		
		return totalArea;
	}
	
	public int compareArea(House otherHouse)
	{
		if (this.getTotalArea() < otherHouse.getTotalArea())
			return -1;
		else if (this.getTotalArea() > otherHouse.getTotalArea())
			return 1;
		else
			return 0;
	}
	
	public String toString()
	{
		return "House [style = " + houseStyle + ", bedrooms = " + numberBedrooms + ", family room area = " + sizeFamilyRoom + ", living room area = " + sizeLivingRoom + ", plot = " + sizePlot + ", square feet = " + this.getTotalArea() + "]";
	}
	
	public void setBedrooms(int bedrooms)
	{
		this.numberBedrooms = bedrooms;
	}
	
	public void setFamilyRoomArea(double area)
	{
		this.sizeFamilyRoom = area;
	}
	
	public void setLivingRoomArea(double area)
	{
		this.sizeLivingRoom = area;
	}
	
	public void setPlot(double area)
	{
		this.sizePlot = area;
	}
	
	public void setStyle(String style)
	{
		this.houseStyle = style;
	}
}
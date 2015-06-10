package nyxmain;


import javax.swing.table.*;
import java.util.Vector;

// Import required Jade classes
import jade.core.Location;

/**
@author 
@version 
*/

public class LocationTableModel extends AbstractTableModel 
{
	Vector names;

	// CONSTRUCTORS
	public LocationTableModel() 
	{
		super();
		names = new Vector();
	}

	// ADD
	public void add(Location loc)
	{
		names.add((Object) loc);
	}
	
	// GETELEMENTAT
	public Location getElementAt(int index)
	{
		return((Location) names.get(index));
	}

	// CLEAR
	public void clear()
	{
		names.clear();
	}

	// Methods to be implemented to have a concrete class
	public int getRowCount()
	{
		return(names.size());
	}

	public int getColumnCount()
	{
		return(3);
	}

	public Object getValueAt(int row, int column)
	{
		String id, name, protocol, address;
		String value = new String(); 
		Location loc = (Location) names.get(row);

		switch(column)
		{
		case 0:
			value = loc.getID();
			
			break;
		case 1:
				value = loc.getName();
			break;
		//case 2:
			//value = loc.getProtocol();
			//break;
			case 2:
			value = loc.getAddress();
			break;
	
		}
		return ((Object) value);	
	}
	
	public Location getValue(int row){
		
		Location loc = (Location) names.get(row);
		return loc;
		
	}
}


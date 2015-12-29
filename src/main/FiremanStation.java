/**
 * 
 */
package main;

import java.util.ArrayList;

/**
 * @author DIEGO
 *
 */
public class FiremanStation {
	
	
	// Holds the districts it serves to
    private ArrayList<Integer> districtsServedList = new ArrayList<Integer>();
        
	/**
	 * @param districtsServedList
	 */
	public FiremanStation(ArrayList<Integer> districtsServedList) {
		super();
		this.districtsServedList = districtsServedList;
	}

	public ArrayList<Integer> getDistrictsServedList() {
		return districtsServedList;
	}

	public void setDistrictsServedList(ArrayList<Integer> districtsServedList) {
		this.districtsServedList = districtsServedList;
	}
}

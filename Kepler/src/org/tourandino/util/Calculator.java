package org.tourandino.util;

import javax.swing.table.TableModel;

public class Calculator {
	
	public Calculator(){
		
	}
	
	public Float calculateColumnTotal(TableModel model, int columnIndex){
		Float total = 0F;
		if(model != null){
			for(int i=0; i < model.getRowCount(); i++){
				try{
					total += Float.parseFloat(model.getValueAt(i, columnIndex).toString());
				}
				catch(NullPointerException e){
					e.printStackTrace();				}
				catch(NumberFormatException e1){
					e1.printStackTrace();
				}
			}
			return total;
		}
		else return total;
	}

}

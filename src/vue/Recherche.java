package vue;

import javax.swing.JTable;

public class Recherche {
	
	public JTable Recherche(String saisie,JTable table){
		int nbrColonnes = table.getModel().getColumnCount()-1;
		int nbrLignes = table.getModel().getRowCount()-1;
		int i = 0;
		int y = 0;
		while(i<=nbrLignes) {
			
			while(y<=nbrColonnes) {
				if(table.getValueAt(y, i)!="%"+saisie+"%") {
					table.removeRowSelectionInterval(y, y);
				}
				y++;
			}
			y=0;
			i++;
		}
		return table;
	}
}

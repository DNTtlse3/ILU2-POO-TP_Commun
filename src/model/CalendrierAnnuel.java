package model;

public class CalendrierAnnuel {

	private Mois[] annee;
	
	public CalendrierAnnuel() {
		this.annee = new Mois[12];
		
		/**/
		
	}







	///////INNER CLASS\\\\\\\
	
	private static class Mois {
		
		private int nbJours;
		private String nom;
		private boolean[] jour;
		
		private Mois(String nom,int nbJours) {
			this.nbJours = nbJours;
			this.nom = nom;
			
			/**/
			jour = new boolean[nbJours];
			
			/*Initialisation*/
			for(int k = 0; k<nbJours;k++) {
				this.jour[k] = true;
			}
			
		}
		
		private  boolean estLibre(int jour) {
			for(int k = 0; k < nbJours; k++) {
				if((k == (jour-1)) && (this.jour[k] == true) ) {
					return true;
				}
			}
			return false;
		}
		
		private void Reserver(int jour) throws IllegalStateException{
			
			if(!estLibre(jour)) {
				throw new IllegalStateException("Ce jour n'est pas disponibles");
			}else {
				/*On réserve le jour*/
				this.jour[jour] = false;
			}
		}
		
		
		
		
		
		
		
	}

}

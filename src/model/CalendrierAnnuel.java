package model;

public class CalendrierAnnuel {

	private Mois[] annee;
	
	public CalendrierAnnuel() {
		this.annee = new Mois[12];
		
		/**/
		this.annee[0] = new Mois("janvier", 31);
		this.annee[1] = new Mois("fevrier", 28);
		this.annee[2] = new Mois("mars", 31);
		this.annee[3] = new Mois("avril", 30);
		this.annee[4] = new Mois("mair", 31);
		this.annee[5] = new Mois("juin", 30);
		this.annee[6] = new Mois("juillet", 31);
		this.annee[7] = new Mois("aout", 31);
		this.annee[8] = new Mois("septembre", 30);
		this.annee[9] = new Mois("octobre", 31);
		this.annee[10] = new Mois("novembre", 30);
		this.annee[11] = new Mois("decembre", 31);
		/**/
	}




	
	public boolean estLibre(int jour, int mois) {
		return annee[mois].estLibre(jour);	
		
	}
	
	
	public boolean reserver(int jour, int mois) {
		boolean msg;
		
		try {
			
			annee[mois].Reserver(jour);
			msg = true;
		}catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
			msg = false;
			
		}finally {
			return msg;
		}
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

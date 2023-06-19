package com.comtrade.yamb.player;

import com.comtrade.yamb.Constants;
import com.comtrade.yamb.Die;
import com.comtrade.yamb.FieldData;
import com.comtrade.yamb.Request;

public class KolonaBottomUp {
	private static int score = 0;
		
		public static int getScore() {
			return score;
		}
		
		private static int polje=-1;
		
	
	//	public void setScore(int score) {
	//		this.score = score;
	//	}
	
		public static int getPolje() {
			return polje;
		}

	
	public static PlayerResponse play(Request request) {

		Die[] kockice = request.getDice();
		int[] brojeviNaKockicama = Patterns.dieToInt(kockice);
		boolean[] cuvanjeKockica = new boolean[Constants.DICE_COUNT];

		int[] ucestalostKockica = Patterns.ucestalostBrojeva(brojeviNaKockicama);

		int brojKojiSeNajvisePonavlja = Patterns.brojKojiSeNajvisePonavlja(brojeviNaKockicama);

		for (int i = 0; i < Constants.DICE_COUNT; i++) {

			if (kockice[i].getValue() == brojKojiSeNajvisePonavlja) {
				cuvanjeKockica[i] = true;
			} else {
				cuvanjeKockica[i] = false;
			}

		}
		
		//YAMB
		if (ucestalostKockica[Patterns.vrednostMaxMetode(brojeviNaKockicama)] == 5 ) 
		{
			polje = Konstante.YAMB;
			if (request.getBoard().getColumns()[2].getFields().get(14).isPlayable()) 
			{
				score = Patterns.vrednostMaxMetode(brojeviNaKockicama) + Konstante.SCORE_YAMB_BASE;
				PlayerResponse response = new PlayerResponse(false, cuvanjeKockica,
						new FieldData(Konstante.KOLONA_BOTTOMUP, Konstante.YAMB));
				return response;
			}
			
		}
		//POKER
		else if(ucestalostKockica[Patterns.vrednostMaxMetode(brojeviNaKockicama)] == 4) 
		{
			polje = Konstante.POKER;
			if (request.getBoard().getColumns()[2].getFields().get(13).isPlayable()) 
			{
				score = Patterns.vrednostMaxMetode(brojeviNaKockicama) + Konstante.SCORE_POKER_BASE;
			PlayerResponse response = new PlayerResponse(false, cuvanjeKockica,
					new FieldData(Konstante.KOLONA_BOTTOMUP, Konstante.POKER));
			return response;
			}
		} 
		
		//FULL HOUSE
		else if (Patterns.ImamoLiFullHouse(brojeviNaKockicama) == true) 
		{
			polje = Konstante.FULL;
			if (request.getBoard().getColumns()[2].getFields().get(12).isPlayable()) 
			{
				score = Patterns.vrednostMaxMetode(brojeviNaKockicama) + Konstante.SCORE_FULL_BASE;
				PlayerResponse response = new PlayerResponse(true, cuvanjeKockica,
						new FieldData(Konstante.KOLONA_BOTTOMUP, Konstante.FULL));
				return response;
			}
		}		
		
		//TRILING
		else if (ucestalostKockica[Patterns.vrednostMaxMetode(brojeviNaKockicama)] == 3) {
			polje = Konstante.FULL;
			if (request.getBoard().getColumns()[2].getFields().get(11).isPlayable()) 
			{
				score = Patterns.vrednostMaxMetode(brojeviNaKockicama) + Konstante.SCORE_TRILING_BASE;	
			PlayerResponse response = new PlayerResponse(true, cuvanjeKockica,
					new FieldData(Konstante.KOLONA_BOTTOMUP, Konstante.TRILING));
			return response;
			}
		}		
		
		//KENTA
		else if (Patterns.ImamoLiKenta(brojeviNaKockicama) == true) 
		{
			polje = Konstante.KENTA;
			if (request.getBoard().getColumns()[2].getFields().get(10).isPlayable()) 
			{
				score = Patterns.vrednostMaxMetode(brojeviNaKockicama) + Konstante.SCORE_KENTA_BASE;
			PlayerResponse response = new PlayerResponse(true, cuvanjeKockica,
					new FieldData(Konstante.KOLONA_BOTTOMUP, Konstante.KENTA));
			return response;
			}
		} 
		
		//MIN KOLONA
		else if(Patterns.poljeMin(kockice) == true)
		{
			polje = Konstante.MIN;
			if (request.getBoard().getColumns()[2].getFields().get(8).isPlayable()) 
			{
				score = Patterns.poljeMinZbir(kockice);
			PlayerResponse response = new PlayerResponse(true, cuvanjeKockica,
					new FieldData(Konstante.KOLONA_BOTTOMUP, Konstante.MIN));
			return response;
			}
		}
		
		//MAX KOLONA
		else if(Patterns.poljeMax(kockice) == true)
		{
			polje = Konstante.MAX;
			if (request.getBoard().getColumns()[2].getFields().get(7).isPlayable()) 
			{
				score = Patterns.poljeMaxZbir(kockice);
			PlayerResponse response = new PlayerResponse(true, cuvanjeKockica,
					new FieldData(Konstante.KOLONA_BOTTOMUP, Konstante.MAX));
			return response;
			}
		}
		
		else if(ucestalostKockica[Patterns.vrednostMaxMetode(brojeviNaKockicama)]>=2)
		{
			for(int i=0; i<Constants.DICE_COUNT; i++)
			{	
				polje = i;
			if (brojKojiSeNajvisePonavlja == i+1)// proveravamo da li je index broj 1
			{
				if (request.getBoard().getColumns()[2].getFields().get(i).isPlayable() == true) {
					score = Patterns.vrednostMaxMetode(brojeviNaKockicama);
					PlayerResponse response = new PlayerResponse(false, cuvanjeKockica,
							new FieldData(Konstante.KOLONA_BOTTOMUP, i));
					return response;
				}
			}
			
			}
		}
		
		
		
		
		return null;
	}
	
}

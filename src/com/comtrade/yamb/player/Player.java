package com.comtrade.yamb.player;

import java.util.HashMap;
import java.util.Map;

import com.comtrade.yamb.Constants;
import com.comtrade.yamb.Request;
import com.comtrade.yamb.RequestType;
import com.comtrade.yamb.Response;

public class Player {
	
	public Response play(Request request) {
		
		if (request.getType() == RequestType.THROW) {
			if (request.getThrowNumber() == Konstante.PRVO_BACANJE) {
				
				Map<Integer, Integer> mapaSkorova = new HashMap<>();
				//int pom = Integer.MIN_VALUE;
				
			for(int i = 0; i<Konstante.ROW_NUMBER; i++)
				{
					mapaSkorova.put(RucnaKolona.getPolje(), RucnaKolona.getScore());
				}
				mapaSkorova.put(RucnaKolona.getPolje(), RucnaKolona.getScore());
				
				//Prodji kroz sve kolone i uradi mapaSkorova.put(Kolona, Rucna.getSkor)
				//Sve sa slike...
				System.out.println("Game num:" + request.getGameNumber() +
						"\nredniBrBacanja: " + request.getThrowNumber() + 
						", brPoteza: " + request.getMoveNumber());
				if(RucnaKolona.play(request) != null)
				{
					return RucnaKolona.play(request);
				}
				else if(KolonaNajava.prvoBacanje(request) != null)
				{
					return KolonaNajava.prvoBacanje(request);
				}
				else if(KolonaTopDown.play(request) != null)
				{
					return KolonaTopDown.play(request);
				}
				else if(KolonaBottomUp.play(request) != null)
				{
					return KolonaBottomUp.play(request);
				}
				else if(KolonaEndpoint.play(request) != null)
				{
					return KolonaEndpoint.play(request);
				}
				else if(KolonaMiddlePoint.play(request) != null)
				{
					return KolonaMiddlePoint.play(request);
				}
				else if(KolonaFree.play(request) != null)
				{
					return KolonaFree.play(request);
				}
				else
				{
					
					int[] brojeviNaKockicama = Patterns.dieToInt(request.getDice());
					int brojKojiSeNajvisePonavlja = Patterns.vrednostMaxMetode(brojeviNaKockicama)+1;
							
					
					boolean[] kockiceKojeSeCuvaju = new boolean[Constants.DICE_COUNT];
					for(int i=0; i<brojeviNaKockicama.length;i++)
					{
						if(brojeviNaKockicama[i] == brojKojiSeNajvisePonavlja)
						{
							kockiceKojeSeCuvaju[i] = true;
						}
						else
						{
							kockiceKojeSeCuvaju[i] = false;
						}
					}
					
					PlayerResponse response = new PlayerResponse(false, kockiceKojeSeCuvaju, null);
					return response;
				}
				
				
			}

			// DRUGO BACANJE
			
			else if (request.getThrowNumber() == Konstante.DRUGO_BACANJE) {
				System.out.println("redniBrBacanja: " + request.getThrowNumber() + 
						", brPoteza: " + request.getMoveNumber());
				
				if(KolonaTopDown.play(request) != null)
				{
					return KolonaTopDown.play(request);
				}
				else if(KolonaBottomUp.play(request) != null)
				{
					return KolonaBottomUp.play(request);
				}
				else if(KolonaEndpoint.play(request) != null)
				{
					return KolonaEndpoint.play(request);
				}
				else if(KolonaMiddlePoint.play(request) != null)
				{
					return KolonaMiddlePoint.play(request);
				}
				else if(KolonaFree.play(request) != null)
				{
					return KolonaFree.play(request);
				}
				else
				{
					int[] brojeviNaKockicama = Patterns.dieToInt(request.getDice());
					int brojKojiSeNajvisePonavlja = Patterns.vrednostMaxMetode(brojeviNaKockicama)+1;
							
					
					boolean[] kockiceKojeSeCuvaju = new boolean[Constants.DICE_COUNT];
					for(int i=0; i<brojeviNaKockicama.length;i++)
					{
						if(brojeviNaKockicama[i] == brojKojiSeNajvisePonavlja)
						{
							kockiceKojeSeCuvaju[i] = true;
						}
						else
						{
							kockiceKojeSeCuvaju[i] = false;
						}
					}
					
					PlayerResponse response = new PlayerResponse(false, kockiceKojeSeCuvaju, null);
					return response;
				}
			}
			
			// TRECE BACANJE
			
			else if (request.getThrowNumber() == Konstante.TRECE_BACANJE) {
				System.out.println("redniBrBacanja: " + request.getThrowNumber() + 
						", brPoteza: " + request.getMoveNumber());
				
				if(KolonaTopDown.play(request) != null)
				{
					return KolonaTopDown.play(request);
				}
				else if(KolonaBottomUp.play(request) != null)
				{
					return KolonaBottomUp.play(request);
				}
				else if(KolonaEndpoint.play(request) != null)
				{
					return KolonaEndpoint.play(request);
				}
				else if(KolonaMiddlePoint.play(request) != null)
				{
					return KolonaMiddlePoint.play(request);
				}
				else if(KolonaFree.play(request) != null)
				{
					return KolonaFree.play(request);
				}
				else
				{
					int[] brojeviNaKockicama = Patterns.dieToInt(request.getDice());
					int brojKojiSeNajvisePonavlja = Patterns.vrednostMaxMetode(brojeviNaKockicama)+1;
							
					
					boolean[] kockiceKojeSeCuvaju = new boolean[Constants.DICE_COUNT];
					for(int i=0; i<brojeviNaKockicama.length;i++)
					{
						if(brojeviNaKockicama[i] == brojKojiSeNajvisePonavlja)
						{
							kockiceKojeSeCuvaju[i] = true;
						}
						else
						{
							kockiceKojeSeCuvaju[i] = false;
						}
					}
					
					PlayerResponse response = new PlayerResponse(false, kockiceKojeSeCuvaju, null);
					return response;
				}
			}
			
			

		}

		return null;

	}

}
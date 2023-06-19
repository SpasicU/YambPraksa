package com.comtrade.yamb.player;

import com.comtrade.yamb.Constants;
import com.comtrade.yamb.Die;

public class Patterns {
	
	public static int brojPonavljanjaNajucestalijegBroja(int[] kockice)
	{
		int[] brojevi = ucestalostBrojeva(kockice);
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<brojevi.length;i++)
		{
			if(max<brojevi[i])
			{
				max=brojevi[i];
			}
		}
		
		return max;
	}
	
	public static int vrednostMaxMetode(int[] kockice)
    {
        int[] brojevi = ucestalostBrojeva(kockice);

        int max = brojPonavljanjaNajucestalijegBroja(kockice);
        int vrednost = 0;

        for(int i=0; i<brojevi.length; i++)
        {
            if(brojevi[i]==max)
            {
                vrednost=i;
            }
        }
        return vrednost;
        //Ovde vraca koji je to broj koji se ponavlja najvise puta
        //Ali vraca jedan manje (5 umesto 6)
        //Ako stavim vrednost+1 izbacuje gresku Index 6 out of bounds for length 6
        //Ne kapiram kako onda radi u rucnoj koloni hmmmmm
    }
	
	public static int brojKojiSeNajvisePonavlja(int[] ucestalostKockica)
	{
		int brojKojiSeNajvisePojavio = vrednostMaxMetode(ucestalostKockica);

        return brojKojiSeNajvisePojavio+1;
		
	}	
	
	public static int[] dieToInt(Die[] kockice)
	{
		int[] brojeviNaKockicama = new int[Constants.DICE_COUNT];
		
		for(int i=0; i<Constants.DICE_COUNT; i++)
		{
			brojeviNaKockicama[i]=kockice[i].getValue();
		}
		return brojeviNaKockicama;
	}
	
	
	
	public static int[] ucestalostBrojeva(int[] kockice) 
	{
		
		int[] brojac=new int[Constants.DICE_COUNT];
		 
		for (int i = 0; i<Constants.DICE_COUNT; i++) {
			if (kockice[i] == 1)  brojac[0]++;
			if (kockice[i] == 2)  brojac[1]++;
			if (kockice[i] == 3)  brojac[2]++;
			if (kockice[i] == 4)  brojac[3]++;
			if (kockice[i] == 5)  brojac[4]++;
			if (kockice[i] == 6)  brojac[5]++;
		}
		
		return brojac;
	}

	public static boolean ImamoLiKenta(int[] kockice) 
	{
		int[] brojac = ucestalostBrojeva(kockice);
		
		if(brojac[1]>0 && brojac[2]>0 && brojac[3]>0 && brojac[4]>0 && (brojac[5]>0 || brojac[0]>0))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	public static boolean ImamoLiFullHouse(int[] kockice) 
	{
		int[] brojac = ucestalostBrojeva(kockice);
		
		if((brojac[5]== 3 && brojac[4]==2) || (brojac[5]== 2 && brojac[4]==3) || 
				(brojac[4]==3 && brojac[3]==2) || (brojac[4]==2 && brojac[3]==3) ||
				(brojac[5]== 3 && brojac[3]==2) || (brojac[5]==2 && brojac[3]==3) || 
				(brojac[5]== 3 && brojac[2]==2) || (brojac[5]== 3 && brojac[2]==2) ||
				(brojac[4]== 3 && brojac[2]==2) || (brojac[4]== 3 && brojac[2]==2)) // 6-5x, 5-4x, 6-4x, 6-3x
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public static boolean najavaImamoLiFullHouse(int[] kockice) 
	{
		int[] brojac = ucestalostBrojeva(kockice);
		
		if((brojac[5]> 2 && brojac[4]>1) || (brojac[5]>1 && brojac[4]>2))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public static boolean poljeMax(Die[] kockice) 
	{
		int zbir = 0;
		
		for (int i = 0; i<Constants.DICE_COUNT; i++) {
			if (kockice[i].getValue() ==1)  zbir=zbir+1;
			if (kockice[i].getValue() ==2)  zbir=zbir+2;
			if (kockice[i].getValue() ==3)  zbir=zbir+3;
			if (kockice[i].getValue() ==4)  zbir=zbir+4;
			if (kockice[i].getValue() ==5)  zbir=zbir+5;
			if (kockice[i].getValue() ==6)  zbir=zbir+6;
		}

		if(zbir>=26)
		{
			return true;
		}
		else
		{
			return false;
		}

	}
	
	public static int poljeMaxZbir(Die[] kockice) 
	{
		int zbir = 0;
		
		for (int i = 0; i<Constants.DICE_COUNT; i++) {
			if (kockice[i].getValue() ==1)  zbir=zbir+1;
			if (kockice[i].getValue() ==2)  zbir=zbir+2;
			if (kockice[i].getValue() ==3)  zbir=zbir+3;
			if (kockice[i].getValue() ==4)  zbir=zbir+4;
			if (kockice[i].getValue() ==5)  zbir=zbir+5;
			if (kockice[i].getValue() ==6)  zbir=zbir+6;
		}

		if(zbir>=26)
		{
			return zbir;
		}
		else
		{
			return -1;
		}

	}
	
	public static int poljeMinZbir(Die[] kockice) 
	{
		int zbir = 0;
		
		for (int i = 0; i<Constants.DICE_COUNT; i++) {
			if (kockice[i].getValue() ==1)  zbir=zbir+1;
			if (kockice[i].getValue() ==2)  zbir=zbir+2;
			if (kockice[i].getValue() ==3)  zbir=zbir+3;
			if (kockice[i].getValue() ==4)  zbir=zbir+4;
			if (kockice[i].getValue() ==5)  zbir=zbir+5;
			if (kockice[i].getValue() ==6)  zbir=zbir+6;
		}

		if(zbir<=10)
		{
			return zbir;
		}
		else
		{
			return -1;
		}

	}
	
	public static boolean poljeMin(Die[] kockice) 
	{
		int zbir = 0;
		
		for (int i = 0; i<Constants.DICE_COUNT; i++) {
			if (kockice[i].getValue() ==1)  zbir=zbir+1;
			if (kockice[i].getValue() ==2)  zbir=zbir+2;
			if (kockice[i].getValue() ==3)  zbir=zbir+3;
			if (kockice[i].getValue() ==4)  zbir=zbir+4;
			if (kockice[i].getValue() ==5)  zbir=zbir+5;
			if (kockice[i].getValue() ==6)  zbir=zbir+6;
		}

		if(zbir<=10)
		{
			return true;
		}
		else
		{
			return false;
		}

	}
	
}






package com.comtrade.yamb;

/**
 * Odgovor Igrača
 */
public interface Response {
   /**
    * Indikator koji govori da li treba odmah izvršiti upis vrednosti u tabelu.<br>
    * Ponekada (na primer, u slučaju kente iz prvog/drugog bacanja) Igrač želi da se upis izvrši pre trećeg bacanja u potezu.
    * @return <code>true</code>, ako upis treba izvršiti odmah<br><code>false</code>, u suprotnom.
    */
   boolean isMoveOver();
   
   /**
    * Niz informacija o tome da li vrednost na kockicama treba da bude fiksirana.<br>
    * @return Niz od Constants.DICE_COUNT logičkih vrednosti. Svaka od vrednosti govori da li će vrednost odgovarajuće kockice biti fiksirana.
    * Ako je, na primer, vraćen niz u kome su vrednosti sa indeksima 2 i 4 <code>true</code>, a ostale su <code>false</code>, to će značiti da treba 
    * fiksirati vrednosti na kockama sa indeksima 2 i 4, a ostale kocke treba baciti ponovo.
    */
   boolean[] getDice();
   
   /**
    * Informacija o polju u koje treba izvršiti upis.<br>
    * Ovaj podatak važi za kolone Najava i Ručno samo posle prvog bacanja, a za ostale kolone ga je moguće postaviti posle bilo kog bacanja.
    * @return Polje (definisano svojim koordinatama) u koje treba izvršiti upis<br>. 
    */
   FieldData getFieldData();
}

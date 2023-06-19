package com.comtrade.yamb;

/**
 * Podaci o situaciji u meču/partiji.<br>
 * Na neke od ovih poruka će Igrač da reaguje nekim konkretnim odgovorom (Response-om), a neke će mu samo davati
 * informaciju o tekućem statusu meča/partije.
 */
public interface Request {
   /**
    * Tip poslate poruke
    */
   RequestType getType();
   
   /**
    * @return Tabela partije
    */
   Board getBoard();
   
   /**
    * @return Niz kockica
    */
   Die[] getDice();
   
   /**
    * @return Redni broj tekuće partije
    */
   int getGameNumber();
   
   /**
    * @return Redni broj poteza u tekućoj partiji
    */
   int getMoveNumber();
   
   /**
    * @return Redni broj bacanja u tekućem potezu
    */
   int getThrowNumber();
   
   /**
    * @return Da li je u potezu najavljen upis u neko polje
    */
   FieldData getNajavljenoPolje();
}

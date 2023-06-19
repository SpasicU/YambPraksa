package com.comtrade.yamb;

/**
 * Kolekcija mogućih tipova informacije koje Organizator igre šalje Igraču.<br>
 * Organizator igre će očekivati odgovor (Response) od Igrača ISKLJUČIVO na poruku tipa THROW, a (eventualne) odgovore na sve druge poruke će ignorisati
 */
public enum RequestType {
   /**
    * Poruka kojom se Igrač obaveštava da meč počinje
    */
   MATCH_START,
   
   /**
    * Poruka kojom se Igrač obaveštava da je meč završen
    */
   MATCH_END,
   
   /**
    * Poruka kojom se Igrač obaveštava da partija počinje
    */
   GAME_START,
   
   /**
    * Poruka kojom se Igrač obaveštava da je partija završena
    */
   GAME_END,
   
   /**
    * Poruka kojom se Igrač obaveštava da je počinje naredni potez
    */
   MOVE_START,
   
   /**
    * Poruka kojom se Igrač obaveštava da tekući potez završen
    */
   MOVE_END,
   
   /**
    * Poruka kojom se Igrač obaveštava da su kockice bačene i da se očekuje odgovor (Response) koji će Organizatoru igre dati informaciju kako Igrač želi da igra.<br>
    * Ovo je jedini tip poruke na koje Organizator igre očekuje odgovor od Igrača.
    */
   THROW;
}

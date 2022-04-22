package net.imparndo.Model;

import java.util.ArrayList;
import java.util.Iterator;

public class Supermercato {
    private ArrayList<Cassa> casse;
    private int nCasse;

    public Supermercato( ){
         casse = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            casse.add(new Cassa());
    }
     public Cassa getCassa(int n){
        return casse.get(n);
     }
     public Cassa getCassaVuota(){
         Iterator<Cassa> iterator = casse.iterator();
         int index = 0;
         while(!iterator.next().isAperta()){
             index++;
         }

        for (Cassa cassa :casse) {
            if(cassa.isAperta())
            if (cassa.quantiCarrelli() < casse.get(index).quantiCarrelli() )
                index = casse.indexOf(cassa);
        }
         return casse.get(index);
    }
     public int indexOf(Cassa a ){
        return casse.indexOf(a);
     }
}


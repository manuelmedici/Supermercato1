package net.imparndo.Model;

import java.util.LinkedList;

public class Cassa {
    static final int Q = 1;
    private LinkedList<Carrello> carrelli;
    private boolean aperta = true;


    public Cassa(){
        carrelli = new LinkedList<>();
    }
    public boolean isAperta() {
        return aperta;
    }
    public void chiudi(){aperta = false;}
    public void apri(){aperta = true;}
    public int quantiCarrelli(){
        return carrelli.size();
    }
    public void aggiungiCarrello(){
        carrelli.add(new Carrello());
    }
    public void liberaCarrello(){
        carrelli.getFirst().passaProdotti(Q);
        if(carrelli.getFirst().empty())
            carrelli.pop();
    }

    public Carrello getCarrello(){
        return carrelli.getFirst();
    }

}

package net.imparndo.Model;
public class Carrello {
    private int prodotti;
    private int generaProdotti()
    {
        this.prodotti = (int)(Math.random()*100)%15;
        return prodotti;
    }

    public int getProdotti(){
        return this.prodotti;
    }



    public void passaProdotti(int n) {
        if (n > this.prodotti)
            prodotti = 0;
        else
            prodotti -= n;
    }
    public boolean empty(){
        return !(prodotti > 0);
    }
    public Carrello(){
        this.prodotti = generaProdotti();
    }
}
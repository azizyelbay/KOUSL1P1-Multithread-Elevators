
package project;

import java.util.Random;


public class Musteri {
    public int musteri_sayisi;
    public int gidilecek_kat;
    Random r = new Random();
    public  Musteri(){
        musteri_sayisi=r.nextInt(9) + 1;
        gidilecek_kat = r.nextInt(4) + 1;
       
    }

    public int getMusteri_sayisi() {
        return musteri_sayisi;
    }

    public void setMusteri_sayisi(int musteri_sayisi) {
        this.musteri_sayisi = musteri_sayisi;
    }

    public int getGidilecek_kat() {
        return gidilecek_kat;
    }

    public void setGidilecek_kat(int gidilecek_kat) {
        this.gidilecek_kat = gidilecek_kat;
    }
    
    
    
    
}

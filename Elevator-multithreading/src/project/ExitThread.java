package project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExitThread implements Runnable {

    BlockingQueue<Integer> giris_kuyrugu;
    BlockingQueue<Integer> gidilecek_kat;
    BlockingQueue<Integer> birinci_kat_kuyrugu;
    BlockingQueue<Integer> ikinci_kat_kuyrugu;
    BlockingQueue<Integer> ucuncu_kat_kuyrugu;
    BlockingQueue<Integer> dorduncu_kat_kuyrugu;
    NewJFrame g;
Katlar katlar;
    public ExitThread(Katlar gelen_katlar,NewJFrame gelen_g, BlockingQueue gelen_birinci_kat_kuyrugu,
            BlockingQueue gelen_ikinci_kat_kuyrugu,
            BlockingQueue gelen_ucuncu_kat_kuyrugu,
            BlockingQueue gelen_dorduncu_kat_kuyrugu,
            BlockingQueue gelen_sıfırıncı_kat_kuyrugu,
            BlockingQueue gelen_gidilecek_kat_kuyrugu) {
        giris_kuyrugu = gelen_sıfırıncı_kat_kuyrugu;
        birinci_kat_kuyrugu = gelen_birinci_kat_kuyrugu;
        ikinci_kat_kuyrugu = gelen_ikinci_kat_kuyrugu;
        ucuncu_kat_kuyrugu = gelen_ucuncu_kat_kuyrugu;
        dorduncu_kat_kuyrugu = gelen_dorduncu_kat_kuyrugu;
        gidilecek_kat = gelen_gidilecek_kat_kuyrugu;
        g = gelen_g;
        katlar=gelen_katlar;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ExitThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            Musteri musteri = new Musteri();
            Random r = new Random();
            int rastgele_musteri = r.nextInt(5) + 1;
            /*System.out.println("ÇIKIŞÇIKIŞÇIKIŞ");
            System.out.println("musteri sayisi=" + musteri.musteri_sayisi);
            System.out.println(musteri.gidilecek_kat+".katta olustu");
            System.out.println("musterinin gidecegi kat=0" );//burada gidilecek kat değil oluşturulacak kat olarak aldık*/
 /*if (musteri.gidilecek_kat == 1) {
                birinci_kat_kuyrugu.add(rastgele_musteri);
            }
            if (musteri.gidilecek_kat == 2) {
                ikinci_kat_kuyrugu.add(rastgele_musteri);
            }
            if (musteri.gidilecek_kat == 3) {
                ucuncu_kat_kuyrugu.add(rastgele_musteri);
            }
            if (musteri.gidilecek_kat == 4) {
                dorduncu_kat_kuyrugu.add(rastgele_musteri);
            }*/
            if (musteri.gidilecek_kat == 1&&rastgele_musteri<=katlar.birinci_kattaki_musteri_sayisi) {
                katlar.birinci_kattaki_musteri_sayisi=katlar.birinci_kattaki_musteri_sayisi-rastgele_musteri;
                birinci_kat_kuyrugu.add(rastgele_musteri);
            }
            if (musteri.gidilecek_kat == 2&&rastgele_musteri<=katlar.ikinci_kattaki_musteri_sayisi) {
                katlar.ikinci_kattaki_musteri_sayisi=katlar.ikinci_kattaki_musteri_sayisi-rastgele_musteri;
                ikinci_kat_kuyrugu.add(rastgele_musteri);
            }
            if (musteri.gidilecek_kat == 3&&rastgele_musteri<=katlar.ucuncu_kattaki_musteri_sayisi) {
                katlar.ucuncu_kattaki_musteri_sayisi=katlar.ucuncu_kattaki_musteri_sayisi-rastgele_musteri;
                ucuncu_kat_kuyrugu.add(rastgele_musteri);
            }
            if (musteri.gidilecek_kat == 4&&rastgele_musteri<=katlar.dorduncu_kattaki_musteri_sayisi) {
                katlar.dorduncu_kattaki_musteri_sayisi=katlar.dorduncu_kattaki_musteri_sayisi-rastgele_musteri;
                dorduncu_kat_kuyrugu.add(rastgele_musteri);
            }
            //System.out.print("sıfırıncı kat kuyrugu:");

        }

    }

}

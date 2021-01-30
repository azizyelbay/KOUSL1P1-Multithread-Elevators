/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
public class LoginThread implements Runnable {

    BlockingQueue<Integer> giris_kuyrugu;
    BlockingQueue<Integer> gidilecek_kat;
    Katlar katlar;

    public LoginThread(BlockingQueue gelen_giris_kuyrugu, BlockingQueue gelen_gidilecek_kat,
             Katlar gelen_katlar) {
        katlar = gelen_katlar;
        giris_kuyrugu = gelen_giris_kuyrugu;
        gidilecek_kat = gelen_gidilecek_kat;
    }

    @Override
    public void run() {

        while (true) {

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(LoginThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            Musteri musteri = new Musteri();
           /* System.out.println("GİRİŞİGİRİŞİGİRİŞGİRİŞ");
            System.out.println("musteri sayisi=" + musteri.musteri_sayisi);
            System.out.println("musterinin gidecegi kat=" + musteri.gidilecek_kat);*/
            giris_kuyrugu.add(musteri.musteri_sayisi);
            gidilecek_kat.add(musteri.gidilecek_kat);

            //System.out.println("uzun" + giris_kuyrugu.size());
           /* Iterator iteratorValues = giris_kuyrugu.iterator();
            Iterator gidilecek_kat_no = gidilecek_kat.iterator();

            while (iteratorValues.hasNext()) {
                System.out.print("[" + iteratorValues.next() + ",");
                System.out.println(gidilecek_kat_no.next() + "]");
            }*/

        }
    }
}

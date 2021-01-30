/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
public class Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Katlar katlar = new Katlar();
        BlockingQueue<Integer> giris_kuyrugu = new ArrayBlockingQueue<>(5000);
        BlockingQueue<Integer> gidilecek_kat = new ArrayBlockingQueue<>(5000);
        BlockingQueue<Integer> birinci_kat_kuyrugu = new ArrayBlockingQueue<>(5000);
        BlockingQueue<Integer> ikinci_kat_kuyrugu = new ArrayBlockingQueue<>(5000);
        BlockingQueue<Integer> ucuncu_kat_kuyrugu = new ArrayBlockingQueue<>(5000);
        BlockingQueue<Integer> dorduncu_kat_kuyrugu = new ArrayBlockingQueue<>(5000);
        
        BlockingQueue<Integer> asansor1_kuyruk_musteri_sayisi = new ArrayBlockingQueue<>(5000);
        BlockingQueue<Integer> asansor1_kuyruk_gidilecek_kat = new ArrayBlockingQueue<>(5000);
        BlockingQueue<Integer> asansor2_kuyruk_musteri_sayisi = new ArrayBlockingQueue<>(5000);
        BlockingQueue<Integer> asansor2_kuyruk_gidilecek_kat = new ArrayBlockingQueue<>(5000);
         BlockingQueue<Integer> asansor3_kuyruk_musteri_sayisi = new ArrayBlockingQueue<>(5000);
        BlockingQueue<Integer> asansor3_kuyruk_gidilecek_kat = new ArrayBlockingQueue<>(5000);
        BlockingQueue<Integer> asansor4_kuyruk_musteri_sayisi = new ArrayBlockingQueue<>(5000);
        BlockingQueue<Integer> asansor4_kuyruk_gidilecek_kat = new ArrayBlockingQueue<>(5000);
        BlockingQueue<Integer> asansor5_kuyruk_musteri_sayisi = new ArrayBlockingQueue<>(5000);
        BlockingQueue<Integer> asansor5_kuyruk_gidilecek_kat = new ArrayBlockingQueue<>(5000);
        NewJFrame g = new NewJFrame();
        Thread loginthread = new Thread(new LoginThread(giris_kuyrugu, gidilecek_kat, katlar));
        Thread exitthread = new Thread(new ExitThread(katlar,g, birinci_kat_kuyrugu, ikinci_kat_kuyrugu, ucuncu_kat_kuyrugu, dorduncu_kat_kuyrugu, giris_kuyrugu, gidilecek_kat));
        Thread asansor1 = new Thread(new Asansor(g, 1, giris_kuyrugu, gidilecek_kat, asansor1_kuyruk_musteri_sayisi, asansor1_kuyruk_gidilecek_kat,
                katlar,
                birinci_kat_kuyrugu,
                ikinci_kat_kuyrugu,
                ucuncu_kat_kuyrugu,
                dorduncu_kat_kuyrugu));
        
        Thread kontrolthread = new Thread(new KontrolThread(g, birinci_kat_kuyrugu, ikinci_kat_kuyrugu, ucuncu_kat_kuyrugu, dorduncu_kat_kuyrugu, giris_kuyrugu));
        Thread asansor2 = new Thread(new Asansor2(g, 2, giris_kuyrugu, gidilecek_kat, asansor2_kuyruk_musteri_sayisi, asansor2_kuyruk_gidilecek_kat,
                katlar,
                birinci_kat_kuyrugu,
                ikinci_kat_kuyrugu,
                ucuncu_kat_kuyrugu,
                dorduncu_kat_kuyrugu));
        Thread asansor3 = new Thread(new Asansor3(g, 3, giris_kuyrugu, gidilecek_kat, asansor3_kuyruk_musteri_sayisi, asansor3_kuyruk_gidilecek_kat,
                katlar,
                birinci_kat_kuyrugu,
                ikinci_kat_kuyrugu,
                ucuncu_kat_kuyrugu,
                dorduncu_kat_kuyrugu));
        Thread asansor4 = new Thread(new Asansor4(g, 4, giris_kuyrugu, gidilecek_kat, asansor4_kuyruk_musteri_sayisi, asansor4_kuyruk_gidilecek_kat,
                katlar,
                birinci_kat_kuyrugu,
                ikinci_kat_kuyrugu,
                ucuncu_kat_kuyrugu,
                dorduncu_kat_kuyrugu));
        Thread asansor5 = new Thread(new Asansor5(g, 5, giris_kuyrugu, gidilecek_kat, asansor5_kuyruk_musteri_sayisi, asansor5_kuyruk_gidilecek_kat,
                katlar,
                birinci_kat_kuyrugu,
                ikinci_kat_kuyrugu,
                ucuncu_kat_kuyrugu,
                dorduncu_kat_kuyrugu));
        kontrolthread.start();
        loginthread.start();
        exitthread.start();
        asansor1.start();
        asansor2.start();
        asansor3.start();
        asansor4.start();
        asansor5.start();
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Iterator iteratorValues = giris_kuyrugu.iterator();
            Iterator gidilecek_kat_no = gidilecek_kat.iterator();
            
            String k0 = "";
            int sıfırıncı_toplam = 0;
            while (iteratorValues.hasNext()) {
                /*System.out.print("[" + iteratorValues.next() + ",");
                System.out.print(gidilecek_kat_no.next() + "]  , ");*/
                int sayi1 = (int) iteratorValues.next();
                int sayi2 = (int) gidilecek_kat_no.next();
                sıfırıncı_toplam += sayi1;
                k0 = k0 + "[" + sayi1 + "," + sayi2 + "]  , ";
                g.kuyruktakitoplam0(sıfırıncı_toplam);
                g.gonder0(k0);
            }

            //System.out.print("\nbirinci kat kuyruğu:");
            Iterator birinci_kuyrugu = birinci_kat_kuyrugu.iterator();
            String k1 = "";
            int birinci_toplam = 0;
            while (birinci_kuyrugu.hasNext()) {
                /*System.out.print("[" + birinci_kuyrugu.next() + ",");
                System.out.print("0" + "]  , ");*/
                int sayi1 = (int) birinci_kuyrugu.next();
                birinci_toplam += sayi1;
                k1 = k1 + "[" + sayi1 + "," + "0" + "]  , ";
                g.kuyruktakitoplam1(birinci_toplam);
                g.gonder1(k1);
            }

            //System.out.print("\nikinci kat kuyruğu:");
            Iterator ikinci_kuyrugu = ikinci_kat_kuyrugu.iterator();
            String k2 = "";
            int ikinci_toplam = 0;
            while (ikinci_kuyrugu.hasNext()) {
                /*System.out.print("[" + ikinci_kuyrugu.next() + ",");
                System.out.print("0" + "]  , ");*/
                int sayi1 = (int) ikinci_kuyrugu.next();
                ikinci_toplam += sayi1;
                k2 = k2 + "[" + sayi1 + "," + "0" + "]  , ";
               g.kuyruktakitoplam2(ikinci_toplam);
                g.gonder2(k2);
            }
 
            //System.out.print("\nucuncu kat kuyruğu:");
            Iterator ucuncu_kuyrugu = ucuncu_kat_kuyrugu.iterator();
            String k3 = "";
            int ucuncu_toplam = 0;
            while (ucuncu_kuyrugu.hasNext()) {
                /* System.out.print("[" + ucuncu_kuyrugu.next() + ",");
                System.out.print("0" + "]  , ");*/
                int sayi1 = (int) ucuncu_kuyrugu.next();
                ucuncu_toplam += sayi1;
                k3 = k3 + "[" + sayi1 + "," + "0" + "]  , ";
                g.kuyruktakitoplam3(ucuncu_toplam);
                g.gonder3(k3);
            }

            //System.out.print("\ndorduncu kat kuyruğu:");
            Iterator dorduncu_kuyrugu = dorduncu_kat_kuyrugu.iterator();
            String k4 = "";
            int dorduncu_toplam = 0;
            while (dorduncu_kuyrugu.hasNext()) {
                /*System.out.print("[" + dorduncu_kuyrugu.next() + ",");
                System.out.print("0" + "]  , ");*/
                int sayi1 = (int) dorduncu_kuyrugu.next();
                dorduncu_toplam += sayi1;
                k4 = k4 + "[" + sayi1 + "," + "0" + "]  , ";
                 g.kuyruktakitoplam4(dorduncu_toplam);
                g.gonder4(k4);
            }
           g.hepsi1(katlar.birinci_kattaki_musteri_sayisi);
           g.hepsi2(katlar.ikinci_kattaki_musteri_sayisi);
           g.hepsi3(katlar.ucuncu_kattaki_musteri_sayisi);
           g.hepsi4(katlar.dorduncu_kattaki_musteri_sayisi);
        }

        //exitthread.start();
    }
    
}

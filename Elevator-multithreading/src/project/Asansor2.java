package project;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Asansor2 implements Runnable {

    int asansor_no;
    int floor;
    int destination;
    int direction;//1 yukarı 0 asağı
    int capacity;
    int count_inside;
    boolean hareket_halinde_mi;
    BlockingQueue<Integer> asansor_kuyruk_musteri_sayisi;
    BlockingQueue<Integer> asansor_kuyruk_gidilecek_kat;

    BlockingQueue<Integer> referans_kuyruk_musteri_sayisi;
    BlockingQueue<Integer> referans_kuyruk_gidilecek_kat;

    BlockingQueue<Integer> birinci_kat_kuyrugu;
    BlockingQueue<Integer> ikinci_kat_kuyrugu;
    BlockingQueue<Integer> ucuncu_kat_kuyrugu;
    BlockingQueue<Integer> dorduncu_kat_kuyrugu;
    int toplam;
    Katlar katlar;
    NewJFrame g;

    public Asansor2(NewJFrame gelen_g, int gelen_no, BlockingQueue gelen_musteri_sayisi, BlockingQueue gelen_gidilecek_kat,
            BlockingQueue gelen_asansor_kuyruk_musteri_sayisi, BlockingQueue gelen_asansor_kuyruk_gidilecek_kat,
            Katlar gelen_katlar,
            BlockingQueue gelen_birinci_kat_kuyrugu,
            BlockingQueue gelen_ikinci_kat_kuyrugu,
            BlockingQueue gelen_ucuncu_kat_kuyrugu,
            BlockingQueue gelen_dorduncu_kat_kuyrugu) {
        referans_kuyruk_musteri_sayisi = gelen_musteri_sayisi;
        referans_kuyruk_gidilecek_kat = gelen_gidilecek_kat;
        asansor_kuyruk_musteri_sayisi = gelen_asansor_kuyruk_musteri_sayisi;
        asansor_kuyruk_gidilecek_kat = gelen_asansor_kuyruk_gidilecek_kat;
        katlar = gelen_katlar;
        floor = 0;
        toplam = 0;
        capacity = 10;
        asansor_no = gelen_no;
        destination = 0;
        birinci_kat_kuyrugu = gelen_birinci_kat_kuyrugu;
        ikinci_kat_kuyrugu = gelen_ikinci_kat_kuyrugu;
        ucuncu_kat_kuyrugu = gelen_ucuncu_kat_kuyrugu;
        dorduncu_kat_kuyrugu = gelen_dorduncu_kat_kuyrugu;
        g = gelen_g;

    }

    @Override
    public void run() {
        /*try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Asansor.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        while (true) {
            
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Asansor2.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (common.asansor2_calısıyormu == true) {
                
                //System.out.println(asansor_kuyruk_musteri_sayisi.peek());
                if (floor == 0 && toplam < 10 && !referans_kuyruk_musteri_sayisi.isEmpty() && (referans_kuyruk_musteri_sayisi.peek() + toplam) < 10) {
                    System.out.println("0da yükleme yapıyor");
                    Iterator musteri_sayisi = referans_kuyruk_musteri_sayisi.iterator();
                    Iterator gidilecek_kat_no = referans_kuyruk_gidilecek_kat.iterator();
                    while (musteri_sayisi.hasNext()) {
                        int asansor_musteri = (int) musteri_sayisi.next();
                        int asansor_git_kat = (int) gidilecek_kat_no.next();

                        toplam = toplam + asansor_musteri;
                        if (toplam >= 10) {
                            toplam = toplam - asansor_musteri;
                            break;
                        } else {
                            asansor_kuyruk_musteri_sayisi.add(asansor_musteri);
                            asansor_kuyruk_gidilecek_kat.add(asansor_git_kat);

                            try {
                                referans_kuyruk_musteri_sayisi.take();
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Asansor2.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try {
                                referans_kuyruk_gidilecek_kat.take();
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Asansor2.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    }
                }
                if (floor == 1 && toplam < 10 && !birinci_kat_kuyrugu.isEmpty() && (birinci_kat_kuyrugu.peek() + toplam) < 10) {
                    Iterator musteri_sayisi = birinci_kat_kuyrugu.iterator();
                    System.out.println("1da yükleme yapıyor");
                    while (musteri_sayisi.hasNext()) {
                        int asansor_musteri = (int) musteri_sayisi.next();
                        int asansor_git_kat = 0;

                        toplam = toplam + asansor_musteri;
                        if (toplam >= 10) {
                            toplam = toplam - asansor_musteri;
                            break;
                        } else {
                            asansor_kuyruk_musteri_sayisi.add(asansor_musteri);
                            asansor_kuyruk_gidilecek_kat.add(asansor_git_kat);

                            try {
                                birinci_kat_kuyrugu.take();
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Asansor2.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }

                    }
                }
                if (floor == 2 && toplam < 10 && !ikinci_kat_kuyrugu.isEmpty() && (ikinci_kat_kuyrugu.peek() + toplam) < 10) {
                    Iterator musteri_sayisi = ikinci_kat_kuyrugu.iterator();
                    System.out.println("2da yükleme yapıyor");
                    while (musteri_sayisi.hasNext()) {
                        int asansor_musteri = (int) musteri_sayisi.next();
                        int asansor_git_kat = 0;

                        toplam = toplam + asansor_musteri;
                        if (toplam >= 10) {
                            toplam = toplam - asansor_musteri;
                            break;
                        } else {
                            asansor_kuyruk_musteri_sayisi.add(asansor_musteri);
                            asansor_kuyruk_gidilecek_kat.add(asansor_git_kat);

                            try {
                                ikinci_kat_kuyrugu.take();
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Asansor2.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }

                    }
                }
                if (floor == 3 && toplam < 10 && !ucuncu_kat_kuyrugu.isEmpty() && (ucuncu_kat_kuyrugu.peek() + toplam) < 10) {
                    Iterator musteri_sayisi = ucuncu_kat_kuyrugu.iterator();
                    System.out.println("3da yükleme yapıyor");
                    while (musteri_sayisi.hasNext()) {
                        int asansor_musteri = (int) musteri_sayisi.next();
                        int asansor_git_kat = 0;

                        toplam = toplam + asansor_musteri;
                        if (toplam >= 10) {
                            toplam = toplam - asansor_musteri;
                            break;
                        } else {
                            asansor_kuyruk_musteri_sayisi.add(asansor_musteri);
                            asansor_kuyruk_gidilecek_kat.add(asansor_git_kat);

                            try {
                                ucuncu_kat_kuyrugu.take();
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Asansor2.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }

                    }
                }
                if (floor == 4 && toplam < 10 && !dorduncu_kat_kuyrugu.isEmpty() && (dorduncu_kat_kuyrugu.peek() + toplam) < 10) {
                    Iterator musteri_sayisi = dorduncu_kat_kuyrugu.iterator();
                    System.out.println("4da yükleme yapıyor");
                    while (musteri_sayisi.hasNext()) {
                        int asansor_musteri = (int) musteri_sayisi.next();
                        int asansor_git_kat = 0;

                        toplam = toplam + asansor_musteri;
                        if (toplam >= 10) {
                            toplam = toplam - asansor_musteri;
                            break;
                        } else {
                            asansor_kuyruk_musteri_sayisi.add(asansor_musteri);
                            asansor_kuyruk_gidilecek_kat.add(asansor_git_kat);

                            try {
                                dorduncu_kat_kuyrugu.take();
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Asansor2.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }

                    }
                }

                if (!asansor_kuyruk_musteri_sayisi.isEmpty()) {
                    destination = asansor_kuyruk_gidilecek_kat.peek();

                }
if ((destination==4&&floor==4&&dorduncu_kat_kuyrugu.isEmpty())||(destination==3&&floor==3&&ucuncu_kat_kuyrugu.isEmpty())||(destination==2&&floor==2&&ikinci_kat_kuyrugu.isEmpty())||(destination==1&&floor==1&&birinci_kat_kuyrugu.isEmpty())) {
                destination=0;

            }
                String gonderilecek = "";
                if (floor < destination) {//yukari

                    System.out.println("yukari cikiliyor");
                    System.out.println("direction=yukarı");
                    floor++;
                    System.out.println("floor=" + floor);
                    gonderilecek += "yukari cikiliyor\n" + "direction=yukarı\n" + "floor=" + floor + "\n" + "destination=" + destination + "\n";
                    gonderilecek+="count_inside="+toplam+"\n";
                    g.asansor2(gonderilecek);

                    Iterator asansor_musteri_sayisi = asansor_kuyruk_musteri_sayisi.iterator();
                    Iterator asansor_gidilecek_kat_no = asansor_kuyruk_gidilecek_kat.iterator();

                    String kuyruk_gonder = "";
                    while (asansor_musteri_sayisi.hasNext()) {

                        /*System.out.print("[" + asansor_musteri_sayisi.next() + ",");
                System.out.print(asansor_gidilecek_kat_no.next() + "]  , ");*/
                        kuyruk_gonder += "[" + asansor_musteri_sayisi.next() + "," + asansor_gidilecek_kat_no.next() + "]  , ";
                        g.asansor2_kuyruk(kuyruk_gonder);
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Asansor2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (floor > destination) {//aşağı

                    System.out.println("asagi iniliyor ");
                    System.out.println("direction=asagi");
                    floor--;
                    System.out.println("floor=" + floor);
                    gonderilecek += "asagi iniliyor \n" + "direction=asagi\n" + "floor=" + floor + "\n" + "destination=" + destination + "\n";
                    gonderilecek+="count_inside="+toplam+"\n";
                    g.asansor2(gonderilecek);
                    Iterator asansor_musteri_sayisi = asansor_kuyruk_musteri_sayisi.iterator();
                    Iterator asansor_gidilecek_kat_no = asansor_kuyruk_gidilecek_kat.iterator();

                    String kuyruk_gonder = "";
                    while (asansor_musteri_sayisi.hasNext()) {

                        /*System.out.print("[" + asansor_musteri_sayisi.next() + ",");
                System.out.print(asansor_gidilecek_kat_no.next() + "]  , ");*/
                        kuyruk_gonder += "[" + asansor_musteri_sayisi.next() + "," + asansor_gidilecek_kat_no.next() + "]  , ";
                        g.asansor2_kuyruk(kuyruk_gonder);
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Asansor2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (floor == destination && !asansor_kuyruk_musteri_sayisi.isEmpty() && floor == (int) asansor_kuyruk_gidilecek_kat.peek()) {

                    
                    if(asansor_kuyruk_gidilecek_kat.peek()==1){
                    katlar.birinci_kattaki_musteri_sayisi+=asansor_kuyruk_musteri_sayisi.peek();
                    g.hepsi1(katlar.birinci_kattaki_musteri_sayisi);
                }
                if(asansor_kuyruk_gidilecek_kat.peek()==2){
                    katlar.ikinci_kattaki_musteri_sayisi+=asansor_kuyruk_musteri_sayisi.peek();
                    g.hepsi2(katlar.ikinci_kattaki_musteri_sayisi);
                }
                if(asansor_kuyruk_gidilecek_kat.peek()==3){
                    katlar.ucuncu_kattaki_musteri_sayisi+=asansor_kuyruk_musteri_sayisi.peek();
                    g.hepsi3(katlar.ucuncu_kattaki_musteri_sayisi);
                }
                if(asansor_kuyruk_gidilecek_kat.peek()==4){
                    katlar.dorduncu_kattaki_musteri_sayisi+=asansor_kuyruk_musteri_sayisi.peek();
                    g.hepsi4(katlar.dorduncu_kattaki_musteri_sayisi);
                }
                    
                    
                    
                    
                    
                    toplam = toplam - (int) asansor_kuyruk_musteri_sayisi.peek();
                    try {
                        asansor_kuyruk_musteri_sayisi.take();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Asansor2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        asansor_kuyruk_gidilecek_kat.take();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Asansor2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("asansorun ici toplam=" + toplam);

                }

            }

        }

    }

}

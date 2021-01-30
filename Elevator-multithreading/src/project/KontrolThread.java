/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
public class KontrolThread implements Runnable{
     BlockingQueue<Integer> giris_kuyrugu;
    BlockingQueue<Integer> birinci_kat_kuyrugu;
    BlockingQueue<Integer> ikinci_kat_kuyrugu;
    BlockingQueue<Integer> ucuncu_kat_kuyrugu;
    BlockingQueue<Integer> dorduncu_kat_kuyrugu;
    NewJFrame g;
    public KontrolThread(NewJFrame gelen_g,BlockingQueue gelen_birinci_kat_kuyrugu,
             BlockingQueue gelen_ikinci_kat_kuyrugu,
             BlockingQueue gelen_ucuncu_kat_kuyrugu,
             BlockingQueue gelen_dorduncu_kat_kuyrugu,
             BlockingQueue gelen_sıfırıncı_kat_kuyrugu){
        
        giris_kuyrugu=gelen_sıfırıncı_kat_kuyrugu;
        birinci_kat_kuyrugu=gelen_birinci_kat_kuyrugu;
        ikinci_kat_kuyrugu=gelen_ikinci_kat_kuyrugu;
        ucuncu_kat_kuyrugu=gelen_ucuncu_kat_kuyrugu;
        dorduncu_kat_kuyrugu=gelen_dorduncu_kat_kuyrugu;
        g = gelen_g;
        
    }

    @Override
    public void run() {
   
   
   
        
        while(true){
           
           int kuyruktaki_toplam_müsteri=0;
           
            Iterator iteratorValues = giris_kuyrugu.iterator();
            

            while (iteratorValues.hasNext()) {
                int asansor_musteri = (int) iteratorValues.next();
                kuyruktaki_toplam_müsteri+=asansor_musteri;
            }
            
            
            
            
            
            Iterator  birinci_kuyrugu = birinci_kat_kuyrugu.iterator();

            while (birinci_kuyrugu.hasNext()) {
                 int asansor_musteri = (int) birinci_kuyrugu.next();
                kuyruktaki_toplam_müsteri+=asansor_musteri;
                
            }
            
            
            Iterator  ikinci_kuyrugu = ikinci_kat_kuyrugu.iterator();

            while (ikinci_kuyrugu.hasNext()) {
                 int asansor_musteri = (int) ikinci_kuyrugu.next();
                kuyruktaki_toplam_müsteri+=asansor_musteri;
               
            }
            
            
            Iterator  ucuncu_kuyrugu = ucuncu_kat_kuyrugu.iterator();

            while (ucuncu_kuyrugu.hasNext()) {
                int asansor_musteri = (int) ucuncu_kuyrugu.next();
                kuyruktaki_toplam_müsteri+=asansor_musteri;
               
            }
            
            
            Iterator  dorduncu_kuyrugu = dorduncu_kat_kuyrugu.iterator();

            while (dorduncu_kuyrugu.hasNext()) {
                int asansor_musteri = (int) dorduncu_kuyrugu.next();
                kuyruktaki_toplam_müsteri+=asansor_musteri;
               
            }
            
           if(kuyruktaki_toplam_müsteri>20){
              
               /*System.out.println("kuyruklardaki toplam musteri sayisi="+kuyruktaki_toplam_müsteri);
               System.out.println("*********asansor 2 devreye sokkkk****************");*/
              if(common.asansor2_calısıyormu==false){
                  common.asansor2_calısıyormu=true;
              }
              else if(common.asansor3_calısıyormu==false){
                  common.asansor3_calısıyormu=true;
              } 
              else if(common.asansor4_calısıyormu==false){
                  common.asansor4_calısıyormu=true;
              } 
              else if(common.asansor5_calısıyormu==false){
                  common.asansor5_calısıyormu=true;
              }  
           }
           if(kuyruktaki_toplam_müsteri<10){
               if(common.asansor5_calısıyormu==true){
                   common.asansor5_calısıyormu=false;
               }
               else if(common.asansor4_calısıyormu==true){
                   common.asansor4_calısıyormu=false;
               }
               else if(common.asansor3_calısıyormu==true){
                   common.asansor3_calısıyormu=false;
               }
               else if(common.asansor2_calısıyormu==true){
                   common.asansor2_calısıyormu=false;
               }
               
           }
           /*if(kuyruktaki_toplam_müsteri<20){
               
               System.out.println("asansor 2 yi devre dışı bırak");
               common.deneme=false;
           }*/
            
           g.asansor2_calisma_durumu(common.asansor2_calısıyormu);
           g.asansor3_calisma_durumu(common.asansor3_calısıyormu);
           g.asansor4_calisma_durumu(common.asansor4_calısıyormu);
           g.asansor5_calisma_durumu(common.asansor5_calısıyormu);
           try {
               Thread.sleep(300);
           } catch (InterruptedException ex) {
               Logger.getLogger(KontrolThread.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
        
    }
}

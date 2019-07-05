import Data.Slot;
import Data.TIM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Energy {
    public static void main(String[] argc)
    {
        TIM T1M1 = new TIM();
        TIM T2M1 = new TIM();
        TIM T3M1 = new TIM();
        TIM T4M1 = new TIM();
        TIM T5M1 = new TIM();
        TIM T6M1 = new TIM();
        TIM T1M2 = new TIM();
        TIM T2M2 = new TIM();
        TIM T3M2 = new TIM();
        TIM T4M2 = new TIM();
        TIM T5M2 = new TIM();
        TIM T6M2 = new TIM();
        try
        {
            BufferedReader in = new BufferedReader(new FileReader("sink1.txt"));
            String temp;
            String lastTIM1 = in.readLine();
            int count  = 1;
            int id = 0;
            while((temp = in.readLine()) != null)
            {
                String[] las = lastTIM1.split("=");
                String[] res = temp.split("=");
                if(res[0].contains(las[0]))
                {
                    count++;
                }
                else
                {
                    if(las[0].contains("T1M"))
                    {
                        T1M1.add(las[1],count,id);
                    }else if(las[0].contains("T2M"))
                    {
                        T2M1.add(las[1],count,id);
                    }else if(las[0].contains("T3M"))
                    {
                        T3M1.add(las[1],count,id);
                    }else if(las[0].contains("T4M"))
                    {
                        T4M1.add(las[1],count,id);
                    }else if(las[0].contains("T5M"))
                    {
                        T5M1.add(las[1],count,id);
                    }else if(las[0].contains("T6M"))
                    {
                        T6M1.add(las[1],count,id);
                    }
                    count = 1;
                }
                lastTIM1 = temp;
                id++;
            }

        }catch (IOException e)
        {

        }
        try
        {
            BufferedReader in = new BufferedReader(new FileReader("sink2.txt"));
            String temp;
            String lastTIM2 = in.readLine();
            int count  = 1;
            int id =0;
            while((temp = in.readLine()) != null)
            {
                String[] las = lastTIM2.split("=");
                String[] res = temp.split("=");
                if(res[0].contains(las[0]))
                {
                    count++;
                }
                else
                {
                    if(las[0].contains("T1M"))
                    {
                        T1M2.add(las[1],count,id);
                    }else if(las[0].contains("T2M"))
                    {
                        T2M2.add(las[1],count,id);
                    }else if(las[0].contains("T3M"))
                    {
                        T3M2.add(las[1],count,id);
                    }else if(las[0].contains("T4M"))
                    {
                        T4M2.add(las[1],count,id);
                    }else if(las[0].contains("T5M"))
                    {
                        T5M2.add(las[1],count,id);
                    }else if(las[0].contains("T6M"))
                    {
                        T6M2.add(las[1],count,id);
                    }
                    count = 1;
                }
                lastTIM2 = temp;
                id++;
            }

        }catch (IOException e)
        {

        }
        T1M1.updateDt();
        T2M1.updateDt();
        T3M1.updateDt();
        T4M1.updateDt();
        T5M1.updateDt();
        T6M1.updateDt();
        T1M2.updateDt();
        T2M2.updateDt();
        T3M2.updateDt();
        T4M2.updateDt();
        T5M2.updateDt();
        T6M2.updateDt();
//        int ll1 = T1M1.length();
//        for(int i=0;i<ll1;i++)
//        {
//            System.out.println("dt"+T1M1.getdt(i));
//        }





        double tt = 0;
        int th = 1;
        System.out.println("T1M1"+T1M1.length()+"T1M2"+T1M2.length());
        int l = T1M1.length();
        int ct11=0,ct21=0;
        for(int i=0;i<l;i++)
        {
            if(T1M1.getCount(i)>th) {
                if (T1M1.getT(i) - T1M2.getT(i) <= 0 - tt) {
                    ct11++;
                    T1M1.setSink(i,1);
                }
                if (T1M1.getT(i) - T1M2.getT(i) > 0 + tt) {
                    ct21++;
                    T1M1.setSink(i,2);
                }
            }
        }
        System.out.println("T1M length:" +l +" "+ct11 +" "+ct21);
        System.out.println("T2M1"+T2M1.length()+"T2M2"+T2M2.length());
        int l2 = T2M1.length();
        int ct12=0,ct22=0;
        for(int i=0;i<l2;i++)
        {
            if(T2M1.getCount(i)>th) {
                if (T2M1.getT(i) - T2M2.getT(i) <= 0 - tt) {
                    ct12++;
                    T2M1.setSink(i,1);
                }
                if (T2M1.getT(i) - T2M2.getT(i) > 0 + tt) {
                    ct22++;
                    T2M1.setSink(i,2);
                }
            }
        }
        System.out.println("T2M length:" +l2 +" "+ct12+" "+ct22);
        System.out.println("T3M1"+T3M1.length()+"T3M2"+T3M2.length());
        int l3 = T3M1.length();
        int ct13=0,ct23=0;
        for(int i=0;i<l3;i++)
        {
            if(T3M1.getCount(i)>th) {
                if (T3M1.getT(i) - T3M2.getT(i) <= 0 - tt) {
                    ct13++;
                    T3M1.setSink(i,1);
                }
                if (T3M1.getT(i) - T3M2.getT(i) > 0 + tt) {
                    ct23++;
                    T3M1.setSink(i,2);
                }
            }
        }
        System.out.println("T3M length:" +l3 +" "+ct13 +" "+ct23);
        System.out.println("T4M1"+T4M1.length()+"T4M2"+T4M2.length());
        int l4 = T4M1.length();
        int ct14=0,ct24=0;
        for(int i=0;i<l4;i++)
        {
            if(T4M1.getCount(i)>th) {
                if (T4M1.getT(i) - T4M2.getT(i) <= 0 - tt) {
                    ct14++;
                    T4M1.setSink(i,1);
                }
                if (T4M1.getT(i) - T4M2.getT(i) > 0 + tt) {
                    ct24++;
                    T4M1.setSink(i,2);
                }
            }
        }
        System.out.println("T1M length:" +l4 +" "+ct14 +" "+ct24);
        System.out.println("T5M1"+T5M1.length()+"T5M2"+T5M2.length());
        int l5 = T5M1.length();
        int ct15=0,ct25=0;
        for(int i=0;i<l5;i++)
        {
            if(T5M1.getCount(i)>th) {
                if (T5M1.getT(i) - T5M2.getT(i) <= 0 - tt) {
                    ct15++;
                    T5M1.setSink(i,1);
                }
                if (T5M1.getT(i) - T5M2.getT(i) > 0 + tt) {
                    ct25++;
                    T5M1.setSink(i,2);
                }
            }
        }
        System.out.println("T1M length:" +l5 +" "+ct15 +" "+ct25);

        System.out.println("T6M1"+T6M1.length()+"T6M2"+T6M2.length());
        int l6 = T6M1.length();
        int ct16=0,ct26=0;
        for(int i=0;i<l6;i++)
        {
            if(T6M1.getCount(i)>th) {
                if (T6M1.getT(i) - T6M2.getT(i) <= 0 - tt) {
                    ct16++;
                    T6M1.setSink(i,1);
                }
                if (T6M1.getT(i) - T6M2.getT(i) > 0 + tt) {
                    ct26++;
                    T6M1.setSink(i,2);
                }
            }
        }
        System.out.println("T1M length:" +l6 +" "+ct16 +" "+ct26);

//       int ll1 = T1M1.length();
//        for(int i=0;i<ll1;i++)
//        {
//            System.out.println("dt"+T1M1.getdt(i)+" "+T1M1.getSink(i));
//        }

        Slot.run(T4M1);
        System.out.println("system finish");


    }

}

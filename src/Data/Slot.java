package Data;

public class Slot {
    static int workTime = 20;//min
    static int calTime = 1200;
    public static void run(TIM tim)
    {
        int cplot = 1;
        tim.updateCurrentTime();
//        int lo = tim.length();
//        for(int i=0;i<lo;i++)
//        {
//            System.out.println(""+tim.getCurrentTime(i));
//        }
        for(int i=0;i<calTime;i++)
        {
            double ct = tim.getCurrentTime(cplot);
            if(i+1>ct)
            {
                   System.out.println(""+tim.getSink(cplot));
              ////  System.out.println("slot"+(i+1)+"send"+tim.getSink(i+1));
              ////  System.out.println("energy at "+(i+1)+"  "+Model.getEnergy(tim.getdt(cplot),i+1-ct));
                 //   System.out.println(""+Model.getEnergy(tim.getdt(cplot),i+1-ct));
                cplot++;
            }
            else
            {
                  System.out.println(""+0);
              ////  System.out.println("slot"+(i+1)+"send"+0);
              ////  System.out.println("energy at "+(i+1)+"  "+Model.getEnergy(tim.getdt(cplot-1),i+1-tim.getCurrentTime(cplot-1)));
                  //  System.out.println(""+Model.getEnergy(tim.getdt(cplot-1),i+1-tim.getCurrentTime(cplot-1)));
            }
        }
    }
}

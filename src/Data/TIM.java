package Data;

import java.util.ArrayList;

public class TIM {
    ArrayList Tim = new ArrayList<time>();
    public void add(String s,int c,int id)
    {
        time t  = new time(s,c,id);
        Tim.add(t);
    }
    public void updateDt()
    {
        int l = Tim.size();
        for(int i=0;i<l;i++)
        {
            if(getCount(i)<=1)
            {
                Tim.remove(i);
                l--;
            }
        }
        int newl = Tim.size();
        for(int i=0;i<newl-1;i++)
        {
            double ddt = getT(i+1)-getT(i);
            setDt(i,ddt);
        }

        int lll = Tim.size();
        for(int i=0;i<lll;i++)
        {
            if(getdt(i)<=1)
            {
                Tim.remove(i);
                lll--;
            }
        }
    }
    public int getId(int i)
    {
        time t = (time) Tim.get(i);
        int ddd = t.id;
        return ddd;
    }
    public double getT(int i)
    {
        time t = (time) Tim.get(i);
        return t.T;
    }
    public double getdt(int i)
    {
        time temp = (time) Tim.get(i);
        return temp.gettimedt();
    }
    public void setDt(int index,double t)
    {
        time nt = (time) Tim.get(index);
        nt.setdt(t);
        Tim.set(index,nt);

    }
    public int getCount(int i)
    {
        time t = (time) Tim.get(i);
        return t.count;
    }
    public int length()
    {
        return Tim.size();
    }
    public void setSink(int index,int s)
    {
        time t = (time) Tim.get(index);
        t.Sink(s);
        Tim.set(index,t);
    }
    public int getSink(int ondex)
    {
        time t = (time) Tim.get(ondex);
        return t.sink;
    }
    public void updateCurrentTime()
    {
        updateDt();
        int l = Tim.size();
        for(int i = 0;i<l-1;i++)
        {
            time t = (time) Tim.get(i);
            time t1 = (time) Tim.get(i+1);
            double cdt = t.dt;
            double ct = cdt+t.currentTime;
            t1.currentTime = ct;
            Tim.set(i+1,t1);
        }

    }
    public double getCurrentTime(int i)
    {
        time t = (time) Tim.get(i);
        return t.currentTime;
    }
    public void setCurrentTime(int i,double c)
    {
        time t = (time) Tim.get(i);
        t.currentTime = c;
        Tim.set(i,t);
    }
    static class time
    {
        int hour;
        int min;
        double second;
        int count = 1;
        double T = 0.0;
        double dt = 0.0;
        int id;
        int sink = 0;
        double currentTime =0;

        //T6M=3907V[2019-05-12 04:57:13.960]
        public time(String str,int count,int id)
        {
            this.id = id;
            String sub = str.substring(str.length()-13,str.length()-1);
          //  System.out.println(sub);
            String[] t = sub.split(":");
            hour = Integer.valueOf(t[0].toString());
            min  = Integer.valueOf(t[1].toString());
            second = Double.valueOf(t[2].toString());
            this.count = count;
            T = hour*3600+min*60+second;
        }
        public void setdt(double t)
        {
            dt = t;
        }
        public void Sink(int s)
        {
            sink = s;
        }
        public double gettimedt() {
            return dt;
        }
    }
}

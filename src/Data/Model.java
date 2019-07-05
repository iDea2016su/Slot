package Data;

public class Model {
    private static final double C = 0.05;//   50mf
    private static final double Vmax = 1.29;
    private static final double Vmin = 0.9;
    private static final double ChargeTime = 4;
    private static final double WorkTime = 0.3;
    public static double getEnergy(double detal, double time)
    {
        //uint in ms
        double currentVoltage = 0.0;
        if(time<=(4/4.3)*detal)
        {
            currentVoltage = Vmin+time/(4/4.3*detal)*(Vmax-Vmin);
        }
        else
        {
            currentVoltage = Vmax-(time-(4/4.3*detal))/(0.3/4.3*detal)*(Vmax-Vmin);
        }
        return 0.5*1000*0.05*currentVoltage*currentVoltage;
    }
}

package application;

import java.lang.instrument.Instrumentation;

public class Instrument {
    private static volatile Instrumentation instrument;

    public static void premain(final String agentArgs, final Instrumentation inst)
    {
        instrument = inst;
    }

    public static void agentmain(String agentArgs, Instrumentation inst)
    {
        instrument = inst;
    }

    public static long sizeOf(final Object object)
    {
        return instrument.getObjectSize(object);
    }
}

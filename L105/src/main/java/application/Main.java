package application;

import application.framework.ReflectionHelper;
import application.framework.UnitExecutor;
import application.underdog.TestUnderdog;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("ONE class");
        TestUnderdog test = new TestUnderdog();
        ReflectionHelper helper = new ReflectionHelper(TestUnderdog.class);

        UnitExecutor unit = new UnitExecutor();
        unit.run(helper.getResult());

        System.out.println("\n\nSet of classes");
        Set<Class<?>> cls = new HashSet<>();
        cls.add(TestUnderdog.class);
        ReflectionHelper helper2 = new ReflectionHelper(cls);
        unit.run(helper2.getResult());

        System.out.println("\n\nBy package");
        ReflectionHelper helper1 = new ReflectionHelper("application.underdog");
        unit.run(helper1.getResult());
    }
}

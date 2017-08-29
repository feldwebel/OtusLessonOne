package application.framework;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class TestMethodsDTO {

    private Class class1;
    private Set<Method> before = new HashSet<>();
    private Set<Method> after = new HashSet<>();
    private Set<Method> test = new HashSet<>();
    private Set<Method> expects = new HashSet<>();

    public Class getClass1() {
        return class1;
    }

    public void setClass1(Class class1) {
        this.class1 = class1;
    }

    public Set<Method> getBefore() {
        return before;
    }

    public void setBefore(Set<Method> before) {
        this.before = before;
    }

    public void addBefore(Method before) {
        this.before.add(before);
    }

    public Set<Method> getAfter() {
        return after;
    }

    public void setAfter(Set<Method> after) {
        this.after = after;
    }

    public void addAfter(Method after) {
        this.after.add(after);
    }

    public Set<Method> getTest() {
        return test;
    }

    public void setTest(Set<Method> test) {
        this.test = test;
    }

    public void addTest(Method test) {
        this.test.add(test);
    }

    public Set<Method> getExpects() {
        return expects;
    }

    public void setExpects(Set<Method> expects) {
        this.expects = expects;
    }

    public void addExpects(Method expects) {
        this.expects.add(expects);
    }
}

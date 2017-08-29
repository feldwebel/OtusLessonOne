package application.framework;

import application.framework.annotations.After;
import application.framework.annotations.Before;
import application.framework.annotations.Expects;
import application.framework.annotations.Test;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.lang.reflect.Method;
import java.util.*;

public class ReflectionHelper {

    private Set<TestMethodsDTO> result = new HashSet<>();

    private Set<Class<?>> classes = new HashSet<>();

    public ReflectionHelper(String testedPackage)
    {
        this.classes = resolvePackageToClasses(testedPackage);
    }

    public ReflectionHelper(Set<Class<?>> classes)
    {
        this.classes = classes;
    }

    public ReflectionHelper(Class class1)
    {
        this.classes.add(class1);
    }

    public Set<TestMethodsDTO> getResult() {
        if (result == null || result.size() == 0) {
            populate();
        }
        return result;
    }

    private static Set<Class<?>> resolvePackageToClasses(String testedPackage)
    {
        List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
        classLoadersList.add(ClasspathHelper.contextClassLoader());
        classLoadersList.add(ClasspathHelper.staticClassLoader());
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setScanners(new SubTypesScanner(false), new ResourcesScanner())
                .setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
                .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(testedPackage))));

        return reflections.getSubTypesOf(Object.class);
    }

    private void populate() {
        if (classes == null) {
            throw new RuntimeException("Nothing to do");
        }

        for (Class class1: classes) {
            TestMethodsDTO dto = new TestMethodsDTO();
            dto.setClass1(class1);
            for (Method method : class1.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Test.class)) {
                    dto.addTest(method);
                }
                if (method.isAnnotationPresent(Expects.class)) {
                    dto.addExpects(method);
                }
                if (method.isAnnotationPresent(Before.class)) {
                    dto.addBefore(method);
                }
                if (method.isAnnotationPresent(After.class)) {
                    dto.addAfter(method);
                }
            }
            result.add(dto);
        }
    }
}

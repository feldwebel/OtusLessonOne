package application.framework;

import application.framework.annotations.Expects;

import java.lang.reflect.Method;
import java.util.Set;

public class UnitExecutor {

    public void run(Set<TestMethodsDTO> dtoSet)
    {
        for(TestMethodsDTO dto: dtoSet) {
            try {
                Object object = dto.getClass1().newInstance();
                System.out.println(dto.getClass1().toString());
                for (Method method: dto.getBefore()) {
                    method.invoke(object);
                }
                for (Method method: dto.getTest()) {
                    try {
                        method.invoke(object);
                        successMessage(dto.getClass1(), method);
                    } catch (Exception e) {
                        if (dto.getExpects().contains(method)) {
                            successMessage(dto.getClass1(), method);
                        } else {
                            failMessage(dto.getClass1(), method, e);
                        }
                    }
                }
                for (Method method: dto.getAfter()) {
                    method.invoke(object);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void successMessage(Class cls, Method method) {
        System.out.printf(
                "Test %s.%s is success\n",
                cls.getCanonicalName(), method.getName()
        );
    }

    private void failMessage(Class cls, Method method, Exception e) {
        System.out.printf(
                "Test %s.%s fails with message %s\n",
                cls.getCanonicalName(),
                method.getName(),
                e.toString()
        );
    }

}

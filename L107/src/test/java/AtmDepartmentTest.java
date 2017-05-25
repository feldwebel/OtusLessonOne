
import application.AtmDepartment;
import application.AtmDevice;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class AtmDepartmentTest {

    AtmDepartment department;

    @Test
    public void balanceTest()
    {
        department = getDepartment();

        Assert.assertEquals(200, department.getBalance());
    }

    private AtmDepartment getDepartment()
    {
        return
            new AtmDepartment().addDevice(getDevice()).addDevice(getDevice());
    }

    private AtmDevice getDevice()
    {
        AtmDevice device = mock(AtmDevice.class);
        when(device.getBalance()).thenReturn(100);

        return device;
    }
}

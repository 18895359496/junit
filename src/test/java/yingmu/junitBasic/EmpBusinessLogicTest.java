package yingmu.junitBasic;

import org.junit.Test;
import vo.EmployeeDetails;
import yingmu.EmpBusinessLogic;

import static org.junit.Assert.*;

/**
 * @author zhouxiang
 * @date 2019/10/24-11:40
 */
public class EmpBusinessLogicTest {
    EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
    EmployeeDetails employee = new EmployeeDetails();


    @Test
    public void testCalculateYearlySalary() {
        employee.setName("Rajeev");
        employee.setAge(25);
        employee.setMonthlySalary(8000);
        double salary= empBusinessLogic.calculateYearlySalary(employee);
        assertEquals(96000, salary, 0.0);
    }


}
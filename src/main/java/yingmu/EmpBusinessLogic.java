package yingmu;

import org.junit.Test;
import vo.EmployeeDetails;


/**
 * @author zhouxiang
 * @date 2019/10/24-11:29
 */
public class EmpBusinessLogic {

    /**
     * Calculate the yearly salary of employee
     *
     * @param employeeDetails
     * @return double
     * @author zhouxiang
     * @date 2019/10/24 11:38
     */
    public double calculateYearlySalary(EmployeeDetails employeeDetails) {
        double yearlySalary = 0;
        yearlySalary = employeeDetails.getMonthlySalary() * 12;
        return yearlySalary;
    }


    /**
     * Calculate the appraisal amount of employee
     *
     * @param employeeDetails
     * @return double
     * @author zhouxiang
     * @date 2019/10/24 11:39
     */
    public double calculateAppraisal(EmployeeDetails employeeDetails) {

        double appraisal = 0;
        if (employeeDetails.getMonthlySalary() < 10000) {
            appraisal = 500;
        } else {
            appraisal = 1000;
        }
        return appraisal;
    }
}

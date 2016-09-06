package workHours.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import workHours.entities.Employee;
import workHours.entities.EmployeeDAO;

/**
 * Created by perrythomson on 9/6/16.
 */
@RestController
@RequestMapping("/restData/")
public class DataRestController {


    private final EmployeeDAO employeeDAO;

    @Autowired
    public DataRestController(EmployeeDAO employeeDAO) {
        Assert.notNull(employeeDAO, "QuizQuestionDAO must not be null!");
        this.employeeDAO = employeeDAO;
    }

    @RequestMapping("getAllQuestions")
    public Iterable<Employee> getAllEmployees() {  //Iterable stack of quiz questions from DAO
        return employeeDAO.findAll();
    }
}



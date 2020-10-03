package com.gyb.springbootcrud.controller;

import com.gyb.springbootcrud.bean.Department;
import com.gyb.springbootcrud.bean.Employee;
import com.gyb.springbootcrud.dao.DepartmentDao;
import com.gyb.springbootcrud.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Random;

/**
 * @Author gb
 * @Date 2020/9/28 23:39
 * @Version 1.0
 * description:
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    /**
     * create by: gb
     * description:
     * create time: 2020/9/28 23:41
     *
     * @param
     * @param model
     * @return
     */
    @GetMapping("emps")
    public String list(Model model) {
        Collection<Employee> employeeDaoAll = employeeDao.getAll();
//        把查询到的员工数据放到域中
        model.addAttribute("emps", employeeDaoAll);
        return "list";
    }

    /**
     * create by: gb
     * description: 点击添加按钮后跳转到添加页面
     * create time: 2020/10/1 14:16
     *
     * @param model
     * @return
     */
    @GetMapping("/addPage")
    public String addPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        /*先从数据中找出所有的部门*/
        model.addAttribute("departments", departments);
        return "add";
    }

    /**
     * create by: gb
     * description: 将新员工信息填写完成并提交之后，跳转到list界面，但这个list界面得显示所有员工的界面，也就是得执行list()方法，所以要转发到emps
     * create time: 2020/10/2 18:08
     *
     * @param employee
     * @return
     */
    @PostMapping("send")
    public String send(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * create by: gb
     * description: 修改员工页面，但是跳转的页面还是add
     * create time: 2020/10/3 1:02
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/upData/{id}")
    public String upData(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("upData", employee);
        /*先从数据中找出所有的部门*/
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "/add";
    }

    /**
     * create by: gb
     * description: TODO
     * create time: 2020/10/3 13:38
     *
     * @param
     * @return
     */
    @PutMapping("send")
    public String upDataCommit(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}




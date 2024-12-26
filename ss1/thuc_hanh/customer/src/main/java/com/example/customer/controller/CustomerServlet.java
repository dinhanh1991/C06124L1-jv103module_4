package com.example.customer.controller;

import com.example.customer.repository.CustomerRop;
import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="Customer",value = "/customer")
public class CustomerServlet extends HttpServlet {
    private  final CustomerRop customerRop = new CustomerRop();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "view":
                viewCustomer(request, response);
                break;
                default:
                    showCustomersList(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertCustomer(request, response);
                break;
                case "edit":
                    editCustomer(request, response);
                    break;
                    case "delete":
                        deleteCustomer(request, response);
                        break;
                        default:
                            showCustomersList(request, response);
                            break;
        }
    }
    private void showCustomersList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList =customerRop.getListCustomer();
        request.setAttribute("customerList", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer =customerRop.getCustomerById(id);
        request.setAttribute("customer", customer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/view.jsp");
        try {
            requestDispatcher.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("deleteCustomer");
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        customerRop.deleteCustomer(id);
        request.setAttribute("messenger","Delete Customer Success");
        try {
            response.sendRedirect("/customer?action=list");
        }catch (Exception e){
            System.out.println("Error"+e.getMessage());
        }

    }
    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Customer> customerList =customerRop.getListCustomer();
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                String name =request.getParameter("name");
                String email =request.getParameter("email");
                String address =request.getParameter("address");
                customer.setName(name);
                customer.setEmail(email);
                customer.setAddress(address);
            }
        }
        showCustomersList(request, response);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int id = Integer.parseInt(request.getParameter("id"));
        String name =request.getParameter("name");
        String email =request.getParameter("email");
        String address =request.getParameter("address");
        Customer customer =new Customer(id, address, name, email);
        customerRop.insertCustomer(customer);
        response.sendRedirect(request.getContextPath()+"/customer?action=list");
        request.setAttribute("messenger","Create Customer Success");

    }
}

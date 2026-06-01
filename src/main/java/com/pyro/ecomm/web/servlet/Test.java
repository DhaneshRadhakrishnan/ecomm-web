package com.pyro.ecomm.web.servlet;

import com.pyro.ecomm.user.dto.UserDTO;
import com.pyro.ecomm.user.remote.TestRemote;
import com.pyro.ecomm.user.remote.UserRemote;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@WebServlet("/test")
public class Test extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Ecomm Web module Test");


        try {
            InitialContext ic = new InitialContext();
           TestRemote testRemote = (TestRemote)
                    ic.lookup("java:global/ecomm-user-1.0/TestSessionBean");



            testRemote.test();

//            List<UserDTO> allUsers = userRemote.getAllUsers();
//            for (UserDTO user : allUsers) {
//                user.toString();
//            }


        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

    }
}


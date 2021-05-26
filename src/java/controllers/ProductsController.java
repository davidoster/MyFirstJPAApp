/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mac
 */
@WebServlet(name = "Products", urlPatterns = {"/products"})
public class ProductsController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Products</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Products at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Products</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Products at " + request.getContextPath() + "</h1>");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyFirstJPAAppPU");
            EntityManager em = emf.createEntityManager();
            List<Product> products = (List<Product>) em.createQuery("SELECT c FROM Product c").getResultList();
            // SELECT ALL
            for (Product product : products) {
                out.println(product + "<br>");
            }

            // SELECT single
            Product myProduct = em.find(Product.class, 7);
            out.println("Before: " + myProduct);

            // UPDATE
//            em.getTransaction().begin();
//            myProduct.setName("KKK");
//            myProduct.setDescription("KKK");
//            em.getTransaction().commit();
//
//            out.println("After: " + myProduct);
            // INSERT
//            em.getTransaction().begin();
//            Product myProduct2 = new Product();
//            em.persist(myProduct2);
//            myProduct2.setName("Extreme Tablet");
//            myProduct2.setDescription("The Extremest Tablet Product EVER!!!!");
//            myProduct2.setImage("xxxx");
//            myProduct2.setPrice(1999);
//            em.getTransaction().commit();
//
            // DELETE
            Product myProduct3 = em.find(Product.class, 18);
            if (myProduct3 != null) {
                em.getTransaction().begin();
                em.remove(myProduct3);
                em.getTransaction().commit();
            }

            out.println("After insert!");
            products = (List<Product>) em.createQuery("SELECT c FROM Product c").getResultList();
            // SELECT ALL
            for (Product product : products) {
                out.println(product + "<br>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

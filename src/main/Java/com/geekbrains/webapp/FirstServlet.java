package com.geekbrains.webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geekbrains.webapp.models.Product;
import lombok.extern.slf4j.Slf4j;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@WebServlet(name = "first", urlPatterns = "/first")
public class FirstServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        log.info("Servlet started.");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = new ArrayList<>();
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        for (int i = 0; i < 10; i++) {
            int id = (int) (Math.random() * 100000);
            String[] titleColor = new String[]{"red", "blue", "green", "coral", "black", "orange"};
            String[] titleName = new String[]{"vacuum cleaner", "pet house", "washing machine", "microwave", "book", "mug"};
            String title = titleColor[(int) (Math.random() * titleColor.length)] + " " +
                            titleName[(int) (Math.random() * titleName.length)];
            double cost = Math.random() * 1000;
            Product product = new Product(id, title, cost);
            productList.add(product);
            resp.getWriter().printf(product.toString());
        }

        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
    }
}

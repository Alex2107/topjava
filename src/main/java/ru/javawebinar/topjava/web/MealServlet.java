package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.dao.MealImpl;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MealServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(MealServlet.class);
    private MealImpl mealDAO;

    @Override
    public void init() throws ServletException {
        mealDAO = new MealImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        log.debug("MealServlet get");
        //resp.sendRedirect("meals.jsp");
        listMeal(req, resp);
    }
    private void listMeal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        log.debug("start of ListMeal");
        //List<MealWithExceed> list = MealsUtil.getFilteredWithExceeded(mealDAO.getMeals(), LocalTime.MIN, LocalTime.MAX, 2000);
        //log.debug(list.toString());
        //System.out.println(list.get(1).getCalories());
        request.setAttribute("meals", MealsUtil.getFilteredWithExceeded(mealDAO.getMeals(), LocalTime.MIN, LocalTime.MAX, 2000));
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/meals.jsp");
        dispatcher.forward(request, response);
        log.debug("finish of ListMeal");
    }
}

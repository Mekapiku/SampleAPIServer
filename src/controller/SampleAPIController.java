package controller;

import beans.TempSensorData;
import utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by mitsuyasu on 2015/07/27.
 */
@WebServlet("/api")
public class SampleAPIController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        TempSensorData data = new TempSensorData();
        {
            data.setDate(new Date());
            data.setTemp((float) Math.random() * 100.0f);
        }

        String res = JsonUtil.toJson(data);

        response.getOutputStream().print(res);
        response.getOutputStream().flush();
    }
}

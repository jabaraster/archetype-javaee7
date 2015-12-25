/**
 *
 */
package ${package}.web.route;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sandbox.service.EmployeeService;

/**
 *
 */
@WebServlet(urlPatterns = "/")
public class Index extends HttpServlet {

    @Inject
    EmployeeService es;

    /**
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(final HttpServletRequest pReq, final HttpServletResponse pResp) throws ServletException, IOException {
        RouteUtil.forwardToJsp("index.jsp", pReq, pResp); //$NON-NLS-1$
    }

    /**
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(final HttpServletRequest pReq, final HttpServletResponse pResp) throws ServletException, IOException {
        this.es.insert(pReq.getParameter("employee-name")); //$NON-NLS-1$
        pResp.sendRedirect("/"); //$NON-NLS-1$
    }
}

/**
 *
 */
package ${package}.web.route;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
final class RouteUtil {

    private RouteUtil() {
        // nop
    }

    /**
     * @param pJspPathFromJspDir 先頭に / は不要.
     * @param pReq -
     * @param pResp -
     * @throws ServletException -
     * @throws IOException -
     * @see RequestDispatcher#forward(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
     */
    static void forwardToJsp( //
            final String pJspPathFromJspDir //
            , final HttpServletRequest pReq //
            , final HttpServletResponse pResp) throws ServletException, IOException {

        pReq.getRequestDispatcher("/WEB-INF/jsp/" + pJspPathFromJspDir).forward(pReq, pResp); //$NON-NLS-1$
    }
}

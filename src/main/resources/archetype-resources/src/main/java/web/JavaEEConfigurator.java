/**
 *
 */
package ${package}.web;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.EnumSet;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jabara.servlet.HeartBeat;

/**
 *
 */
@WebListener
public class JavaEEConfigurator implements ServletContextListener {

    @Inject
    private EntityManagerFactory entityManagerFactory;

    /**
     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
     */
    @Override
    public void contextDestroyed(@SuppressWarnings("unused") final ServletContextEvent pEvent) {
        // nop
    }

    /**
     * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
     */
    @Override
    public void contextInitialized(final ServletContextEvent pEvent) {
        setUpCharacterEncoding(pEvent);
        setUpHeartBeat(pEvent);
        this.setUpJpa();
    }

    private void setUpJpa() {
        // JPAメタデータクラスのstaticフィールドを初期化してもらう.
        // これをやっておかないと、アプリケーション中でメタデータクラスを利用している箇所で
        // NPEがスローされてしまう可能性が生じる.
        this.entityManagerFactory.createEntityManager().close();
    }

    private static void setUpCharacterEncoding(final ServletContextEvent pEvent) {
        pEvent.getServletContext() //
                .addFilter(CharacterEncodingFilter.class.getName(), CharacterEncodingFilter.class) //
                .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/*"); //$NON-NLS-1$
    }

    private static void setUpHeartBeat(final ServletContextEvent pEvent) {
        pEvent.getServletContext().addServlet(HeartBeat.class.getName(), HeartBeat.class).addMapping("/ping"); //$NON-NLS-1$
    }

    private static class CharacterEncodingFilter implements Filter {

        @Override
        public void destroy() {
            // nop
        }

        @Override
        public void doFilter(final ServletRequest pReq, final ServletResponse pResp, final FilterChain pChain) throws IOException, ServletException {
            final String ENC = StandardCharsets.UTF_8.name();
            ((HttpServletRequest) pReq).setCharacterEncoding(ENC);
            ((HttpServletResponse) pResp).setCharacterEncoding(ENC);
            pChain.doFilter(pReq, pResp);
        }

        @Override
        public void init(@SuppressWarnings("unused") final FilterConfig pConfig) {
            // nop
        }

    }
}

package auth;

import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author evrnsky(vrnsky at protonmail.ch)
 * @version 0.1
 * @since 30.03.2017
 *
 * This filter allow only user which have permission edit advert.
 */
@WebFilter(urlPatterns = {"/ads", "/newadvert", "/login"})
public class AuthFilter implements Filter {

    /**
     * Call once at the filter created.
     * @param filterConfig for external configuration.
     * @throws ServletException if some problem.
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * Main method of filter. When user asking about login page we skip request, otherwise should check that user already have session.
     * @param servletRequest from client to server.
     * @param servletResponse from server to client.
     * @param chain of filters.
     * @throws IOException if an input or output error detected.
     * @throws ServletException if request could not be handled.
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        if (req.getRequestURI().contains("/login")) {
            chain.doFilter(req, resp);
        } else {
            HttpSession session = req.getSession();
            if (session.getAttribute("user") == null) {
                resp.sendRedirect(String.format("%s/login.html", req.getContextPath()));
                return;
            }
            chain.doFilter(req, resp);
        }
    }

    /**
     * Call once and release resources.
     */
    @Override
    public void destroy() {
    }
}

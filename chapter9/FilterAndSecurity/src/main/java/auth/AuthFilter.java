package auth;

import model.User;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author evrnsky
 * @version 0.1
 * @since 22.02.2017
 * This is web filter which filtered all request.
 */
@WebFilter(filterName = "auth", urlPatterns = "*")
public class AuthFilter implements Filter {

    /**
     * This method call once when filter created.
     *
     * @param filterConfig init params for filter.
     * @throws ServletException if problem with concurrency.
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * Main method of filter. Contains logic of filtering.
     *
     * @param servletRequest  from client to server.
     * @param servletResponse from server to client.
     * @param chain           filter chain.
     * @throws IOException      if problem with data exchange.
     * @throws ServletException if problem with data concurrency.
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = ((HttpServletRequest) servletRequest);
        if (request.getRequestURI().contains("/login")) {
            chain.doFilter(servletRequest, servletResponse);
        } else {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user == null) {
                ((HttpServletResponse) servletResponse).sendRedirect(String.format("%s/login", request.getContextPath()));
                return;
            }
            chain.doFilter(servletRequest, servletResponse);
        }
    }

    /**
     * This method call once when filter is destroyed.
     */
    @Override
    public void destroy() {

    }
}

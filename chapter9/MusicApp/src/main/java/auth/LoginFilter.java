package auth;

import model.User;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author evrnsky
 * @version 0.1
 * @since 28.03.2017
 */
@WebFilter(urlPatterns = "*")
public class LoginFilter implements Filter {

    /**
     * Call once at the time and set internal settings.
     * @param filterConfig instance of filter config.
     * @throws ServletException if request could not be handled.
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * Main method of filter.
     * @param servletRequest from client to server.
     * @param servletResponse from server to client.
     * @param  chain of filter, must need throw request further to the filter chain.
     * @throws IOException if an input or output error detected.
     * @throws ServletException if request could not be handled.
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getRequestURI().contains("/login")) {
           chain.doFilter(servletRequest, servletResponse);
        } else {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user == null) {
                response.sendRedirect(String.format("%s/login.html", request.getContextPath()));
                return;
            }
            chain.doFilter(servletRequest, servletResponse);
        }
    }

    /**
     * Call once at the all time.
     * Release all resources.
     */
    @Override
    public void destroy() {
    }
}

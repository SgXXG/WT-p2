package by.bsuir.lab4.filter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.bsuir.lab4.constant.PageConstant;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter(urlPatterns = { "/*" })
public class XssFilter implements Filter {

    private static Logger log = LogManager.getLogger("filter");

    private static final String XSS_SCRIPT_TAG = "<script";
    private static final String XSS_SCRIPT_END_TAG = "</script>";
    private static final String JAVASCRIPT = "javascript:";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        Enumeration<String> parameterNames = servletRequest.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String text = servletRequest.getParameter(parameterNames.nextElement()).toLowerCase();
            if (text.contains(XSS_SCRIPT_TAG) || text.contains(XSS_SCRIPT_END_TAG) || text.contains(JAVASCRIPT)) {
                RequestDispatcher dispatcher = ((FilterConfig) servletRequest).getServletContext()
                        .getRequestDispatcher(PageConstant.ERROR_PAGE);
                log.info("xss-attack was prevented");
                dispatcher.forward(servletRequest, servletResponse);
                return;
            }

        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

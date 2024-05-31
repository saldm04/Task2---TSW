package it.unisa.control;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class PageAccessFilter implements Filter {
    private static final List<String> FORBIDDEN_PAGES = Arrays.asList("META-INF/context.xml", "WEB-INF/web.xml");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inizializzazione del filtro (se necessaria)
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String page = httpRequest.getParameter("page");

        if (page != null && FORBIDDEN_PAGES.contains(page)) {
            // Reindirizza a Home.jsp se la pagina richiesta è proibita
            httpResponse.sendRedirect("Home.jsp");
        } else {
            // Continua la catena di filtri o richieste
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // Pulizia del filtro (se necessaria)
    }
}

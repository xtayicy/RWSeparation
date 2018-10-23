package harry.filter;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import net.urlrewriter.RewriteFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author harry
 *
 */
public class CustomUrlRewriteFilter extends RewriteFilter {
	private Logger logger = LoggerFactory.getLogger(CustomUrlRewriteFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		logger.info("uri = " + req.getRequestURI());

		if (isMatch(req.getRequestURI())) {
			if (isStaticResourceExits(req)) {
				chain.doFilter(request, response);
			} else {
				super.doFilter(request, response, chain);
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	public static boolean isStaticResourceExits(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		return new File(request.getSession().getServletContext().getRealPath("/").replace("\\", "/")
				+ requestURI.substring(requestURI.indexOf("/", 1))).exists();
	}

	public boolean isMatch(String url) {
		return Pattern.compile(".*\\.html$").matcher(url).matches();
	}
}

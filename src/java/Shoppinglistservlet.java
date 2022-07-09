

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aleena
 */
public class Shoppinglistservlet extends HttpServlet {

  private ArrayList<String> item = new ArrayList<>();
        
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      HttpSession session = request.getSession();
    String process = request.getParameter("action");
    
    String user = (String) session.getAttribute("user_name");
    if (process != null && process.equals("Logout")) {
        session.invalidate();
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        return;
    }
    if (user == null) {
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);
        return;
        
    } else {
        getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
        return;
    }
      
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String item = request.getParameter("item");
        String delete = request.getParameter("itemname");
        String username = request.getParameter("user_name");
        String process = request.getParameter("action");
        String add = request.getParameter("add");
        
        if(process != null && process.equals("register")) {
            if (username == null || username.equals("")) {
                request.setAttribute("errormessage", true);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
                return;
            } else {
                session.setAttribute("user_name", username);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
                return;
            }
        }
        if (process != null && process.equals("add")) {
           
           session.setAttribute("itemlist", item);
           getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
           return;  
        }
        if (process != null && process.equals("delete") ) {
            session.setAttribute("itemlist", item);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            return;       
        }
        
        
        
    }

}

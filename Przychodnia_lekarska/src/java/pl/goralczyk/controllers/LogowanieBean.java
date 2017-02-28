package pl.goralczyk.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.*;
import javax.servlet.http.*;

@RequestScoped
@ManagedBean(name = "logowanieBean")
public class LogowanieBean extends HttpServlet{

    private String username;
    private String password;

    @ManagedProperty(value = "#{pacjentBean}")
    private PacjentBean pacjentBean;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public PacjentBean getPacjentBean(){
        return pacjentBean;
    }
    
    public void setPacjentBean(PacjentBean pacjentBean){
        this.pacjentBean = pacjentBean;
    }
    
    public void dodajInformacje(String s) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, s, ""));
    }
    
    public void submit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        FacesContext context = FacesContext.getCurrentInstance();
        PrintWriter out = response.getWriter();
        username = request.getParameter("inputName");
        password = request.getParameter("inputPassword");
        try {
            if(username.equals("SYSTEM")&&password.equals("SYSTEM")){
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                RequestDispatcher rd = request.getRequestDispatcher("logowanie.xhtml");
                rd.forward(request, response);
            }
            else{
                RequestDispatcher rd = request.getRequestDispatcher("indexPowitalny.xhtml");
                rd.include(request, response);
            }
        } finally{
            out.close();
        }
    }

//    public void logout() throws IOException {
//        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
//        externalContext.invalidateSession();
//        externalContext.redirect(externalContext.getRequestContextPath() + "/login.xhtml");
//    }
   
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     HttpSession session = request.getSession(false);
     // Destroys the session for this user.
     if (session != null)
          session.invalidate();

     // Redirects back to the initial page.
     response.sendRedirect(request.getContextPath());
    }

}

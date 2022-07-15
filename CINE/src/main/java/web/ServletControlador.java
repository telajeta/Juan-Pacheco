package web;

import data.SeriesDAO;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.*;

@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet {
    
   @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
        String accion = req.getParameter("accion");
        
        if(accion!=null){
            switch(accion){
                case "eliminar":
                    break;
                case "editar":
                    editarSerie(req, res);
                    break;
                default:
                    accionDefault(req, res);
                    break;
            }
        }else{
            accionDefault(req, res);
        }
    }
    
    protected void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
        String queryParam = req.getParameter("accion");
        if(queryParam!=null){
            switch(queryParam){
                case "insertar":
                    insertarSerie(req,res);
                    break;
                case "modificar":
                    break;
                default:
                    accionDefault(req,res);
                    break;
            }
        }
    }
    
    private void accionDefault(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
        List <Series> series = new SeriesDAO().findAll();
        series.forEach(System.out::println);
        HttpSession sesion = req.getSession();
        sesion.setAttribute("Series", series);
        sesion.setAttribute("cantidadCapitulos",calcularCapitulos(series));
        sesion.setAttribute("precioTotal", calcularPrecio(series));
//        req.getRequestDispatcher("cines.jsp").forward(req, res);
        res.sendRedirect("cines.jsp");
    }
    
    private void insertarSerie(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException{
        String nombre = req.getParameter("nombre");
        String director = req.getParameter("director");
        int cantMinutos = Integer.parseInt(req.getParameter("cantMinutos"));
        double precio = Double.parseDouble(req.getParameter("precio"));
        int capitulos = Integer.parseInt(req.getParameter("capitulos"));  
        
        Series serie = new Series(nombre, director, cantMinutos, precio, capitulos);
        
        int registrosMod = new SeriesDAO().insert(serie);
        
        System.out.println("insertados = " + registrosMod);
        
        accionDefault(req, res);
    }
    
    private void editarSerie(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException {
        int idCine = Integer.parseInt(req.getParameter("idcines"));
        Series serie = new SeriesDAO().findById(idCine);
        req.setAttribute("serie", serie);
        String jspEditar = "/WEB-INF/paginas/operaciones/editar.jsp";
        req.getRequestDispatcher(jspEditar).forward(req, res);
    }
    
    
    private int calcularCapitulos(List<Series> vid){
        int cant=0;
        for (int i = 0; i < vid.size(); i++){
            cant += vid.get(i).getCapitulos();
        }
        return cant;
    }
    
    private double calcularPrecio(List<Series> vid){
        double precio = 0;
        for (int i = 0; i < vid.size(); i++){
            precio += vid.get(i).getPrecio();
        }
        return precio;
    }
    
    
}

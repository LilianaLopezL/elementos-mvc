
package unitec.elementosmvc;

import ETE.Estatus;
import unitec.elementosmvc.Cliente;
import unitec.elementosmvc.RepositorioCliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@CrossOrigin

public class ControladorCliente 
{
    
    @Autowired RepositorioCliente repoClt;
    
    // Caso a) Buscar Todos
    
    @GetMapping("/cliente")
    public List<Cliente> buscarTodos()
    {
        return repoClt.findAll();
        
    }
    
    // Caso b) Buscar por ID
    
    @GetMapping("/cliente/{id}")
    public Cliente buscarPorId(@PathVariable String id)
    {
       return repoClt.findById(id).get();
    }
    
    // Caso c) Insertar
    @PostMapping("/cliente")
    
    

    public Estatus guardar(@RequestBody String json) throws Exception
    {
     //PRIMERO CONVETIMOS ESTE STRING JSON A UN OBJETO JAVA
        
        ObjectMapper maper= new ObjectMapper();
        
        Cliente mensa= maper.readValue(json, Cliente.class);
        
        repoClt.save(mensa);
        
        
        System.out.println("Este Objeto Se Convirtio: "+mensa);
        
        Estatus estatus = new Estatus();
        
        estatus.setSuccess(true);
        estatus.setMensaje("Mensaje Guardado Con Éxito");
        
        return estatus;
    }  
        
        // Caso d) Actualizar
    @PutMapping("/cliente")

    public Estatus actualizar(@RequestBody String json) throws Exception
    {
     //PRIMERO CONVETIMOS ESTE STRING JSON A UN OBJETO JAVA
        
      ObjectMapper maper= new ObjectMapper();
        
        Cliente mensa= maper.readValue(json, Cliente.class);
        
        repoClt.save(mensa);
        
        
        System.out.println("Este Objeto Se Convirtio: "+mensa);
        
        Estatus estatus = new Estatus();
        
        estatus.setSuccess(true);
        estatus.setMensaje("Mensaje Actualizado Con Éxito");
        
        return estatus;
    }
    
    // Caso e) Borrar
    @DeleteMapping("/cliente/{id}")

    public Estatus borrarPorId(@PathVariable String id) throws Exception
    {
        Cliente mensa=  new Cliente(); //mensa
        
        repoClt.deleteById(id);
        Estatus e = new Estatus();
        
        e.setSuccess(true);
        e.setMensaje("Mensaje Borrado Con Éxito");

        
        return e;
    }
    
    
}

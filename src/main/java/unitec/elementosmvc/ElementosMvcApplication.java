package unitec.elementosmvc;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElementosMvcApplication implements CommandLineRunner 
{
    @Autowired
    ServicioSaldo servicio;
    @Autowired
    RepositorioMensaje repoMensaje;

    public static void main(String[] args) 
    {
        SpringApplication.run(ElementosMvcApplication.class, args);
    }

    @Override

    public void run(String... args) throws Exception 
    {
        //servicio.obtenerSaldo().obtenerSaldo();
        //LocalDate fecha = LocalDate.now();
        
//------------------------------------------------------------------------------
        //               GUARDAR MENSAJE
//------------------------------------------------------------------------------ 

        //repoMensaje.save(new Mensaje("hola",fecha,"Cerdito"));
        
        

//------------------------------------------------------------------------------
        //               BUSCAR TODOS LOS MENSAJES ya
//------------------------------------------------------------------------------        
        /*
        for(Mensaje mensj: repoMensaje.findAll())
        {
          System.out.println(mensj);         
        }
      */


        
//------------------------------------------------------------------------------        
        //                  BUSCAR POR ID
//------------------------------------------------------------------------------        
        
        //System.out.println(repoMensaje.findById("5b08cafe0b09d8000445bb42").get());
        //System.out.println(repoMensaje.findByCuerpo("Cerdito"));
        
        
//------------------------------------------------------------------------------
        //               BORRAR UN MENSAJE
//------------------------------------------------------------------------------

   // repoMensaje.save(new Mensaje("hola",fecha,"Cerdito"));

        //repoMensaje.deleteById("5b08c87ce62c022e8c87a1f8");
       /* 
        Mensaje ms = new Mensaje();
        ms.setId("hola"); 
        repoMensaje.delete(ms);
       */
    }
}

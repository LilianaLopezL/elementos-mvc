/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.elementosmvc;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
public class MiUI extends UI {

    @Autowired
    RepositorioMensaje repoMenj;
    
    @Override
    protected void init(VaadinRequest request) {
        //Borrar lo que se genera dentro
        //Aqui va INTERFAZ DE USUARIO

        VerticalLayout layout = new VerticalLayout();

        Label etiqueta = new Label("Bienvenido a Mi Aplicación !");
        etiqueta.addStyleName(ValoTheme.LABEL_H2);

        TextField texto = new TextField();
        texto.setPlaceholder("Cuerpo del Mensaje");

        Button boton = new Button("Guardar Mensaje");
        boton.addStyleName(ValoTheme.BUTTON_DANGER);

        //MANEJAMOS EL EVENTO DE TIPO BOTÓN
        boton.addClickListener(algo -> {
        String cuerpo = texto.getValue();
        
        //GUARDAMOS
        repoMenj.save(new Mensaje(cuerpo));

        //LE COMUNICAMOS AL USUARIO QUE SE GUARDO
        Notification.show("Mensaje Guardado", Notification.Type.ERROR_MESSAGE);
        }
        );

        //CASO 2: BUSCAR TODOS
        Grid<Mensaje> grid = new Grid<>();
        
        //grid.addStyleName(ValoTheme.ACCORDION_BORDERLESS);
        grid.setItems(repoMenj.findAll());
        
        //https://vaadin.com/components/vaadin-grid/java-examples
        
        grid.addColumn(Mensaje::getId).setCaption("ID");
        grid.addColumn(Mensaje::getCuerpo).setCaption("CUERPO");
                
        //AGREGAMOS LA ETIQUETA Y EL BOTON A EL LAYOUT
        layout.addComponent(etiqueta);
        layout.addComponent(texto);
        layout.addComponent(boton);

        //AGREGAMOS DICHA COMPONENTE AL LAYOUT
        layout.addComponent(grid);
        
        //FINALMENTE AGREGAMOS EL LAYOUT AL CONTENEDOR PRINCIPAL DE INIT
        setContent(layout);

    }

}

package ec.edu.espe.tecnizoneapp.view;

import ec.edu.espe.tecnizoneapp.controller.TecniZoneController;

/**
 *
 * @author CodeX3Team, @ESPE
 */
public class TecniZoneApp {

    public static void main(String[] args) {
        TecniZoneController controller = new TecniZoneController();
        MenuHandler menu = new MenuHandler(controller);
        
        menu.start();
    }
}

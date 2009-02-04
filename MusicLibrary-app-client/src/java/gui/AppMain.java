package gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;


public class AppMain extends SingleFrameApplication {
    private AppView appView;
    static InitialContext icx;

    private static boolean initContext(){

        boolean retval = true;
        try {
            icx = new InitialContext();
        } catch (NamingException ex) {
            Logger.getLogger(AppMain.class.getName()).log(Level.SEVERE, null, ex);
            retval = false;
        }
        return retval;
    }

    public static <T> T getBean(Class<T> t) {
        try {
            return (T) icx.lookup(t.getCanonicalName());
        } catch (NamingException ex) {
            Logger.getLogger(AppMain.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    
    @Override protected void startup() {
         appView = new AppView(this);
        show(appView);
    }

    public AppView getAppView(){
        return appView;
    }
    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of DesktopApplication1
     */
    public static AppMain getApplication() {
        return Application.getInstance(AppMain.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        if (!initContext()) {
             return ;
        }
    

        launch(AppMain.class, args);
    }
}

package gui;

import gui.AppMain;
import org.jdesktop.application.Application;
import org.jdesktop.application.Task;
import sess.LibrarySessionRemote;

/**
 *
 * @author sbrosig
 */
public class TestTask extends Task {
    private String out;
    private static LibrarySessionRemote lsr;


    TestTask(Application app) {
        super(app);
        
    }

    @Override
    protected String doInBackground() throws Exception {
        lsr = AppMain.getBean(LibrarySessionRemote.class);
        if (lsr != null) {
            out = lsr.testMethod("balls");
        }
        return out;
    }

    @Override
    protected void succeeded(Object result) {
       AppMain.getApplication().getAppView().message(out);

        }
}

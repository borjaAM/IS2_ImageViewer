package imageviewer.control;

/**
 *
 * @author Usuario
 */
public class ExitImageCommand implements Command{

    @Override
    public void execute() {
        System.exit(0);
    }
    
}

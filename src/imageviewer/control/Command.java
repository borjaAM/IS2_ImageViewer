package imageviewer.control;

public interface Command {
    void execute();
    
    public class Null implements Command{

        @Override
        public void execute() {
        }
        
    }
}

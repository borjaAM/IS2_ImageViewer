package imageviewer.control;

import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import imageviewer.view.ImageLoader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class InitCommand implements Command{

    private final Map<String, Command> commands;
    private final List<Image> images;
    private final ImageDisplay imageDisplay;

    public InitCommand(List<Image> images, ImageDisplay imageDisplay) {
        this.commands = new HashMap<>();
        this.imageDisplay = imageDisplay;
        this.images = images;
    }

    public Map<String, Command> getCommands() {
        return commands;
    }
    

    @Override
    public void execute() {
        imageDisplay.display(images.get(0));
        createCommands();
    }
    
    private void createCommands(){
        commands.put("N", new NextImageCommand(images, imageDisplay));
        commands.put("P", new PrevImageCommand(images, imageDisplay));
        commands.put("Q", new ExitImageCommand());
    }
}

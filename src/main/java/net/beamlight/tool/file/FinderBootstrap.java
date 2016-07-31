package net.beamlight.tool.file;

/**
 * Created on Jul 31, 2016
 * @author gaofeihang
 */
public class FinderBootstrap {
    
    public static final String PATH = "/Users/gaofeihang/desktop";
    
    public static void main(String[] args) {
        new FileFinder(PATH).start();
    }

}

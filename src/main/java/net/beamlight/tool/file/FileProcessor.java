package net.beamlight.tool.file;

import java.io.File;

/**
 * created on Jul 31, 2016 
 * @author gaofeihang
 */
public interface FileProcessor {
    
    void process(File file);
    
    String dump();

}

package net.beamlight.tool.file;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created Jul 31, 2016
 * @author gaofeihang
 */
public class FileFinder {
    
    private static final Logger LOG = LoggerFactory.getLogger(FileFinder.class);
    
    private String path;
    
    public FileFinder(String path) {
        this.path = path;
    }
    
    public void start() {
        LOG.info("file finder started");
        
        File file = new File(path);
        FileProcessor processor = null;
        
//        processor = new DuplicateProcessor();
        processor = new LengthProcessor();
        
        findFiles(file, Arrays.asList(processor));
        
        LOG.info(processor.dump());
    }
    
    private void findFiles(File file, List<? extends FileProcessor> processors) {
        if (file.isDirectory()) {
            String[] fileList = file.list();
            for (String path : fileList) {
                findFiles(new File(path), processors);
            }
        } else {
            for (FileProcessor processor : processors) {
                processor.process(file);
            }
        }
    }

}

package net.beamlight.tool.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * created on Jul 31, 2016
 * @author gaofeihang
 */
public class LengthProcessor implements FileProcessor {
    
    private static final Logger LOG = LoggerFactory.getLogger(FileFinder.class);
    
    private List<FileInfo> infos = new ArrayList<FileInfo>();

    @Override
    public void process(File file) {
        String name = file.getName();
        String path = file.getAbsolutePath();
        long length = file.length();
        
        FileInfo info = new FileInfo();
        info.setName(name);
        info.setPath(path);
        info.setLength(length);
        
        infos.add(info);
        
        LOG.info(path);
    }
    
    @Override
    public String dump() {
        if (infos.size() == 0) {
            return "no duplicate files";
        }
        
        Collections.sort(infos);
        StringBuilder sb = new StringBuilder();
        for (FileInfo info : infos) {
            sb.append(info.toString()).append("\n");
        }
        return sb.toString();
    }

}

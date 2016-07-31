package net.beamlight.tool.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * created on Jul 31, 2016
 * @author gaofeihang
 */
public class DuplicateProcessor implements FileProcessor {
    
    private static final Logger LOG = LoggerFactory.getLogger(FileFinder.class);
    
    private Map<String, FileInfo> firstInfos = new HashMap<String, FileInfo>();
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
        
        FileInfo firstInfo = firstInfos.get(name);
        if (firstInfo == null) {
            firstInfos.put(name, firstInfo);
        } else {
            if (!firstInfo.isDuplicate()) {
                firstInfo.setDuplicate(true);
                infos.add(firstInfo);
            }
            infos.add(info);
        }
        
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

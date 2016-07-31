package net.beamlight.tool.file;

/**
 * Created Jul 31, 2016
 * @author gaofeihang
 */
public class FileInfo implements Comparable<FileInfo> {
    
    private String name;
    private String path;
    private long length;
    private boolean duplicate;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public long getLength() {
        return length;
    }
    public void setLength(long length) {
        this.length = length;
    }
    public boolean isDuplicate() {
        return duplicate;
    }
    public void setDuplicate(boolean duplicate) {
        this.duplicate = duplicate;
    }
    
    @Override
    public int compareTo(FileInfo o) {
        int result = this.name.compareTo(o.name);
        if (result == 0) {
            return (int) (o.length - this.length);
        }
        return 0;
    }
    
    @Override
    public String toString() {
        return name + ", " + length + ", " + path;
    }

}

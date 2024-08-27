package cons.service;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class FileLoader {
    
    @Value("C:\\Users\\HP\\git\\remitoTxt")
    private String folderPath;
    
    @Autowired
    private FileService fileService;
    
  /*  @PostConstruct
    public void init() {
        loadFiles();
    }
    
    public void loadFiles() {
        List<File> files = getFilesFromFolder(folderPath);
        for (File file : files) {
            fileService.readAndPersistFile(file.getName());
        }
    }*/
    
    private List<File> getFilesFromFolder(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
        return Arrays.asList(files);
    }
}

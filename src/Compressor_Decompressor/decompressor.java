/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Compressor_Decompressor;

/**
 *
 * @author DELL
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author DELL
 */
public class decompressor {
    public static void method(File file, String ext) throws FileNotFoundException, IOException{
        String fileDirectory = file.getParent();
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "\\decompressedfile" + ext);
        GZIPInputStream gzip = new GZIPInputStream(fis);
        
        byte[] buffer = new byte[1024];
        int len;
        
        while((len = gzip.read(buffer))!= -1){
            fos.write(buffer, 0, len);
        }
        
        gzip.close();
        fos.close();
        fis.close();
    }
    public static void main(String[] args) throws IOException{
        File path = new File("C:\\Users\\DELL\\Documents\\Downloads\\decompressed");
        method(path, "");
    }
}

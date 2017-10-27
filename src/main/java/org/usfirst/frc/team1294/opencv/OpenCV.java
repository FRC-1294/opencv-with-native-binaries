package org.usfirst.frc.team1294.opencv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class OpenCV {
  private static final Logger logger = LoggerFactory.getLogger(OpenCV.class);

  public static void loadNativeLibraries() {
    try {
      final String osName = System.getProperty("os.name");
      final String osArch = System.getProperty("os.arch");
      logger.debug("os.name: " + osName);
      logger.debug("os.arch: " + osArch);

      String resname = "/nativelibraries/";
      if (osName.startsWith("Windows"))
        resname += "Windows/" + osArch + "/";
      else
        resname += osName + "/" + osArch + "/";

      if (osName.startsWith("Linux") && new File("/usr/lib/arm-linux-gnueabihf").exists()) {
        resname += "hf/";
      }

      if (osName.startsWith("Windows"))
        resname += "opencv_java331.dll";
      else if (osName.startsWith("Mac"))
        resname += "libopencv_java331.dylib";
      else
        resname += "libopencv_java331.so";

      logger.debug("resourceName: " + resname);

      InputStream is = OpenCV.class.getResourceAsStream(resname);
      if (is == null) {
        if (new File("./" + resname).exists()) {
          is = new FileInputStream("./" + resname);
        } else if (new File("./src/main/resources/" + resname).exists()) {
          is = new FileInputStream("./src/main/resources/" + resname);
        }
      }

      File jniLibrary;
      if (is != null) {
        // create temporary file
        if (osName.startsWith("Windows"))
          jniLibrary = File.createTempFile("opencv_java331", ".dll");
        else if (osName.startsWith("Mac"))
          jniLibrary = File.createTempFile("opencv_java331", ".dylib");
        else
          jniLibrary = File.createTempFile("opencv_java331", ".so");
        // flag for delete on exit
        jniLibrary.deleteOnExit();
        OutputStream os = new FileOutputStream(jniLibrary);

        byte[] buffer = new byte[1024];
        int readBytes;
        try {
          while ((readBytes = is.read(buffer)) != -1) {
            os.write(buffer, 0, readBytes);
          }
        } finally {
          os.close();
          is.close();
        }

        System.load(jniLibrary.getAbsolutePath());
      } else {
        System.loadLibrary("opencv_java331");
      }
      logger.debug("Successfully loaded opencv native libraries.");
    } catch (IOException ex) {
      logger.error("Failed to load opencv native libraries.", ex);
      System.exit(1);
    }
  }
}

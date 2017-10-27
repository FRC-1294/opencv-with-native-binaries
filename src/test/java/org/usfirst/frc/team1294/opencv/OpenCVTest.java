package org.usfirst.frc.team1294.opencv;

import org.junit.Test;
import org.opencv.core.Core;
import static org.junit.Assert.*;

public class OpenCVTest {

  @Test
  public void calLoadNativeLibrariesTest() throws Exception {
    OpenCV.loadNativeLibraries();
    assertEquals("3.3.1", Core.VERSION);
  }
}
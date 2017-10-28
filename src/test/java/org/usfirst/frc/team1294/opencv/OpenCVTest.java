package org.usfirst.frc.team1294.opencv;

import org.junit.Before;
import org.junit.Test;
import org.opencv.core.Core;
import org.opencv.features2d.DescriptorExtractor;
import org.opencv.features2d.FeatureDetector;

import static org.junit.Assert.*;

public class OpenCVTest {

  @Before
  public void before() {
    OpenCV.loadNativeLibraries();
  }

  @Test
  public void canLoadNativeLibrariesTest() {
    assertEquals("3.3.1", Core.VERSION);
  }

  @Test
  public void canUseContribFeatures() throws Exception {
    FeatureDetector detector = FeatureDetector.create(FeatureDetector.SURF);
    DescriptorExtractor extractor = DescriptorExtractor.create(DescriptorExtractor.SURF);
  }
}
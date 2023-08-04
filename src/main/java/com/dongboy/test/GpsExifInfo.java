package com.dongboy.test;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.GpsDirectory;

import java.io.File;
import java.util.Objects;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.lang.GeoLocation;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.GpsDirectory;
import java.io.File;
import java.util.Objects;

/**
 * @Author  dongboy
 * @what time    2023/1/27 22:38
 */
public class GpsExifInfo {

    public static void main(String[] args) throws Exception {
        File jpegFile = new File("D:/a.jpg");
        Metadata metadata = JpegMetadataReader.readMetadata(jpegFile);
        //获取图片所有EXIF信息
        Iterable<Directory> directories = metadata.getDirectories();
        for (Directory directory : directories) {
            for (Tag tag : directory.getTags()) {
                System.out.println(tag);
            }
        }
    }

//    public static void main(String[] args) throws Exception {
//        File jpegFile = new File("D:/a.jpg");
//        Metadata metadata = JpegMetadataReader.readMetadata(jpegFile);
//        GpsDirectory gpsDirectory = metadata.getDirectory(GpsDirectory.class);
//        if (Objects.nonNull(gpsDirectory)) {
//            GeoLocation geoLocation = gpsDirectory.getGeoLocation();
//            System.out.println(geoLocation.getLongitude());
//            System.out.println(geoLocation.getLatitude());
//        }
//    }

}

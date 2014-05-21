package com.enlightendev.patterns.behavioral.strategy.ex1;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jl25292 on 5/21/14.
 */
public class Client {
    public static void main(String[] args) {
        CompressionContext compressionContext = new CompressionContext();

        //use pref or props to figure out which compression algorithm
        compressionContext.setCompressionStrategy(new ZipCompressionStrategy());

        File file = new File("/opt");
        File[] files = file.listFiles();

        ArrayList<File> f = new ArrayList<File>(Arrays.asList(files));
        compressionContext.createArchive(f);
    }
}
package com.enlightendev.patterns.behavioral.strategy.ex1;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by jl25292 on 5/21/14.
 */
public class RarCompressionStrategy implements CompressionStrategy {

    @Override
    public void compressFiles(ArrayList<File> files) {
        System.out.println("Compressing using RAR");
    }
}

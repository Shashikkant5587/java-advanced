package com.enlightendev.patterns.behavioral.strategy.ex1;

import java.io.File;
import java.util.ArrayList;

/**
 * Context will provide a way for the client to compress the files.
 * Let's say that there is a preferences setting in our application
 * that sets which compression algorithm to use. We can change our
 * strategy using the setCompressionStrategy method in the Context.
 */
public class CompressionContext {

    private CompressionStrategy strategy;

    /**
     * this can be set at runtime
     * @param strategy
     */
    public void setCompressionStrategy(CompressionStrategy strategy){
        this.strategy = strategy;
    }

    /**
     * Use the strategy
     * @param files
     */
    public void createArchive(ArrayList<File> files){
        strategy.compressFiles(files);
    }
}
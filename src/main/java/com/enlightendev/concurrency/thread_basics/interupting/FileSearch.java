package com.enlightendev.concurrency.thread_basics.interupting;

import java.io.File;
import java.nio.file.NotDirectoryException;
import java.util.concurrent.TimeUnit;

/**
 * Created by jl25292 on 5/22/14.
 */
public class FileSearch implements Runnable {

    private String initPath;
    private String fileName;
    private File directoryPath;

    public FileSearch(String initPath, String fileName) throws NotDirectoryException {
        this.initPath = initPath;
        this.fileName = fileName;

        directoryPath = new File(initPath);
        if (!directoryPath.isDirectory()) {
            throw new NotDirectoryException(directoryPath.getAbsolutePath());
        }
    }

    @Override
    public void run() {

        //loop until interrupted
        while(true) {
            try {
                System.out.printf("%s: checking for file: %s\n", Thread.currentThread().getName(), fileName);

                //check every 5 seconds
                TimeUnit.SECONDS.sleep(5);

                directoryProcess(directoryPath);

            } catch (InterruptedException e) {
                System.out.printf("%s: The search has been interrupted", Thread.currentThread().getName());
                return;
            }
        }
    }

    /**
     * This method will obtain the files and subfolders in a folder and process them.
     * For each directory, the method will make a recursive call passing the directory
     * as a parameter. For each file, the method will call the fileProcess() method.
     * After processing all files and folders, the method checks if Thread has been
     * interrupted and, in this case, throws an InterruptedException exception.
     * @param file
     * @throws InterruptedException
     */
    private void directoryProcess(File file) throws InterruptedException {
        File list[] = file.listFiles();
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory()) {
                    directoryProcess(list[i]);
                } else {
                    fileProcess(list[i]);
                }
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    /**
     * This method will compare the name of the file it's processing with the name we are
     * searching for. If the names are equal, we will write a message in the console.
     * After this comparison, Thread will check if it has been interrupted and, in this
     * case, it throws an InterruptedException exception
     * @param file
     * @throws InterruptedException
     */
    private void fileProcess(File file) throws InterruptedException {
        if (file.getName().equals(fileName)) {
            System.out.printf("%s : %s\n",Thread.currentThread().getName() ,file.getAbsolutePath());
            Thread.currentThread().interrupt();
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }
}
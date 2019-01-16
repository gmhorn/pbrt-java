package org.gmhorn.pbrt;


import picocli.CommandLine;

import java.io.File;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    private int nThreads;

//    @CommandLine.Parameters(arity="1..*", paramLabel="FILE", description = "Source file(s) to process.")
//    private File[] sourceFiles;
    private File outfile;

    @CommandLine.Option(names = {"--quick"}, description = "Be quick.")
    private boolean quick = false;

    @CommandLine.Option(names = {"--quiet"}, description = "Be quiet.")
    private boolean quiet = false;

    @CommandLine.Option(names = {"--verbose"}, description = "Be verbose.")
    private boolean verbose = false;

    public static void main( String[] args ) {
        args = new String[]{"--verbose"};
        App app = CommandLine.populateCommand(new App(), args);
    }
}

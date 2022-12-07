package utils;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import static java.util.concurrent.ExecutorService.*;
import static java.util.concurrent.Executors.newSingleThreadExecutor;

public class AppiumManager {

    public static void startServer() {

        CommandLine command = new CommandLine(
                "/Applications/Appium.app/Contents/Resources/node/bin/node");
        command.addArgument(
                "/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js",
                false);
        command.addArgument("--address", false);
        command.addArgument("127.0.0.1");
        command.addArgument("--port", false);
        command.addArgument("4723");
        command.addArgument("--full-reset", false);
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(1);
        try {
            executor.execute(command, resultHandler);
            Thread.sleep(5000);
            System.out.println("Appium server started.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void stopServer() {
        String[] command = {"/usr/bin/killall", "-KILL", "node"};
        try {
            Runtime.getRuntime().exec(command);
            System.out.println("Appium server stopped.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ProcessReader implements Callable {
        private InputStream inputStream;

        public ProcessReader(InputStream inputStream){
            this.inputStream = inputStream;

        }

        @Override
        public Object call() throws Exception {
            return new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.toList());
        }
    }

    public static void startAppi() {
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("sh", "-c", "/Users/hilarychukwuji/IdeaProjects/automationFramework/src/main/resources/appium/appium-start.sh");
        ExecutorService executorService = newSingleThreadExecutor();
        try {
            Process process = builder.start();
            //Thread.sleep(50000);
            ProcessReader processReader = new ProcessReader(process.getInputStream());
            Future<List<String>> future = executorService.submit(processReader);

            List<String> result = future.get();
            for (String res: result){
                System.out.println(result);
            }

            int exitCode = process.waitFor();
            System.out.println("The exit code: " + exitCode);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }

    }

    public static void startAppiumServer() throws IOException, InterruptedException {
        // String[] cmd = new String[]{"/bin/sh", "/Users/hilarychukwuji/IdeaProjects/automationFramework/src/main/resources/appium/appium-start.sh.sh"};
//
//        String[] env = {"PATH=/bin:/usr/bin/"};
//        String cmd = "/Users/hilarychukwuji/IdeaProjects/automationFramework/src/main/resources/appium/appium-start.sh";  //e.g test.sh -dparam1 -oout.txt
//        Process process = Runtime.getRuntime().exec(cmd, env);
//        Thread.sleep(50000);
//
        try {
            Process p = new ProcessBuilder("/Users/hilarychukwuji/IdeaProjects/automationFramework/src/main/resources/appium/appium-start.sh").start();
            Thread.sleep(50000);
            System.out.println("Started Appium with process info: " + p);
            String result = String.valueOf(p.getOutputStream());
            System.out.println(result);
            // p.html#getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
//
//        try {
//            Process pr = Runtime.getRuntime().exec(cmd);
//            Thread.sleep(50000);
//            System.out.println(pr);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}


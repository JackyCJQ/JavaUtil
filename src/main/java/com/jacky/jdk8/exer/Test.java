package com.jacky.jdk8.exer;

import org.apache.commons.cli.*;

/**
 * @Authror jacky
 * @create 2019-04-20
 */
public class Test {
    public static void main(String[] args) {
        MQVersion.Version[] values = MQVersion.Version.values();
//        System.out.println(MQVersion.getVersionDesc(1));
        MQVersion.Version version = MQVersion.value2Version(1);
        System.out.println(version.name());
        System.out.println(version.ordinal());

    }
    public static CommandLine parseCmdLine(final String appName, String[] args, Options options, CommandLineParser parser) {
        HelpFormatter hf = new HelpFormatter();
        //每行显示的字符数。超过了就换行
        hf.setWidth(110);
        CommandLine commandLine = null;
        try {
            //通过参数解析出对应的配置
            commandLine = parser.parse(options, args);
            //帮助打印配置
            if (commandLine.hasOption('h')) {
                hf.printHelp(appName, options, true);
                return null;
            }
        } catch (ParseException e) {
            hf.printHelp(appName, options, true);
        }

        return commandLine;
    }
}

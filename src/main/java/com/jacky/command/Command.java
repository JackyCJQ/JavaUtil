package com.jacky.command;

import org.apache.commons.cli.*;

/**
 * @Authror jacky
 * @create 2019-04-21
 */
public class Command {
    /**
     * 程序开始执行时program arguments 中输入 -f value 的话会获取到value的值
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Options options = buildCommandlineOptions(new Options());
        CommandLine line = parseCmdLine("mqnamesrv", args, buildCommandlineOptions(options),
                new PosixParser());

    }

    public static Options buildCommandlineOptions(final Options options) {
        //指定这个命令行 短操作为 -h 完整操作为 -help 是否有参数   对该命令的描述
        Option opt = new Option("h", "help", false, "Print help");
        opt.setRequired(false);
        //增加一个帮助命令
        options.addOption(opt);
        //构造启动时需要加上 -n 说明命名服务器的地址
        opt = new Option("n", "namesrvAddr", true,
                        "Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876");
        opt.setRequired(false);
        options.addOption(opt);

        opt = new Option("c", "configFile", true, "Name server config properties file");
        opt.setRequired(false);
        options.addOption(opt);

        opt = new Option("p", "printConfigItem", false, "Print all config item");
        opt.setRequired(false);
        options.addOption(opt);

        return options;
    }

    public static CommandLine parseCmdLine(final String appName, String[] args, Options options, CommandLineParser parser) {
        HelpFormatter hf = new HelpFormatter();
        //每行显示的字符数。超过了就换行
        hf.setWidth(110);
        CommandLine commandLine = null;
        try {
            //解析程序入口输入的program arguments 中输入-h -n -p -c 四个参数的值
            commandLine = parser.parse(options, args);
            //如果有-h的输入
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

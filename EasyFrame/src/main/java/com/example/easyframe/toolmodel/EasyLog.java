package com.example.easyframe.toolmodel;

import com.elvishew.xlog.*;
import com.elvishew.xlog.interceptor.BlacklistTagsFilterInterceptor;
import com.elvishew.xlog.printer.Printer;
import com.elvishew.xlog.printer.file.FilePrinter;
import com.elvishew.xlog.printer.file.backup.NeverBackupStrategy;
import com.elvishew.xlog.printer.file.clean.FileLastModifiedCleanStrategy;
import com.elvishew.xlog.printer.file.naming.DateFileNameGenerator;

import java.io.Console;

public class EasyLog {


    public static void init() {
        XLog.init(LogLevel.ALL);
        LogConfiguration config = new LogConfiguration.Builder()
                .enableThreadInfo()                                    // 允许打印线程信息，默认禁止
                .enableStackTrace(2)                                   // 允许打印深度为 2 的调用栈信息，默认禁止
                .enableBorder()
                .tag("EasyLog")// 允许打印日志边框，默认禁止
                .build();


        Printer filePrinter = new FilePrinter                      // 打印日志到文件的打印器
                .Builder("<日志目录全路径>")                             // 指定保存日志文件的路径
                .fileNameGenerator(new DateFileNameGenerator())        // 指定日志文件名生成器，默认为 ChangelessFileNameGenerator("log")
                .backupStrategy(new NeverBackupStrategy())             // 指定日志文件备份策略，默认为 FileSizeBackupStrategy(1024 * 1024)
                .build();

        XLog.init(config);
    }

    public static void d(String value) {
        XLog.d(value);

    }

    public static void e(String value) {
        XLog.e(value);

    }
}

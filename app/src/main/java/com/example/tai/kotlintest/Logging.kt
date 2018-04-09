package com.example.tai.kotlintest

import java.util.logging.*
//import android.util.Log

fun getLineNumber(callingClassName: String, callingMethodName: String) : Number {
    for (frame in Throwable().stackTrace) {
        if (frame.className == callingClassName && frame.methodName == callingMethodName) {
            return frame.lineNumber;
        }
    }
    return 0;
}

class CustomFormatter : Formatter() {
    override fun format(rec: LogRecord) : String {
        var ret : String = "TEST"
        var lineno = getLineNumber(rec.sourceClassName, rec.sourceMethodName)
        ret = "[${rec.sourceClassName}.${rec.sourceMethodName}:${lineno}] ${rec.message}"
        return ret
   }
}

class Logging {
    companion object {
        val log = Logger.getLogger(javaClass.enclosingClass.name)
        val handler = ConsoleHandler()

        init {
            handler.formatter = CustomFormatter()
            log.addHandler(handler)
            log.useParentHandlers = false

            log.info("Initialized handlers")
        }
    }
}

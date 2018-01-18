/*
 * # DON'T BE A DICK PUBLIC LICENSE
 *
 * > Version 1.1, December 2016
 *
 * > Copyright (C) 2016-2017 Adam Prakash Lewis
 *
 *  Everyone is permitted to copy and distribute verbatim or modified
 *  copies of this license document.
 *
 * > DON'T BE A DICK PUBLIC LICENSE
 * > TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *
 *  1. Do whatever you like with the original work, just don't be a dick.
 *
 *      Being a dick includes - but is not limited to - the following instances:
 *
 * 	 1a. Outright copyright infringement - Don't just copy this and change the name.
 * 	 1b. Selling the unmodified original with no work done what-so-ever, that's REALLY being a dick.
 * 	 1c. Modifying the original work to contain hidden harmful content. That would make you a PROPER dick.
 *
 *  2. If you become rich through modifications, related works/services, or supporting the original work,
 *  share the love. Only a dick would make loads off this work and not buy the original work's
 *  creator(s) a pint.
 *
 *  3. Code is provided with no warranty. Using somebody else's code and bitching when it goes wrong makes
 *  you a DONKEY dick. Fix the problem yourself. A non-dick would submit the fix back.
 */
 
 
 
 package database

import mu.KLogging
import java.io.File
import java.io.InputStream
import java.sql.Connection
import java.sql.SQLException
import java.util.*

/**
 * Created by alewis on 13/12/2016.
 */
class SQLScript() {

    companion object : KLogging()

    var inputStream: InputStream? = null

    constructor(inputStream: InputStream): this() { this.inputStream = inputStream }
    constructor(file: File): this() { this.inputStream = file.inputStream() }

    private val statements = mutableListOf("")

    fun parse() {
        statements.clear()
        val fileScanner = Scanner(inputStream)
        fileScanner.useDelimiter("(;(\r)?\n)|(--\n)")
        while (fileScanner.hasNext()) {
            var line = fileScanner.next()
            if (line.startsWith("/*") && line.endsWith("*/")) {
                val i = line.indexOf(' ')
                line = line.substring(i + 1, line.length - " */".length)
            }
            if (line.trim().isNotEmpty()) {
                statements.add(line)
            }
        }
    }

    fun replace(placeholder: String, newValue: String) {
        if (statements.isNotEmpty()) {
            statements.forEachIndexed { index, statement ->
                val newStatement = statement.replace(placeholder, newValue, ignoreCase = true)
                statements[index] = newStatement
            }
        }
    }

    fun executeStatements(connection: Connection, logScriptExecution: Boolean = false) {
        statements.forEach { statement ->
            val preparedStatement = connection.prepareStatement(statement)
            try {
                if (logScriptExecution)
                    logger.info("Executing update statement from script: $preparedStatement")
                preparedStatement.execute()
                connection.commit()
            } catch (e: SQLException) {
                logger.error(e.message)
            }
            preparedStatement?.closeOnCompletion()
        }
    }
}
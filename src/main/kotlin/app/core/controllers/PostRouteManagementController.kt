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

package app.core.controllers

import mu.KLogging
import spark.ModelAndView
import spark.Request
import spark.Response
import spark.Session
class PostRouteManagementController : Controller {

    companion object : KLogging()

    override var rootUri: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}
    override val childGetUris: MutableList<String>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val childPostUris: MutableList<String>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val templatePath: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val pageTitleSubstring: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val handlesGets: Boolean
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override val handlesPosts: Boolean
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun initSessionBoolAttributes(session: Session) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(request: Request, response: Response, layoutTemplate: String): ModelAndView {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun post(request: Request, response: Response): Response {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
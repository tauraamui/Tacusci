package controllers

import db.DAOManager
import db.UserDAO
import mu.KLogger
import mu.KLogging
import spark.ModelAndView
import spark.Request
import spark.Response
import java.util.*

/**
 * Created by alewis on 04/11/2016.
 */
object ProfileController : KLogging() {

    fun get_getUserProfilePage(username: String): HashMap<String, Any> {
        val model = HashMap<String, Any>()
        model.put("template", "/templates/profile_page.vtl")
        model.put("title", "Thames Valley Furs $username")
        model.put("username", username)
        model.put("stylesheet", "/css/ui_elements.css")
        model.put("base_stylesheet", "/css/tvf.css")
        return model
    }

    fun get_profilePage(request: Request, response: Response, layoutTemplate: String): ModelAndView {
        var model = HashMap<String, Any>()
        if (UserHandler.isLoggedIn(request.session())) {
            val userNameOfProfileToView = request.params(":username")
            if (userNameOfProfileToView != null && userNameOfProfileToView.isNotBlank() && userNameOfProfileToView.isNotEmpty()) {
                val userDAO: UserDAO = DAOManager.getDAO(DAOManager.TABLE.USERS) as UserDAO
                if (userDAO.userExists(userNameOfProfileToView)) {
                    model = get_getUserProfilePage(userNameOfProfileToView)
                } else {
                    return Web.get_userNotFound(request, response, layoutTemplate)
                }
            } else {
                return Web.get_userNotFound(request, response, layoutTemplate)
            }
        } else {
            return Web.get_accessDeniedPage(request, response, layoutTemplate)
        }
        return ModelAndView(model, layoutTemplate)
    }
}
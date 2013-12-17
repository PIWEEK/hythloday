package net.kaleidos.hythloday

import grails.converters.JSON

class GoogleController {
    def googleService
    
    def callbackLogin() {
        def requestToken = session["GOOGLE_TOKEN"]
        def accessToken = googleService.getAccessTokenLogin(params.oauth_verifier, requestToken)

        if (!accessToken) {
            return redirect(mapping:'googleLogin')
        }
        
        def userInfo = googleService.getUserInfoLogin(accessToken)
        
        println userInfo
    }

    def googleLogin() {
        def oauthService = googleService.getAuthServiceLogin()

        session["GOOGLE_TOKEN"] = oauthService.requestToken
        redirect (url:  oauthService.authUrl)

        return
    }
}
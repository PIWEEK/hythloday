package net.kaleidos.hythloday

import grails.converters.JSON

class GoogleController {
    def googleService
    
    def callbackLogin() {
        def accessToken = googleService.getAccessTokenLogin(params.code)

        if (!accessToken) {
            return
        }
        
        def userInfo = googleService.getUserInfoLogin(accessToken)
        
        println userInfo
    }

    def googleLogin() {
        def authUrl = googleService.getAuthServiceLogin()

        println authUrl

        redirect (url:  authUrl)

        return
    }
}
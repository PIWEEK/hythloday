package net.kaleidos.hythloday

import grails.converters.JSON

import org.springframework.transaction.annotation.*
import org.scribe.builder.ServiceBuilder
import org.scribe.builder.api.Google2Api
import org.scribe.model.OAuthRequest
import org.scribe.model.Verb
import org.scribe.model.Verifier
import org.scribe.model.Token

/**
 * Based on https://github.com/tomaslin/grails-inviter
 */
class GoogleService {
    def grailsApplication
    def authServiceLogin
    def grailsLinkGenerator
    
    static transactional = false
    private static final String SCOPE = "https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile";

    def getAccessTokenLogin(code) {
        try {
            getAuthServiceLogin()

            def verifier = new Verifier(code)
            def token = authServiceLogin.getAccessToken(null, verifier)
            
            return token
        } catch (Exception e) {
            log.error  "GooogleService.getAccessTokenLogin Exception" + e
            return null
        }
    }

    def getAuthServiceLogin(){
        if (!authServiceLogin) {
            def callbackUrl = grailsLinkGenerator.link(absolute: true, mapping: 'googleCallBack')
            def key = grailsApplication.config.google.key as String
            def secret = grailsApplication.config.google.secret as String

            authServiceLogin = new ServiceBuilder().provider(Google2Api.class)
            .apiKey(key)
            .apiSecret(secret)
            .scope(SCOPE)
            .callback(callbackUrl)
            .build()
        }

        return authServiceLogin.getAuthorizationUrl()
    }

    private def sendRequest(accessToken, method, url){
        OAuthRequest request = new OAuthRequest(method, url)
        authServiceLogin.signRequest(accessToken, request)
        def response = request.send();

        return JSON.parse(response.body)
    }

    def Map getUserInfoLogin(accessToken) {
        return sendRequest(accessToken, Verb.GET, "https://www.googleapis.com/userinfo/v2/me" )
    }
}